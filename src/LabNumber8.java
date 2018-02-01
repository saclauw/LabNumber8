import java.util.Arrays;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.InputMismatchException;

/* Steven Clauw 1/30/2018
 * 
 * Caclulate batting stats
 * 
 * What will the app do:
 * -Calculate the batting average and slugging percentage for one or more baseball players
 * -First, ask for the number of at bats
 * -For each at bat, ask the user for the number of bases earned by the batter.
 * After all of the at-bats are entered display the batting average and slugging percentage of the batter.
 * 
 * BUILD SPECS
 * -Use an Array to store the at-bat results for each player
 * -Validate the input so that the user can only enter positive ints.  For the at-bat results, the user
 * can enter only, 0,1,2,3, of 4.
 * -Validate the users response to the question "Another Batter?" so the user can only enter Y,y, N, or n.
 * if the user chooses n, end the program
 * -Format the batting average and slugging percentages such that three decimal places are shown.
 * 
 * 
 */
public class LabNumber8 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String cont = "y";
		int[] atBatResults = null;
		int numsAtBat = 0;
		int i = 0;
		double sluggingPercentage;
		
		System.out.println("Welcome to the Batting Average Calculator!");

		while (cont.equalsIgnoreCase("y")) {

			numsAtBat = storeAtBat(scan); // method store at bat called to assign value to numsAtBat
			atBatResults = new int[numsAtBat];
			System.out.println("0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");

		
			for (i = 0; i < numsAtBat; i++) {
				System.out.print("Results for at-bat " + (i + 1) + ": ");
				atBatResults[i] = scan.nextInt();
				scan.nextLine();
				while ((atBatResults[i] < 0) || (atBatResults[i] > 4)) {
					System.out.println("Not a valid number for result at-bat. (result must be 0-4)");
					System.out.print("Results for at-bat " + (i + 1) + ": ");
					atBatResults[i] = scan.nextInt(); // would be an infinite loop if arrIndex not assigned to new value
					scan.nextLine();
					continue;
				} // end if statement
			} // end for loop

			int basehit = 0;
			for (i = 0; i < atBatResults.length; i++) {
				if (atBatResults[i] > 0) {
					basehit++;
				}
			}
			double batAvg = ((double) (basehit) / (double) (numsAtBat));
			BigDecimal batAv = new BigDecimal(batAvg);
			batAv = batAv.setScale(3, BigDecimal.ROUND_HALF_UP);

			System.out.println("\nBatting average: " + batAv);

			double sum = 0;
			for (i = 0; i < atBatResults.length; i++) {
				sum += atBatResults[i];
			}
			sluggingPercentage = (double) sum / (double) atBatResults.length;
			BigDecimal slug = new BigDecimal(sluggingPercentage);
			slug = slug.setScale(3, BigDecimal.ROUND_HALF_UP);
			System.out.println("Slugging Percentage: " + slug);
			// end application

			System.out.print("\nAnother batter? (y/n) ");
			cont = scan.nextLine();
			 switch (cont) {
			 case "y" :
			 break;
			 case "Y":
			 break;
			 case "n" :
			 System.out.println("Goodbye!");
			 break;
			 case "N" :
			 System.out.println("Goodbye!");
			 break;
			 default:
			 System.out.print("Not a valid input. ");
			 System.out.print("Another batter? (y/n): ");
			 cont = scan.nextLine();
			 continue;
			 }
		}
		scan.close();

	} // end main

	public static int storeAtBat(Scanner scan) {
		int numsAtBat = 0;
		while (numsAtBat <= 0) {
			System.out.print("Enter number of times at bat: ");
			numsAtBat = scan.nextInt();
			scan.nextLine();
			if (numsAtBat <= 0) {
				System.out.print("That is not a valid number. ");
				numsAtBat = 0;
				continue;
			} // end if
		}
		return numsAtBat;// end while loop
	} // end storeAtBat method

}
