import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;
import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;

public class JavaFXApp extends Application {

    Pane rootPane;
    TextField txtResult;
    TextField txtNumber1;
    TextField txtNumber2;

    private static final String PLUS = "+";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private int getNumberFromTextField (TextField textField) {
        return Integer.parseInt (textField.getText ());
    }

    protected int computeAdd (int number1, int number2) {
        return number1+number2;
    }

    protected int computeMultiply (int number1, int number2) {
        return 0;
    }

    protected int computeDivide (int number1, int number2) {
        return 0;
    }

    private void compute (String operator) {

        int result;
        int number1 = getNumberFromTextField (txtNumber1);
        int number2 = getNumberFromTextField (txtNumber2);

        switch (operator) {
            case PLUS:
                result = computeAdd (number1, number2);
                break;
            case MULTIPLY:
                result = computeMultiply (number1, number2);
                break;
            case DIVIDE:
                result = computeDivide (number1, number2);
                break;
            default:
                result = 0;
        }

        txtResult.setText (String.valueOf (result));
    }

    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent> () {
        @Override
        public void handle(MouseEvent mouseEvent) {
            compute (((Button) mouseEvent.getSource()).getText ());
        }
    };

    EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent> () {
        @Override
        public void handle (KeyEvent keyEvent) {
            compute(((Button) keyEvent.getSource ()).getText ());
        }
    };

    /*
     * Er wordt een label toegevoegd aan het scherm.
     */
    private void addLabel (String text, int width, int height, int x, int y) {
        Label label = new Label (text);
        label.setFocusTraversable (false);
        label.setPrefWidth (width);
        label.setPrefHeight (height);
        label.setLayoutX (x);
        label.setLayoutY (y);
        label.setFont (new Font ("System Bold", 18.0));
        rootPane.getChildren ().add (label);
    }

    /*
     * Er wordt een textfield toegevoegd aan het scherm.
     */
    private TextField addTextField (String prompt, boolean isFocusTraversable, int width, int x, int y) {

        TextField textField = new TextField ();
        textField.setPromptText (prompt);
        textField.setFocusTraversable (isFocusTraversable);
        textField.setPrefWidth (width);
        textField.setLayoutX (x);
        textField.setLayoutY (y);
        textField.setFont (new Font ("System Bold", 18.0));
        rootPane.getChildren ().add (textField);
        return textField;
    }

    /*
     * Er wordt een button toegevoegd aan het scherm en event handlers voor het verwerken van een mouse-klik of het
     * selecteren van een toets op het toetsenbord wordt gekoppeld aan deze button.
     */
    private void addButton (String label, int width, int x, int y) {
        Button button = new Button (label);
        button.setFocusTraversable (true);
        button.setPrefWidth (width);
        button.setLayoutX (x);
        button.setLayoutY (y);
        button.setFont (new Font ("System Bold", 18.0));
        button.addEventHandler (MOUSE_CLICKED, mouseHandler);
        button.addEventHandler (KEY_PRESSED, keyHandler);
        rootPane.getChildren ().add (button);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        rootPane = new Pane();
        rootPane.setMinSize (500,205);

        /*
         * Met de parameter isFocusTraversable wordt aangegeven of het element wel of niet in de tab-volgorde wordt
         * opgenomen (met andere woorden: als de gebruiker op tab klikt in een actief veld (bijv. een textfield), dan
         * is het veld wel of niet opgenomen in de volgorde van elementen die met tab kan worden bereikt.
         *
         * Hieronder worden 2 textfields (voor het invoeren van getallen), 3 buttons (voor bewerkingen op die getallen)
         * en 1 resultaatveld toegevoegd.
         */
        addLabel ("Getal1", 161, 71, 10, 0);
        txtNumber1 = addTextField ("Voer hier het eerste getal in...", true, 310, 181, 15);
        addLabel ("Getal 2", 161, 71, 10, 40);
        txtNumber2 = addTextField ("Voer hier het tweede getal in...", true, 310, 181, 55);
        addButton (PLUS, 160, 10, 105);
        addButton (MULTIPLY, 160, 170, 105);
        addButton (DIVIDE, 160, 330, 105);
        txtResult = addTextField ("Hier wordt het resultaat getoond...", false, 480, 10, 155);
        txtResult.setEditable (false);

        /*
         * De applicatie wordt opgestart.
         */
        Scene startScene = new Scene(rootPane);
        primaryStage.setScene(startScene);
        primaryStage.setTitle("OPT3 - Rekenmachine");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch (args);
    }
}