package week1;

public class DeadlockExample {

  static Object lock1 = new Object();
  static Object lock2 = new Object();

  public static void main(String[] args) {

    Thread t1 = new Thread(() -> {
      synchronized (lock1) {
        System.out.println("t1: lock1 획득");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        synchronized (lock2) {
          System.out.println("t1: lock2 획득");
        }
      }
    });

    Thread t2 = new Thread(() -> {
      synchronized (lock1) {
        System.out.println("t2: lock1 획득");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        synchronized (lock2) {
          System.out.println("t2: lock2 획득");
        }
      }
    });

    t1.start();
    t2.start();
  }
}