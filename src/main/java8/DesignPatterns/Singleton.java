package DesignPatterns;




class SingletonPojo{
    private static SingletonPojo singleton;
    private SingletonPojo(){ // private so that in some other files Singleton o = new Singleton() cant be used
    }

    public static SingletonPojo getInstance(){
        if (singleton == null)
            singleton = new SingletonPojo();
        return singleton;
    }
}
public class Singleton {
    public static void main(String[] args){
        SingletonPojo p = SingletonPojo.getInstance();
        System.out.println(p);
        SingletonPojo p1 = SingletonPojo.getInstance();
        System.out.println(p1);

//        SingletonPojo o = new SingletonPojo();       // that will fail surely because private constructor is of type private

    }
}











