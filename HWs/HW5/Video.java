import java.util.ArrayList;

/** Video is a class that represents a video page. It has comments and can be liked and disliked.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */
public class Video implements Likeable {

    /** Represents the comments on a video. */
    private ArrayList<Comment> comments;
    /** Represents the length of the video in minutes: cannot be negative or exceed 60 min. */
    private double length;
    /** Represents the number of likes for a video.*/
    private int likes;
    /** Represents the number of dislikes for a video/*/
    private int dislikes;

    /** Constructor for video.
     *
      * @param vLength the length of the video
     * @param vLikes the number of likes for the video
     * @param vDislikes the number of dislikes for the video
     */
    public Video(double vLength, int vLikes, int vDislikes) {

        if ((vLength >= 0) && (vLength <= 60)) {
            this.length = vLength;
        } else {
            this.length = 0;
        }

        if (vLikes < 0) {
            this.likes = 0;
        } else {
            this.likes = vLikes;
        }

        if (vDislikes < 0) {
            this.dislikes = 0;
        } else {
            this.dislikes = vDislikes;
        }
        comments = new ArrayList<Comment>();

    }

    /** Default Constructor.
     */
    public Video() {
        this(0, 0, 0);
    }

    /** Overridden getLikes method.
     *
     * @return number of likes
     */
    @Override
    public int getLikes() {
        return this.likes;
    }

    /** Sets the number of likes to a new values.
     *
     * @param nLikes new number of likes
     */
    public void setLikes(int nLikes) {
        if (nLikes >= 0) {
            this.likes = nLikes;
        }
    }

    /** Overridden getDislikes method.
     *
     * @return number of dislikes
     */
    @Override
    public int getDislikes() {
        return this.dislikes;
    }

    /** Sets the number of dislikes to a new value.
     *
     * @param nDislikes number of dislikes
     */
    public void setDislikes(int nDislikes) {
        if (nDislikes >= 0) {
            this.dislikes = nDislikes;
        }
    }

    /** Get length method.
     *
     * @return the length in minutes
     */
    public double getLength() {
        return this.length;
    }

    /** Sets the length to a new values.
     *
     * @param nLength the new length
     */
    public void setLength(double nLength) {
        if ((nLength >= 0) && (nLength <= 60)) {
            this.length = nLength;
        }
    }

    /** Get the comments.
     *
     * @return ArrayList with comments
     */
    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    /** Sets the comments ArrayList to a new value.
     *
     * @param nComments new comments ArrayList
     */
    public void setComments(ArrayList<Comment> nComments) {
        if (nComments != null) {
            this.comments = nComments;
        }
    }

    /** Overridden toString method.
     *
     * @return “This video has 'number of comments' comments and is 'length' long.”
     */
    @Override
    public String toString() {
        String returnValue = "This video has " + this.comments.size() + " comments and is "
                + this.length + " long.";
        return returnValue;
    }

    /** Overridden equals method.
     *
     * @param o any object to be compared
     * @return boolean for whether they have the same number of comments, length, likes, and dislikes
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Video)) {
            return false;
        } else {
            Video v = (Video) o;

            return ((this.comments.size() ==  v.comments.size()) && (this.length == v.getLength())
                    && (this.getLikes() == v.getLikes()) && (this.getDislikes() == v.getDislikes()));
        }
    }

    /** Adds a comment to the comments ArrayList.
     *
     * @param c comment to be added
     */
    public void createComment(Comment c) {
        if (c != null) {
            this.comments.add(c);
        }

    }

    /** Removes the first occurrence of a comment in the ArrayList.
     *
     * @param c the comment to be removed
     * @return whether it has been removed or not
     */
    public boolean removeComment(Comment c) {
        return this.comments.remove(c);
    }

    /** Returns an ArrayList with the spam comments.
     *
     * @return ArrayList with the spam comments
     */
    public ArrayList<Comment> spamComments() {
        ArrayList<Comment> spam = new ArrayList<>();

        for (Comment c: this.comments) {
            if (c.getIsSpam()) {
                spam.add(c);
            }
        }
        return spam;
    }

    /** Converts the comments to an Array.
     *
     * @return Array with the comments
     */
    public Object[] toArray() {
        return this.comments.toArray();
    }

    /** Returns an array with the top and worst comment based on Like Factor.
     *
     * @return an array with the top and worst comment based on Like Factor
     */
    public Comment[] topAndWorstComment() {
        Comment[] topWorst = new Comment[2];
        Comment top = this.comments.get(0);
        Comment worst = this.comments.get(0);
        int likeFactor;

        for (Comment c: this.comments) {

            likeFactor = c.getLikes() - c.getDislikes();

            if (likeFactor > (top.getLikes() - top.getDislikes())) {
                top = c;
            }
            if (likeFactor < (worst.getLikes() - worst.getDislikes())) {
                worst = c;
            }
        }

        topWorst[0] = top;
        topWorst[1] = worst;

        return topWorst;
    }


}
