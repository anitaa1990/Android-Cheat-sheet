package deadlock;

public class ThreadLockFixedDemo {

    /* Both method are now requesting lock in same order,
     * first Integer and then String.
     * This will solve the problem,
     * as long as both method are requesting lock in consistent order.
     * */
    public void method1() {
        synchronized (Integer.class) {
            System.out.println("Acquired lock on Integer.class object");
        }
        synchronized (String.class) {
            System.out.println("Acquired lock on String.class object");
        }
    }

    public void method2() {
        synchronized (Integer.class) {
            System.out.println("Acquired lock on Integer.class object");
        }
        synchronized (String.class) {
            System.out.println("Acquired lock on String.class object");
        }
    }
}