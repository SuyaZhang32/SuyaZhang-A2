import java.util.ArrayList;

public class AssignmentTwo {
    // Create an instance of AssignmentTwo and call the methods of each task section in turn
    public static void main(String[] args) {
        AssignmentTwo assignmentTwo = new AssignmentTwo();
        assignmentTwo.partThree();
        assignmentTwo.partFourA();
        assignmentTwo.partFourB();
        assignmentTwo.partFive();
        assignmentTwo.partSix();
        assignmentTwo.partSeven();
    }

    public void partThree(){
        // Create an employee object
        Employee employee = new Employee(
                "John Doe",         // name
                30,                 // age
                "123 Main St",      // address
                "555-5555",         // phoneNumber
                "E001",             // employeeId
                "Rides",      // department
                "Staff" // role
        );
        // Create a new Ride object
        Ride ride = new Ride("Green Lantern Coaster",500,true,employee,2);
        Visitor visitor1 = new Visitor("Alice", 30, "123 Main St", "555-1234", "M001", "Gold", 150);
        Visitor visitor2 = new Visitor("Bob", 25, "456 Elm St", "555-5678", "M002", "Silver", 100);
        Visitor visitor3 = new Visitor("Charlie", 35, "789 Oak St", "555-9101", "M003", "Gold", 150);
        Visitor visitor4 = new Visitor("Diana", 28, "101 Maple St", "555-2345", "M004", "Bronze", 50);
        Visitor visitor5 = new Visitor("Eve", 22, "202 Birch St", "555-6789", "M005", "Silver", 100);
        Visitor visitor6 = new Visitor("David Clark", 50, "303 Elm Street", "555-3456", "MEM006", "VIP", 750);


        // Add a minimum of 6 Visitors to the Queue
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);
        ride.addVisitorToQueue(visitor6);

        // Remove a Visitor from the Queue
        Visitor removedVisitor = ride.removeVisitorFromQueue();
        if (removedVisitor != null) {
            System.out.println("Removed visitor: " + removedVisitor);
        }

        // Print all Visitors in the Queue
        ride.printQueue();
    }

    public void partFourA(){
        Employee employee = new Employee(
                "John Doe",         // name
                30,                 // age
                "123 Main St",      // address
                "555-5555",         // phoneNumber
                "E001",             // employeeId
                "Rides",      // department
                "Staff" // role
        );
        // Create a new Ride object
        Ride ride = new Ride("Green Lantern Coaster",500,true,employee,2);
        Visitor visitor1 = new Visitor("Alice", 30, "123 Main St", "555-1234", "M001", "Gold", 150);
        Visitor visitor2 = new Visitor("Bob", 25, "456 Elm St", "555-5678", "M002", "Silver", 100);
        Visitor visitor3 = new Visitor("Charlie", 35, "789 Oak St", "555-9101", "M003", "Gold", 150);
        Visitor visitor4 = new Visitor("Diana", 28, "101 Maple St", "555-2345", "M004", "Bronze", 50);
        Visitor visitor5 = new Visitor("Eve", 22, "202 Birch St", "555-6789", "M005", "Silver", 100);
        Visitor visitor6 = new Visitor("David Clark", 50, "303 Elm Street", "555-3456", "MEM006", "VIP", 750);

        // Add Visitors to the Ride's history queue
        ride.addVisitorToHistory(visitor1);

        ride.addVisitorToHistory(visitor2);

        ride.addVisitorToHistory(visitor3);

        ride.addVisitorToHistory(visitor4);

        ride.addVisitorToHistory(visitor5);

        ride.addVisitorToHistory(visitor6);

        // Check if a Visitor is in the collection
        ride.checkVisitorFromHistory(visitor3);

        // Print the number of Visitors in the collection
        ride.numberOfVisitors();

        // Print all Visitors in the collection
        ride.printRideHistory();

    }

    public void partFourB(){

        Employee employee = new Employee(
                "John Doe",         // name
                30,                 // age
                "123 Main St",      // address
                "555-5555",         // phoneNumber
                "E001",             // employeeId
                "Rides",      // department
                "Staff" // role
        );
        // Create a new Ride object
        Ride ride = new Ride("Green Lantern Coaster",500,true,employee,2);
        Visitor visitor1 = new Visitor("Alice", 30, "123 Main St", "555-1234", "M001", "Gold", 150);
        Visitor visitor2 = new Visitor("Bob", 25, "456 Elm St", "555-5678", "M002", "Silver", 100);
        Visitor visitor3 = new Visitor("Charlie", 35, "789 Oak St", "555-9101", "M003", "Gold", 150);
        Visitor visitor4 = new Visitor("Diana", 28, "101 Maple St", "555-2345", "M004", "Bronze", 50);
        Visitor visitor5 = new Visitor("Eve", 22, "202 Birch St", "555-6789", "M005", "Silver", 100);
        Visitor visitor6 = new Visitor("David Clark", 50, "303 Elm Street", "555-3456", "MEM006", "VIP", 750);

        // Add Visitors to the Ride's history queue
        ride.addVisitorToHistory(visitor1);

        ride.addVisitorToHistory(visitor2);

        ride.addVisitorToHistory(visitor3);

        ride.addVisitorToHistory(visitor4);

        ride.addVisitorToHistory(visitor5);

        ride.addVisitorToHistory(visitor6);

        // Print all Visitors in the collection
        ride.printRideHistory();
        //sort the rideHistory collection
        ride.sortRideHistory();
        // Print all Visitors in the collection
        ride.printRideHistory();
    }
    public void partFive(){
        // Create a new Ride object with specified attributes
        Employee employee = new Employee(
                "John Doe",         // name
                30,                 // age
                "123 Main St",      // address
                "555-5555",         // phoneNumber
                "E001",             // employeeId
                "Rides",      // department
                "Staff" // role
        );
        Ride ride = new Ride("Ferris Wheel", 20, true, employee, 4);

        // Add a minimum of 12 Visitors to the Queue
        for (int i = 1; i <= 12; i++) {
            Visitor visitor = new Visitor("Visitor " + i, 20 + (i % 10), "Address " + i, "Phone " + i, "M" + String.format("%03d", i), "Gold", 100 + (i * 10));
            ride.addVisitorToQueue(visitor);
        }

        // Print all Visitors in the queue
        System.out.println("Visitors in the queue before running the ride:");
        ride.printQueue();

        // Run one cycle of the ride
        ride.runOneCycle();

        // Print all Visitors in the queue after one cycle is run
        System.out.println("Visitors in the queue after running one cycle:");
        ride.printQueue();

        // Print all Visitors in the collection (ride history)
        System.out.println("Visitors who have taken the ride:");
        ride.printRideHistory();
    }
    public void partSix(){
        Employee employee = new Employee(
                "John Doe",         // name
                30,                 // age
                "123 Main St",      // address
                "555-5555",         // phoneNumber
                "E001",             // employeeId
                "Rides",      // department
                "Staff" // role
        );
        // Create a new Ride object
        Ride ride = new Ride("Green Lantern Coaster",500,true,employee,2);
        Visitor visitor1 = new Visitor("Alice", 30, "123 Main St", "555-1234", "M001", "Gold", 150);
        Visitor visitor2 = new Visitor("Bob", 25, "456 Elm St", "555-5678", "M002", "Silver", 100);
        Visitor visitor3 = new Visitor("Charlie", 35, "789 Oak St", "555-9101", "M003", "Gold", 150);
        Visitor visitor4 = new Visitor("Diana", 28, "101 Maple St", "555-2345", "M004", "Bronze", 50);
        Visitor visitor5 = new Visitor("Eve", 22, "202 Birch St", "555-6789", "M005", "Silver", 100);
        Visitor visitor6 = new Visitor("David Clark", 50, "303 Elm Street", "555-3456", "MEM006", "VIP", 750);

        // Add visitors to play history
        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);
        ride.addVisitorToHistory(visitor6);

        // Export play history to CSV file
        ride.exportRideHistory("/Users/32hz./Desktop/SuyaZhang-A2/data/ride_history.csv");
    }

    public void partSeven(){
        Employee employee = new Employee(
                "John Doe",         // name
                30,                 // age
                "123 Main St",      // address
                "555-5555",         // phoneNumber
                "E001",             // employeeId
                "Rides",      // department
                "Staff" // role
        );
        // Create a new Ride object
        Ride ride = new Ride("Green Lantern Coaster",500,true,employee,2);
        // Import play history from CSV file
        ride.importRideHistory("/Users/32hz./Desktop/SuyaZhang-A2/data/ride_history.csv");
        // Print the number of visitors and details in the tour history
        ride.numberOfVisitors();
        ride.printRideHistory();
    }

}