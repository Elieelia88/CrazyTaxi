package Clients;

import Controllers.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class Login extends Application {
    private final static Controller controller = new Controller();
    public static void main(String[] args) {
    /*

        Admin can:
            1- * add, remove, update drivers *
            2- * add, remove, update cars *
            3- * do Drivers inventory Ind/All *
            4- * do Cars inventory Ind/All *
            5- * sum/avg of costs of trips for cars Ind/All between two date or All Time *
            6- * sum/avg of costs of trips for drivers Ind/All between two date or All Time *
            7- * update all rates *

     */

        launch(args);
    }

    @Override
    public void start(Stage stage)  {


        Label lblUserId = new Label("ID: ");
        Label lblLoginInfo = new Label("failed to Login");
        lblLoginInfo.setVisible(false);
        TextField tfUserId = new TextField();

        Label lblUserPass = new Label("password: ");
        PasswordField tfUserPassword = new PasswordField();

        Button btnLogin = new Button("Login");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20,20,20,20));
        VBox vBox = new VBox(20);
        root.setCenter(vBox);
        vBox.getChildren().addAll(lblUserId,tfUserId,lblUserPass,tfUserPassword,btnLogin,lblLoginInfo);
        BorderPane.setAlignment(vBox, Pos.BOTTOM_CENTER);


        btnLogin.setOnAction(e->{
            try {
                int Id = Integer.parseInt(tfUserId.getText());
                if(Id == 0)
                {
                    new Admin().start(new Stage());
                    stage.close();
                }
                else
                {
                    Objects.Driver driver =  controller.getDriver(Id+"");
                    if(driver != null){
                        if(driver.getPassword().trim().equals(tfUserPassword.getText()))
                        {
                            setDriverId(Id);
                            new Drivers().start(new Stage());
                            stage.close();
                        }
                        else
                        {
                            lblLoginInfo.setText("wrong Password");
                            lblLoginInfo.setVisible(true);
                        }
                    }
                    else
                    {
                        lblLoginInfo.setVisible(true);
                    }
                }
            }
            catch (NumberFormatException | IOException ex)
            {
                lblLoginInfo.setVisible(true);
            }
        });

        Scene scene = new Scene(root,200,250);
        stage.setScene(scene);
        stage.show();

    }

    private void setDriverId(int Id) throws IOException {
        FileWriter fileWriter = new FileWriter("src/Clients/DriverId");
        fileWriter.write(Id+"");
        fileWriter.close();
    }
}
