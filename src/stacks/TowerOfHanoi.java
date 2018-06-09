package stacks;


import java.util.Stack;

public class TowerOfHanoi {


    /*
     * The Tower of Hanoi is a mathematical game or puzzle.
     * It consists of three rods, and a number of disks of different sizes which can slide onto any rod.
     * The puzzle starts with the disks in a neat stack in ascending order of size on one rod, the smallest at the top, thus making a conical shape.
     * The objective of the puzzle is to move the entire stack to another rod, obeying the following rules:
     *      i) Only one disk may be moved at a time.
     *      ii) Each move consists of taking the upper disk from one of the rods and sliding it onto another rod, on top of the other disks that may already be present on that rod.
     *      iii) No disk may be placed on top of a smaller disk.
     * */

    private static Stack<Integer>[] tower = new Stack[4];

    public static void towerOfHanoiAlgorithm(int n) {
        tower[1] = new Stack<>();
        tower[2] = new Stack<>();
        tower[3] = new Stack<>();

        for(int i =n; i> 0; i--) {
            tower[1].push(i);
        }
        moveToH(n, 1,2,3);
    }

    private static void moveToH(int n, int a, int b, int c) {
        if(n > 0) {
            moveToH(n-1, a,c,b);
            int d = tower[a].pop();
            tower[c].push(d);

            System.out.println(String.format("Moving tower from %s to %s", a, b));
            moveToH(n-1, b,a,c);
        }
    }


    public static void main(String args[]) {
        int n = 4; // Number of disks
        towerOfHanoiAlgorithm(n);
    }
}
