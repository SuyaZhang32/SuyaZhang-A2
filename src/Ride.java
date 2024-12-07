import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface{
    // Instance variables for the Ride class
    private String name;
    private int capacity;
    private boolean isOpen;
    private Employee rideOperator;
    // Specifies the maximum number of visitors per cycle
    private int maxRider;
    // Tracks the number of cycles the ride has completed
    private int numOfCycles;


    // Queue to manage visitors
    private Queue<Visitor> visitorQueue = new LinkedList<>();

    // Collection to store visitors who have taken the ride
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

    // Default constructor
    public Ride() {
        this.name = "Default Ride";
        this.capacity = 0;
        this.isOpen = false;
        this.rideOperator = null;
        this.maxRider = 1;
        this.numOfCycles = 0;
    }
    // Parameterized constructor
    public Ride(String name, int capacity, boolean isOpen, Employee rideOperator, int maxRider) {
        this.name = name;
        this.capacity = capacity;
        this.isOpen = isOpen;
        this.rideOperator = rideOperator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    // Method to add a visitor to the queue
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.offer(visitor);
        System.out.println(visitor.getName() + " has joined the  queue for the " + name + ".");
    }

    // Method to remove and return the next visitor from the queue
    @Override
    public Visitor removeVisitorFromQueue() {
        System.out.println("Remove Visitor From Queue ");
        return visitorQueue.poll();
    }


    // Method to print the list of queue
    @Override
    public void printQueue() {
        System.out.println("visitors for the " + name + ":");
        for (Visitor visitor : visitorQueue) {
            System.out.println(visitor.getName());
        }
    }


    // Method to add a visitor to the ride history
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " has been added to the ride history of the " + name + ".");
    }

    // Method to check whether the visitor is in the ride history
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor);
        if (found) {
            System.out.println(visitor.getName() + " has already taken the " + name + ".");
        } else {
            System.out.println(visitor.getName() + " has not taken the " + name + ".");
        }
        return found;
    }

    // Method to return the number of Visitors in the ride history
    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("The number of visitors who have taken the " + name + " is: " + count);
        return count;
    }

    // Method to print the details of all Visitors who have taken the Ride
    @Override
    public void printRideHistory() {
        System.out.println("Visitors who have taken the " + name + ":");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(visitor); // Assuming Visitor class has a properly overridden toString() method
        }
    }

    // Method to sort the rideHistory collection
    public void sortRideHistory() {
        rideHistory.sort(new VisitorComparator());
        System.out.println("Ride history sorted.");
    }
    // Getter and setter methods
    public String getName() {
        return name;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }


    // Method to execute one cycle of the ride
    @Override
    public void runOneCycle() {
        // Check if a ride operator is assigned
        if (rideOperator == null) {
            System.out.println("The ride cannot be run without a ride operator.");
            return;
        }

        // Check if there are any visitors in the queue
        if (visitorQueue.isEmpty()) {
            System.out.println("The ride cannot be run without any waiting visitors.");
            return;
        }

        // Determine the number of visitors to process, up to the maxRider limit
        int visitorsToProcess = Math.min(maxRider, visitorQueue.size());

        // Process the visitors
        for (int i = 0; i < visitorsToProcess; i++) {
            // Remove a visitor from the queue
            Visitor visitor = visitorQueue.poll();

            // Add the visitor to the ride history
            rideHistory.add(visitor);

            // Print a success message
            System.out.println(visitor.getName() + " has taken the ride: " + name);
        }

        // Increment the number of cycles
        numOfCycles++;

        // Print a message indicating the cycle has been completed
        System.out.println("Ride cycle completed. Total cycles: " + numOfCycles);
    }


    // Method to export ride history to a file
    public void exportRideHistory(String filePath) {
        // Check if the ride history is empty
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride yet, nothing to export.");
            return;
        }

        // Use try-with-resources to ensure BufferedWriter is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Iterate through the ride history and write each visitor's details
            for (Visitor visitor : rideHistory) {
                // Assuming Visitor class has a properly overridden toString() method
                writer.write(Visitor.formatString(visitor));
                writer.newLine();
            }
            System.out.println("Ride history successfully exported to " + filePath);
        } catch (IOException e) {
            // Handle file writing exceptions
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    public void importRideHistory(String filePath) {
        // Use try-with-resources to ensure BufferedReader is closed properly
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Assuming there's a way to create a Visitor from a String
                // This could be a constructor, a static factory method, or some other mechanism
                Visitor visitor = Visitor.fromString(line);
                if (visitor != null) {
                    // Add the visitor to the ride history
                    rideHistory.add(visitor);
                } else {
                    System.err.println("Failed to create a Visitor from the line: " + line);
                }
            }
            System.out.println("Ride history successfully imported from " + filePath);
        } catch (IOException e) {
            // Handle file reading exceptions
            System.err.println("Error reading from file: " + e.getMessage());
        } catch (Exception e) {
            // Handle other potential exceptions, such as issues with Visitor.fromString
            System.err.println("Error importing ride history: " + e.getMessage());
        }
    }

    // Getters and setters for the new instance variables
    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        if (maxRider > 0) {
            this.maxRider = maxRider;
        } else {
            System.out.println("maxRider must be at least 1.");
        }
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }

    // Optional: Override the toString() method for better representation of Ride objects
    @Override
    public String toString() {
        return "Ride{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", isOpen=" + isOpen +
                ", rideOperator=" + (rideOperator != null ? rideOperator.getName() : "null") +
                ", waitingVisitors=" + visitorQueue.size() +
                '}';
    }
}