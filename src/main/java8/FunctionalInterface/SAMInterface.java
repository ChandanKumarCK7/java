package FunctionalInterface;





@FunctionalInterface
interface Functional{
    public abstract int multiply(int a, int b);
}





public class SAMInterface {
    public static void main(String[] args){

        // Sample Example to Create a SAMInterface and then call it's abstract method using lambda

        Functional f = (a, b) -> a * b;
        System.out.println(f.multiply(6, 7));






    }


}
