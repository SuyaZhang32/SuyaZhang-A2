public class Visitor extends Person {
    // Instance variables specific to Visitor
    private String membershipId;
    private String membershipType;
    private int membershipPoints;

    // Default constructor
    public Visitor() {
        super();
    }

    // Parameterized constructor
    public Visitor(String name, int age, String address, String phoneNumber,  String membershipId, String membershipType, int membershipPoints) {
        super(name, age,address,phoneNumber); // Calls the parameterized constructor of Person
        this.membershipId = membershipId;
        this.membershipType = membershipType;
        this.membershipPoints = membershipPoints;
    }

    // Getters and setters for Employee variables
    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }


    // Method to format the Visitor's data into a string
    public static String formatString(Visitor visitor) {
        // Using getters to access the Visitor's data
        String name = visitor.getName();
        int age = visitor.getAge();
        String address = visitor.getAddress();
        String phoneNumber = visitor.getPhoneNumber();
        String membershipId = visitor.getMembershipId();
        String membershipType = visitor.getMembershipType();
        int membershipPoints = visitor.getMembershipPoints();

        // Concatenating the data into the specified format
        return String.format("%s,%d,%s,%s,%s,%s,%d",
                name, age, address, phoneNumber, membershipId, membershipType, membershipPoints);
    }

    // Static method to create a Visitor object from a String representation
    public static Visitor fromString(String visitorStr) {
        // Split the input string by commas
        String[] parts = visitorStr.split(",");

        // Check if the input string was split into the expected number of parts
        if (parts.length != 7) {
            System.err.println("Error: Input string format is incorrect. Expected 7 parts.");
            return null;
        }

        try {
            // Trim whitespace and parse the parts
            String name = parts[0].trim();
            int age = Integer.parseInt(parts[1].trim());
            String address = parts[2].trim();
            String phoneNumber = parts[3].trim();
            String membershipId = parts[4].trim();
            String membershipType = parts[5].trim();
            int membershipPoints = Integer.parseInt(parts[6].trim());

            // Create and return a new Visitor object
            return new Visitor(name, age, address, phoneNumber, membershipId, membershipType, membershipPoints);
        } catch (NumberFormatException e) {
            // Handle the case where age or membershipPoints is not a valid number
            System.err.println("Error: One or more numeric fields in the input string are invalid.");
            return null;
        }
    }


    @Override
    public String toString() {
        return "Visitor{" +
                "membershipId='" + membershipId + '\'' +
                ", membershipType='" + membershipType + '\'' +
                ", membershipPoints=" + membershipPoints +
                ", " + super.toString() +
                '}';
    }
}
