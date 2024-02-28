/** This is a program that helps predict the results of each match in the World Cup in Qatar.
 * It predicts the outcome of matches based on the player's ratings.
 * The SoccerPlayer is an abstract class that represents a player in the team.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */

public abstract class SoccerPlayer {

    /** A String that represents the name of the soccer player. */
    private String name;
    /** A String that represents the name of the country the soccer player is from. */
    private String country;
    /** An integer that represents the starting stamina for the player. */
    private int stamina;

    /** The constructor that takes in a name, country, and stamina.
     *
     * @param spName the name of the Soccer Player
     * @param spCountry the country of the Soccer Player
     * @param spStamina the stamina of the player which must be positive non-zero integer
     *                  if not, it is assigned a default value of 20
     */
    public SoccerPlayer(String spName, String spCountry, int spStamina) {
        this.name = spName;
        this.country = spCountry;

        if (spStamina > 0) {
            this.stamina = spStamina;
        } else {
            this.stamina = 20;
        }
    }

    /** An overridden toString method.
     *
     * @return a String: “'name' from 'country' has 'stamina' stamina left”
     */
    @Override
    public String toString() {
        String returnString = this.name + " from " + this.country + " has "
                + this.stamina + " stamina left";
        return returnString;
    }

    /** An overridden equals method that check if 2 Soccer Players are equal.
     *
     * @param obj2 the other object to which this object is to be compared
     * @return boolean that checks whether they have the same name, and country
     */
    @Override
    public boolean equals(Object obj2) {

        if (obj2 == null) {
            return false;

        } else if (!(obj2 instanceof SoccerPlayer)) {
            return false;

        } else {
            SoccerPlayer sp2 = (SoccerPlayer) obj2;

            return ((sp2.name == this.name) && (sp2.country == this.country));
        }
    }

    /** An abstract method that changes for each subclass. */
    public abstract void play();

    /** An abstract method that changes for each subclass.
     *
     * @return double with the rating of the player
     */
    public abstract double calculateRating();

    /** A method that increases a players stamina by 5. */
    public void rest() {
        this.stamina += 5;
    }

    /** Accessor for name.
     *
     * @return the name of the player
     */
    public String getName() {
        return this.name;
    }

    /** Modifier for the name of the player.
     *
     * @param newName the new name to change it to
     */
    public void setName(String newName) {

        if (newName != null) {
            this.name = newName;
        }
    }

    /** Accessor for the country.
     *
     * @return the player's country
     */
    public String getCountry() {
        return this.country;
    }

    /** Modifier for the country.
     *
     * @param newCountry new country to change it to
     */
    public void setCountry(String newCountry) {

        if (newCountry != null) {
            this.country = newCountry;
        }
    }

    /** Accessor for player's stamina.
     *
     * @return player's stamina
     */
    public int getStamina() {
        return this.stamina;
    }

    /** Modifier for player's stamina.
     *
      * @param newStamina player's stamina
     */
    public void setStamina(int newStamina) {

        if ((this.stamina + newStamina) < 0) {
            this.stamina = 0;
        } else {
            this.stamina += newStamina;
        }
    }

}
