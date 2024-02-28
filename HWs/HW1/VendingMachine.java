public class VendingMachine {

    public static void main(String[] args) {

        int[][] items = {{101, 25}, {102, 20}, {103, 30}, {104, 35}, {105, 40}, {106, 45}, {107, 50}, {108, 55}};
        int balance = 200;

        balance = buyItem(items, balance, 103);    //returns 170
        balance = buyRandomItem(items, balance);
        updateItems(items, 108, 60); //changes the price of the item with code 108 to 60
        System.out.println(items[7][0]);
        System.out.println(items[7][1]);
        updateItems(items, 100, 15); //changes the item with code 102 to 100 and its price to 15
        System.out.println(items[1][0]);
        System.out.println(items[1][1]);

    }

    public static int updateBalance(int price, int currentBalance) {
        int newBalance;
        if (currentBalance >= price) {
            newBalance = currentBalance - price;
        } else {
            newBalance = currentBalance;
        }
        return newBalance;
    }

    public static int buyItem(int[][] itemsArray, int currentBalance, int itemCode) {
        int newBalance = currentBalance;

        for (int i = 0; i < itemsArray.length; i++) {
            if (itemCode == itemsArray[i][0]) {
                if (currentBalance > itemsArray[i][1]) {
                    newBalance = updateBalance(itemsArray[i][1], currentBalance);
                }
                break;
            }
        }
        return newBalance;
    }

    public static int buyRandomItem(int[][] itemsArray, int currentBalance) {
        int arrayLength = itemsArray.length;
        int randomItemIndex = (int) (Math.random() * arrayLength);
        int newBalance = buyItem(itemsArray, currentBalance, itemsArray[randomItemIndex][0]);
        return newBalance;
    }

    public static void updateItems(int[][] itemsArray, int newItemCode, int newItemPrice) {
        int lowestPriceIndex = 0;
        int lowestItemPrice = itemsArray[0][1];

        for (int i = 0; i < itemsArray.length; i++) {
            if (newItemCode == itemsArray[i][0]) {
                lowestPriceIndex = i;
                break;
            } else if (lowestItemPrice > itemsArray[i][1]) {
                lowestItemPrice = itemsArray[i][1];
                lowestPriceIndex = i;
            }
        }

        itemsArray[lowestPriceIndex][0] = newItemCode;
        itemsArray[lowestPriceIndex][1] = newItemPrice;
    }

}






















