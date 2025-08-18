package DesignPatterns;



interface Coffee{
    String getDescription();
    double getCost();
}

class PlainCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Plain Coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}

// make DecoratorCoffee as Abstract so that direct instantiation like "new DecoratorCoffee()" can be prevented at compiletime
abstract class DecoratorCoffee implements Coffee{
    Coffee decoratedCoffee;

    public DecoratorCoffee(Coffee decoratedCoffee){
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

class MilkDecorator extends DecoratorCoffee{
    public MilkDecorator(Coffee decoratedCoffee){
        // calling super class helps to maintain the decoratedCoffe globally, so that even other Decorators like SugarMilkDecorator can use it.
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}

class SugarMilkDecorator extends DecoratorCoffee{
    public SugarMilkDecorator(Coffee decoratedCoffee){
        // calling super class helps to maintain the decoratedCoffe globally, so that even other Decorators like MilkDecorator can use it.
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.2;
    }
}

public class Decorator {
    public static void main(String[] args){


        Coffee coffee = new PlainCoffee();
        Coffee milkCoffee = new MilkDecorator(new PlainCoffee());
        Coffee SugarMilkCoffee = new SugarMilkDecorator(new MilkDecorator(new PlainCoffee()));

        System.out.println("coffee "+coffee.getCost());
        System.out.println("milkCoffee "+milkCoffee.getCost());
        System.out.println("SugarMilkCoffee "+SugarMilkCoffee.getCost());

    }
}
