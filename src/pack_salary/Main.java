package pack_salary;

public class Main {
    public static void main(String[] args) {
        EmployeeFixedSalary employeeFixedSalary = new EmployeeFixedSalary(1400);
        EmployeeHourlyPayment employeeHourlyPayment = new EmployeeHourlyPayment(14, 200);

        employeeFixedSalary.salary();
        employeeHourlyPayment.salary();
    }
}
