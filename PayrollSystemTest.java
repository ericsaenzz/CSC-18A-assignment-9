import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Employee.BasePlusCommissionEmployee;
import Employee.CommissionEmployee;
import Employee.Employee;
import Employee.PieceWorker;
import Employee.SalariedEmployee;
import Employee.HourlyEmployee;

public class PayrollSystemTest{
    public static void main(String[] args) {
        // subclass
        SalariedEmployee salariedEmployee =
                new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
        HourlyEmployee hourlyEmployee =
                new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
        CommissionEmployee commissionEmployee =
                new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee =
                new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);
        PieceWorker pieceWorker =
                new PieceWorker("Lisa", "Brown", "555-55-5555", 2.50, 1000);

        System.out.println("Employees processed individually:");

        System.out.printf("%n%s%n%s: $%,.2f%n%n",
                salariedEmployee, "earned", salariedEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                hourlyEmployee, "earned", hourlyEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                commissionEmployee, "earned", commissionEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                pieceWorker, "earned", pieceWorker.earnings());

        // five-element Employee array
        Employee[] employees = new Employee[5];

        // initialize array with Employees
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = pieceWorker;

        System.out.printf("Employees processed polymorphically:%n%n");

        // process each element in array employees
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee);

            // determine if element is a BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                // downcast Employee to BasePlusCommissionEmployee
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf(
                        "new base salary with 10%% increase is: $%,.2f%n",
                        employee.getBaseSalary());
            }

            System.out.printf(
                    "earned $%,.2f%n%n", currentEmployee.earnings());
        }

        // get type name of each object in employees array
        for (int j = 0; j < employees.length; j++) {
            System.out.printf("Employee %d is a %s%n", j,
                    employees[j].getClass().getName());
        }
        //DATE AND TIME FORMATTER
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MM-dd-yyyy , (HH:mm:ss a)");
        String Date_and_time = now.format(formatter);
       
        System.out.println(">> Thank you for using Eric's Modified Payroll App");
        System.out.print("Time of Calculation is: " + Date_and_time+"\n");
        System.exit(0);
    }
}