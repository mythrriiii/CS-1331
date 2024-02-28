public class Chef {

    private String name;
    private String specialty;
    private Recipe[] recipes;


    private Recipe testRecipe1 = new Recipe();
    private Recipe[] testRecipeArray = {testRecipe1};

    public Chef(String newName, String newSpecialty, Recipe[] newRecipeArray) {

        name = newName.trim();
        specialty = newSpecialty.trim();
        recipes = newRecipeArray;


        if (((newName.trim()).equals("")) || (newName == null) || ((newSpecialty.trim()).equals(""))
                || (newSpecialty == null) || (!(newRecipeArray.length >= 1) && (newRecipeArray.length <= 10))) {
            name = "Gordon Ramsay";
            specialty = "Lamb Sauce";
            recipes = testRecipeArray;
        }
    }

    public Chef() {
        name = "Gordon Ramsay";
        specialty = "Lamb Sauce";
        recipes = testRecipeArray;
    }

    public void cook(int recipeIndex) {
        int prepTime;
        if (recipes[recipeIndex].getName().equals(this.specialty)) {
            prepTime = recipes[recipeIndex].getPrepTime() / 2;
        } else if ((recipeIndex < 0) || (recipeIndex >= recipes.length) || (recipes[recipeIndex] == null)) {
            prepTime = -1;
        } else {
            prepTime = recipes[recipeIndex].getPrepTime();
        }

        if (prepTime == -1) {
            System.out.println("What is this nonsense? Get out of my kitchen, I won’t make that!");
        } else {
            System.out.println("Bon Appetit! Using");
            for (int i = 0; i < recipes[recipeIndex].getIngredients().length; i++) {
                System.out.println(recipes[recipeIndex].getIngredients()[i].getQuantity() + " grams of "
                        + recipes[recipeIndex].getIngredients()[i].getKind());
            }
            System.out.println("I, " + this.name + ", finished cooking " + this.recipes[recipeIndex].getName()
                    + " after " + this.recipes[recipeIndex].getPrepTime() + " minute(s). This can serve "
                    + this.recipes[recipeIndex].getNumServings() + " people.");
        }
    }

    public void cater(int numOfServings) {
        int recipeIndex = -1;

        for (int i = 0; i < this.recipes.length; i++) {
            if (this.recipes[i] != null) {
                if (numOfServings <= this.recipes[i].getNumServings()) {
                    recipeIndex = i;
                    break;
                }
            }
        }

        if (recipeIndex == -1) {
            System.out.println("My gran could do better... than me?!");
        } else {
            cook(recipeIndex);
        }

    }

    /* public static void main (String[] args){
        Ingredient i1 = new Ingredient();
        Ingredient i2 = new Ingredient("Lamb", 2.3);
        Ingredient [] iArray = {i1, i2, i2, i2};
        Recipe r1 = new Recipe ();
        Recipe r2 = new Recipe("Name1", 40, 2, iArray );
        Recipe r3 = new Recipe("Name2", 60, 4, iArray );
        Recipe [] rArray = {r1, r2, r3};

        Chef c1= new Chef ("Gala", "Chicken", rArray);
        c1.cook(1);
        c1.cater(9);
    } */

}
