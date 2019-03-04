package pack_salary;

public class EmployeeFixedSalary implements Salary {
    private double rate_per_month;

    EmployeeFixedSalary () {
        rate_per_month = 1200;
    }

    public EmployeeFixedSalary(double rate_per_month) {
        this.rate_per_month = rate_per_month;
    }

    @Override
    public void salary() {
        System.out.println("Salary = " + rate_per_month);
    }
}
