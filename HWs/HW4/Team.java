/** Team class has a team name and an array of different soccer players.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */

public class Team {

    /** String representing the team name. */
    private String teamName;
    /** Array of Soccer Players. */
    private SoccerPlayer[] players;

    /** Constructor that takes in team name and initializes the array to contain 11 players.
     *
     * @param newTeamName the team name
     */
    public Team(String newTeamName) {

        if (newTeamName != null) {
            this.teamName = newTeamName;
        }
        players = new SoccerPlayer[11];

    }

    /** Overridden toString method.
     *
     * @return String: “Team name: 'teamName'” followed by the toString() of each
     * player on the team on a new line.
     */
    @Override
    public String toString() {
        String returnString = "Team name: " + this.teamName + "\n";
        for (SoccerPlayer s: players) {
            returnString += s.toString() + "\n";
        }

        return returnString;
    }

    /** Method to add a team member to the team.
     *
     * @param player player to be added
     */
    public void addTeamMember(SoccerPlayer player) {

        if (player != null) {
            for (int i = 0; i < this.players.length; i++) {
                if (this.players[i] == null) {
                    this.players[i] = player;
                    break;
                }
            }
        }

    }

    /** Method to play against another team that calculates who wins.
     *
     * @param opponent the other team
     * @return String with the team who won
     */
    public String playAgainstTeam(Team opponent) {
        for (SoccerPlayer p1: this.players) {
            if (p1 != null) {
                p1.play();
            }
        }
        for (SoccerPlayer p2: opponent.players) {
            if (p2 != null) {
                p2.play();
            }
        }

        int playerCount1 = 0;
        int playerCount2 = 0;
        double ratingTotal1 = 0;
        double ratingTotal2 = 0;

        for (SoccerPlayer p1: this.players) {
            if (p1 != null) {
                playerCount1++;
                if (p1 instanceof GoalKeeper) {
                    ratingTotal1 += ((GoalKeeper) p1).getBallHandling();
                } else if (p1 instanceof Defender) {
                    ratingTotal1 += ((Defender) p1).getDefenseRating();
                } else if (p1 instanceof Attacker) {
                    ratingTotal1 += ((Attacker) p1).getAttackingRating();
                }
            }
        }

        for (SoccerPlayer p2: opponent.players) {
            if (p2 != null) {
                playerCount2++;
                if (p2 instanceof GoalKeeper) {
                    ratingTotal2 += ((GoalKeeper) p2).getBallHandling();
                } else if (p2 instanceof Defender) {
                    ratingTotal2 += ((Defender) p2).getDefenseRating();
                } else if (p2 instanceof Attacker) {
                    ratingTotal2 += ((Attacker) p2).getAttackingRating();
                }
            }
        }

        double average1;
        double average2;

        if (playerCount1 == 0) {
            average1 = 0;
        } else {
            average1 = ratingTotal1 / playerCount1;
        }

        if (playerCount2 == 0) {
            average2 = 0;
        } else {
            average2 = ratingTotal2 / playerCount2;
        }

        if (average1 > average2) {
            return this.toString();
        } else if (average1 == average2) {
            return "Tie";
        } else {
            return opponent.toString();
        }

    }

}
