public class Recipe {

    private String name;
    private int prepTime;
    private int numServings;
    private Ingredient[] ingredients;

    private Ingredient testIngredient1 = new Ingredient();
    private Ingredient[] testIngredients = {testIngredient1};


    public Recipe(String newName, int newPrepTime, int newNumServings, Ingredient[] newIngredients) {

        if (((newName.trim()).equals("")) || (newName == null)) {
            name = "Lamb Sauce";
        } else {
            name = newName.trim();
        }

        if (newPrepTime < 0) {
            prepTime = 60;
        } else {
            prepTime = newPrepTime;
        }

        if (newNumServings < 0) {
            numServings = 8;
        } else {
            numServings = newNumServings;
        }

        if ((newIngredients.length >= 1) && (newIngredients.length <= 10)) {
            ingredients = newIngredients;
        } else {
            ingredients = testIngredients;
        }
    }

    public Recipe() {
        name = "Lamb Sauce";
        prepTime = 60;
        numServings = 8;
        ingredients = testIngredients;
    }

    public String getName() {
        return this.name;
    }
    public int getPrepTime() {
        return this.prepTime;
    }
    public int getNumServings() {
        return this.numServings;
    }
    public Ingredient[] getIngredients() {
        return this.ingredients;
    }

    public void setName(String newName) {
        if (!(((newName.trim()).equals("")) || (newName == null))) {
            name = newName.trim();
        }
    }
    public void setPrepTime(int newPrepTime) {
        if (newPrepTime >= 0) {
            prepTime = newPrepTime;
        }
    }
    public void setNumServings(int newNumServings) {
        if (newNumServings >= 0) {
            numServings = newNumServings;
        }
    }
    public void setIngredients(Ingredient[] newIngredients) {
        if ((newIngredients.length >= 1) && (newIngredients.length <= 10)) {
            ingredients = newIngredients;
        }
    }

    public Ingredient dominantIngredient() {

        int maxCount = 0;
        int currentCount = 0;
        Ingredient maxIngredient = ingredients[0];

        for (int i = 0; i < this.ingredients.length; i++) {
            currentCount = 0;
            for (int j = 0; j < this.ingredients.length; j++) {
                if (ingredients[j] == ingredients[i]) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxIngredient = ingredients[i];
            }
        }
        return maxIngredient;
    }

    public void scaleRecipe(int scale) {
        if (scale >= 0) {
            prepTime *= scale;
            numServings *= scale;

            for (int i = 0; i < this.ingredients.length; i++) {
                this.ingredients[i].setQuantity(this.ingredients[i].getQuantity() * scale);
            }
        }
    }

     /* public static void main(String[] args){
        Ingredient i1 = new Ingredient();
        Ingredient i2 = new Ingredient("Lamb", 2.3);
        Ingredient [] iArray = {i1, i2, i2, i2};
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe("Chicken", 4,4, iArray);

        System.out.println("r1: "+r1.getName()+r1.getPrepTime());
        System.out.println("r2: "+r2.getName()+r2.getPrepTime());

         Ingredient[] iA1 = r1.getIngredients();
        for (int i =0; i<iA1.length; i++){
            System.out.println(iA1[i].getKind()+iA1[i].getQuantity());
        }
        Ingredient[] iA2 = r2.getIngredients();
        for (int i =0; i<iA2.length; i++){
            System.out.println(iA2[i].getKind()+iA2[i].getQuantity());
        }

        Ingredient i3dom = r2.dominantIngredient();
        System.out.println(i3dom.getKind()+i3dom.getQuantity());

    }*/


}
