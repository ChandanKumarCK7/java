package DesignPatterns;






// Factory Method just like Abstract Factory Pattern allows the subclasses
// to decide what class has to be instantiated - REF1

// Factory Method can be chosen over Abstract Factory Pattern when single object such as vehicle
// or document has to be created instead of multiple families of objects.




// single object Vehicle
interface Vehicle{
    public int getCost();
}

class Car implements Vehicle{
    int cost = 50;
    public Car(){

    }

    public int getCost(){
        return cost;
    }
}
class Bike implements Vehicle{
    int cost = 50;
    public Bike(){

    }

    public int getCost(){
        return cost;
    }
}
class Factory{
    public Vehicle getCost(String vehicleType){
        return vehicleType.equalsIgnoreCase("Car") ? new Car() :
                vehicleType.equalsIgnoreCase("Bike") ? new Bike() :null;
    }
}
class FactoryMethod {
    public static void main(String[] args){
        Factory f =new Factory();
        Vehicle v = f.getCost("Car");
        System.out.println(v.getCost());
    }
}




// Example 2



// Single object - Document
interface Document {
    void save();
}

class WordDocument implements Document {
    @Override
    public void save() {
        System.out.println("word save");
    }

}

class TextDocument implements Document {
    // Implementation for plain text documents
    @Override
    public void save() {
        System.out.println("text save");
    }
}

// Factory Method pattern
interface DocumentFactory { // REF1 subclass that decides what class has to be instatiated at runtime
    Document createDocument();
}

class WordDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class TextDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new TextDocument();
    }
}

class FactoryMethodExample{
    public static void main(String[] args) {
        DocumentFactory textFactory = new TextDocumentFactory();
        Document textDocument = textFactory.createDocument();
        textDocument.save();

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDocument = wordFactory.createDocument();
        wordDocument.save();


    }
}