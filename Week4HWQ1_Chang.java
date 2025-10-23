import java.util.Scanner;
public class Week4HWQ1_Chang {

	public static void main(String[] args) {
        // Named constants
        final double BENCHMARK = 12000;
        final double BASE_RATE = 0.10;
        final double ACCELERATED_RATE = 0.15;

        // Prompt user for monthly revenue
        Scanner input = new Scanner(System.in);
        System.out.print("Enter monthly revenue: ");
        double revenue = input.nextDouble();

        // Base incentive (applies to all revenue)
        double baseIncentive = revenue * BASE_RATE;

        // Accelerated incentive (only applies if revenue > BENCHMARK)
        double acceleratedIncentive = (revenue > BENCHMARK) 
                ? (revenue - BENCHMARK) * ACCELERATED_RATE 
                : 0;

        // Total incentive
        double totalIncentive = baseIncentive + acceleratedIncentive;

        // Display formatted output like your example
        System.out.printf("%n    Monthly revenue:   $%,.2f%n", revenue);

        if (revenue <= BENCHMARK) {
            // Only base incentive applies
            System.out.printf("    Total Incentive:   $%,.2f x %.0f%% = $%,.2f%n", 
                              revenue, BASE_RATE * 100, totalIncentive);
        } else {
            // Show both base + accelerated clearly
            System.out.printf("    Total Incentive:   ($%,.2f x %.0f%%) + (($%,.2f - $%,.2f) x %.0f%%) = $%,.2f%n", 
                              revenue, BASE_RATE * 100, revenue, BENCHMARK, BENCHMARK, ACCELERATED_RATE * 100, totalIncentive);
        }

        input.close();
   }
}

/*
---------------------------
TEST CASES USED:

1) Revenue = $10,000
   - Tests calculation when revenue is below the benchmark.
   - Expected: Base incentive = $1,000, Accelerated = $0

2) Revenue = $12,000
   - Edge case: exactly at the benchmark.
   - Expected: Base incentive = $1,200, Accelerated = $0

3) Revenue = $15,000
   - Tests both base and accelerated tiers.
   - Expected: Base = $1,200, Accelerated = $450, Total = $1,650

These values were chosen to cover: below, exactly at, and above the benchmark.
*/

	


