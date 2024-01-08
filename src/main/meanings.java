









Comparable vs the Comparator - Comparable is used to sort elements in pojo using implicit sorting mechanism meaning, that there will be
a compareTo method in that class that implements Comparable and then we can just call Collections.sort(people)

Comparator is used to sort elements in pojo explicitly meaning compareTo method wont be used but programmer has to define a compare()
and that will be called Collection.sort(people, new ComparatorImpl());

Explain about the Solid Principles in java?
     Solid principles are considered as good practices of java programming that makes sure that code will be clean and easily
modularized or changed in future without causing major issues or code revamps

    1- Single Responsibility Principle or SRP
    SRP says that basically there has to be a class serving for one particular purpose only Ex ->

    if there will be class as Report that should handle generateReport() method only if downloadingReport() has to be handled
    define downloadingReport() as part of another class such as ReportDownloader

    2- Open or Closed Principle OCP
    that says only that when you want to calculateArea() of a rectangle then dont create a class to handle calculateArea(Rectangle rectangle)
        rather create just like interface(Shape) -----> class(Rectangle) that contains calculateArea()

    so waht exactly will happen then is that if new shapr will be introduced we can create new class of that shape and implement
    rather than modifying the CalculateArea class that will be overloaded with multiple shape logic

    3- Liskov Substitution Principle LSP
    that says that if you have a subclass that is derived from a superclass then that subclass should be able to accept

    4- interface segregation -
    make sure that an interface supports has only one purpose meaning try to split interface as much as possible
        else the classes that implement have to provide implementation to all of them

    5- Dependency Inversion
        that makes sure that a higherLevel class wont be dependent on lower level class only
        ex - PricePlan is a concrete class that has an attribute DiscountCalculator;

        make sure that the member variable discountCalculator will be either an interface or abstract class
        because high level of concrete classes should depend on abstract class or interface not on concrete class


what are the thread lifecycles -
    new - whenever a thread will be created that will be in new state though execution hasnt started yet // Thread t = new Thread();
    active - whenever a thread will be started it will be in active, There are two types
        Runnable - a thread that will be ready to run is in Runnable state
        Runing -  a thread that will be in running state where run() method will be used by thread
    blocked or the waiting state - whenever a thread will be inactive for certain timethat is in blocked state
    timed waiting - a thread started execution and enters critical section then goes to sleep so threadB has to wait until
    other thread will be awake and exits critical section

what is the wait method used for
wait method will make sure that current thread will be put into waiting stake until other thread will coplete its task and triggers notify

locks are used in a multithreaded environment to prevent deadlocks in java
ReadLock will make sure that when a thread acquires write lock on a resource then all other threads that access to only read but cant write

reentrantlock will make sure that when one thread acquires lock then until that thread will unlock no other thread can access
resource

POST vs  the request PUT - when there will be a record already present in db and then u have to update then use PUT
when u want to insert a new record then use POST.

PATCH vs the request PUT - when there will be a small data change such as specific columns to be changed then use PATCH
where PUT will be used to update entire row


so why exactly compiler cant perform dynamic binding
 example

class Vehicle
{
    void move()
}

    class Bike extends Vehicle{ void move()}
    class Car extends Vehicle{ void move}

    main(){
        Vehicle v = generateObject(number_of_tyre_require_for_vehicle);
        v.move(); // compiler cant predict what move method to call either in bike or car because the instance will be provides
        // dynamically based on the number of tyres required in above code
        }

explain about the thread priorities -
        so usualy there will be about all threads be given norm_priority that will be 5 by scheduler

though using the setPriority in Thread class we can change
the types of thread priorities are - MIN, NORM, MAx

though the scheduler cant always guarantee that thread with higher priority will be picked to execute

What is the particular deamon thread
    deamon thread of java is basically a thread that can be user created or system created and the benefir of that is that
these kind of threads will be running until jvm will be in execution , and whenever jvm wants to exit that wont care if

daemon wil be running or not. so these threads cant be used for core functionality they shall be only used to perform some
of the automatic synchrnozation or background tasks that have lowest priority.

Serialization
    when an object has to be stored in db or a file or transmitted then usually that object will be converted to stream of bytes

and then that object will be stored

to serialize an object you have to implements serializable interface in POJO class

ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("path"));
    o.writeObject(person);

ObjectInputStream o = new ObjectInputStream(new FileInputStream("path"));
    Person p = (Person) o.readObject();

    or

        OutputStream os = new FileOutputStream("data.bin");
        os.write(data);

        InputStream is = new FileInputStream("data.bin");
        byte[] Buffer = new byte[5];
        is.read(buffer);

What is the purpose of having transient keyword
    that helps to make sure that a field in the pojo wont be part of serialization

assume there will be 5 threads that produce simultaneously and suddenly they move to waiting state because there is one consumer
only and that is yet to consume so out of those 5 producers what will resume prodcuing when consumer notifies?

    behaviour will be arbitrary meaning any of those 5 threads can be picked by thread scheduler to resume producing

Q- in the scenario of string buffer having being used by one thread only, will the performance be on par with
stringbuilder?

yeah there wont be performance drop to access that object because only in case of multiple threads there
will be drop of performance on that stringbuffer object to provide synchronization

Q- usually as part of marker interface there will be no methods or variables then what is the purpose of that

Q- so how to achieve concurreny?
1- synchronization with the synchronized keyword on method or synchronized block
-    locks in the concurrent package also help to achieve concurrency

tell the particular like ways to talk to relational databases in java
hibernate, jpa really just like two main ways to communicate to relational databases.

Q- explain about equals method
    usually that just compares memory address of the object for any custom class object, where as when comparing string
    that compares the equality of string irrespective of memory address of the objects

    we need not override equals method but we have to override for custom comparision.

example -

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return Objects.equals(name, person.name) &&
            Objects.equals(address, person.address);
        }

Q- what is the difference between compareTo and compare method
    compareTo is part of the comparable interface where was compare is part of the comparator interface.classes
    that implement those interfaces will have these methods by default

    compareTo compares the current object with the specified object
    compare compares the first object in parameter with the second object passed in parameter

Q- so why exactly is it import to override hashcode when equals is overriden
    usually hashCode() not implemented same across all platforms and it can be independant

    and also one thing that has to be taken caare is lets say there is a pojo Person that has equals() overiden not hashCode()
    then person1 and person8 are stored on two different locations

            person1 p1 = new Person("name1");
            person8 p8 = new Person("name1");

            hashmap.put(p1);
            hashmap.put(p8);

        then if the equals() will be overriden based on name then it returns true
        but hashCode() will be based on memory locations and here we have used new Operator so memory locations differ

        then hashCode() will be different and that breaks the contract of equals() and hashCode() aggrement.class

    hence always rcomended to overide hashCode() when equals() will be overriden and provide implementation of hashCode()
    not based on memory location but based on an attribute

Q- explain about the heap and stack memory
    heap memory usually contains objects that are common to all of threads such as collection objects and stack memory on other hand
    contains data such as threads local variables present in the run() associated to each thread










