import java.util.Scanner;
public class GroupE_BusinessSimulator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array storing product names for BuildRight Hardware
        String[] itemNames = {"Cement (bag)", "Nails (kg)", "Paint (tin)", "Timber (piece)"};

        // Array storing corresponding unit prices in UGX
        double[] itemPrices = {35000.0, 4000.0, 45000.0, 25000.0};

        // Array storing purchase quantities assigned for test verification
        int[] itemQuantities = {4, 2, 2, 4};

        // Method 1 to loop through arrays and display price list
        displayPriceList(itemNames, itemPrices);

        // Method 2 to process discount rules, print receipt, and return grand total
        double grandTotal = processAndPrintReceipt(itemNames, itemPrices, itemQuantities);

        // Print divider line before grand total output
        System.out.println("----------------------------------------");

        // Print final grand total formatted to 2 decimal places using returned value
        System.out.printf("TOTAL        = UGX %.2f%n", grandTotal);
    }

    // Method 1: Iterates through product arrays to display formatted business price list
    public static void displayPriceList(String[] names, double[] prices) {

        // Display store header
        System.out.println("==== BUILDRIGHT HARDWARE ====");

        // Loop through item array indices to display each product and price dynamically
        for (int i = 0; i < names.length; i++) {

            // Format line output showing item number, name padded to 15 chars, and price
            System.out.printf("%d. %-15s UGX %.2f%n", (i + 1), names[i], prices[i]);
        }

        // Print line break for visual structure
        System.out.println();
    }

    // Method 2: Performs discount calculations per item, prints receipt lines, and returns final grand total
    public static double processAndPrintReceipt(String[] names, double[] prices, int[] quantities) {

        // Accumulator variable to track running grand total
        double total = 0.0;

        // Display receipt section header
        System.out.println("==== RECEIPT ====");

        // Loop through each item to evaluate subtotal and business discount logic
        for (int i = 0; i < names.length; i++) {

            // Extract item details from arrays using index
            String name = names[i];
            double price = prices[i];
            int qty = quantities[i];

            // Calculate base cost before discount logic
            double rawSubtotal = price * qty;

            // Variable to hold final cost after discount calculations
            double finalSubtotal = rawSubtotal;

            // Variable to hold dynamic receipt explanation text
            String discountNote = "";

            // Conditional block handling specific discount rules
            if (i == 0) { 
                // Cement (bag): 5% off total subtotal if quantity >= 5
                if (qty >= 5) {
                    finalSubtotal = rawSubtotal * 0.95;
                    discountNote = "(5% discount applied)";
                } else {
                    discountNote = "(no discount - fewer than 5)";
                }
            } else if (i == 1) { 
                // Nails (kg): Never discounted regardless of quantity
                discountNote = "(no discount)";
            } else if (i == 2) { 
                // Paint (tin): Flat UGX 5,000 off total subtotal if quantity >= 3
                if (qty >= 3) {
                    finalSubtotal = rawSubtotal - 5000.0;
                    discountNote = "(UGX 5,000 discount applied)";
                } else {
                    discountNote = "(no discount - fewer than 3)";
                }
            } else if (i == 3) { 
                // Timber (piece): 10% off total subtotal if quantity >= 4
                if (qty >= 4) {
                    finalSubtotal = rawSubtotal * 0.90;
                    discountNote = "(10% discount applied)";
                } else {
                    discountNote = "(no discount - fewer than 4)";
                }
            }

            // Print itemized line with quantity, subtotal
            System.out.printf("%-15s x%d = UGX %.2f %s%n", name, qty, finalSubtotal, discountNote);

            // Adding item subtotal to running total balance
            total += finalSubtotal;
        }

        return total;
    }
}
