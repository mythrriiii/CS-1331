import java.util.Scanner;
import java.util.Random;

public class CoinToss {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String choice;

	do {
		System.out.println("Ready to run a coin toss simulation. Enter the number of rounds: ");
		int iterations = scan.nextInt();
		Random trial = new Random();
		int countHeads = 0;
		int countTails = 0;
		System.out.println("Simulating Coin Tosses");


		for (int j = 1; j<=iterations; j++) {
			String tossPattern = "";
			while ( !((tossPattern.contains("H"))&&(tossPattern.contains("T")))){

				int i = trial.nextInt(2);


				if ( i == 0){
					tossPattern += "H";
					countHeads++;

				}else if ( i == 1){
					tossPattern += "T";
					countTails++;

				}else{
					System.out.println("Error!");
				}
			}
			System.out.println(j+" - "+ tossPattern);
		}
		float average = (float)(countHeads+countTails)/iterations;
		System.out.println("The average number of coin tosses was "+ average+".");
		System.out.println("A total of "+ countHeads+" heads and "+countTails+" tails were tossed.");

		Scanner scan1 = new Scanner(System.in);
		System.out.println("Would you like to run another simulation? (y/n)");
		choice = scan1.nextLine();
	} while (choice.equals("y"));
    }
}
