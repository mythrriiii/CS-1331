public class Weight {

    public static void main(String[] args) {
        double kgValue = 160;
        int poundValue = (int) ((kgValue* 35.274)/16);
        double ounceValue = (((kgValue* 35.274)/16)-poundValue)*16;

        System.out.println(kgValue + "kg is " + poundValue + " lb " + ounceValue + " oz");
    }
}
