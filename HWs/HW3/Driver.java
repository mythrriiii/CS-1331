import java.util.Scanner;

/** This is the driver class that contains the main method to run the code.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */

public class Driver {

    /** The main method that runs the code.
     *
     * @param args part of the main method
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Set text: ");
        String theText = scan.nextLine();
        System.out.print("Enter the initial number of words: ");
        int theNumber = scan.nextInt();

        WordStatistics w1 = new WordStatistics(theText);
        String[][] wordAndCount = w1.countInitWords(theNumber);

        System.out.println("Word Counts: ");
        for (String[] a: wordAndCount) {
            System.out.println(a[0] + " " + a[1]);
        }

        System.out.print("Longest Sentence: ");
        int longestLength = w1.longestSentence();

        System.out.print("Age of text: ");
        System.out.println(w1.textAge());


    }
}
