/** GameSim class to simulate a game and test out the methods of the classes.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */

public class GameSim {

    /** Main method to run and test the program.
     *
     * @param args main method parameter
     */
    public static void main(String[] args) {

        SoccerPlayer p1 = new GoalKeeper("Andy", "Brazil", 59, 5, 7, 78);
        SoccerPlayer p2 = new GoalKeeper("Mal", "Argentina", 45, 7, 8, 85);
        SoccerPlayer p3 = new Defender("Sam", "England", 77, 7, 5, 66);
        SoccerPlayer p4 = new Defender("Mike", "USA", 45, 10, 8, 54);
        SoccerPlayer p5 = new Defender("Randall", "Spain", 48, 9, 5, 88);
        SoccerPlayer p6 = new Defender("Ben", "England", 66, 9, 6, 69);
        SoccerPlayer p7 = new Attacker("Sal", "Brazil", 77, 6, 9, 28, Attacker.CelebrationMove.SIUU);
        SoccerPlayer p8 = new Attacker("Richard", "USA", 98, 7, 10, 88, Attacker.CelebrationMove.CARTWHEEL);


        Team t1 = new Team("Team A");
        Team t2 = new Team("Team B");

        t1.addTeamMember(p1);
        t1.addTeamMember(p3);
        t1.addTeamMember(p5);
        t1.addTeamMember(p6);
        t1.addTeamMember(p7);
        t1.addTeamMember(p4);
        t1.addTeamMember(p2);
        t2.addTeamMember(p3);
        t2.addTeamMember(p8);
        t2.addTeamMember(p5);
        t2.addTeamMember(p4);
        t2.addTeamMember(p7);
        t2.addTeamMember(p1);
        t2.addTeamMember(p3);


    }

}
