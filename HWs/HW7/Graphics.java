import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/** This is a JavaFX program that uses several graphic calls to create art.
 * This particular program creates a diagram uses shapes of different sizes and angles to create a map of the
 * American Continent. I was inspired by the Russian art form of Suprematism which I have further explained in the
 * attached extra credit text file.
 *
 * @author Mythri Muralikannan
 * @version 1.0
 */

public class Graphics extends Application {

    /** Overridden start method that produces the JavaFX Stage.
     *
     * @param primaryStage the stage for the program
     */
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        Text name = new Text(10, 675, "Mythri Muralikannan");
        Text email = new Text(10, 690, "mmuralikannan3@gatech.edu");
        Text title = new Text(30, 60, "The American Continent");
        Text subtitle = new Text(140, 90, "Suprematism");
        title.setFont(Font.font("TimesNewRoman", FontWeight.BOLD, 30));
        subtitle.setFont(Font.font("TimesNewRoman", FontWeight.BOLD, 20));
        Rectangle bgd = new Rectangle(400, 700, Color.BISQUE);

        //North America
        Rectangle canada = new Rectangle(120, 190, 200, 100);
        canada.setRotate(18);
        canada.setFill(Color.MAROON);
        Rectangle alaska = new Rectangle(100, 140, 20, 100);
        alaska.setRotate(10);
        alaska.setFill(Color.DARKORANGE);
        Rectangle usa = new Rectangle(70, 290, 180, 100);
        usa.setRotate(9);
        usa.setFill(Color.CORAL);
        Rectangle mexico = new Rectangle(80, 390, 80, 120);
        mexico.setFill(Color.CRIMSON);
        mexico.setRotate(-10);
        Rectangle guatemala = new Rectangle(100, 525, 45, 18);
        guatemala.setRotate(-15);
        guatemala.setFill(Color.GOLD);
        Circle belize = new Circle(160, 515, 10);
        belize.setFill(Color.RED);
        Circle elSalvedor = new Circle(120, 553, 7);
        elSalvedor.setFill(Color.BROWN);
        Rectangle honduras = new Rectangle(135, 545, 40, 15);
        honduras.setFill(Color.MAROON);
        Rectangle nicaragua = new Rectangle(140, 560, 20, 23);
        nicaragua.setRotate(-10);
        nicaragua.setFill(Color.CRIMSON);
        Rectangle costaRica = new Rectangle(158, 580, 15, 25);
        costaRica.setRotate(-80);
        costaRica.setFill(Color.DARKORANGE);
        Rectangle panama = new Rectangle(180, 600, 30, 10);
        panama.setRotate(20);
        panama.setFill(Color.CHOCOLATE);
        Rectangle cuba = new Rectangle(190, 440, 60, 10);
        cuba.setRotate(10);
        cuba.setFill(Color.GOLD);
        Circle jamaica = new Circle(230, 465, 7);
        jamaica.setFill(Color.CORAL);
        Rectangle haiti = new Rectangle(252, 455, 15, 12);
        haiti.setFill(Color.CHOCOLATE);
        Circle puertoRico = new Circle(290, 470, 5);
        puertoRico.setFill(Color.DARKORANGE);
        Rectangle dominican = new Rectangle(270, 455, 15, 12);
        dominican.setRotate(5);
        dominican.setFill(Color.BROWN);


        Pane pane = new Pane();
        pane.getChildren().add(bgd);
        pane.getChildren().add(title);
        pane.getChildren().add(subtitle);
        pane.getChildren().add(name);
        pane.getChildren().add(email);

        pane.getChildren().add(canada);
        pane.getChildren().add(alaska);
        pane.getChildren().add(usa);
        pane.getChildren().add(mexico);
        pane.getChildren().add(guatemala);
        pane.getChildren().add(belize);
        pane.getChildren().add(elSalvedor);
        pane.getChildren().add(honduras);
        pane.getChildren().add(nicaragua);
        pane.getChildren().add(costaRica);
        pane.getChildren().add(panama);
        pane.getChildren().add(cuba);
        pane.getChildren().add(jamaica);
        pane.getChildren().add(haiti);
        pane.getChildren().add(dominican);
        pane.getChildren().add(puertoRico);

        Scene scene = new Scene(pane, 400, 700);
        primaryStage.setTitle("The American Continent: Suprematism"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /** The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     *
     * @param args main method
     */
    public static void main(String[] args) {
        launch(args);
    }

}
