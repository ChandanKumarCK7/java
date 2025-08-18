package Threads;






class Appender{
    public StringBuilder output = new StringBuilder();
    boolean numberTurn = true;

    public synchronized StringBuilder getOutput(){
        return this.output;
    }

    public synchronized void appendNumber(String c){
        while (numberTurn == false){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        System.out.println("NumberAppended");
        output.append(c);
        numberTurn=false;
        notify();
    }

    public synchronized void appendAlpha(String c){
        while (numberTurn == true){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        output.append(c);
        numberTurn=true;
        notify();
    }

}


class AlphaGenerator implements Runnable{
    Appender appender;

    public AlphaGenerator(Appender appender) {
        this.appender = appender;
    }

    @Override
    public void run() {
        for(char c = 'a'; c<='z'; c++){
//            System.out.println("Alpha");
            appender.appendAlpha(String.valueOf(c));
        }
    }
}

class NumberGenerator implements Runnable{
    Appender appender;

    public NumberGenerator(Appender appender) {
        this.appender = appender;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 25; i++){
//            System.out.println("Number");
            appender.appendNumber(String.valueOf(i));
        }
    }
}

class TwoThreadsNumAlpha {



    public static void main(String[] args){

        Appender appender = new Appender();

        Thread t1 = new Thread(new AlphaGenerator(appender));
        Thread t2 = new Thread(new NumberGenerator(appender));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(appender.getOutput().toString());


    }




}