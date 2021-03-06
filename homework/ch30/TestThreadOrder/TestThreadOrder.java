import java.util.concurrent.Semaphore;

public class TestThreadOrder {
    public static Semaphore semaphore2 = new Semaphore(0);
    public static Semaphore semaphore3 = new Semaphore(0);
    public static void main(String[] argv){
        Test_work1 r1 = new Test_work1();
        Test_work2 r2 = new Test_work2();
        Test_work3 r3 = new Test_work3();
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        Thread thread3 = new Thread(r3);
        thread2.start();
        thread1.start();
        thread3.start();
    }
}

class Test_work1 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(15);
            System.out.println("Finished work1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            TestThreadOrder.semaphore2.release();
        }
    }
}

class Test_work2 implements Runnable {
    @Override
    public void run() {
        try {
            TestThreadOrder.semaphore2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5);
            System.out.println("Finished work2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            TestThreadOrder.semaphore3.release();
        }
    }
}

class Test_work3 implements Runnable {
    @Override
    public void run() {
        try {
            TestThreadOrder.semaphore3.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5);
            System.out.println("Finished work3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}