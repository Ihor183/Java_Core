package pack_salary;

public class EmployeeHourlyPayment implements Salary {
    private double charge_per_hour;
    private int number_of_hour;

    EmployeeHourlyPayment () {
        charge_per_hour = 12.5;
        number_of_hour = 200;
    }

    public EmployeeHourlyPayment(double charge_per_hour, int number_of_hour) {
        this.charge_per_hour = charge_per_hour;
        this.number_of_hour = number_of_hour;
    }

    @Override
    public void salary() {
        System.out.println("Salary = " + charge_per_hour * number_of_hour);
    }
}
