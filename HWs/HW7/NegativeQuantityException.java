/** This should be an unchecked exception (be sure to extend the correct class). It should have a
 * one-arg constructor that takes in the String attempted to be used as a quantity that sets the
 * error message that would be displayed on the console if the exception was not caught to
 * Quantity 'argument' is not positive.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 *
 */
public class NegativeQuantityException extends RuntimeException {

    /** Constructor for this exception that takes int he quantity.
     *
     * @param quantity the quantity
     */
    public NegativeQuantityException(String quantity) {
        super("Quantity " + quantity + " is not positive.");
    }

}
