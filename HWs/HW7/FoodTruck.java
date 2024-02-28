import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

/** A simple CS 1331 Food Truck interactive application where users can select multiple items and then make a purchase.
 *  It has 5 food items, all with different costs. The user can provide a count of how many of each item that they
 *  want to order.  The current cost for the active selections should always be shown in the UI.
 *  The interface also contains a “Clear” button that, when pressed, sets the quantity of all items back to zero.
 *  Finally, when a purchase is made, the total order and its cost is printed out to a file named “order.txt”.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */
public class FoodTruck extends Application {

    /** Cost of the 1st item. */
    static int costItem1 = 5;
    /** Cost of the 2nd item. */
    static int costItem2 = 8;
    /** Cost of the 3rd item. */
    static int costItem3 = 2;
    /** Cost of the 4th item. */
    static int costItem4 = 6;
    /** Cost of the 5th item. */
    static int costItem5 = 1;

    /** Variable representing the current total cost. */
    static Integer totalCost = 0;
    /** A label that displays the current total cost on the UI. */
    static Label totalText = new Label("Total is: $" + totalCost); // add count variable

    /**Overridden start method that produces the JavaFX Stage.
     *
     * @param primaryStage the stage for the program
     * @throws NegativeQuantityException if entered quantity is a negative number.
     */
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws NegativeQuantityException {
        try {
            //Item Quantity TextFields
            TextField input1 = new TextField();   //Item 1 Quantity TextField
            quantityTextFieldSetUp(input1);
            TextField input2 = new TextField();   //Item 2 Quantity TextField
            quantityTextFieldSetUp(input2);
            TextField input3 = new TextField();   //Item 3 Quantity TextField
            quantityTextFieldSetUp(input3);
            TextField input4 = new TextField();   //Item 4 Quantity TextField
            quantityTextFieldSetUp(input4);
            TextField input5 = new TextField();   //Item 5 Quantity TextField
            quantityTextFieldSetUp(input5);

            GridPane innerCentrepane = new GridPane();
            Button info1 = new Button("Ingredients");                         //Item 1 Information Alert
            EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    String ingList = "Ingredients: \n\nCheese \nChilli pepper \nOnion \nTomato \nChicken \nSeasoning";
                    String imgName = "Taco.jpg";
                    infoButtonSetUp(ingList, imgName);
                }
            };
            info1.setOnAction(event1);

            Button info2 = new Button("Ingredients");                        //Item 2 Information Alert
            EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    String ingList = "Ingredients: \n\nCheese \nPatty \nOnion \nTomato \nSpecial Sauce \nPickles";
                    String imgName = "Burger.jpg";
                    infoButtonSetUp(ingList, imgName);
                }
            };
            info2.setOnAction(event2);

            Button info3 = new Button("Ingredients");                        //Item 3 Information Alert
            EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    String ingList = "Ingredients: \n\nHouse Cut Potato Fries \nSecret Blend Seasoning \nSalt";
                    String imgName = "Fries.jpg";
                    infoButtonSetUp(ingList, imgName);
                }
            };
            info3.setOnAction(event3);

            Button info4 = new Button("Ingredients");                       //Item 4 Information Alert
            EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    String ingList = "Ingredients: \n\nChicken Wings \nSauce \nRanch \nCelery ";
                    String imgName = "Wings.jpg";
                    infoButtonSetUp(ingList, imgName);
                }
            };
            info4.setOnAction(event4);

            Button info5 = new Button("Ingredients");                       //Item 5 Information Alert
            EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    String ingList = "Ingredients: \n\nCoca-Cola \nPepsi \nSprite \nLemonade \nDiet Coke \nWater";
                    String imgName = "Drink.jpg";
                    infoButtonSetUp(ingList, imgName);
                }
            };
            info5.setOnAction(event5);

            Button clear = new Button("Clear");                             //Clear Button
            clear.setOnAction(new EventHandler<ActionEvent>() {
                @Override // Override the handle method
                public void handle(ActionEvent e) {
                    setTo0(input1, input2, input3, input4, input5);
                }
            });
            Button purchase = new Button("Purchase");                       //Purchase Button
            purchase.setOnAction(new EventHandler<ActionEvent>() {
                @Override // Override the handle method
                public void handle(ActionEvent e) {
                    try {
                        changeTotal(input1, input2, input3, input4, input5);
                    } catch (NegativeQuantityException ex) {
                        System.out.println(ex.toString());
                    } catch (IllegalQuantityException ex) {
                        System.out.println(ex.toString());
                    }
                    printReceipt(input1, input2, input3, input4, input5);
                }
            });

            input1.setOnAction(e -> {                                        //Updating Values
                try {
                    changeTotal(input1, input2, input3, input4, input5);
                } catch (NegativeQuantityException ex) {
                    System.out.println(ex.toString());
                } catch (IllegalQuantityException ex) {
                    System.out.println(ex.toString());
                }
            });
            input2.setOnAction(e -> {
                try {
                    changeTotal(input1, input2, input3, input4, input5);
                } catch (NegativeQuantityException ex) {
                    System.out.println(ex.toString());
                } catch (IllegalQuantityException ex) {
                    System.out.println(ex.toString());
                }
            });
            input3.setOnAction(e -> {
                try {
                    changeTotal(input1, input2, input3, input4, input5);
                } catch (NegativeQuantityException ex) {
                    System.out.println(ex.toString());
                } catch (IllegalQuantityException ex) {
                    System.out.println(ex.toString());
                }
            });
            input4.setOnAction(e -> {
                try {
                    changeTotal(input1, input2, input3, input4, input5);
                } catch (NegativeQuantityException ex) {
                    System.out.println(ex.toString());
                } catch (IllegalQuantityException ex) {
                    System.out.println(ex.toString());
                }
            });
            input5.setOnAction(e -> {
                try {
                    changeTotal(input1, input2, input3, input4, input5);
                } catch (NegativeQuantityException ex) {
                    System.out.println(ex.toString());
                } catch (IllegalQuantityException ex) {
                    System.out.println(ex.toString());
                }
            });

            BorderPane pane = new BorderPane();                                //Method Call
            topPaneSetUp(pane);
            centrePaneSetUp(pane, innerCentrepane, input1, input2, input3, input4, input5);
            centrePaneAddButtons(innerCentrepane, info1, info2, info3, info4, info5);
            bottomPaneSetUp(pane, clear, purchase);

            Scene scene = new Scene(pane, 350, 370);                    //Scene
            primaryStage.setTitle("Food Truck"); // Set the stage title
            primaryStage.setScene(scene); // Place the scene in the stage
            primaryStage.show(); // Display the stage

        } catch (RuntimeException ex) {
            System.out.println(ex.toString());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    /** Sets up the TextFields with the dimensions 40x50, centers it, and sets an initial value of 0.
     *
     * @param t1 the TextField to be changed.
     */
    public static void quantityTextFieldSetUp(TextField t1) {
        t1.setAlignment(Pos.CENTER);
        t1.setMaxSize(40, 50);
        t1.setText("0");
    }

    /**Sets up the Information Buttons to have an Alert pop up with the ingredients and a picture of the food.
     *
     * @param ingList List of ingredients as a String
     * @param imgName Name of the image file to be shown
     */
    public static void infoButtonSetUp(String ingList, String imgName) {
        Alert a1 = new Alert(Alert.AlertType.NONE,
                ingList, ButtonType.OK);

        Pane pane = new Pane();
        ImageView image = new ImageView(imgName);
        image.setFitHeight(150);
        image.setFitWidth(150);
        pane.getChildren().add(image);
        a1.setGraphic(pane);
        // show the dialog
        a1.show();

    }

    /** Sets up the top pane with the title.
     *
     * @param pane The base pane onto which all the nodes are to be added
     */
    public static void topPaneSetUp(BorderPane pane) {
        //Top
        Text title = new Text("CS 1331 Food Truck");
        title.setFont(Font.font("TimesNewRoman", FontWeight.BOLD, 20));
        VBox innerTopPane = new VBox();
        innerTopPane.getChildren().add(title);
        innerTopPane.setPadding(new Insets(20, 20, 20, 20));
        innerTopPane.setAlignment(Pos.CENTER);
        innerTopPane.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY,
                Insets.EMPTY)));
        //Add innerPane to Top
        pane.setTop(innerTopPane);
    }

    /**Sets up the Centre pane with buttons and textFields so users can enter the quantity of the food they want.
     *
     * @param pane The base pane to which all the nodes are to be added
     * @param innerCentrepane The inner pane which will have the buttons and label to be placed in the centre
     * @param t1 textField to get quantity of Food Item1
     * @param t2 textField to get quantity of Food Item2
     * @param t3 textField to get quantity of Food Item3
     * @param t4 textField to get quantity of Food Item4
     * @param t5 textField to get quantity of Food Item5
     */
    public static void centrePaneSetUp(BorderPane pane, GridPane innerCentrepane, TextField t1, TextField t2,
                                       TextField t3, TextField t4, TextField t5) {
        //Centre
        innerCentrepane.setPadding(new Insets(30, 30, 30, 30));
        innerCentrepane.setHgap(10);
        innerCentrepane.setVgap(10);
        innerCentrepane.setAlignment(Pos.CENTER);
        innerCentrepane.setBackground(new Background(new BackgroundFill(Color.BISQUE,
                CornerRadii.EMPTY, Insets.EMPTY)));

        //Add elements to Pane
        innerCentrepane.add(new Label("Taco  $5"), 1, 0);
        innerCentrepane.add(t1, 0, 0);
        innerCentrepane.add(new Label("Burger  $8"), 1, 1);
        innerCentrepane.add(t2, 0, 1);
        innerCentrepane.add(new Label("Fries  $2"), 1, 2);
        innerCentrepane.add(t3, 0, 2);
        innerCentrepane.add(new Label("Wings  $6"), 1, 3);
        innerCentrepane.add(t4, 0, 3);
        innerCentrepane.add(new Label("Drink  $1"), 1, 4);
        innerCentrepane.add(t5, 0, 4);

        //Add innerCentrepane to Centre
        pane.setCenter(innerCentrepane);

    }

    /** Adds buttons to the Centre pane for viewers to see ingredients and a picture of the food.
     *
     * @param innerCentrepane The inner pane which will have the buttons
     * @param b1 button to get information on Food Item 1
     * @param b2 button to get information on Food Item 2
     * @param b3 button to get information on Food Item 3
     * @param b4 button to get information on Food Item 4
     * @param b5 button to get information on Food Item 5
     */
    public static void centrePaneAddButtons(GridPane innerCentrepane, Button b1, Button b2, Button b3,
                                            Button b4, Button b5) {
        innerCentrepane.add(b1, 4, 0);
        innerCentrepane.add(b2, 4, 1);
        innerCentrepane.add(b3, 4, 2);
        innerCentrepane.add(b4, 4, 3);
        innerCentrepane.add(b5, 4, 4);
    }

    /** Sets up the bottom pane of the base pane.
     *
     * @param pane The base pane to which all the nodes are to be added
     * @param clear Resets all quantities and total cost to 0
     * @param purchase prints out the receipt on a text file
     */
    public static void bottomPaneSetUp(BorderPane pane, Button clear, Button purchase) {
        BorderPane bottomPane = new BorderPane();
        bottomPane.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));

        bottomPane.setLeft(clear);
        bottomPane.setRight(purchase);
        bottomPane.setPadding(new Insets(10, 20, 10, 20));

        Pane bottomPane1 = new Pane();
        bottomPane1.getChildren().add(totalText);
        bottomPane1.setPadding(new Insets(5, 5, 5, 5));

        //Add bottomPane to Bottom
        bottomPane.setTop(bottomPane1);
        pane.setBottom(bottomPane);
    }

    /** Sets all values of TextFields to 0.
     *
     * @param t1 textField to get quantity of Food Item1
     * @param t2 textField to get quantity of Food Item2
     * @param t3 textField to get quantity of Food Item3
     * @param t4 textField to get quantity of Food Item4
     * @param t5 textField to get quantity of Food Item5
     */
    public static void setTo0(TextField t1, TextField t2, TextField t3, TextField t4, TextField t5) {
        t1.setText("0");
        t2.setText("0");
        t3.setText("0");
        t4.setText("0");
        t5.setText("0");

        totalCost = 0;
        totalText.setText("Total is: $" + totalCost);
    }

    /** Checks if a given string contains only numbers.
     *
     * @param str string to be checked
     * @return boolean of whether the String contains only numbers.
     */
    public static boolean isNumeric(String str) {
        if ((((str.trim()).toCharArray())[0] == '-') && (!(str.substring(1).equals("")))) {
            for (char c : str.substring(1).toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;

    }

    /** Updates the total cost.
     *
     * @param t1 textField to get quantity of Food Item1
     * @param t2 textField to get quantity of Food Item2
     * @param t3 textField to get quantity of Food Item3
     * @param t4 textField to get quantity of Food Item4
     * @param t5 textField to get quantity of Food Item5
     * @throws IllegalQuantityException If given String is not a number
     * @throws NegativeQuantityException If given String is a negative number
     */
    public static void changeTotal(TextField t1, TextField t2, TextField t3, TextField t4, TextField t5)
            throws IllegalQuantityException, NegativeQuantityException {

        if (!(isNumeric(t1.getText()))) {
            throw new IllegalQuantityException(t1.getText());
        } else if (!(isNumeric(t2.getText()))) {
            throw new IllegalQuantityException(t2.getText());
        } else if (!(isNumeric(t3.getText()))) {
            throw new IllegalQuantityException(t3.getText());
        } else if (!(isNumeric(t4.getText()))) {
            throw new IllegalQuantityException(t4.getText());
        } else if (!(isNumeric(t5.getText()))) {
            throw new IllegalQuantityException(t5.getText());
        } else {

            int total1 = Integer.parseInt(t1.getText());
            int total2 = Integer.parseInt(t2.getText());
            int total3 = Integer.parseInt(t3.getText());
            int total4 = Integer.parseInt(t4.getText());
            int total5 = Integer.parseInt(t5.getText());

            if (total1 < 0) {
                throw new NegativeQuantityException(t1.getText());
            } else if (total2 < 0) {
                throw new NegativeQuantityException(t2.getText());
            } else if (total3 < 0) {
                throw new NegativeQuantityException(t3.getText());
            } else if (total4 < 0) {
                throw new NegativeQuantityException(t4.getText());
            } else if (total5 < 0) {
                throw new NegativeQuantityException(t5.getText());
            } else {
                totalCost = (total1 * costItem1) + (total2 * costItem2) + (total3 * costItem3)
                        + (total4 * costItem4) + (total5 * costItem5);
                totalText.setText("Total is: $" + totalCost);
            }
        }

    }

    /** Prints out a Receipt on a text file and onto the console.
     *
     * @param t1 textField to get quantity of Food Item1
     * @param t2 textField to get quantity of Food Item2
     * @param t3 textField to get quantity of Food Item3
     * @param t4 textField to get quantity of Food Item4
     * @param t5 textField to get quantity of Food Item5
     */
    public static void printReceipt(TextField t1, TextField t2, TextField t3, TextField t4, TextField t5) {

        try {
            File outFile = new File("order.txt");
            PrintWriter outWriter = new PrintWriter(outFile);
            outWriter.println("Receipt of Purchase");
            outWriter.println();
            if (Integer.parseInt(t1.getText()) != 0) {
                outWriter.println("Item 1: Taco    Price: $5    Quantity: " + Integer.parseInt(t1.getText())
                        + "    Item Cost: " + (costItem1 * Integer.parseInt(t1.getText())));
            }
            if (Integer.parseInt(t2.getText()) != 0) {
                outWriter.println("Item 2: Burger    Price: $8    Quantity:  " + Integer.parseInt(t2.getText())
                        + "    Item Cost: " + (costItem2 * Integer.parseInt(t2.getText())));
            }
            if (Integer.parseInt(t3.getText()) != 0) {
                outWriter.println("Item 3: Fries    Price: $2    Quantity:  " + Integer.parseInt(t3.getText())
                        + "    Item Cost: " + (costItem3 * Integer.parseInt(t3.getText())));
            }
            if (Integer.parseInt(t4.getText()) != 0) {
                outWriter.println("Item 4: Wings    Price: $6    Quantity:  " + Integer.parseInt(t4.getText())
                        + "    Item Cost: " + (costItem4 * Integer.parseInt(t4.getText())));
            }
            if (Integer.parseInt(t5.getText()) != 0) {
                outWriter.println("Item 5: Drink    Price: $1   Quantity:  " + Integer.parseInt(t5.getText())
                        + "    Item Cost: " + (costItem5 * Integer.parseInt(t5.getText())));
            }

            outWriter.println();
            outWriter.println("Total is: $" + totalCost);


            outWriter.close();
        } catch (IOException e) {
            System.err.println("Problem with file ");
            System.err.println("Try again");
        }


        try (BufferedReader br = new BufferedReader(new FileReader("order.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}


