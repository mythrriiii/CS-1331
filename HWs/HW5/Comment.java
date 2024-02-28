/** Videos hold comments and comments can be liked, disliked, and compared to each other.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */
public class Comment implements Likeable, Comparable<Comment> {

    /** Represents whether a comment was spam, true if it was. */
    private boolean isSpam;
    /** A count of how many likes a comment has. Can never be negative. */
    private int likes;
    /** A count of how many dislikes a comment has. Can never be negative. */
    private int dislikes;
    /** Represents the text in a comment. */
    private String value;

    /** Constructor for Comment.
     *
     * @param nLikes number of likes
     * @param nDislikes number of dislikes
     * @param nValue the text in a comment
     * @param nIsSpam whether it is spam
     */
    public Comment(int nLikes, int nDislikes, String nValue, boolean nIsSpam) {

        if (nLikes < 0) {
            this.likes = 0;
        } else {
            this.likes = nLikes;
        }

        if (nDislikes < 0) {
            this.dislikes = 0;
        } else {
            this.dislikes = nDislikes;
        }

        if (nValue != null) {
            this.value = nValue;
        } else {
            this.value = "";
        }

        this.isSpam = nIsSpam;

    }

    /** Overridden getLikes method.
     *
     * @return number of likes
     */
    @Override
    public int getLikes() {
        return this.likes;
    }

    /** Sets the number of likes to a new value.
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

    /** Get value of the string method.
     *
     * @return the comment in the String
     */
    public String getValue() {
        return this.value;
    }

    /** Set the string value to a new one.
     *
     * @param nValue the new string value
     */
    public void setValue(String nValue) {
        if (nValue != null) {
            this.value = nValue;
        }
    }

    /** Get boolean whether the comment is spam.
     *
     * @return whether it is spam or not
     */
    public boolean getIsSpam() {
        return this.isSpam;
    }

    /** Set whether it is spam or not to a new value.
     *
     * @param nIsSpam the new spam or not value.
     */
    public void setIsSpam(boolean nIsSpam) {
        this.isSpam = nIsSpam;
    }

    /**Overridden compareTo.
     *
     * @param o object to be compared to
     * @return -1 if this object's like factor is lower. 0 if it is the same, 1 if it is higher
     */
    @Override
    public int compareTo(Comment o) {

        int likeFactor1 = this.likes - this.dislikes;
        int likeFactor2 = o.getLikes() - o.getDislikes();

        if (o == null) {
            return -1;
        } else {
            if (likeFactor1 > likeFactor2) {
                return 1;
            } else if (likeFactor1 == likeFactor2) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    /**Overridden equals method.
     *
     * @param o object to be compared with
     * @return whether the objects are equal
     */
    @Override
    public boolean equals(Object o) {

        if (o == null) {
            return false;
        } else if (!(o instanceof Comment)) {
            return false;
        } else {
            Comment c = (Comment) o;

            return ((this.getLikes() ==  c.getLikes()) && (this.getDislikes() == c.getDislikes())
                    && (this.getValue() == c.getValue()) && (this.getIsSpam() == c.getIsSpam()));

        }
    }


    /**Overridden toString methods.
     *
     * @return Returns “'Value', 'likes' likes, Spam: 'isSpam'.”
     */
    @Override
    public String toString() {
        String returnValue = this.value + ", " + this.likes + "likes, Spam: " + this.isSpam + ".";
        return returnValue;
    }
}

