package arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingIntervals {


    /*
     * Given an array of intervals as input where each interval has a start and end timestamps.
     * Input array is sorted by starting timestamps.
     * Merge overlapping intervals and return output array (list).
     * Eg:
     * Input: Intervals [(1, 5), (3, 7), (4, 6), (6, 8)]
     * Output: [(1, 8)]
     *
     * */

    /*
     * Solution: Linear Scan
     * Runtime Complexity - Linear, O(n)
     * Memory Complexity - Constant O(1)
     * */


    /*
     * For each interval in the input list,
     * Step 1: check if the current element  value < the output interval y value. If it is, then it is overlapping
     * Step 2: Update last interval of output list with merged interval i.e. the max value between y1 & y2
     * Step 3: If it is not overlapping, add the current input interval element to the output list
     * */
    public static List<Tuple<Integer, Integer>> mergeIntervals(List<Tuple<Integer, Integer>> v1) {

        List<Tuple<Integer, Integer>> v2 = new ArrayList<>();
        v2.add(new Tuple<>(v1.get(0).x, v1.get(0).y));

        for(int i=1; i<v1.size(); i++) {
            int x1 = v1.get(i).x;
            int y1 = v1.get(i).y;
            int x2 = v2.get(v2.size()-1).getX();
            int y2 = v2.get(v2.size()-1).getY();

            if(y2 >= x1) {
                v2.get(v2.size()-1).setY(Math.max(y1,y2));
            } else {
                v2.add(new Tuple<>(x1,y1));
            }
        }
        return v2;
    }



    public static void main(String[] args) {
        List<Tuple<Integer, Integer>> v1 = new ArrayList<>();
        v1.add(new Tuple(10, 12));
        v1.add(new Tuple(11, 15));
//        v1.add(new Tuple(4, 6));
//        v1.add(new Tuple(6, 8));

        List<Tuple<Integer, Integer>> v2 = mergeIntervals(v1);
        for(Tuple tuple: v2) {
            System.out.println(tuple.x + " " + tuple.y);
        }
    }


    public static class Tuple<X, Y> {
        private X x;
        private Y y;
        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        public X getX() {
            return x;
        }

        public void setX(X x) {
            this.x = x;
        }

        public Y getY() {
            return y;
        }

        public void setY(Y y) {
            this.y = y;
        }
    }
}
