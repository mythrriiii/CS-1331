/**PokemonDB is the file to search and sort Pokemon objects.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */
public class PokemonDB {

    /** Main method to test the code.
     *
     * @param args main method
     */
    public static void main(String[] args) {
        Pokemon p1 = new Pokemon("Pokemon1", 50, new Fire(), 60);
        Pokemon p2 = new Pokemon("Pokemon2", 30, new Water(), 80);
        Pokemon p3 = new Pokemon("Pokemon3", 80, new Grass(), 45);

        Pokemon[] pArray = {p1, p2, p3};
        PokemonDB.compareSort(pArray);
        System.out.println((PokemonDB.findPokemon(50, pArray)).getName());
    }

    /**Given the health of a Pokemon and an unsorted list of Pokemon, in that
     * order, it should find the Pokemon with that health and return the Pokemon.
     * Uses binary search.
     *
     * @param health health of pokemon to be found
     * @param pArray unsorted pokemon array
     * @return the Pokemon with the given health
     */
    public static Pokemon findPokemon(int health, Pokemon[] pArray) {
        Pokemon[] sArray = PokemonDB.compareSort(pArray);
        int low = 0;
        int high = sArray.length - 1;
        Pokemon returnValue = null;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (sArray[mid].getHealth() < health) {
                low = mid + 1;
            } else if (sArray[mid].getHealth() > health) {
                high = mid - 1;
            } else if (sArray[mid].getHealth() == health) {
                returnValue = sArray[mid];
                break;
            }
        }
        return returnValue;
    }

    /** Will take in an array of Pokemons. It should sort the Pokemons in ascending
     * order based on the compareTo method in Pokemon class.
     *
     * @param pArray unsorted list of Pokemons
     * @return sorted list
     */
    public static Pokemon[] compareSort(Pokemon[] pArray) {
        for (int outer = 0; outer < pArray.length - 1; outer++) {
            int min = outer;

            for (int inner = outer; inner < pArray.length; inner++) {
                if (pArray[min].compareTo(pArray[inner]) == 1) {
                    min = inner;
                }
            }

            Pokemon temp = pArray[min];
            pArray[min] = pArray[outer];
            pArray[outer] = temp;
        }

        return pArray;
    }
}
