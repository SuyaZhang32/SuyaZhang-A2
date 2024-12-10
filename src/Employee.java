// The Employee class inherits from the Person class and represents the specific information of the employee
public class Employee extends Person {
    // Instance variables specific to Employee
    private String employeeId;
    private String department;
    private String role;

    // Default constructor
    public Employee() {
        super();
    }

    // Parameterized constructor
    public Employee(String name, int age, String address, String phoneNumber, String employeeId,String department, String role) {
        super(name, age,address,phoneNumber); // Calls the parameterized constructor of Person
        this.employeeId = employeeId;
        this.department = department;
        this.role = role;
    }

    // Getters and setters for Employee variables
    // Getter method - Gets the employee number
    public String getEmployeeId() {
        return employeeId;
    }
    // Setter method - Set the employee number
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    // Getter method - gets the corner role of the employee
    public String getRole() {
        return role;
    }
    // Setter method - Sets the role of the employee
    public void setRole(String role) {
        this.role = role;
    }
    // Getter method - gets the department of the employee
    public String getDepartment() {
        return department;
    }
    // Setter method - Sets the department of the employee
    public void setDepartment(String department) {
        this.department = department;
    }

    // Returns a string representation containing all attribute information of the employee
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", " + super.toString() +'}';
    }
}

