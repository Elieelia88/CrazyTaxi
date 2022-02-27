package Views;

import Objects.Object;
import Objects.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class View {
    public Object ShowResult_Insert_Update_Delete(String type, String[] resultRow){
        if(resultRow[0] != null)
        {
            if(type.equals("cars"))
                return  new Car(resultRow[1],resultRow[2],resultRow[3],resultRow[4],resultRow[5] );
            else if(type.equals("drivers"))
                return  new Driver(resultRow[1],resultRow[2],resultRow[3],resultRow[4]);
            else
                return new Trip(resultRow[1],resultRow[2],resultRow[3],resultRow[4],resultRow[5]);
        }
        return null;
    }


    public TableView TableInventoryView(List<List<String>> result, String category) {
        if(category.equals("drivers"))
        {
            String[] InventoryDriversRow ={"did","dname","phone","rate","tid","destination","source","cost","time","cid","cplatenumber","cmodelname","cmodelyear"};
            TableView<DriverInventory> table = new TableView<>();

            for(String col : InventoryDriversRow)
            {
                TableColumn<DriverInventory,String> Column = new TableColumn<>(col);
                Column.setCellValueFactory(new PropertyValueFactory<>(col));
                table.getColumns().add(Column);
            }
            if(result.size() != 0) {
                for (List<String> resultRow : result) {
                    table.getItems().add(new DriverInventory(resultRow.get(0), resultRow.get(1), resultRow.get(2),
                            resultRow.get(3), resultRow.get(4), resultRow.get(5),
                            resultRow.get(6), resultRow.get(7), resultRow.get(8),
                            resultRow.get(9), resultRow.get(10),resultRow.get(11), resultRow.get(12)));
                }
            }
            return table;
        }
        else if (category.equals("cars"))
        {
            String[] InventoryCarsRow ={"cid","cplatenumber","cmodelname","cmodelyear","tid","destination","source","cost","time","did","dname","phone","rate"};
            TableView<CarInventory> table = new TableView<>();

            for(String col : InventoryCarsRow)
            {
                TableColumn<CarInventory,String> Column = new TableColumn<>(col);
                Column.setCellValueFactory(new PropertyValueFactory<>(col));
                table.getColumns().add(Column);
            }

            if(result.size() != 0){

                for(List<String> resultRow: result)
                {
                    table.getItems().add(new CarInventory(resultRow.get(0), resultRow.get(1), resultRow.get(2),
                            resultRow.get(3), resultRow.get(4), resultRow.get(5),
                            resultRow.get(6), resultRow.get(7), resultRow.get(8),
                            resultRow.get(9), resultRow.get(10),resultRow.get(11), resultRow.get(12)));
                }
            }
            return table;
        }
        return null;
    }

    public  TableView TableAverageSumView(List<List<String>> result, String category,String operation)
    {
        if(operation.equals("avg")){

            if(category.equals("drivers"))
            {
                String[] AvgDriverRow = {"did","dname","phone","rate","average","numberOfTrips"};
                TableView<AverageDriver> table = new TableView<>();

                for(String col : AvgDriverRow)
                {
                    TableColumn<AverageDriver,String> Column = new TableColumn<>(col);
                    Column.setCellValueFactory(new PropertyValueFactory<>(col));
                    table.getColumns().add(Column);
                }
                if(result.size() != 0) {
                    for (List<String> resultRow : result) {
                        table.getItems().add(new AverageDriver(resultRow.get(0), resultRow.get(1), resultRow.get(2),
                                resultRow.get(3), resultRow.get(4), resultRow.get(5)));
                    }
                }
                table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                return table;
            }
            else if (category.equals("cars"))
            {
                String[] AvgCarRow = {"cid","cplatenumber","cmodelname","cmodelyear","average","numberOfTrips"};
                TableView<AverageCar> table = new TableView<>();

                for(String col : AvgCarRow)
                {
                    TableColumn<AverageCar,String> Column = new TableColumn<>(col);
                    Column.setCellValueFactory(new PropertyValueFactory<>(col));
                    table.getColumns().add(Column);
                }

                if(result.size() != 0){

                    for(List<String> resultRow: result)
                    {
                        table.getItems().add(new AverageCar(resultRow.get(0), resultRow.get(1), resultRow.get(2),
                                resultRow.get(3), resultRow.get(4), resultRow.get(5)));
                    }
                    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                }
                return table;
            }
        }
        else
        {
            if(category.equals("drivers"))
            {
                String[] SumDriverRow = {"did","dname","phone","rate","sum","numberOfTrips"};
                TableView<SumDriver> table = new TableView<>();

                for(String col : SumDriverRow)
                {
                    TableColumn<SumDriver,String> Column = new TableColumn<>(col);
                    Column.setCellValueFactory(new PropertyValueFactory<>(col));
                    table.getColumns().add(Column);
                }
                if(result.size() != 0) {
                    for (List<String> resultRow : result) {
                        table.getItems().add(new SumDriver(resultRow.get(0), resultRow.get(1), resultRow.get(2),
                                resultRow.get(3), resultRow.get(4), resultRow.get(5)
                        ));
                    }
                }
                table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                return table;
            }
            else if (category.equals("cars"))
            {
                String[] SumCarRow = {"cid","cplatenumber","cmodelname","cmodelyear","sum","numberOfTrips"};
                TableView<SumCar> table = new TableView<>();

                for(String col : SumCarRow)
                {
                    TableColumn<SumCar,String> Column = new TableColumn<>(col);
                    Column.setCellValueFactory(new PropertyValueFactory<>(col));
                    table.getColumns().add(Column);
                }

                if(result.size() != 0){

                    for(List<String> resultRow: result)
                    {
                        table.getItems().add(new SumCar(resultRow.get(0), resultRow.get(1), resultRow.get(2),
                                resultRow.get(3), resultRow.get(4), resultRow.get(5)
                        ));
                    }
                    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                }
                return table;
            }
        }
        return null;
    }

    public Driver SetDriver(String[] res) {
        if(res!=null)
            return new Driver(res[0],res[1],res[2],res[3],res[4],res[5]);

        return null;

    }

    public Car SetCar(String[] res) {
        if(res!=null)
            return new Car(res[0],res[1],res[2],res[3],res[4]);
        return null;

    }

    public Trip SetTrip(String[] res) {
        if(res!=null)
            return new Trip(res[0],res[1],res[2]);
        return null;
    }

    public TableView TableObjectView(List<List<String>> result, String category) {
        if(category.equals("drivers"))
        {
            String[] driver = {"id","driverName","birthDate","phone","address","rate","password"};
            TableView<Driver> table = new TableView<>();

            for(String col : driver)
            {
                TableColumn<Driver,String> Column = new TableColumn<>(col);
                Column.setCellValueFactory(new PropertyValueFactory<>(col));
                table.getColumns().add(Column);
            }
            if(result.size() != 0) {
                for (List<String> resultRow : result) {
                    table.getItems().add(new Driver(resultRow.get(0), resultRow.get(1), resultRow.get(2),
                            resultRow.get(3), resultRow.get(4), resultRow.get(5),resultRow.get(6)));
                }
            }
            return table;
        }
        else if (category.equals("cars")) {
            String[] car = {"id","cplatenumber","color","cmodelname","cmodelyear","cassurance"};
            TableView<Car> table = new TableView<>();

            for(String col : car)
            {
                TableColumn<Car,String> Column = new TableColumn<>(col);
                Column.setCellValueFactory(new PropertyValueFactory<>(col));
                table.getColumns().add(Column);
            }
            if(result.size() != 0) {
                for (List<String> resultRow : result) {
                    table.getItems().add(new Car(resultRow.get(0), resultRow.get(1), resultRow.get(2),
                            resultRow.get(3), resultRow.get(4), resultRow.get(5)));
                }
            }
            return table;
        }
        else {
            String[] trip = {"tid","cid","destination","source","cost","time"};
            TableView<Trip> table = new TableView<>();

            for(String col : trip)
            {
                TableColumn<Trip,String> Column = new TableColumn<>(col);
                Column.setCellValueFactory(new PropertyValueFactory<>(col));
                table.getColumns().add(Column);
            }
            if(result.size() != 0) {
                for (List<String> resultRow : result) {
                    table.getItems().add(new Trip(resultRow.get(0), resultRow.get(1), resultRow.get(2),
                            resultRow.get(3), resultRow.get(4), resultRow.get(5)));
                }
            }
            return table;
        }
    }


}