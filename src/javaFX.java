import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class javaFX extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        Label lA = new Label("A");
        Label lB = new Label("B");
        Label lC = new Label("C");

        TextField valueA = new TextField();
        TextField valueB = new TextField();
        TextField valueC = new TextField();

        HBox layout1 = new HBox(10);
        layout1.getChildren().addAll(lA, valueA, lB, valueB, lC, valueC);

        Button btn = new Button("Посчитать");
        Label result = new Label("Результат");

        HBox layout2 = new HBox(30);
        layout2.getChildren().addAll(btn, result);

        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(20, 20, 20, 20));
        mainLayout.getChildren().addAll(layout1, layout2);

        btn.setOnMouseClicked(event -> {
            String a = valueA.getText();
            String b = valueB.getText();
            String c = valueC.getText();

            int resultA = Integer.parseInt(a);
            int resultB = Integer.parseInt(b);
            int resultC = Integer.parseInt(c);

            String string = Descr(resultA, resultB, resultC);
            result.setText(string);
        });


        Scene mainScene = new Scene(mainLayout, 500, 300);
        window.setScene(mainScene);
        window.setTitle("Решение квадратного уравнения");
        window.show();
    }


    Button createButton(String name) {
        return new Button(name);
    }

    public String Descr(int a, int b, int c) {
        double D = Math.pow(b, 2) - (4 * a * b);
        double d = Math.sqrt(D);

        double x1 = (-b + d) / (2 * a);
        double x2 = (-b - d) / (2 * a);

        if (D > 0) {
            return "x1 = " + x1 + " " + "x2 = " + x2;
        } else if (D < 0) {
            return "Нет корней";
        } else if (D == 0) {
            return "Корень - " + x1;
        }
        return " ";
    }
}

