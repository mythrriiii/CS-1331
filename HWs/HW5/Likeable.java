/** Likeable denotes whether an object can receive likes or dislikes. For instance, comments should be able to
 * be liked and disliked.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */

public interface Likeable {

    /** Abstract method to get the number of likes.
     *
     * @return number of likes
     */
    int getLikes();

    /** Abstract method to get the number of dislikes.
     *
     * @return number of dislikes
     */
    int getDislikes();


}
