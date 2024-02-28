/** GoalKeeper class that has an is-a relationship with SoccerPlayer.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */

public class GoalKeeper extends SoccerPlayer {

    /** Integer that represents the number of saves for this goalkeeper. */
    private int totalSaves;
    /** Integer that represents the total number of shots on target on the net defended by the goalkeeper. */
    private int totalShotsOnTarget;
    /** Double that represents the Goal Keeper's ball handling skills (0-100). */
    private double ballHandling;

    /** Constructor that takes in name, country, stamina, saves, shots on target and ball handling skills.
     *
     * @param gkName the name
     * @param gkCountry the country
     * @param gkStamina stamina of the player
     * @param gkSaves number of saves(shots on target blocked)
     * @param gkTotalShots number of shots on the target
     * @param gkBallHandling player's ball handling skills (0-100)
     */
    public GoalKeeper(String gkName, String gkCountry, int gkStamina,
                      int gkSaves, int gkTotalShots, double gkBallHandling) {

        super(gkName, gkCountry, gkStamina);

        if (gkTotalShots >= 0) {
            this.totalShotsOnTarget = gkTotalShots;
        }

        if (gkSaves >= 0) {
            if (gkSaves > gkTotalShots) {
                this.totalSaves = gkTotalShots;
            } else {
                this.totalSaves = gkSaves;
            }
        }

        if ((gkBallHandling >= 0) && (gkBallHandling <= 100)) {
            this.ballHandling = gkBallHandling;
        }
    }

    /** Accessor for the total number of saves.
     *
     * @return total number of saves
     */
    public int getTotalSaves() {
        return this.totalSaves;
    }

    /** Mutator for the total number of saves.
     *
     * @param newTotalSaves new total number of saves
     */
    public void setTotalSaves(int newTotalSaves) {

        if (newTotalSaves >= 0) {
            if (newTotalSaves > this.totalShotsOnTarget) {
                this.totalSaves = this.totalShotsOnTarget;
            } else {
                this.totalSaves = newTotalSaves;
            }
        }
    }


    /** Accessor for the total shots on target.
     *
     * @return the total shots on target
     */
    public int getTotalShotsOnTarget() {
        return this.totalShotsOnTarget;
    }

    /** Mutator for total shots on target.
     *
     * @param newTotalShots new total shots on target
     */
    public void setTotalShotsOnTarget(int newTotalShots) {
        if (newTotalShots >= 0) {
            this.totalShotsOnTarget = newTotalShots;
        }
    }

    /** Accessor for ball handling skill.
     *
     * @return ball handling skill
     */
    public double getBallHandling() {
        return this.ballHandling;
    }

    /** Mutator for ball handling skills that makes sure that it is a legal entry.
     *
     * @param newBH new ball handling skill
     */
    public void setBallHandling(double newBH) {
        if ((newBH >= 0) && (newBH <= 100)) {
            this.ballHandling = newBH;
        }
    }

    /** Method that calculates the ball handling skills of the player.
     * It divides the goals by the total shots on target and multiplies it by 100
     * @return
     */
    @Override
    public double calculateRating() {

        double bhRating;
        if (this.totalShotsOnTarget == 0) {
            bhRating = 0;
        } else {
            bhRating = ((double) totalSaves / totalShotsOnTarget) * 100;
        }

        return bhRating;
    }

    /** Completes a play for the Goal Keeper.     */
    @Override
    public void play()  {

        int randomNum = (int) (Math.random() * 101);
        this.setStamina(this.getStamina() - randomNum);

        int randomShots = (int) (Math.random() * 101);
        this.totalShotsOnTarget = randomShots;


        if (this.getStamina() == 0) {
            this.totalSaves = 0;
        } else {
            int randomSaves = (int) (Math.random() * (randomShots + 1));
            this.totalSaves = randomSaves;
        }

        this.ballHandling = this.calculateRating();
    }


    /** Overridden toString method.
     *
     * @return String: “'name' from 'country' has 'stamina' stamina left. As a
     * Goalkeeper, I have stopped 'totalSaves' shots from 'totalShotsOnTarget' shots on
     * target and my rating is 'ballHandling'”.
     */
    @Override
    public String toString() {
        double roundBH = Math.round(this.ballHandling * 100) / 100;
        String returnString = super.toString() + ". As a Goalkeeper, I have stopped "
                + this.totalSaves + " shots from" + this.totalShotsOnTarget
                + " shots on target and my rating is " + roundBH;
        return returnString;
    }

    /** Overridden equals methods.
     *
     * @param obj2 the other object to which this object is to be compared
     * @return boolean that checks if it is the name, country, total saves,
     * total shots on target, and ball handling rating is the same
     */
    @Override
    public boolean equals(Object obj2) {

        if (obj2 == null) {
            return false;

        } else if (!(obj2 instanceof GoalKeeper)) {
            return false;

        } else {
            GoalKeeper gk2 = (GoalKeeper) obj2;

            return ((super.equals(obj2)) && (gk2.totalSaves == this.totalSaves)
                    && (gk2.totalShotsOnTarget == this.totalShotsOnTarget)
                    && (gk2.ballHandling == this.ballHandling));
        }
    }


}
