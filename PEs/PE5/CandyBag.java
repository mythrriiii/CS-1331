public class CandyBag {

    enum Candy {
        GUMMY_BEAR,
        LOLLIPOP,
        CHOCOLATE,
        LICORICE,
        HARD_CANDY
    }

    public static Candy[] createBag() {
        Candy[] candyArray = new Candy[6];
        for (int i = 0; i < 6; i++) {
            int testNum = (int) (Math.random() * 5);
            Candy candyName = Candy.HARD_CANDY;

            switch (testNum) {
            case 0:
                candyName = Candy.GUMMY_BEAR;
                break;
            case 1:
                candyName = Candy.LOLLIPOP;
                break;
            case 2:
                candyName = Candy.CHOCOLATE;
                break;
            case 3:
                candyName = Candy.LICORICE;
                break;
            case 4:
                candyName = Candy.HARD_CANDY;
                break;
            default:
            }
            candyArray[i] = candyName;
        }

        return candyArray;
    }

    public static void printBag(Candy[] candyArrayPrint) {
        System.out.println("Your assortment of candy includes: ");
        for (int i = 0; i < candyArrayPrint.length; i++) {
            System.out.println(candyArrayPrint[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Candy[] candyArray1 = createBag();
        Candy[] candyArray2 = createBag();
        printBag(candyArray1);
        printBag(candyArray2);

    }
}
