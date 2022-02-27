package Clients;

import Controllers.Controller;
import Objects.Car;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


public class Admin extends Application {
    public static final Controller controller  = new Controller();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        AtomicInteger flag = new AtomicInteger();
        flag.set(1);

        Button btnHome = new Button(" Home",setImage("homeClicked"));
        btnHome.setStyle("-fx-background-color: #C9A368; -fx-text-fill: white;");

        Button btnInventory = new Button("Inventory",setImage("inventory"));
        btnInventory.setStyle("-fx-background-color: #C9A368;");


        Button btnAverage_Sum = new Button("Functions",setImage("calculation"));
        btnAverage_Sum.setStyle("-fx-background-color: #C9A368;");

        Button btnDriver = new Button(" Drivers",setImage("driver"));
        btnDriver.setStyle("-fx-background-color: #C9A368;");

        Button btnCar = new Button(" Car",setImage("car"));
        btnCar.setStyle("-fx-background-color: #C9A368;");


        HBox hBox = new HBox();
        VBox vBox = new VBox(40);

        vBox.getChildren().addAll(btnHome,btnInventory,btnDriver,btnCar,btnAverage_Sum);
        vBox.setStyle("-fx-background-color: #C9A368;");
        hBox.getChildren().add(vBox);
        VBox v = new VBox();
        hBox.getChildren().add(v);
        hBox.getChildren().set(1,getHome(primaryStage));

        btnHome.setOnAction(e->{
            if(flag.get() != 1)
            {
                try {

                    btnHome.setGraphic(setImage("homeClicked"));
                    btnHome.setStyle("-fx-background-color: #C9A368; -fx-text-fill: white;");

                    btnAverage_Sum.setGraphic(setImage("calculation"));
                    btnAverage_Sum.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");

                    btnDriver.setGraphic(setImage("driver"));
                    btnDriver.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");

                    btnCar.setGraphic(setImage("car"));
                    btnCar.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");

                    btnInventory.setGraphic(setImage("inventory"));
                    btnInventory.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");


                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                hBox.getChildren().set(1,getHome(primaryStage));
                flag.set(1);
            }
        });

        btnInventory.setOnAction(e->{
            if(flag.get() != 2)
            {
                try {

                    btnHome.setGraphic(setImage("home"));
                    btnHome.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");

                    btnAverage_Sum.setGraphic(setImage("calculation"));
                    btnAverage_Sum.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");

                    btnDriver.setGraphic(setImage("driver"));
                    btnDriver.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");

                    btnCar.setGraphic(setImage("car"));
                    btnCar.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");

                    btnInventory.setGraphic(setImage("inventoryClicked"));
                    btnInventory.setStyle("-fx-background-color: #C9A368; -fx-text-fill: white;");

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                hBox.getChildren().set(1,getInventory());
                flag.set(2);
            }
        });

        btnDriver.setOnAction(e->{
            if(flag.get() != 3)
            {
                try {
                    btnHome.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                    btnAverage_Sum.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                    btnDriver.setStyle("-fx-background-color: #C9A368; -fx-text-fill: white;");
                    btnCar.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                    btnInventory.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");

                    btnHome.setGraphic(setImage("home"));
                    btnAverage_Sum.setGraphic(setImage("calculation"));
                    btnDriver.setGraphic(setImage("driverClicked"));
                    btnCar.setGraphic(setImage("car"));
                    btnInventory.setGraphic(setImage("inventory"));

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                hBox.getChildren().set(1,getDrivers());
                flag.set(3);

            }
        });

        btnCar.setOnAction(e->{
            if(flag.get() != 4)
            {
                try {

                    btnHome.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                    btnAverage_Sum.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                    btnDriver.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                    btnCar.setStyle("-fx-background-color: #C9A368; -fx-text-fill: white;");
                    btnInventory.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");

                    btnHome.setGraphic(setImage("home"));
                    btnAverage_Sum.setGraphic(setImage("calculation"));
                    btnDriver.setGraphic(setImage("driver"));
                    btnCar.setGraphic(setImage("carClicked"));
                    btnInventory.setGraphic(setImage("inventory"));

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                hBox.getChildren().set(1,getCars());
                flag.set(4);
            }
        });

        btnAverage_Sum.setOnAction(e->{
            if(flag.get() != 5)
            {
                try {

                    btnHome.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                    btnAverage_Sum.setStyle("-fx-background-color: #C9A368; -fx-text-fill: white;");
                    btnDriver.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                    btnCar.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                    btnInventory.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");

                    btnHome.setGraphic(setImage("home"));
                    btnAverage_Sum.setGraphic(setImage("calculationClicked"));
                    btnDriver.setGraphic(setImage("driver"));
                    btnCar.setGraphic(setImage("car"));
                    btnInventory.setGraphic(setImage("inventory"));

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                hBox.getChildren().set(1,getCalculation());
                flag.set(5);
            }
        });


        Scene scene = new Scene(hBox,1250,480);
        primaryStage.setTitle("Crazy Taxi");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private VBox getHome(Stage s) {
        VBox vBox = new VBox(10);

        HBox hBox = new HBox(5);
        hBox.setPadding(new Insets(5));


        // drivers table
        VBox vBoxDrivers = new VBox(5);
        vBoxDrivers.setPadding(new Insets(5));

        var tblDrivers = controller.getAllDrivers();
        int nbOfDrivers = tblDrivers.getItems().size();
        Label lblNbOfDrivers = new Label("Number Of drivers: "+nbOfDrivers);

        vBoxDrivers.getChildren().addAll(lblNbOfDrivers,tblDrivers);


        // car table
        VBox vBoxCars = new VBox(5);
        vBoxCars.setPadding(new Insets(5));

        var tblCars = controller.getAllCars();
        int nbOfCars = tblCars.getItems().size();
        Label lblNbOfCars = new Label("Number Of Cars: "+nbOfCars);

        vBoxCars.getChildren().addAll(lblNbOfCars,tblCars);


        // number of trips
        HBox hBoxTrips = new HBox(5);
        hBoxTrips.setPadding(new Insets(5));


        Label lblNbOfTrips = new Label("number of Trips: " + controller.inventories("drivers", LocalDateTime.of(2000,1,1,0,0, 0),LocalDateTime.of(3000,1,1,0,0, 0)).getItems().size());

        Label lblChangePassword = new Label("Change Password: ");
        lblChangePassword.setFont(new Font(16));
        Label lblChangePasswordInfo = new Label();
        PasswordField pfPassword = new PasswordField();

        Button btnChangePassWord = new Button("Change");
        Button btnLogout = new Button("Logout");

        btnLogout.setOnAction(e->{
            new Login().start(new Stage());
            s.close();
        });

        hBoxTrips.getChildren().addAll(lblNbOfTrips,new Label("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"),lblChangePassword,pfPassword,lblChangePasswordInfo,btnChangePassWord,btnLogout);


        hBox.getChildren().addAll(vBoxDrivers,vBoxCars);
        // to be edited when adding passwords

        btnChangePassWord.setOnAction(e->{
            if(pfPassword.getText().isBlank())
                lblChangePasswordInfo.setText("empty password");
            else
                lblChangePasswordInfo.setText("password changed");
        });

        vBox.getChildren().addAll(hBox,hBoxTrips);
        return vBox;
    }

    private VBox getDrivers()
    {
        VBox vBox = new VBox(9.5);
        HBox hBox = new HBox();

        var tableView = controller.getAllDrivers();
        HBox.setHgrow(tableView, Priority.ALWAYS);



        // update driver Layout
        Label lblMessageUp = new Label("Update Driver");
        lblMessageUp.setFont(new Font(15));
        lblMessageUp.setPadding(new Insets(10));

        VBox vbUpdateD = new VBox(5);
        vbUpdateD.setPadding(new Insets(10));
        Label lblUpdate = new Label("enter Driver Id: ");
        Label lblUpdateInfo = new Label();
        lblUpdateInfo.setVisible(false);

        TextField tfIdUpdate = new TextField();

        Button btnSearchUpdate = new Button("get Driver");
        Label lblNameUpdate = new Label("Name: ");
        TextField tfNameUpdate = new TextField();

        Label lblBDUpdate = new Label("BirthDate: ");
        DatePicker dpBDUpdate = new DatePicker();
        dpBDUpdate.setValue(LocalDate.now());
        dpBDUpdate.getEditor().setDisable(true);
        dpBDUpdate.getEditor().setOpacity(12);
        Label lblPhoneUpdate = new Label("Phone: ");
        TextField tfPhoneUpdate = new TextField();

        Label lblAddressUpdate = new Label("Address: ");
        TextField tfAddressUpdate = new TextField();


        Label lblInfoSearchUpdate = new Label();
        lblInfoSearchUpdate.setVisible(false);

        Label lblRateUpdate = new Label("Rate: ");
        TextField tfRateUpdate = new TextField();

        Button btnUpdate = new Button("Update Driver");

        lblNameUpdate.setVisible(false);
        tfNameUpdate.setVisible(false);
        lblBDUpdate.setVisible(false);
        dpBDUpdate.setVisible(false);
        lblPhoneUpdate.setVisible(false);
        tfPhoneUpdate.setVisible(false);
        lblAddressUpdate.setVisible(false);
        tfAddressUpdate.setVisible(false);
        btnUpdate.setVisible(false);
        tfRateUpdate.setVisible(false);
        lblRateUpdate.setVisible(false);
        lblInfoSearchUpdate.setVisible(false);
        lblUpdateInfo.setVisible(false);

        vbUpdateD.getChildren().addAll(lblMessageUp,lblUpdate,tfIdUpdate,btnSearchUpdate,lblInfoSearchUpdate,
                lblNameUpdate,tfNameUpdate,lblBDUpdate,dpBDUpdate,lblPhoneUpdate,tfPhoneUpdate,
                lblAddressUpdate,tfAddressUpdate,lblRateUpdate,tfRateUpdate,btnUpdate,lblUpdateInfo);





        //delete driver Layout
        Label lblMessageDlt = new Label("Delete Driver");
        lblMessageDlt.setPadding(new Insets(10));
        lblMessageDlt.setFont(new Font(15));

        TextField tfDelete = new TextField();
        Label lblDeleteInfo = new Label();
        lblDeleteInfo.setVisible(false);
        VBox vbDeleteD = new VBox(10);
        vbDeleteD.setPadding(new Insets(10));
        Label lblDelete = new Label("enter Driver Id: ");
        Button btnDelete = new Button("Delete Driver");
        vbDeleteD.getChildren().addAll(lblMessageDlt,lblDelete,tfDelete,btnDelete,lblDeleteInfo);


        //Add driver Layout
        Label lblMessageAdd = new Label("Add Driver");
        lblMessageAdd.setPadding(new Insets(10));
        lblMessageAdd.setFont(new Font(15));

        VBox vbAddD = new VBox(10);
        vbAddD.setPadding(new Insets(10));
        Label lblName = new Label("Name: ");
        TextField tfName = new TextField();

        Label lblBD = new Label("BirthDate: ");
        DatePicker dpBD = new DatePicker();
        dpBD.setValue(LocalDate.now());
        dpBD.getEditor().setDisable(true);
        dpBD.getEditor().setOpacity(12);


        Label lblPhone = new Label("Phone: ");
        TextField tfPhone = new TextField();

        Label lblAddress = new Label("Address: ");
        TextField tfAddress = new TextField();

        Label lblInfo = new Label();
        lblInfo.setVisible(false);

        Button btnAdd = new Button("Add Driver");

        vbAddD.getChildren().addAll(lblMessageAdd,lblName,tfName,lblBD,dpBD,lblPhone,tfPhone,lblAddress,tfAddress,btnAdd,lblInfo);


        hBox.getChildren().addAll(vbAddD,vbDeleteD,vbUpdateD,tableView);
        vBox.getChildren().addAll(hBox);


        //***********************************************************



        btnAdd.setOnAction(e->{
            // empty to delete
            tfDelete.setText("");
            lblDeleteInfo.setVisible(false);

            //empty to update
            tfIdUpdate.setText("");
            lblNameUpdate.setVisible(false);
            tfNameUpdate.setVisible(false);
            lblBDUpdate.setVisible(false);
            dpBDUpdate.setVisible(false);
            lblPhoneUpdate.setVisible(false);
            tfPhoneUpdate.setVisible(false);
            lblAddressUpdate.setVisible(false);
            tfAddressUpdate.setVisible(false);
            btnUpdate.setVisible(false);
            tfRateUpdate.setVisible(false);
            lblRateUpdate.setVisible(false);
            lblUpdateInfo.setVisible(false);
            lblInfoSearchUpdate.setVisible(false);

            if(tfName.getText().isBlank() || tfAddress.getText().isBlank())
            {
                lblInfo.setText("Invalid Input");
                lblInfo.setVisible(true);
            }
            else
            {

                try {
                    int Phone = Integer.parseInt(tfPhone.getText());

                    Objects.Driver driver = (Objects.Driver) controller.Add(new String[]{"'"+tfName.getText()+"'",
                            "'"+DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(dpBD.getValue().atStartOfDay())+"'",
                            "'"+ Phone +"'",
                            "'"+tfAddress.getText()+"'"},"drivers");
                    if(driver != null)
                    {
                        hBox.getChildren().set(3,controller.getAllDrivers());
                        lblInfo.setText("Driver Added");
                    }
                    else
                        lblInfo.setText("new driver Birthdate error\n(underage)");

                    lblInfo.setVisible(true);


                }
                catch (NumberFormatException ex)
                {
                    lblInfo.setText("Invalid Input");
                    lblInfo.setVisible(true);
//                ex.printStackTrace();
                }
            }
        });





//************************************************************

        btnSearchUpdate.setOnAction(e->{
            //empty to insert
            tfName.setText("");
            tfAddress.setText("");
            tfPhone.setText("");
            lblInfo.setVisible(false);

            // empty to delete
            tfDelete.setText("");
            lblDeleteInfo.setVisible(false);

            try {
                int id = Integer.parseInt(tfIdUpdate.getText());
                Objects.Driver driver = controller.getDriver(id+"");
                if(driver != null){

                    lblNameUpdate.setVisible(true);
                    tfNameUpdate.setVisible(true);
                    tfNameUpdate.setText(driver.getDriverName().trim());

                    lblBDUpdate.setVisible(true);
                    dpBDUpdate.setVisible(true);

                    Date bd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(driver.getBirthDate());
                    LocalDate bdDate = bd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    dpBDUpdate.setValue(bdDate);


                    lblPhoneUpdate.setVisible(true);
                    tfPhoneUpdate.setVisible(true);
                    tfPhoneUpdate.setText(driver.getPhone().trim());

                    lblAddressUpdate.setVisible(true);
                    tfAddressUpdate.setVisible(true);
                    tfAddressUpdate.setText(driver.getAddress().trim());

                    tfRateUpdate.setVisible(true);
                    lblRateUpdate.setVisible(true);
                    tfRateUpdate.setText(driver.getRate().trim());

                    btnUpdate.setVisible(true);
                }
                else
                {
                    lblInfoSearchUpdate.setText("Cannot find Driver");
                    lblInfoSearchUpdate.setVisible(true);
                }
            }
            catch (NumberFormatException ex){
                lblInfoSearchUpdate.setText("Invalid input");
                lblInfoSearchUpdate.setVisible(true);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        });

        btnUpdate.setOnAction(e->{
            //empty to insert
            tfName.setText("");
            tfAddress.setText("");
            tfPhone.setText("");

            // empty to delete
            tfDelete.setText("");
            lblDeleteInfo.setVisible(false);


            if(tfNameUpdate.getText().isBlank() || tfAddressUpdate.getText().isBlank())
            {
                lblUpdateInfo.setText("Invalid Input");
                lblUpdateInfo.setVisible(true);
            }
            else
            {
                try {
                    int Phone = Integer.parseInt(tfPhoneUpdate.getText());
                    int Rate = Integer.parseInt(tfRateUpdate.getText());

                    Objects.Driver driver = (Objects.Driver) controller.Update(new String[]{"'"+tfNameUpdate.getText()+"'",
                                    "'"+DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(dpBDUpdate.getValue().atStartOfDay())+"'",
                                    "'"+Phone+"'",
                                    "'"+tfAddressUpdate.getText()+"'",
                                    "'"+Rate+"'"},
                            new String[]{"dname","dbirthdate","phone","address","rate"},tfIdUpdate.getText(),"drivers");

                    if(driver != null) {
                        hBox.getChildren().set(3,controller.getAllDrivers());
                        lblUpdateInfo.setText("Driver Updated");
                    }
                    else {
                        lblUpdateInfo.setText("update birthdate error\n(underage) ");
                    }

                    lblUpdateInfo.setVisible(true);
                }
                catch (NumberFormatException ex)
                {
                    lblUpdateInfo.setText("Invalid Input");
                    lblUpdateInfo.setVisible(true);
//                ex.printStackTrace();
                }
            }
        });


//      *************************************************************

        btnDelete.setOnAction(e->{

            //empty to update
            tfIdUpdate.setText("");
            lblNameUpdate.setVisible(false);
            tfNameUpdate.setVisible(false);
            lblBDUpdate.setVisible(false);
            dpBDUpdate.setVisible(false);
            lblPhoneUpdate.setVisible(false);
            tfPhoneUpdate.setVisible(false);
            lblAddressUpdate.setVisible(false);
            tfAddressUpdate.setVisible(false);
            btnUpdate.setVisible(false);
            tfRateUpdate.setVisible(false);
            lblRateUpdate.setVisible(false);
            lblUpdateInfo.setVisible(false);
            lblInfoSearchUpdate.setVisible(false);

            //empty to insert
            tfName.setText("");
            tfAddress.setText("");
            tfPhone.setText("");
            lblInfo.setVisible(false);

            try {
                int id = Integer.parseInt(tfDelete.getText());
                Objects.Driver driver = (Objects.Driver) controller.Remove(tfDelete.getText(),"drivers");

                if(driver != null)
                {
                    lblDeleteInfo.setText("Driver "+id+" is deleted");
                    hBox.getChildren().set(3,controller.getAllDrivers());
                }
                else
                    lblDeleteInfo.setText("driver not found");

                lblDeleteInfo.setVisible(true);
                lblDeleteInfo.setVisible(true);

            }
            catch (NumberFormatException ex){
                lblDeleteInfo.setText("Invalid input");
                lblDeleteInfo.setVisible(true);
            }
        });

        return vBox;
    }

    private VBox getCars()
    {
        VBox vBox = new VBox(10);
        HBox hBox = new HBox();

        // Add Car Layout
        VBox vBoxAddCarrLayout = new VBox(10);
        vBoxAddCarrLayout.setPadding(new Insets(10));

        Label lblTitleAdd = new Label("Add Car");
        lblTitleAdd.setFont(new Font(15));
        lblTitleAdd.setPadding(new Insets(10));

        Label lblCarPlateNumber = new Label("Plate Number: ");
        TextField tfCarPlateNumber = new TextField();

        Label lblCarColor = new Label("Color: ");
        TextField tfCarColor = new TextField();

        Label lblCarModelName = new Label("Model Name: ");
        TextField tfCarModelName = new TextField();

        Label lblCarModelYear = new Label("Model Year: ");
        TextField tfCarModelYear = new TextField();

        Label lblCarAssuranceDate = new Label("Assurance: ");
        DatePicker dpCarAssuranceDate = new DatePicker();
        dpCarAssuranceDate.setValue(LocalDate.now());
        dpCarAssuranceDate.getEditor().setDisable(true);
        dpCarAssuranceDate.getEditor().setOpacity(12);

        Button btnAddCar = new Button("Add Car");

        Label lblResultAddCarInfo = new Label();
        lblResultAddCarInfo.setVisible(false);

        vBoxAddCarrLayout.getChildren().addAll(lblTitleAdd,lblCarPlateNumber,tfCarPlateNumber,
                lblCarColor,tfCarColor,
                lblCarModelName,tfCarModelName,
                lblCarModelYear,tfCarModelYear,
                lblCarAssuranceDate,dpCarAssuranceDate,btnAddCar,lblResultAddCarInfo);


        // Car Delete Layout

        VBox vBoxCarDelete = new VBox(10);
        vBoxCarDelete.setPadding(new Insets(10));

        Label lblTitleDelete = new Label("Delete Car");
        lblTitleDelete.setFont(new Font(15));
        lblTitleDelete.setPadding(new Insets(10));

        Label lblCarIdDelete = new Label("Enter Car Id: ");
        TextField tfCarIdDelete = new TextField();

        Button btnDeleteCar = new Button("Delete Car");

        Label lblResultDeleteCarInfo = new Label();
        lblResultDeleteCarInfo.setVisible(false);

        vBoxCarDelete.getChildren().addAll(lblTitleDelete,lblCarIdDelete,tfCarIdDelete,btnDeleteCar,lblResultDeleteCarInfo);



        //Car Update Layout

        VBox vBoxCarUpdate = new VBox(4.5);
        vBoxCarUpdate.setPadding(new Insets(10));

        Label lblTitleUpdate = new Label("Update Car");
        lblTitleUpdate.setFont(new Font(15));
        lblTitleUpdate.setPadding(new Insets(10));

        Label lblCarIdUpdate = new Label("Enter Car Id: ");
        TextField tfCarIdUpdate = new TextField();

        Button btnSearchUpdateCar = new Button("get Car");

        Label lblResultSearchUpdateCarInfo = new Label();
        lblResultSearchUpdateCarInfo.setVisible(false);

        Label lblCarPlateNumberUpdate = new Label("Plate Number: ");
        TextField tfCarPlateNumberUpdate = new TextField();

        Label lblCarColorUpdate = new Label("Color: ");
        TextField tfCarColorUpdate = new TextField();

        Label lblCarModelNameUpdate = new Label("Model Name: ");
        TextField tfCarModelNameUpdate = new TextField();

        Label lblCarModelYearUpdate = new Label("Model Year: ");
        TextField tfCarModelYearUpdate = new TextField();

        Label lblCarAssuranceDateUpdate = new Label("Assurance: ");
        DatePicker dpCarAssuranceDateUpdate = new DatePicker();
        dpCarAssuranceDateUpdate.setValue(LocalDate.now());
        dpCarAssuranceDateUpdate.getEditor().setDisable(true);
        dpCarAssuranceDateUpdate.getEditor().setOpacity(12);

        Button btnUpdateCar = new Button("Update Car");
        Label lblResultAddCarInfoUpdate = new Label();
        lblResultAddCarInfoUpdate.setVisible(false);

        vBoxCarUpdate.getChildren().addAll(lblTitleUpdate,lblCarIdUpdate,tfCarIdUpdate,btnSearchUpdateCar,lblResultSearchUpdateCarInfo,lblCarPlateNumberUpdate,tfCarPlateNumberUpdate,
                lblCarColorUpdate,tfCarColorUpdate,
                lblCarModelNameUpdate,tfCarModelNameUpdate,
                lblCarModelYearUpdate,tfCarModelYearUpdate,
                lblCarAssuranceDateUpdate,dpCarAssuranceDateUpdate,btnUpdateCar,lblResultAddCarInfoUpdate);

        lblCarPlateNumberUpdate.setVisible(false);
        tfCarPlateNumberUpdate.setVisible(false);
        lblCarColorUpdate.setVisible(false);
        tfCarColorUpdate.setVisible(false);
        lblCarModelNameUpdate.setVisible(false);
        tfCarModelNameUpdate.setVisible(false);
        lblCarModelYearUpdate.setVisible(false);
        tfCarModelYearUpdate.setVisible(false);
        lblCarAssuranceDateUpdate.setVisible(false);
        dpCarAssuranceDateUpdate.setVisible(false);
        lblResultAddCarInfoUpdate.setVisible(false);
        btnUpdateCar.setVisible(false);


        //Table All Car
        var tblAllCar = controller.getAllCars();


        // general Layout
        hBox.getChildren().addAll(vBoxAddCarrLayout,vBoxCarDelete,vBoxCarUpdate,tblAllCar);
        vBox.getChildren().add(hBox);


        // add a Driver Button Function
        btnAddCar.setOnAction(e->
        {
            // empty delete
            tfCarIdDelete.setText("");
            lblResultDeleteCarInfo.setVisible(false);

            // empty Update
            tfCarIdUpdate.setText("");
            lblResultSearchUpdateCarInfo.setVisible(false);
            lblCarPlateNumberUpdate.setVisible(false);
            tfCarPlateNumberUpdate.setVisible(false);
            lblCarColorUpdate.setVisible(false);
            tfCarColorUpdate.setVisible(false);
            lblCarModelNameUpdate.setVisible(false);
            tfCarModelNameUpdate.setVisible(false);
            lblCarModelYearUpdate.setVisible(false);
            tfCarModelYearUpdate.setVisible(false);
            lblCarAssuranceDateUpdate.setVisible(false);
            dpCarAssuranceDateUpdate.setVisible(false);
            lblResultAddCarInfoUpdate.setVisible(false);
            btnUpdateCar.setVisible(false);

            // check if a field is empty or car date assurance before now
            if(tfCarPlateNumber.getText().isBlank() || tfCarColor.getText().isBlank() || tfCarModelYear.getText().isBlank() ||
                    tfCarModelName.getText().isBlank() || dpCarAssuranceDate.getValue().isBefore(LocalDate.now()))
            {
                lblResultAddCarInfo.setVisible(true);
                lblResultAddCarInfo.setText("Invalid Input");
            }
            else
            {
                try {
                    int year = Integer.parseInt(tfCarModelYear.getText());

                    Car car = (Car) controller.Add(new String[]{"'"+tfCarPlateNumber.getText()+"'",
                                    "'"+tfCarColor.getText()+"'",
                                    "'"+tfCarModelName.getText()+"'",
                                    "'"+year+"'",
                                    "'"+DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(dpCarAssuranceDate.getValue().atStartOfDay())+"'"},
                            "cars");

                    if(car != null)
                    {
                        hBox.getChildren().set(3,controller.getAllCars());
                        lblResultAddCarInfo.setText("Car Added");
                    }
                    else
                        lblResultAddCarInfo.setText("Car ModelYear error\n(old)");

                    lblResultAddCarInfo.setVisible(true);
                }
                catch (NumberFormatException ex)
                {
                    lblResultAddCarInfo.setVisible(true);
                    lblResultAddCarInfo.setText("Model year error");
                }
            }
        });


        // Delete Car Button Function
        btnDeleteCar.setOnAction(e->{
            // empty add
            tfCarPlateNumber.setText("");
            tfCarColor.setText("");
            tfCarModelName.setText("");
            tfCarModelYear.setText("");
            dpCarAssuranceDate.setValue(LocalDate.now());
            lblResultAddCarInfo.setVisible(false);

            // empty Update
            tfCarIdUpdate.setText("");
            lblResultSearchUpdateCarInfo.setVisible(false);
            lblCarPlateNumberUpdate.setVisible(false);
            tfCarPlateNumberUpdate.setVisible(false);
            lblCarColorUpdate.setVisible(false);
            tfCarColorUpdate.setVisible(false);
            lblCarModelNameUpdate.setVisible(false);
            tfCarModelNameUpdate.setVisible(false);
            lblCarModelYearUpdate.setVisible(false);
            tfCarModelYearUpdate.setVisible(false);
            lblCarAssuranceDateUpdate.setVisible(false);
            dpCarAssuranceDateUpdate.setVisible(false);
            lblResultAddCarInfoUpdate.setVisible(false);
            btnUpdateCar.setVisible(false);

            try {
                int id = Integer.parseInt(tfCarIdDelete.getText());
                Car car = controller.getCar(tfCarIdDelete.getText());

                if(car != null)
                {
                    controller.Remove(tfCarIdDelete.getText(),"cars");
                    hBox.getChildren().set(3,controller.getAllCars());
                    lblResultDeleteCarInfo.setText("Car "+id+" is deleted");
                }
                else
                    lblResultDeleteCarInfo.setText("Cannot find Car");

                lblResultDeleteCarInfo.setVisible(true);
            }
            catch (NumberFormatException ex)
            {
                lblResultDeleteCarInfo.setVisible(true);
                lblResultDeleteCarInfo.setText("Invalid Input");
            }
        });


        //Button Update Car
        // Search Car

        btnSearchUpdateCar.setOnAction(e->{
            // empty add
            tfCarPlateNumber.setText("");
            tfCarColor.setText("");
            tfCarModelName.setText("");
            tfCarModelYear.setText("");
            dpCarAssuranceDate.setValue(LocalDate.now());
            lblResultAddCarInfo.setVisible(false);

            // empty delete
            tfCarIdDelete.setText("");
            lblResultDeleteCarInfo.setVisible(false);

            try {
                int id = Integer.parseInt(tfCarIdUpdate.getText());
                Car car = controller.getCar(id+"");

                if(car != null)
                {

                    btnUpdateCar.setVisible(true);

                    lblCarPlateNumberUpdate.setVisible(true);
                    tfCarPlateNumberUpdate.setVisible(true);
                    tfCarPlateNumberUpdate.setText(car.getCplatenumber().trim());


                    lblCarColorUpdate.setVisible(true);
                    tfCarColorUpdate.setVisible(true);
                    tfCarColorUpdate.setText(car.getColor().trim());

                    lblCarModelNameUpdate.setVisible(true);
                    tfCarModelNameUpdate.setVisible(true);
                    tfCarModelNameUpdate.setText(car.getCmodelname().trim());

                    lblCarModelYearUpdate.setVisible(true);
                    tfCarModelYearUpdate.setVisible(true);
                    tfCarModelYearUpdate.setText(car.getCmodelyear().trim());

                    lblCarAssuranceDateUpdate.setVisible(true);
                    dpCarAssuranceDateUpdate.setVisible(true);
                    Date bd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(car.getCassurance());
                    LocalDate bdDate = bd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    dpCarAssuranceDateUpdate.setValue(bdDate);


                }
                else {
                    lblResultSearchUpdateCarInfo.setText("Cannot find Car");
                    lblResultSearchUpdateCarInfo.setVisible(true);
                }

            }
            catch (NumberFormatException | ParseException ex)
            {
                lblResultSearchUpdateCarInfo.setVisible(true);
                lblResultSearchUpdateCarInfo.setText("Invalid Input");
            }

        });

        // update car found
        btnUpdateCar.setOnAction(e->
        {
            if(tfCarPlateNumberUpdate.getText().isBlank() || tfCarColorUpdate.getText().isBlank() || tfCarModelYearUpdate.getText().isBlank() ||
                    tfCarModelNameUpdate.getText().isBlank() || dpCarAssuranceDateUpdate.getValue().isBefore(LocalDate.now()))
            {
                lblResultAddCarInfoUpdate.setVisible(true);
                lblResultAddCarInfoUpdate.setText("Invalid Input");
            }
            else
            {
                try {
                    int year = Integer.parseInt(tfCarModelYearUpdate.getText());

                    Car car = (Car) controller.Update(new String[]{"'"+tfCarPlateNumberUpdate.getText()+"'",
                                    "'"+tfCarColorUpdate.getText()+"'",
                                    "'"+tfCarModelNameUpdate.getText()+"'",
                                    "'"+year+"'",
                                    "'"+DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(dpCarAssuranceDateUpdate.getValue().atStartOfDay())+"'"},
                            new String[]{"cplatenumber","ccolor","cmodelname","cmodelyear","cassurance"},tfCarIdUpdate.getText(),"cars");

                    if(car != null)
                    {
                        hBox.getChildren().set(3,controller.getAllCars());
                        lblResultAddCarInfoUpdate.setText("Car Updated");
                    }
                    else
                        lblResultAddCarInfoUpdate.setText("Car ModelYear error\n(old)");

                    lblResultAddCarInfoUpdate.setVisible(true);
                }
                catch (NumberFormatException ex)
                {
                    ex.printStackTrace();
                    lblResultAddCarInfoUpdate.setVisible(true);
                    lblResultAddCarInfoUpdate.setText("Model year error");
                }
            }
        });

        return vBox;
    }

    public VBox getInventory()
    {

        Label lblName = new Label("please enter an id:\n(Empty input for all data)");
        lblName.setFont(new Font(11));
        lblName.setPadding(new Insets(0,5,5,5));

        Label lblFrom = new Label("from:");
        Label lblTo = new Label("to:");
        lblFrom.setPadding(new Insets(5,5,5,5));
        lblTo.setPadding(new Insets(5,5,5,5));

        TextField tfId = new TextField();


        Button btnSearch = new Button("Search Inventory");

        RadioButton cars = new RadioButton("cars");
        RadioButton drivers = new RadioButton("drivers");
        drivers.setSelected(true);

        cars.setPadding(new Insets(5));
        drivers.setPadding(new Insets(5));

        ToggleGroup InventoryCat = new ToggleGroup();

        cars.setToggleGroup(InventoryCat);
        drivers.setToggleGroup(InventoryCat);

        DatePicker from = new DatePicker();
        DatePicker to = new DatePicker();

        from.getEditor().setDisable(true);
        from.getEditor().setOpacity(12);

        to.getEditor().setDisable(true);
        to.getEditor().setOpacity(12);

        from.setValue(LocalDate.now());
        to.setValue(LocalDate.now());

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(5));
        hBox.getChildren().addAll(lblName,tfId,btnSearch,cars,drivers,lblFrom,from,lblTo,to);

        VBox vBox = new VBox(10);
        vBox.getChildren().add(hBox);



        btnSearch.setOnAction(e->{
            try {
                int id = Integer.parseInt(tfId.getText());
                String category;

                LocalDate fromDate = from.getValue();
                LocalDate toDate = to.getValue();

                if(cars.isSelected())
                    category = "cars";
                else
                    category = "drivers";

                var tableView = controller.inventoriesInd(id,category, fromDate.atStartOfDay(),toDate.atStartOfDay());


                if(vBox.getChildren().size() == 1)
                    vBox.getChildren().add(tableView);
                else
                    vBox.getChildren().set(1,tableView);

            }
            catch (NumberFormatException ex)
            {
                String category;

                LocalDate fromDate = from.getValue();
                LocalDate toDate = to.getValue();

                if(cars.isSelected())
                    category = "cars";
                else
                    category = "drivers";

                var tableView = controller.inventories(category, fromDate.atStartOfDay(),toDate.atStartOfDay());


                if(vBox.getChildren().size() == 1)
                    vBox.getChildren().add(tableView);
                else
                    vBox.getChildren().set(1,tableView);
            }
        });

        return vBox;
    }

    public VBox getCalculation()
    {

        Label lblName = new Label("please enter an id:\n(Empty input for all data)");
        lblName.setFont(new Font(11));
        lblName.setPadding(new Insets(0,5,5,5));

        Label lblFrom = new Label("from:");
        Label lblTo = new Label("to:");
        lblFrom.setPadding(new Insets(5,5,5,5));
        lblTo.setPadding(new Insets(5,5,5,5));

        TextField tfId = new TextField();


        Button btnSearch = new Button("Search Calculation");

        RadioButton cars = new RadioButton("cars");
        RadioButton drivers = new RadioButton("drivers");
        drivers.setSelected(true);

        cars.setPadding(new Insets(5));
        drivers.setPadding(new Insets(5));

        ToggleGroup InventoryCat = new ToggleGroup();

        cars.setToggleGroup(InventoryCat);
        drivers.setToggleGroup(InventoryCat);

        CheckBox AllTime = new CheckBox("All time Operation (turned it off to see between two dates)");
        AllTime.setPadding(new Insets(5));
        AllTime.setSelected(true);
        AllTime.setVisible(false);
        RadioButton Average = new RadioButton("Average");
        RadioButton Sum = new RadioButton("Sum");
        Average.setSelected(true);

        Average.setPadding(new Insets(5));
        Sum.setPadding(new Insets(5));

        ToggleGroup Functions = new ToggleGroup();

        Average.setToggleGroup(Functions);
        Sum.setToggleGroup(Functions);

        DatePicker from = new DatePicker();
        DatePicker to = new DatePicker();

        from.getEditor().setDisable(true);
        from.getEditor().setOpacity(12);

        to.getEditor().setDisable(true);
        to.getEditor().setOpacity(12);

        from.setValue(LocalDate.now());
        to.setValue(LocalDate.now());

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(5));
        hBox.getChildren().addAll(lblName,tfId,btnSearch,cars,drivers,lblFrom,from,lblTo,to);

        HBox hBoxC = new HBox();
        hBoxC.setPadding(new Insets(5));
        hBoxC.getChildren().addAll(Average,Sum,AllTime);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(0,0,0,10));
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(hBoxC);



        btnSearch.setOnAction(e->{
            try {
                AllTime.setVisible(false);
                int id = Integer.parseInt(tfId.getText());
                String category;

                LocalDate fromDate = from.getValue();
                LocalDate toDate = to.getValue();
                TableView tableView;

                if(Average.isSelected())
                {
                    if(cars.isSelected())
                        category = "cars";
                    else
                        category = "drivers";

                    tableView = controller.AverageBetweenTwoDate(category,id, fromDate.atStartOfDay(),toDate.atStartOfDay());
                }
                else
                {
                    if(cars.isSelected())
                        category = "cars";
                    else
                        category = "drivers";

                    tableView = controller.SumBetweenTwoDate(category,id, fromDate.atStartOfDay(),toDate.atStartOfDay());
                }
//
//
                if(vBox.getChildren().size() == 2)
                    vBox.getChildren().add(tableView);
                else
                    vBox.getChildren().set(2,tableView);

            }
            catch (NumberFormatException ex)
            {
                AllTime.setVisible(true);
                String category;
                TableView tableView;

                LocalDate fromDate = from.getValue();
                LocalDate toDate = to.getValue();

                if(AllTime.isSelected())
                {
                    if (Average.isSelected()) {
                        if (cars.isSelected())
                            category = "cars";
                        else
                            category = "drivers";

                        tableView = controller.AveragesBetweenTwoDateAllTime(category);
                    } else {
                        if (cars.isSelected())
                            category = "cars";
                        else
                            category = "drivers";

                        tableView = controller.SumsBetweenTwoDateAllTime(category);
                    }
                }
                else {

                    if (Average.isSelected()) {
                        if (cars.isSelected())
                            category = "cars";
                        else
                            category = "drivers";

                        tableView = controller.AveragesBetweenTwoDateAll(category, fromDate.atStartOfDay(), toDate.atStartOfDay());
                    } else {
                        if (cars.isSelected())
                            category = "cars";
                        else
                            category = "drivers";

                        tableView = controller.SumsBetweenTwoDateAll(category, fromDate.atStartOfDay(), toDate.atStartOfDay());
                    }
                }
//
//
                if(vBox.getChildren().size() == 2)
                    vBox.getChildren().add(tableView);
                else
                    vBox.getChildren().set(2,tableView);
            }
        });

        return vBox;
    }

    public ImageView setImage(String name) throws FileNotFoundException
    {
        FileInputStream input = new FileInputStream("src/Images/"+name+".png");
        Image image = new Image(input,50,50,true,true);
        return new ImageView(image);
    }

}

