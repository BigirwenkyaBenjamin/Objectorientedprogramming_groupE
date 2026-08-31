public class GroupE_BusinessSimulator {

    public static void main(String[] args) {
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

    // Method 1: Display formatted business price list
    public static void displayPriceList(String[] names, double[] prices) {
        System.out.println("==== BUILDRIGHT HARDWARE ====");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d. %-15s UGX %.2f%n", i + 1, names[i], prices[i]);
        }
        System.out.println();
    }

    // Method 2: Calculate discounts, print receipt lines, and return total
    public static double processAndPrintReceipt(String[] names, double[] prices, int[] quantities) {
        double total = 0.0;
        System.out.println("==== RECEIPT ====");

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            double price = prices[i];
            int qty = quantities[i];
            double discountThreshold = getDiscountThreshold(i);
            double rawSubtotal = price * qty;
            double finalSubtotal = rawSubtotal;
            String discountNote = "";

            switch (i) {
                case 0: // Cement: 5% off if qty >= 5
                    if (qty >= 5) {
                        finalSubtotal = rawSubtotal * 0.95;
                        discountNote = "(5% discount applied)";
                    } else {
                        discountNote = "(no discount - fewer than 5)";
                    }
                    break;
                case 1: // Nails: no discount
                    discountNote = "(no discount)";
                    break;
                case 2: // Paint: UGX 5,000 off if qty >= 3
                    if (qty >= 3) {
                        finalSubtotal = rawSubtotal - 5000.0;
                        discountNote = "(UGX 5,000 discount applied)";
                    } else {
                        discountNote = "(no discount - fewer than 3)";
                    }
                    break;
                case 3: // Timber: 10% off if qty >= 4
                    if (qty >= 4) {
                        finalSubtotal = rawSubtotal * 0.90;
                        discountNote = "(10% discount applied)";
                    } else {
                        discountNote = "(no discount - fewer than 4)";
                    }
                    break;
            }

            System.out.printf("%-15s x%d = UGX %.2f %s%n", name, qty, finalSubtotal, discountNote);
            total += finalSubtotal;
        }

        return total;
    }

    // Helper method to return discount threshold for each product
    private static int getDiscountThreshold(int itemIndex) {
        switch (itemIndex) {
            case 0: return 5;  // Cement
            case 1: return Integer.MAX_VALUE;  // Nails (no discount)
            case 2: return 3;  // Paint
            case 3: return 4;  // Timber
            default: return 0;
        }
    }
}
