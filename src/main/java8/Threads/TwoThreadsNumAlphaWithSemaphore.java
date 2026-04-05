package Threads;


import java.util.concurrent.Semaphore;

class Appender1 {
    private final StringBuilder output = new StringBuilder();

    public void append(String s) {
        output.append(s);
    }

    public String getOutput() {
        return output.toString();
    }
}

class AlphaGenerator1 implements Runnable {
    private final Appender1 appender;
    private final Semaphore alphaSem;
    private final Semaphore numberSem;

    public AlphaGenerator1(Appender1 appender, Semaphore alphaSem, Semaphore numberSem) {
        this.appender = appender;
        this.alphaSem = alphaSem;
        this.numberSem = numberSem;
    }

    @Override
    public void run() {
        for (char c = 'a'; c <= 'z'; c++) {
            try {
                // Wait for turn to append alpha
                alphaSem.acquire();
                appender.append(String.valueOf(c));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } finally {
                // Signal number thread to proceed next
                numberSem.release();
            }
        }
    }
}

class NumberGenerator1 implements Runnable {
    private final Appender1 appender;
    private final Semaphore alphaSem;
    private final Semaphore numberSem;

    public NumberGenerator1(Appender1 appender, Semaphore alphaSem, Semaphore numberSem) {
        this.appender = appender;
        this.alphaSem = alphaSem;
        this.numberSem = numberSem;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 25; i++) {
            try {
                // Wait for turn to append number
                numberSem.acquire();
                appender.append(String.valueOf(i));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } finally {
                // Signal alpha thread to proceed next
                alphaSem.release();
            }
        }
    }
}

public class TwoThreadsNumAlphaWithSemaphore {
    public static void main(String[] args) {
        Appender1 appender = new Appender1();

        // Choose who starts:
        // If numbers should start, numberSem=1 and alphaSem=0.
        // If letters should start, alphaSem=1 and numberSem=0.
        Semaphore numberSem = new Semaphore(1); // numbers go first
        Semaphore alphaSem = new Semaphore(0);

        Thread tAlpha = new Thread(new AlphaGenerator1(appender, alphaSem, numberSem));
        Thread tNum = new Thread(new NumberGenerator1(appender, alphaSem, numberSem));

        tAlpha.start();
        tNum.start();

        try {
            tAlpha.join();
            tNum.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(appender.getOutput());
    }
}
