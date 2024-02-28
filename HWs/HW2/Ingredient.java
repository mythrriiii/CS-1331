public class Ingredient {

    private String kind;
    private double quantity;

    public Ingredient() {
        this("Salt", 0.2);
    }

    public Ingredient(String newKind, double newQuantity) {

        if (((newKind.trim()).equals("")) || (newKind == null)) {
            kind = "Salt";
        } else {
            kind = newKind.trim();
        }

        if (newQuantity < 0) {
            quantity = 0.2;
        } else {
            quantity = newQuantity;
        }
    }

    public Ingredient(double newQuantity, String newKind) {
        this(newKind, newQuantity);
    }

    public String getKind() {
        return this.kind;
    }

    public double getQuantity() {
        return this.quantity;
    }


    public void setKind(String newKind) {

        if (newKind != null) {
            if (!(newKind.trim().equals(""))) {
                kind = newKind.trim();
            }
        }
    }

    public void setQuantity(double newQuantity) {
        if (newQuantity > 0) {
            quantity = newQuantity;
        }
    }

    /* public static void main (String[] args){
        Ingredient i1 = new Ingredient();
        Ingredient i2 = new Ingredient("Lamb", 2.3);
        System.out.println("i1: "+i1.getKind()+i1.getQuantity());
        System.out.println("i2: "+i2.getKind()+i2.getQuantity());

        i1.setQuantity(3.4);
        i2.setQuantity(-2.0);
        i1.setKind("ab");
        i2.setKind("");

        System.out.println("i1: "+i1.getKind()+i1.getQuantity());
        System.out.println("i2: "+i2.getKind()+i2.getQuantity());

    } */


}







