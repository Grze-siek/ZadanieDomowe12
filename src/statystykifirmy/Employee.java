package statystykifirmy;

public class Employee {
    private String firstName;
    private String lastName;
    private String id;
    private String employeeSection;
    private String salary;

    public Employee(String firstName, String lastName, String id, String employeeSection, String salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.employeeSection = employeeSection;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", employeeSection='" + employeeSection + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    public String getEmployeeSection() {
        return employeeSection;
    }

    public String getSalary() {
        return salary;
    }
}
