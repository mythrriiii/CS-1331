/** Pokemon class which can be compared.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */
public class Pokemon implements Comparable<Pokemon> {

    /** Name of Pokemon  */
    private String name;
    /** Health of Pokemon - can only be between 1 and 100  */
    private int health;
    /** Strength of Pokemon - can only be between 1 and 100 */
    private int strength;
    /** Type of the Pokemon  */
    private PokemonType type;

    /** 4-args Constructor – Takes in instance data in order name, health, type and then strength.
     *
     * @param pName Pokemon Name
     * @param pHealth Pokemon Health
     * @param pType Pokemon Type
     * @param pStrength Pokemon Strength
     */

    public Pokemon(String pName, int pHealth, PokemonType pType, int pStrength) {

        if (pName != null) {
            if (!(pName.trim().equals(""))) {
                this.name = pName;
            } else {
                this.name = "Pikachu";
            }
        } else {
            this.name = "Pikachu";
        }

        if ((pHealth >= 0) && (pHealth <= 100)) {
            this.health = pHealth;
        } else {
            this.health = 50;
        }

        if ((pStrength >= 0) && (pStrength <= 100)) {
            this.strength = pStrength;
        } else {
            this.strength = 50;
        }

        if ((pType.type().equals("Water")) || (pType.type().equals("Fire")) || (pType.type().equals("Water"))) {
            this.type = pType;
        } else {
            this.type = new Fire();
        }

    }

    /** 2-args Constructor – Takes Name and Type of Pokemon and assigns health. If the
     * type is Grass, then the health should be 65. If the type is Water, health should be 80.
     * Else, the health should be 50. Strength should be a random integer between 1 to 100
     * (inclusive).
     *
     * @param pName Pokemon Name
     * @param pType Pokemon Type
     */
    public Pokemon(String pName, PokemonType pType) {

        if (pName != null) {
            if (!(pName.trim().equals(""))) {
                this.name = pName;
            } else {
                this.name = "Pikachu";
            }
        } else {
            this.name = "Pikachu";
        }


        if (pType instanceof Grass) {
            this.type = pType;
            this.health = 65;
        } else if (pType instanceof Water) {
            this.type = pType;
            this.health = 80;
        } else if (pType instanceof Fire) {
            this.type = pType;
            this.health = 50;
        } else {
            this.type = new Fire();
        }

        this.strength = 1 + (int) (Math.random() * 100);
    }

    /**1-args Constructor – Takes in a Pokemon object and deep copies all the
     * information into the current instance.
     *
     * @param p Pokemon to be deep copied
     */
    public Pokemon(Pokemon p) {
        this(p.getName(), p.getHealth(), p.getType(), p.getStrength());

        if (p.getType() instanceof Grass) {
            this.type = new Grass();
        } else if (p.getType() instanceof Water) {
            this.type = new Water();
        } else if (p.getType() instanceof Fire) {
            this.type = new Fire();
        } else {
            this.type = new Fire();
        }
    }

    /** Accessor for name.
     *
     * @return Pokemon name
     */
    public String getName() {
        return this.name;
    }

    /** Modifier for name.
     *
     * @param pName new name
     */
    public void setName(String pName) {
        if (pName != null) {
            if (!(pName.trim().equals(""))) {
                this.name = pName;
            }
        }
    }

    /** Accessor for health.
     *
     * @return Pokemon health
     */
    public int getHealth() {
        return this.health;
    }

    /** Modifier for health.
     *
     * @param pHealth new health
     */
    public void setHealth(int pHealth) {
        if ((pHealth >= 0) && (pHealth <= 100)) {
            this.health = pHealth;
        }
    }

    /** Accessor for Strength.
     *
     * @return Pokemon strength
     */
    public int getStrength() {
        return this.strength;
    }

    /** Modifier for strength.
     *
     * @param pStrength new strength
     */
    public void setStrength(int pStrength) {
        if ((pStrength >= 0) && (pStrength <= 100)) {
            this.strength = pStrength;
        }
    }

    /** Accessor for Pokemon Type.
     *
     * @return Pokemon Type
     */
    public PokemonType getType() {
        return this.type;
    }

    /** Modifier for Pokemon Type.
     *
     * @param pType new pokemon type
     */
    public void setType(PokemonType pType) {
        if ((pType instanceof Water) || (pType instanceof Fire) || (pType instanceof Water)) {
            this.type = pType;
        }
    }

    /** Overridden toString method.
     *
     * @return “'Name' is a 'PokemonType' type with
     * health 'health' and strength 'strength'.”
     */
    @Override
    public String toString() {
        String returnString = this.name + " is a " + this.type.type()
                + " type with health " + this.health + "and strength "
                + this.strength + ".";
        return returnString;
    }

    /** Overridden compareTo method.
     *
     * @param p Pokemon to be compared to
     * @return the health, then the strength of the Pokemon with another
     * Pokemon, then the type of Pokemon such that Grass < Fire < Water
     */
    @Override
    public int compareTo(Pokemon p) {

        if (this.health > p.getHealth()) {
            return 1;
        } else if (this.health < p.getHealth()) {
            return -1;
        } else {

            if (this.strength > p.getStrength()) {
                return 1;
            } else if (this.strength < p.getStrength()) {
                return -1;
            } else {
                return this.type.compareTo(p.getType());
            }
        }
    }


}