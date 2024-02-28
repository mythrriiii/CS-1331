import java.util.ArrayList;

/** This is the driver class.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */
public class YouTube {

    /** Main method.
     *
     * @param args main method specification
     */
    public static void main(String[] args) {
        Comment c1 = new Comment(3, 4, "Hello", false);
        Comment c2 = new Comment(5, 3, "Bye", true);
        Comment c4 = new Comment(80, 35, "A", true);
        Comment c3 = new Comment(43, 30, "B", false);

        Video v1 = new Video(40, 9, 4);
        Video v2 = new Video(30, 10, 3);

        v1.createComment(c1);
        v1.createComment(c2);
        v1.createComment(c3);
        v1.createComment(c4);

        v1.removeComment(c4);

        ArrayList<Comment> cAList = v1.spamComments();

        for (Comment a: cAList) {
            System.out.println(a.toString());
        }

        Object[] cArray = v1.toArray();
        Comment[] topWorst = v1.topAndWorstComment();

        for (Comment a: topWorst) {
            System.out.println(a.toString());
        }

    }

}
