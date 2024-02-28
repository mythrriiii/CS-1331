/** Attacker class that has an is-a relationship with SoccerPlayer.
 *
 * @author Mythri Muralikannan
 *  @version 1.0
 */
public class Attacker extends SoccerPlayer {

    enum CelebrationMove {
        DIVE,
        CARTWHEEL,
        SIUU
    }

    /** Integer that represents total number of goals. */
    private int totalGoals;
    /** Integer that represents the total shots on target. */
    private int totalShotsOnTarget;
    /** Double that represents the player's attacking rating. */
    private double attackingRating;
    /** Player's celebration move. */
    private CelebrationMove celebrationMove;

    /** Constructor that takes in name, country, stamina, goals,
     * total shots at the target, attacking rating, and celebration move.
     *
     * @param aName player's name
     * @param aCountry player's country
     * @param aStamina player's stamina
     * @param aGoals total goals
     * @param aShots total shots at the target
     * @param aRating attacking rating
     * @param aMove celebration move
     */
    public Attacker(String aName, String aCountry, int aStamina,
                    int aGoals, int aShots, double aRating, CelebrationMove aMove) {
        super(aName, aCountry, aStamina);
        if (aShots >= 0) {
            this.totalShotsOnTarget = aShots;
        }

        if (aGoals >= 0) {
            if (aGoals > aShots) {
                this.totalGoals = aShots;
            } else {
                this.totalGoals = aGoals;
            }
        }

        if ((aRating >= 0) && (aRating <= 100)) {
            this.attackingRating = aRating;
        }

        this.celebrationMove = aMove;
    }

    /** Accessor for total goals.
     *
     * @return total goals
     */
    public int getTotalGoals() {
        return this.totalGoals;
    }

    /** Mutator for total goals.
     *
     * @param newGoals new total goals
     */
    public void setTotalGoals(int newGoals) {

        if (newGoals >= 0) {
            if (newGoals > this.totalShotsOnTarget) {
                this.totalGoals = this.totalShotsOnTarget;
            } else {
                this.totalGoals = newGoals;
            }
        }
    }

    /** Accessor for total shots on targets.
     *
     * @return total shots on target
     */
    public int getTotalShotsOnTarget() {
        return this.totalShotsOnTarget;
    }

    /** Mutator for total shots on target.
     *
     * @param newShots new total shots on target
     */
    public void setTotalShotsOnTarget(int newShots) {
        if (newShots >= 0) {
            this.totalShotsOnTarget = newShots;
        }
    }

    /** Accessor for attacking rating.
     *
     * @return attacking rating
     */
    public double getAttackingRating() {
        return this.attackingRating;
    }

    /** Mutator for attacking rating.
     *
     * @param newRate new attacking rating
     */
    public void setAttackingRating(double newRate) {
        if ((newRate >= 0) && (newRate <= 100)) {
            this.attackingRating = newRate;
        }
    }

    /** Accessor for celebration move.
     *
     * @return celebration move
     */
    public CelebrationMove getCelebrationMove() {
        return this.celebrationMove;
    }

    /** Mutator for celebration move.
     *
     * @param newMove new celebration move
     */
    public void setCelebrationMove(CelebrationMove newMove) {
        this.celebrationMove = newMove;
    }

    /** Overridden toString method.
     *
     * @return String: “'name' from 'country' has 'stamina' stamina left. As an Attacker,
     * I have scored 'totalGoals' goals from 'totalShotsOnTarget' shots on target and my
     * rating is 'attackingRating'  My celebration is 'celebrationMove'”
     */
    @Override
    public String toString() {
        double roundAR = Math.round(this.attackingRating * 100) / 100;
        String returnString = super.toString() + ". As an Attacker, I have scored "
                + this.totalGoals + " goals from" + this.totalShotsOnTarget
                + " shots on target and my rating is " + roundAR
                + ".My celebration is " + this.celebrationMove;
        return returnString;
    }

    /** Overridden equals method.
     *
     * @param obj2 the other object to which this object is to be compared
     * @return boolean of whether the objects have same name, country, total goals,
     * total shots on target, rating, and celebration move.
     */
    @Override
    public boolean equals(Object obj2) {

        if (obj2 == null) {
            return false;

        } else if (!(obj2 instanceof Attacker)) {
            return false;

        } else {
            Attacker a2 = (Attacker) obj2;

            return ((super.equals(obj2)) && (a2.totalGoals == this.totalGoals)
                    && (a2.totalShotsOnTarget == this.totalShotsOnTarget)
                    && (a2.attackingRating == this.attackingRating)
                    && (a2.celebrationMove == this.celebrationMove));
        }
    }

    /** Calculates the attacking rating of the player.
     *
     * @return the defense rating
     */
    @Override
    public double calculateRating() {

        double aRating;
        if (this.totalShotsOnTarget == 0) {
            aRating = 0;
        } else {
            aRating = ((double) totalGoals / totalShotsOnTarget) * 100;
        }

        return aRating;
    }

    /** Completes a play for the Attacker.      */
    @Override
    public void play() {
        int randomNum = (int) (Math.random() * 101);
        this.setStamina(this.getStamina() - randomNum);

        int randomShots = (int) (Math.random() * 101);
        this.totalShotsOnTarget = randomShots;

        if (this.getStamina() == 0) {
            this.totalGoals = 0;
        } else {
            int randomGoals = (int) (Math.random() * (randomShots + 1));
            this.totalGoals = randomGoals;

            if (this.celebrationMove == CelebrationMove.SIUU) {
                int goals = (int) (this.totalGoals * 1.1);
                this.setTotalGoals(goals);
            }
        }
        this.attackingRating = this.calculateRating();
    }

}
