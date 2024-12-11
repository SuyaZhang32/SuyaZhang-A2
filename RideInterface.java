import java.util.Iterator;

public interface RideInterface {
    // Method to add a visitor to the queue
    void addVisitorToQueue(Visitor visitor);

    // Method to remove a visitor from the queue
    Visitor removeVisitorFromQueue();

    // Method to print the list of waiting visitors in the queue
    void printQueue();

    // Method to run the ride for one cycle
    void runOneCycle();

    // Method to add a visitor to the ride history
    void addVisitorToHistory(Visitor visitor);

    // Method to check whether the visitor is in the ride history
    boolean checkVisitorFromHistory(Visitor visitor);

    // Method to return the number of Visitors in the ride history
    int numberOfVisitors();

    // Method to print the list of visitors who took the rides
    void printRideHistory();
}


