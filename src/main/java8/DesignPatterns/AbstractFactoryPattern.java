package DesignPatterns;





// Abstract Factory Pattern just like Factory Method Pattern allows the subclasses
// to decide what class has to be instantiated - REF1






// Family of objects - GUI components
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Abstract Factory pattern - Abstract factory interface for creating GUI components
interface GUIFactory { // REF1
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete implementations for Windows platform
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Windows button rendered.");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Windows checkbox rendered.");
    }
}

// Concrete implementations for MacOS platform
class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("MacOS button rendered.");
    }
}

class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("MacOS checkbox rendered.");
    }
}

// Concrete factories for Windows and MacOS
class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}




public class AbstractFactoryPattern {
    public static void main(String[] args){
        GUIFactory windowsFactory = new WindowsGUIFactory();
        Button windowsButton = windowsFactory.createButton();
        windowsButton.render();

        GUIFactory macFactory = new MacOSGUIFactory();
        Button macButton = macFactory.createButton();
        macButton.render();

        Checkbox windowsCheckbox = windowsFactory.createCheckbox();
        windowsCheckbox.render();

        Checkbox macCheckbox= macFactory.createCheckbox();
        macCheckbox.render();

    }
}
