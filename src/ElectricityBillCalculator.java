import java.util.Scanner;

public class ElectricityBillCalculator {

    private static final double UNIT_RATE_1 = 5.0; 
    private static final double UNIT_RATE_2 = 7.0; 
    private static final double UNIT_RATE_3 = 8.5; 
    private static final double FIXED_CHARGE = 50.0;

    public static double calculateBill(Customer customer, int previousMeterReading, int currentMeterReading) {
        int unitsConsumed = currentMeterReading - previousMeterReading;
        double totalBill = 0.0;
        
        if (unitsConsumed <= 100) {
            totalBill = unitsConsumed * UNIT_RATE_1 + FIXED_CHARGE;
        } else if (unitsConsumed <= 300) {
            totalBill = 100 * UNIT_RATE_1 + (unitsConsumed - 100) * UNIT_RATE_2 + FIXED_CHARGE;
        } else {
            totalBill = 100 * UNIT_RATE_1 + 200 * UNIT_RATE_2 + (unitsConsumed - 300) * UNIT_RATE_3 + FIXED_CHARGE;
        }
        
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Address: " + customer.getAddress());
        System.out.println("Previous Meter Reading: " + previousMeterReading);
        System.out.println("Current Meter Reading: " + currentMeterReading);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Electricity Bill Amount: $" + totalBill);
        
        return totalBill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Previous Meter Reading: ");
        int previousMeterReading = scanner.nextInt();
        System.out.print("Enter Current Meter Reading: ");
        int currentMeterReading = scanner.nextInt();

        Customer customer = new Customer(name, address);
        calculateBill(customer, previousMeterReading, currentMeterReading);

        scanner.close(); 
    }
}

class Customer {
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
