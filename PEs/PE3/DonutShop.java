import java.util.Scanner;

public class DonutShop {

    public static void main(String[] args) {
        System.out.println("Welcome to Donut Shop Finder!\n");

        Scanner scan = new Scanner (System.in);
        System.out.print("Enter your desired zip code: ");
        int zipCode = scan.nextInt();
        String shopName;

        switch (zipCode){

            case 33511:
                shopName = "Dunkin Donuts";
                break;

            case 30328:
                shopName = "Tim Hortons";
                break;

            case 30356:
                shopName = "Krispy Kreme";
                break;

            case 30211:
                shopName = "Sublime";
                break;

            default:
                shopName = "Sorry, no shops found.";
        }

        if (shopName.equals("Sorry, no shops found.")){
            System.out.println(shopName);
        }
        else{
            System.out.println("There is a donut shop called "+shopName+" here!");
            System.out.print("Enter your budget: ");
            int budget = scan.nextInt();
            int donuts;

            if ((1<=budget) && (budget<=5)) {
                donuts = 2;
            }
            else if ((6<=budget) && (budget<=11)) {
                donuts = 4;
            }
            else if ((12<=budget) && (budget<=20)) {
                donuts = 8;
            }
            else if (20<=budget)  {
                donuts = 16;
            }
            else {
                donuts = -1;
            }

            if (donuts==-1){
                System.out.println("Invalid");
            }
            else{
                System.out.println("You can purchase "+donuts+" donut(s).");
            }
        }
    }
}
