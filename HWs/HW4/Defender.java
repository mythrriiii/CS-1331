import java.util.Random;

/** Defender class that has an is-a relationship with SoccerPlayer.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */
public class Defender extends SoccerPlayer {

    /** Integer that represents the total number of passes. */
    private int totalPasses;
    /** Integer that represents the total number of passes completed. */
    private int totalPassesCompleted;
    /** Double that represents the defense rating of the player. */
    private double defenseRating;

    /** Constructor that takes in name, country, stamina, number of passes,
     * completed passes, and defense rating.
     * @param dName player's name
     * @param dCountry player's country
     * @param dStamina player's stamina
     * @param dPasses total number of passes of the player
     * @param dCompletedPasses total number of passes the player completed
     * @param dRating the player's rating
     */
    public Defender(String dName, String dCountry, int dStamina,
                     int dPasses, int dCompletedPasses, double dRating) {
        super(dName, dCountry, dStamina);
        if (dPasses >= 0) {
            this.totalPasses = dPasses;
        }

        if (dCompletedPasses >= 0) {
            if (dCompletedPasses > dPasses) {
                this.totalPassesCompleted = dPasses;
            } else {
                this.totalPassesCompleted = dCompletedPasses;
            }
        }

        if ((dRating >= 0) && (dRating <= 100)) {
            this.defenseRating = dRating;
        }

    }

    /** Accessor for totalPasses.
     *
     * @return total number of passes
     */
    public int getTotalPasses() {
        return this.totalPasses;
    }

    /** Mutator for the total number of passes.
     *
     * @param newTotalPasses new total number of passes
     */
    public void setTotalPasses(int newTotalPasses) {
        if (newTotalPasses >= 0) {
            this.totalPasses = newTotalPasses;
        }
    }

    /** Accessor for the total number of completed passes.
     *
     * @return total number of completed passes
     */
    public int getTotalPassesCompleted() {
        return this.totalPassesCompleted;
    }

    /** Mutator for total number of passes completed.
     *
     * @param newTotalPassesCompleted new total completed passes
     */
    public void setTotalPassesCompleted(int newTotalPassesCompleted) {

        if (newTotalPassesCompleted >= 0) {
            if (newTotalPassesCompleted > this.totalPasses) {
                this.totalPassesCompleted = this.totalPasses;
            } else {
                this.totalPassesCompleted = newTotalPassesCompleted;
            }
        }
    }

    /** Accessor for the player's defense rating.
     *
     * @return player's defense rating
     */
    public double getDefenseRating() {
        return this.getDefenseRating();
    }

    /** Mutator for the player's defense rating.
     *
     * @param newDefenseRating player's new defense rating
     */
    public void setDefenseRating(double newDefenseRating) {
        if ((newDefenseRating >= 0) && (newDefenseRating <= 100)) {
            this.defenseRating = newDefenseRating;
        }
    }

    /** Overridden toString method.
     *
     * @return String: “'name' from 'country' has 'stamina' stamina left. As a Defender, I
     * have completed 'totalPassesCompleted' passes from 'totalPasses' initiated passes
     * and my rating is 'defenseRating>'
     */
    @Override
    public String toString() {
        double roundDR = Math.round(this.defenseRating * 100) / 100;
        String returnString = super.toString() + ". As a Defender, I have completed "
                + this.totalPassesCompleted + " passes from" + this.totalPasses
                + " initiated passes and my rating is " + roundDR;
        return returnString;
    }

    /** Overriden equals method.
     *
     * @param obj2 the other object to which this object is to be compared
     * @return boolean to check if the 2 objects have the same name, country, total passes,
     * total completed passes and defense rating
     */
    @Override
    public boolean equals(Object obj2) {

        if (obj2 == null) {
            return false;

        } else if (!(obj2 instanceof Defender)) {
            return false;

        } else {
            Defender d2 = (Defender) obj2;

            return ((super.equals(obj2)) && (d2.totalPasses == this.totalPasses)
                    && (d2.totalPassesCompleted == this.totalPassesCompleted)
                    && (d2.defenseRating == this.defenseRating));
        }
    }

    /** Completes a play for the Defender.      */
    @Override
    public void play() {
        int randomNum = (int) (Math.random() * 101);
        this.setStamina(this.getStamina() - randomNum);

        int randomPasses = (int) (Math.random() * 101);
        this.totalPasses = randomPasses;

        boolean outperforming = new Random().nextInt(10) == 0;

        if (this.getStamina() == 0) {
            this.totalPassesCompleted = 0;
        } else if (outperforming) {
            this.totalPassesCompleted = this.totalPasses;
        } else {
            int randomCPasses = (int) (Math.random() * (randomPasses + 1));
            this.totalPassesCompleted = randomCPasses;
        }

        this.defenseRating = this.calculateRating();
    }

    /** Calculates the defense rating of the player.
     *
     * @return the defense rating
     */
    @Override
    public double calculateRating() {

        double dRating;
        if (this.totalPasses == 0) {
            dRating = 0;
        } else {
            dRating = ((double) totalPassesCompleted / totalPasses) * 100;
        }

        return dRating;
    }


}
