package misc;

import java.util.ArrayList;
import java.util.List;

public class ClosestMeetingPoint {

    /*
     * Given N people on MxM grid, find the point that requires the least total distance covered by all the ​people to meet at that point.
     *
     * Consider a 5x5 grid with 3 people at X(1,2), Y(3,3) and Z(4,2).
     * find the meeting point(x,y) for these people where the total distance covered by all three is the minimum.
     * They can travel in all directions i.e. horizontally, vertically and diagonally.
     * The minimum distance point, in this case, is (3,3).
     *
     * Runtime Complexity:
     * Linear, O(n).
     * 'n' is the number of people on the grid.
     *
     * Memory Complexity:
     * Linear, O(n).
     * 'n' is the number of people on the grid.
     *
     * The solution uses the 'centroid' to find the minimum distance travelled point.
     * The centroid of a two-dimensional region is the arithmetic mean or average position of all the points.
     * Calculate the centroid of all the points with people on the grid and that will be the minimum distance travelled point.
     * It is the average of x-coordinates and y-coordinates.
     *
     *
     * */

    private static class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        void setX(int x) {
            this.x = x;
        }

        int getY() {
            return y;
        }

        void setY(int y) {
            this.y = y;
        }

        double calculateDistance(Point p) {
            double distance;
            distance = Math.sqrt((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y));
            return distance;
        }

        double calculateSumOfDistances(List<Point> points) {
            double distance_sum;
            distance_sum = 0;
            for (int i = 0; i < points.size(); i++) {
                distance_sum += this.calculateDistance(points.get(i));
            }
            return distance_sum;
        }
    }


    protected static class Distance {
        public Point shortestDistanceTravelled(int m, List<Point> points) {
            Point min_pt = new Point(0, 0);
            double x = 0;
            double y = 0;


            Point centroid = new Point(0, 0);
            for (int i = 0; i < points.size(); i++) {
                x += points.get(i).getX();
                y += points.get(i).getY();
            }
            centroid.setX((int) Math.round(x / points.size()));
            centroid.setY((int) Math.round(y / points.size()));

            // initialize the min_pt to centroid
            min_pt.setX(centroid.getX());
            min_pt.setY(centroid.getY());

            double min_distance = min_pt.calculateSumOfDistances(points);

            // checking points surrounding the potential centroid
            for (int i = min_pt.getX() - 1; i < min_pt.getX() + 2; i++) {
                for (int j = min_pt.getY() - 1; j < min_pt.getY() + 2; j++) {
                    if (i < 1 || j > m) {
                        continue;
                    }
                    Point pt = new Point(i, j);
                    double distance = pt.calculateSumOfDistances(points);
                    if (distance < min_distance) {
                        min_distance = distance;
                        min_pt.setX(pt.getX());
                        min_pt.setY(pt.getY());
                    }
                }
            }

            return min_pt;
        }
    }


    public static void main(String[] args) {

        int m = 5; // size of the grid
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(1, 2));
        points.add(new Point(3, 3));
        points.add(new Point(4, 2));

        Distance d = new Distance();
        Point pt = d.shortestDistanceTravelled(m, points);
        System.out.println("Shortest Distance Point = p(" + pt.getX() + ", " + pt.getY() + ")");
    }
}
