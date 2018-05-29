package strings;

import javax.swing.tree.TreeNode;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class XmlToString {


    public static Node convertXmlStringToTreeNode(String xmlString) throws XMLStreamException {
        Node last = null;

        InputStream is = new ByteArrayInputStream(xmlString.getBytes());
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(is);

        Stack<Node> nodeStack = new Stack<>();
        while (reader.hasNext()) {

            if(reader.getEventType() == XMLStreamConstants.START_DOCUMENT ||
               reader.getEventType() == XMLStreamConstants.SPACE ||
               reader.getEventType() == XMLStreamConstants.END_DOCUMENT) {

                reader.next();
                continue;
            }

            if(reader.getEventType() == XMLStreamConstants.END_ELEMENT) {
                if(!nodeStack.isEmpty()) {
                    last = nodeStack.pop();
                }
                reader.next();
                continue;
            }

            if(reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                Node treeNode = new Node(reader.getLocalName());
                if(!nodeStack.isEmpty()) {
                    ((Stack<Node>)nodeStack.peek().getChildren()).add(treeNode);
                }

            } else if(reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                Node treeNode = new Node(reader.getText());
                if(!nodeStack.isEmpty()) {
                    ((Stack<Node>)nodeStack.peek().getChildren()).add(treeNode);
                }
            }

            reader.next();
        }


        return last;
    }


    public static class Node<T> implements TreeNode {

        private T data = null;

        private List<Node<T>> children = new ArrayList<>();

        private Node<T> parent = null;

        public Node(T data) {
            this.data = data;
        }

        public Node<T> addChild(Node<T> child) {
            child.setParent(this);
            this.children.add(child);
            return child;
        }

        public void addChildren(List<Node<T>> children) {
            children.forEach(each -> each.setParent(this));
            this.children.addAll(children);
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        private void setParent(Node<T> parent) {
            this.parent = parent;
        }

        @Override
        public TreeNode getChildAt(int childIndex) {
            return null;
        }

        @Override
        public int getChildCount() {
            return 0;
        }

        public Node<T> getParent() {
            return parent;
        }

        @Override
        public int getIndex(TreeNode node) {
            return 0;
        }

        @Override
        public boolean getAllowsChildren() {
            return false;
        }

        @Override
        public boolean isLeaf() {
            return false;
        }

        @Override
        public Enumeration children() {
            return null;
        }


    }







    public static void main(String[] args) throws XMLStreamException, ParseException {
        String xmlString = "<html>\n" +
                "  <body>\n" +
                "    <div>\n" +
                "      <h1>CodeRust</h1>\n" +
                "      <a>http://coderust.com</a> \n" +
                "    </div>\n" +
                "    <div>\n" +
                "        <h2>Chapter 1</h2>\n" +
                "    </div>\n" +
                "    <div>\n" +
                "        <h3>Chapter 2</h3>\n" +
                "        <h4>Chapter 2.1</h4>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "</html>";

        System.out.println(convertXmlStringToTreeNode(xmlString));
    }
}
