



class Cloneable1{
    int superV;

    public Cloneable1(int superV) {
        this.superV = superV;
    }


    public int getSuperV() {
        return superV;
    }

    public void setSuperV(int superV) {
        this.superV = superV;
    }
}
class Personal implements Cloneable{


    int v;
    Cloneable1 cv;

    public Cloneable1 getCv() {
        return cv;
    }

    public void setCv(Cloneable1 cv) {
        this.cv = cv;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public Personal(int v, Cloneable1 cv){
        this.v = v;
        this.cv = cv;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}





public class ShallowCopy{
    public static void main(String[] args) throws CloneNotSupportedException {

        Personal p = new Personal(5, new Cloneable1(9));
        Personal p1 = (Personal) p.clone();


        System.out.println(p == p1);
        p1.getCv().setSuperV(1);
        System.out.println(p == p1);
        System.out.println(p.getCv().getSuperV()+" "+p1.getCv().getSuperV());






    }
    public static void main(String[] args, String[] args1){

    }
}
