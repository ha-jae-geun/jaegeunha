package net.java_school.thread.test;

public class test implements Runnable {

    public void doA() {
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J'};
        int length = alphabet.length;
        for ( int i = 0; i < length; i++ ) {
            System.out.print(alphabet[i]);

            try {
                // 테스트가 되기 위해 0.01초 쉬어 다른 쓰레드가 제어권을 갖도록 한다.
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void doB() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);

            try {
                // 테스트가 되기 위해 0.01초 쉬어 다른 쓰레드가 제어권을 갖도록 한다.
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void run() {
        doA();
    }

    public static void main(String[] args) {
        test mt2 = new test();
        Thread t = new Thread(mt2);
        t.start();
        mt2.doB();
    }
}