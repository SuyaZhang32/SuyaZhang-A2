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
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", " + super.toString() +'}';
    }
}

