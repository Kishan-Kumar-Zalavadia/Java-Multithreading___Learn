package demo4;

import java.util.Scanner;

class Processor extends Thread{

    private volatile boolean running = true;
    // volatile: Use to prevent threads caching variables when they are not changed from within that thread (i.e., change variable from other thread.
    // If other thread is changing value then use volatile.

    public void run() {
        while(running){
            System.out.println("JSK!!");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running=false;
    }
}

public class App {
    public static void main(String[] args) {
        Processor p1 = new Processor();
        p1.start();

        System.out.println("Print return to stop....");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        p1.shutdown();

    }
}
