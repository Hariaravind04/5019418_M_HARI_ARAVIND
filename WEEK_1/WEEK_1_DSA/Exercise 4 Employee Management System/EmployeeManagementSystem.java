public class EmployeeManagementSystem {

    static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;
        
        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee [ID=" + employeeId + ", Name=" + name + ", Position=" + position + ", Salary=" + salary + "]";
        }
    }

    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count == employees.length) {
            System.out.println("Array is full. Cannot add more employees.");
            return;
        }
        employees[count++] = employee;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i] = employees[count - 1];
                employees[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(10);
        
        system.addEmployee(new Employee(1, "Alice", "Manager", 70000));
        system.addEmployee(new Employee(2, "Bob", "Developer", 50000));
        system.addEmployee(new Employee(3, "Charlie", "Designer", 60000));
        
        System.out.println("Employee records:");
        system.traverseEmployees();

        System.out.println("Searching for employee with ID 2:");
        Employee emp = system.searchEmployee(2);
        if (emp != null) {
            System.out.println("Found: " + emp);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("Deleting employee with ID 2:");
        system.deleteEmployee(2);
        
        System.out.println("Employee records after deletion:");
        system.traverseEmployees();
    }
}
