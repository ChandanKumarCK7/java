package DesignPatterns;




// Prototype pattern can be useful when there will e many attributes of a class and so if there is an existing object
// then clone that and then modify the required attributes in cloned object

// since creating an object from scratch can be costly if there will be huge processing in the creation of object.


class PrototypePojo{
    int v;
    public PrototypePojo(int v){
        this.v = v;
    }
    public PrototypePojo getcopy(){
        return new PrototypePojo(this.v);
    }
}
public class Prototype {
    public static void main (String[] args){
        PrototypePojo p = new PrototypePojo(5);
        System.out.println(p);
        PrototypePojo p1 = p.getcopy();
        System.out.println(p1);

    }
}
