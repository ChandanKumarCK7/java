package DesignPatterns;












// Object Pool Pattern is quite useful. It's often employed in situations
// where resources are limited, such as network connections, database connections,
// or other expensive-to-create
// objects, and where reusing these resources or objects can help reduce system load and improve performance.

import java.util.ArrayList;
import java.util.List;

// Object Pool for managing connections
class ConnectionPool {
    private List<Connection> connections;
    private int maxPoolSize;

    public ConnectionPool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        this.connections = new ArrayList<>();
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < maxPoolSize; i++) {
            connections.add(new Connection());
        }
    }

    public Connection borrowConnection() {
        if (!connections.isEmpty()) {
            Connection connection = connections.remove(0);
            System.out.println("Borrowed connection: " + connection.getId()+" by "+Thread.currentThread());
            return connection;
        }
        System.out.println("No available connections.");
        return null;
    }

    public void returnConnection(Connection connection) {
        if (connections.size() < maxPoolSize) {
            connections.add(connection);
            System.out.println("Returned connection: " + connection.getId() +" by "+Thread.currentThread());
        } else {
            System.out.println("Pool is full. Connection not returned.");
        }
    }
}

// Object representing a Connection
class Connection {
    private static int nextId = 1;
    private int id;

    public Connection() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }
}

public class ObjectPool {
    public static void main(String[] args) {
        int maxPoolSize = 5;
        ConnectionPool connectionPool = new ConnectionPool(maxPoolSize);

        // Simulate clients borrowing and returning connections
        new Thread(() -> {
            for (int i = 0; i < 7; i++) {
                Connection connection = connectionPool.borrowConnection();
                if (connection != null) {
                    // Simulate using the connection
                    // ...

                    // Return the connection to the pool
                    connectionPool.returnConnection(connection);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 7; i++) {
                Connection connection = connectionPool.borrowConnection();
                if (connection != null) {
                    // Simulate using the connection
                    // ...

                    // Return the connection to the pool
                    connectionPool.returnConnection(connection);
                }
            }
        }).start();

        // or

//        ThreadCreator t1 = new ThreadCreator();
//        ThreadCreator t8 = new ThreadCreator();
//
//        t1.start();
//        t8.start();


    }
}

class ThreadCreator extends Thread{
    int maxPoolSize = 5;
    ConnectionPool connectionPool = new ConnectionPool(maxPoolSize);

    public void run(){
        for (int i = 0; i < 7; i++) {
            Connection connection = connectionPool.borrowConnection();
            if (connection != null) {
                // Simulate using the connection
                // ...

                // Return the connection to the pool
                connectionPool.returnConnection(connection);
            }
        }
    }
}
