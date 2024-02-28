/** Class that implements Pokemon Type as Fire.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */
public class Fire implements PokemonType {

    /** Returns the type of this Pokemon.
     *
     * @return "Fire"
     */
    public String type() {
        return "Fire";
    }

    /** Overridden compareTo method.
     *
     * @param p Pokemon to be compared to
     * @return -1 if lower, 1 is higher, 0 if same in the order Grass < Fire < Water
     */
    @Override
    public int compareTo(PokemonType p) {

        if (p == null) {
            return -1;
        } else {
            if (p.type().equals("Grass")) {
                return 1;
            } else if (p.type().equals("Fire")) {
                return 0;
            } else if (p.type().equals("Water")) {
                return -1;
            } else {
                return -1;
            }
        }
    }



}
