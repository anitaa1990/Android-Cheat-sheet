package deadlock;

public class ThreadLockDemo {
    /*
     * This method request two locks, first Integer and then String
     * */
    public void method1() {
        synchronized (Integer.class) {
            System.out.println("Acquired lock on Integer.class object");
        }
        synchronized (String.class) {
            System.out.println("Acquired lock on String.class object");
        }
    }

    /*
     * This method request two locks also, but in oppsite order.
     * This creates potential deadlock, if one thread holds String lock and other holds Integer lock
     * and they wait for each other, forever.
     * */
    public void method2() {
        synchronized (String.class) {
            System.out.println("Acquired lock on String.class object");
        }
        synchronized (Integer.class) {
            System.out.println("Acquired lock on Integer.class object");
        }
    }
}