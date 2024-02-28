/** PokemonType is an interface that defines certain methods for other classes to implement. PokemonType
 * should implement the Comparable interface.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */
public interface PokemonType extends Comparable<PokemonType> {

    /** Should return the name of the class in the form of a String.
     *
     * @return name of the class
     */
    String type();
}
