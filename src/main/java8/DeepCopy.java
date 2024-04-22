












class POJO implements Cloneable {
    int v;


    public POJO(int v) {
        this.v = v;
    }



    public POJO clone() throws CloneNotSupportedException {
        return (POJO)super.clone();
    }

}

public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {



    POJO p = new POJO(5);
    POJO p8 = p.clone();

    System.out.println(p==p8);
    System.out.println(p.hashCode()+"     "+p8.hashCode());

    System.out.println(p.equals(p8));

    p8.v = 9;
    System.out.println(p==p8);

    System.out.println(p.equals(p8));




    }












}
