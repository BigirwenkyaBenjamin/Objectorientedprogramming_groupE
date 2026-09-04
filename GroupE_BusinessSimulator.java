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
              
             // Cement
           if (i == 0 && qty >= 5) { 
               finalSubtotal = rawSubtotal * 0.95;
                discountNote = "(5% discount applied)";
               
             // Paint
            } else if (i == 2 && qty >= 3) { 
              finalSubtotal = rawSubtotal - 5000;
              discountNote = "(UGX 5,000 discount applied)";
              
             // Timber
            } else if (i == 3 && qty >= 4) { 
              finalSubtotal = rawSubtotal * 0.90;
              discountNote = "(10% discount applied)";

            } else {
              discountNote = "(No discount)";
         }


            System.out.printf("%-15s x%d = UGX %.2f %s%n", name, qty, finalSubtotal, discountNote);
            total += finalSubtotal;
        }

        return total;
    }
//Method to get the discount threshold
    public static double getDiscountThreshold(int index) {
       int[] discountThresholds = {5, 0, 3, 4}; // Corresponding thresholds for Cement, Nails, Paint, Timber
       return discountThresholds[index];
    }

}
