/** This is a program that creates objects of type WordStatistics which has text and history unique to each object.
 * It also has totalWordCount and longestSentenceLength that are shared by the entire class.
 * This can help give statistics about text and writing.
 * It can count the total number of initial words that appear in sentences,
 * count the length of the longest sentence in a short paragraph, and calculate the age of a certain piece of text.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */


public class WordStatistics {

    /** The text containing all the sentences. */
    private String text;
    /** The text containing details about the date it was created. */
    private String history;
    /** The total number of words in all of the objects of this class. */
    private static int totalWordCount;
    /** The length of the longest sentence from within all of the objects. */
    private static int longestSentenceLength;

    /** Constructor that takes in the year and the history.
     *
     * @param newText The text containing all the sentences.
     * @param newHistory The text containing details about the date it was created.
     */
    public WordStatistics(String newText, String newHistory) {
        this.text = newText;
        this.history = newHistory;
    }

    /** Constructor that takes in the year given no history.
     *
     * @param newText The text containing all the sentences.
     * history is given a preset value.
     */

    public WordStatistics(String newText) {
        this.text = newText;
        this.history = "Published_18700101";
    }

    /** Method that takes in a number for the required unique words from the text.
     * It then counts the number of each unique word's occurrences and puts them in an array to return it.
     *
     * @param reqUniqueWords the number of unique words required from the text.
     * @return an array containing each unique word and the number of its occurrences.
     */

    public String[][] countInitWords(int reqUniqueWords) {

        String[][] wordAndCount = new String[reqUniqueWords][2];
        String theText = text;
        String[] firstSplit = theText.split("\\s+");
        String[] allWords = new String[(firstSplit.length) * 2];
        String[] allUniqueWords = new String[reqUniqueWords];
        int[] countUniqueWords = new int[reqUniqueWords];

        int count = 0;

        for (int i = 0; i < firstSplit.length; i++) {

            int wordLength = firstSplit[i].length();
            if (firstSplit[i].substring(wordLength - 1).equals(".")) {

                String c = firstSplit[i].replace(".", "");
                allWords[count] = c;
                count++;

            } else if (firstSplit[i].substring(wordLength - 1).equals(",")) {

                String c = firstSplit[i].replace(",", "");
                allWords[count] = c;
                count++;

            } else if (firstSplit[i].contains(".")) {

                String[] dotSplit = firstSplit[i].split("\\.");

                for (String b: dotSplit) {

                    allWords[count] = b;
                    count++;
                }

            } else {

                allWords[count] = firstSplit[i];
                count++;
            }
        }


        for (int i = 0; i < allUniqueWords.length; i++) {
            int allWordsIndex = i;

            if (contains(allWords[allWordsIndex], allUniqueWords)) {
                allWordsIndex++;
            }

            allUniqueWords[i] = allWords[allWordsIndex];

        }


        for (int i = 0; i < allUniqueWords.length; i++) {
            count = 0;
            for (String a: allWords) {
                if ((a != null) && ((a.toLowerCase()).equals(allUniqueWords[i].toLowerCase()))) {
                    count++;
                }
            }
            countUniqueWords[i] = count;
        }

        for (int i = 0; i < reqUniqueWords; i++) {
            wordAndCount[i][0] = allUniqueWords[i].toLowerCase();
            wordAndCount[i][1] = Integer.toString(countUniqueWords[i]);
            totalWordCount += countUniqueWords[i];
        }

        return wordAndCount;
    }

    /** Method that helps the countInitWords method by checking if a given word is already present in the given array.
     *
     * @param wordToCheck word to be checked in array.
     * @param arrayToCheckIn array to check the word in.
     * @return boolean value about whether the word is in the array or not.
     */

    public static boolean contains(String wordToCheck, String[] arrayToCheckIn) {
        boolean doesItContain;

        for (String a: arrayToCheckIn) {
            if ((wordToCheck != null) && (a != null)) {
                if (wordToCheck.equals(a)) {
                    doesItContain = true;
                    return doesItContain;
                }
            }
        }

        doesItContain = false;
        return doesItContain;
    }

    /** Method that checks for and prints the longest sentence and return the number of words in it.
     *
     * @return the length of the longest sentence.
     */

    public int longestSentence() {

        String theText = text;
        String[] sentences = theText.split("\\.");
        int longestLength = 0;
        int longestSentenceIndex = 0;
        String[] sentenceWords;

        for (int i = 0; i < sentences.length; i++) {
            sentenceWords = sentences[i].split("\\s");
            int sentenceWordsLength = 0;

            for (int j = 0; j < sentenceWords.length; j++) {
                if (!(sentenceWords[j].trim().equals(""))) {
                    sentenceWordsLength++;
                }
            }


            if ((sentenceWordsLength) > longestLength) {
                longestLength = sentenceWordsLength;
                longestSentenceIndex = i;
            }
        }

        /*for (int i = 0; i < (sentences[longestSentenceIndex].split("\\s")).length; i++) {
            System.out.println(i + (sentences[longestSentenceIndex].split("\\s"))[i]);
        }*/

        //System.out.println(longestLength);

        if (longestSentenceLength <= longestLength) {
            longestSentenceLength = longestLength;
        }


        System.out.println(sentences[longestSentenceIndex] + ".");
        return longestLength;

    }

    /** Method the get the age of the text in years.
     *
     * @return the age of the test in years.
     */

    public int textAge() {
        String[] splitHistory = this.history.split("_");
        Integer givenYear = Integer.valueOf(splitHistory[1].substring(0, 4));
        int age = 2022 - givenYear + 1;
        return age;
    }

}
