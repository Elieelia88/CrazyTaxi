package Clients;

import Controllers.Controller;
import Objects.Trip;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class Drivers extends Application {
    private static int ID;
    {
        try {
            ID = getDriverId();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final Controller controller = new Controller();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        HBox hbGeneralLayout = new HBox();
        VBox vbMenuLayout = new VBox(70);
        AtomicInteger flag = new AtomicInteger(1);

        vbMenuLayout.setStyle("-fx-background-color: #C9A368;");

        Button btnProfile = new Button("Profile",setImage("profileClicked"));
        Button btnTrip = new Button("Trip",setImage("trip"));
        Button btnInventory = new Button("Inventory",setImage("inventory"));
        btnInventory.setPrefWidth(110);
        btnProfile.setStyle("-fx-background-color: #C9A368; -fx-text-fill: white;");
        btnTrip.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
        btnInventory.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");


        vbMenuLayout.getChildren().addAll(btnProfile,btnTrip,btnInventory);
        hbGeneralLayout.getChildren().addAll(vbMenuLayout,getProfile(primaryStage));

        btnProfile.setOnAction(e->{
            if(flag.get() !=1)
            {
                try {
                    btnProfile.setGraphic(setImage("profileClicked"));
                    btnTrip.setGraphic(setImage("trip"));
                    btnInventory.setGraphic(setImage("inventory"));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                btnProfile.setStyle("-fx-background-color: #C9A368; -fx-text-fill: white;");
                btnTrip.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                btnInventory.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                hbGeneralLayout.getChildren().set(1,getProfile(primaryStage));
                flag.set(1);
            }
        });

        btnTrip.setOnAction(e->{
            if(flag.get() !=2)
            {
                try {
                    btnProfile.setGraphic(setImage("profile"));
                    btnTrip.setGraphic(setImage("tripClicked"));
                    btnInventory.setGraphic(setImage("inventory"));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }


                btnProfile.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                btnTrip.setStyle("-fx-background-color: #C9A368; -fx-text-fill: white;");
                btnInventory.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                hbGeneralLayout.getChildren().set(1,getTrips());
                flag.set(2);
            }
        });

        btnInventory.setOnAction(e->{
            if(flag.get() !=3)
            {
                try {

                    hbGeneralLayout.getChildren().set(1,getIndInventory());
                    btnProfile.setGraphic(setImage("profile"));
                    btnTrip.setGraphic(setImage("trip"));
                    btnInventory.setGraphic(setImage("inventoryClicked"));
                }
                catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }


                btnProfile.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                btnTrip.setStyle("-fx-background-color: #C9A368; -fx-text-fill: black;");
                btnInventory.setStyle("-fx-background-color: #C9A368; -fx-text-fill: white;");

                flag.set(3);
            }
        });




        Scene scene = new Scene(hbGeneralLayout,1200,360);
        primaryStage.setTitle("Crazy Taxi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public VBox getProfile(Stage s){

        VBox vbProfileLayout = new VBox(10);

        VBox vbDriverInfo = new VBox(10);
        vbDriverInfo.setPadding(new Insets(10));

        VBox vbTripsInfo = new VBox(10);

        HBox hBox = new HBox(70);
        hBox.setPadding(new Insets(10));

        Objects.Driver driver = controller.getDriver(ID+"");

        Label lblDriverName = new Label("Name: "+driver.getDriverName());
        Label lblDriverBirthDate = new Label("BirthDate: "+driver.getBirthDate());
        Label lblDriverPhone = new Label("Name: "+driver.getPhone());
        Label lblDriverAddress = new Label("Name: "+driver.getAddress());
        Label lblDriverRate = new Label("Name: "+driver.getRate());
        Label lblChangePass = new Label("Change Password: ");
        PasswordField pfPassword = new PasswordField();
        Button btnChangePass = new Button("Change Password");

        Button btnLogout = new Button("Logout");
        btnLogout.setOnAction(e->{
            new Login().start(new Stage());
            s.close();
        });

        vbDriverInfo.getChildren().addAll(lblDriverName,lblDriverBirthDate,lblDriverPhone,lblDriverAddress,lblDriverRate,
                lblChangePass,pfPassword,btnChangePass,btnLogout);

        var tblTrips = controller.getAllTrips(ID);
        Label lblNbOfTrips = new Label("Number of trips: "+tblTrips.getItems().size());



        var tblAvgInd = controller.AverageBetweenTwoDate("drivers",
                ID,LocalDateTime.of(2000,1,1,0,0,0),
                LocalDateTime.of(3000,1,1,0,0,0));

        var tblSumInd = controller.SumBetweenTwoDate("drivers",
                ID,LocalDateTime.of(2000,1,1,0,0,0),
                LocalDateTime.of(3000,1,1,0,0,0));

        if(tblAvgInd.getItems().size() != 0)
        {

            TableColumn tableColumn1 = tblAvgInd.getVisibleLeafColumn(4);
            TableColumn tableColumn = tblSumInd.getVisibleLeafColumn(4);

            String avg = tableColumn1.getCellData(0).toString();
            Label lblAverageTrips = new Label("Average cost: "+avg);

            String sum = tableColumn.getCellData(0).toString();
            Label lblSumTrips = new Label("Sum cost: "+sum);

            vbTripsInfo.getChildren().addAll(lblNbOfTrips,lblAverageTrips,lblSumTrips,tblTrips);
        }





        hBox.getChildren().addAll(vbDriverInfo,vbTripsInfo);

        vbProfileLayout.getChildren().add(hBox);
        return vbProfileLayout;
    }

    public VBox getTrips(){
        VBox vBox = new VBox(10);
        HBox hBox = new HBox();

        // Add Trip Layout
        VBox vBoxAddTripLayout = new VBox(10);
        vBoxAddTripLayout.setPadding(new Insets(10));

        Label lblTitleTripAdd = new Label("Add Trip");
        lblTitleTripAdd.setFont(new Font(15));
        lblTitleTripAdd.setPadding(new Insets(10));

        Label lblTripCarId = new Label("Car Id: ");
        TextField tfTripCarId = new TextField();

        Label lblTripDestination = new Label("Destination: ");
        TextField tfTripDestination = new TextField();

        Label lblTripSource = new Label("Source: ");
        TextField tfTripSource = new TextField();

        Label lblTripCost = new Label("Cost: ");
        TextField tfTripCost = new TextField();


        Button btnAddTrip = new Button("Add Trip");

        Label lblResultAddTripInfo = new Label();
        lblResultAddTripInfo.setVisible(false);

        vBoxAddTripLayout.getChildren().addAll(lblTitleTripAdd,lblTripCarId,tfTripCarId,
                lblTripDestination,tfTripDestination,
                lblTripSource,tfTripSource,
                lblTripCost,tfTripCost
                ,btnAddTrip,lblResultAddTripInfo);


        // Trip Delete Layout

        VBox vBoxTripDelete = new VBox(10);
        vBoxTripDelete.setPadding(new Insets(10));

        Label lblTitleDelete = new Label("Delete Trip");
        lblTitleDelete.setFont(new Font(15));
        lblTitleDelete.setPadding(new Insets(10));

        Label lblTripIdDelete = new Label("Enter Trip Id: ");
        TextField tfTripIdDelete = new TextField();

        Button btnDeleteTrip = new Button("Delete Trip");

        Label lblResultDeleteTripInfo = new Label();
        lblResultDeleteTripInfo.setVisible(false);

        vBoxTripDelete.getChildren().addAll(lblTitleDelete,lblTripIdDelete,tfTripIdDelete,btnDeleteTrip,lblResultDeleteTripInfo);



        //Trip Update Layout

        VBox vBoxTripUpdate = new VBox(4.5);
        vBoxTripUpdate.setPadding(new Insets(10));

        Label lblTitleUpdate = new Label("Update Trip");
        lblTitleUpdate.setFont(new Font(15));
        lblTitleUpdate.setPadding(new Insets(10));

        Label lblTripIdUpdate = new Label("Enter Trip Id: ");
        TextField tfTripIdUpdate = new TextField();

        Button btnSearchUpdateTrip = new Button("get Trip");

        Label lblResultSearchUpdateTripInfo = new Label();
        lblResultSearchUpdateTripInfo.setVisible(false);


        Label lblTripDestinationUpdate = new Label("Destination: ");
        TextField tfTripDestinationUpdate = new TextField();

        Label lblTripSourceUpdate = new Label("Source: ");
        TextField tfTripSourceUpdate = new TextField();

        Label lblTripCostUpdate = new Label("Cost: ");
        TextField tfTripCostUpdate = new TextField();

        Button btnUpdateTrip = new Button("Update Trip");
        Label lblResultAddTripInfoUpdate = new Label();
        lblResultAddTripInfoUpdate.setVisible(false);

        vBoxTripUpdate.getChildren().addAll(lblTitleUpdate,lblTripIdUpdate,tfTripIdUpdate,btnSearchUpdateTrip,lblResultSearchUpdateTripInfo,
                lblTripDestinationUpdate,tfTripDestinationUpdate,
                lblTripSourceUpdate,tfTripSourceUpdate,
                lblTripCostUpdate,tfTripCostUpdate,
                btnUpdateTrip,lblResultAddTripInfoUpdate);

        lblTripDestinationUpdate.setVisible(false);
        tfTripDestinationUpdate.setVisible(false);
        lblTripSourceUpdate.setVisible(false);
        tfTripSourceUpdate.setVisible(false);
        lblTripCostUpdate.setVisible(false);
        tfTripCostUpdate.setVisible(false);
        lblResultAddTripInfoUpdate.setVisible(false);
        btnUpdateTrip.setVisible(false);


        //Table All Trips
        var tblAllTrips = controller.getAllTrips(ID);


        // general Layout
        hBox.getChildren().addAll(vBoxAddTripLayout,vBoxTripDelete,vBoxTripUpdate,tblAllTrips);
        vBox.getChildren().add(hBox);


        // add a Trip Button Function
        btnAddTrip.setOnAction(e->
        {
            // empty delete
            tfTripIdDelete.setText("");
            lblResultDeleteTripInfo.setVisible(false);

            // empty Update
            tfTripIdUpdate.setText("");
            lblResultSearchUpdateTripInfo.setVisible(false);
            lblTripDestinationUpdate.setVisible(false);
            tfTripDestinationUpdate.setVisible(false);
            lblTripSourceUpdate.setVisible(false);
            tfTripSourceUpdate.setVisible(false);
            lblTripCostUpdate.setVisible(false);
            tfTripCostUpdate.setVisible(false);
            lblResultAddTripInfoUpdate.setVisible(false);
            btnUpdateTrip.setVisible(false);

            // check if a field is empty or car date assurance before now
            if(tfTripDestination.getText().isBlank() ||
                    tfTripSource.getText().isBlank())
            {
                lblResultAddTripInfo.setVisible(true);
                lblResultAddTripInfo.setText("Invalid Input");
            }
            else
            {

                try {
                    int cid = Integer.parseInt(tfTripCarId.getText());
                    double cost = Double.parseDouble(tfTripCost.getText());
                    Trip trip = (Trip) controller.Add(new String[]{"'"+cid+"'",
                                    "'"+ID+"'",
                                    "'"+tfTripDestination.getText()+"'",
                                    "'"+tfTripSource.getText()+"'",
                                    "'"+cost+"'",
                                    "'"+ DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(LocalDateTime.now())+"'"}
                            ,"trips");

                    if(trip != null)
                    {
                        hBox.getChildren().set(3,controller.getAllCars());
                        lblResultAddTripInfo.setText("Trip Added");
                        hBox.getChildren().set(3,controller.getAllTrips(ID));
                    }
                    else
                        lblResultAddTripInfo.setText("Car not found");

                    lblResultAddTripInfo.setVisible(true);
                }
                catch (NumberFormatException ex)
                {
                    lblResultAddTripInfo.setVisible(true);
                    lblResultAddTripInfo.setText("Model year error");
                }
            }
        });


        // Delete Trip Button Function
        btnDeleteTrip.setOnAction(e->{
            // empty add
            tfTripCarId.setText("");
            tfTripDestination.setText("");
            tfTripSource.setText("");
            tfTripCost.setText("");
            lblResultAddTripInfo.setVisible(false);

            // empty Update
            tfTripIdUpdate.setText("");
            lblResultSearchUpdateTripInfo.setVisible(false);
            lblTripDestinationUpdate.setVisible(false);
            tfTripDestinationUpdate.setVisible(false);
            lblTripSourceUpdate.setVisible(false);
            tfTripSourceUpdate.setVisible(false);
            lblTripCostUpdate.setVisible(false);
            tfTripCostUpdate.setVisible(false);
            lblResultAddTripInfoUpdate.setVisible(false);
            btnUpdateTrip.setVisible(false);

            try {
                int id = Integer.parseInt(tfTripIdDelete.getText());
                Trip trip = controller.getTrip(tfTripIdDelete.getText());

                if(trip != null)
                {
                    controller.Remove(tfTripIdDelete.getText(),"trips");
                    hBox.getChildren().set(3,controller.getAllTrips(ID));
                    lblResultDeleteTripInfo.setText("Trip "+id+" is deleted");
                }
                else
                    lblResultDeleteTripInfo.setText("Cannot find Trip");

                lblResultDeleteTripInfo.setVisible(true);
            }
            catch (NumberFormatException ex)
            {
                lblResultDeleteTripInfo.setVisible(true);
                lblResultDeleteTripInfo.setText("Invalid Input");
            }
        });


        // Button Update Trip
        // Search Trip

        btnSearchUpdateTrip.setOnAction(e->{
            // empty add
            tfTripCarId.setText("");
            tfTripDestination.setText("");
            tfTripSource.setText("");
            tfTripCost.setText("");
            lblResultAddTripInfo.setVisible(false);

            // empty delete
            tfTripIdDelete.setText("");
            lblResultDeleteTripInfo.setVisible(false);

            try {
                int id = Integer.parseInt(tfTripIdUpdate.getText());
                Trip trip = controller.getTrip(id+"");

                if(trip != null)
                {

                    btnUpdateTrip.setVisible(true);



                    lblTripDestinationUpdate.setVisible(true);
                    tfTripDestinationUpdate.setVisible(true);
                    tfTripDestinationUpdate.setText(trip.getDestination().trim());

                    lblTripSourceUpdate.setVisible(true);
                    tfTripSourceUpdate.setVisible(true);
                    tfTripSourceUpdate.setText(trip.getSource().trim());

                    lblTripCostUpdate.setVisible(true);
                    tfTripCostUpdate.setVisible(true);
                    tfTripCostUpdate.setText(trip.getCost().trim());

                }
                else {
                    lblResultSearchUpdateTripInfo.setText("Cannot find Trip");
                    lblResultSearchUpdateTripInfo.setVisible(true);
                }

            }
            catch (NumberFormatException  ex)
            {
                lblResultSearchUpdateTripInfo.setVisible(true);
                lblResultSearchUpdateTripInfo.setText("Invalid Input");
            }

        });

        // update Trip found
        btnUpdateTrip.setOnAction(e->
        {
            if(tfTripDestinationUpdate.getText().isBlank() || tfTripCostUpdate.getText().isBlank())
            {
                lblResultAddTripInfoUpdate.setVisible(true);
                lblResultAddTripInfoUpdate.setText("Invalid Input");
            }
            else
            {
                try {
                    double cost = Double.parseDouble(tfTripCostUpdate.getText());

                    controller.Update(new String[]{"'"+tfTripDestinationUpdate.getText()+"'",
                            "'"+tfTripSourceUpdate.getText()+"'",
                            "'"+cost+"'"},new String[]{"destination","source","cost"},tfTripIdUpdate.getText(),"trips");

                    hBox.getChildren().set(3,controller.getAllTrips(ID));
                    lblResultAddTripInfoUpdate.setText("Trip Updated");
                    lblResultAddTripInfoUpdate.setVisible(true);
                }
                catch (NumberFormatException ex)
                {
                    ex.printStackTrace();
                    lblResultAddTripInfoUpdate.setVisible(true);
                    lblResultAddTripInfoUpdate.setText("Invalid input");
                }
            }
        });

        return vBox;
    }

    public VBox getIndInventory(){
        Label lblFrom = new Label("from:");
        Label lblTo = new Label("to:");
        lblFrom.setPadding(new Insets(5, 5, 5, 5));
        lblTo.setPadding(new Insets(5, 5, 5, 5));

        DatePicker from = new DatePicker();
        DatePicker to = new DatePicker();

        from.getEditor().setDisable(true);
        from.getEditor().setOpacity(12);

        to.getEditor().setDisable(true);
        to.getEditor().setOpacity(12);

        from.setValue(LocalDate.now());
        to.setValue(LocalDate.now());

        Button btnSearch = new Button("Search Inventory");

        var tblIndInventory = controller.inventoriesInd(ID, "drivers", LocalDateTime.of(2000, 1, 1, 0, 0, 0), LocalDateTime.of(3000, 1, 1, 0, 0, 0));

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(5));
        hBox.getChildren().addAll(lblFrom, from, lblTo, to,btnSearch);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(15));
        vBox.getChildren().addAll(hBox, tblIndInventory);

        btnSearch.setOnAction(e -> vBox.getChildren().set(1,controller.inventoriesInd(ID,"drivers",from.getValue().atStartOfDay(),to.getValue().atStartOfDay())));
        return vBox;
    }

    private ImageView setImage(String name) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("src/Images/"+name+".png");
        Image image = new Image(input,50,50,true,true);
        return new ImageView(image);
    }

    private int getDriverId() throws IOException {
        FileReader fileReader = new FileReader("src/Clients/DriverId");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();
        fileReader.close();
        return Integer.parseInt(line);
    }

}