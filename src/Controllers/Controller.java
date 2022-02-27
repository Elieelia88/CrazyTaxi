package Controllers;

import Model.Model;
import Objects.Car;
import Objects.Driver;
import Objects.Trip;
import Views.View;
import javafx.scene.control.TableView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public  class Controller {
    private final Model model = new Model();
    private final View view = new View();
    private Object object;


    public Object Add(String[] data, String table_Name)
    {
        String[] resultRow = model.generateSQlInsert(data,table_Name);
        object = view.ShowResult_Insert_Update_Delete(table_Name,resultRow);
        if(object != null)
        {
            System.out.println(resultRow[0]);
            System.out.println(object.toString());

        }

        return object;
    }

    public Object Remove(String id, String table_Name)
    {
        String[] resultRow = model.generateSQlDelete(id,table_Name);
        object = view.ShowResult_Insert_Update_Delete(table_Name,resultRow);
        if(object != null)
        {
            System.out.println(resultRow[0]);
            System.out.println(object.toString());
        }
        return object;
    }

    public Object Update(String[] newValues, String[] columns, String id, String table_name)
    {
        String[] resultRow = model.generateSQlUpdate(newValues,columns, id,table_name);
        object = view.ShowResult_Insert_Update_Delete(table_name,resultRow);
        if(object != null)
        {
            System.out.println(resultRow[0]);
            System.out.println(object.toString());
        }

        return object;
    }

    public TableView inventories(String table_name, LocalDateTime from, LocalDateTime to)
    {
        String f = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(from);
        String t = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(to);

        List<List<String>> result = model.generateSQLInventories(table_name,f,t,to);
        return view.TableInventoryView(result,table_name);
    }

    public TableView inventoriesInd(int id, String table_name, LocalDateTime from, LocalDateTime to)
    {
        String f = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(from);
        String t = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(to);

        List<List<String>> result = model.generateSQLInventoriesInd(id,table_name,f,t,to);
        return view.TableInventoryView(result,table_name);
    }

    public TableView AveragesBetweenTwoDateAllTime(String table_name)
    {
        List<List<String>> result;
        if(table_name.equals("cars"))
            result = model.SQlExecuteCars("exec AllCarsAveragesAllTime","avg");
        else
            result = model.SQlExecuteDrivers("exec AllDriversAveragesAllTime","avg");

        return view.TableAverageSumView(result,table_name,"avg");

    }

    public TableView AveragesBetweenTwoDateAll(String table_name, LocalDateTime from, LocalDateTime to)
    {
        List<List<String>> result;
        String f = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(from);
        String t = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(to);

        if(table_name.equals("cars"))
            result = model.SQlExecuteCars("exec AllCarsAverages '"+f+"','"+t+"'","avg");
        else
            result = model.SQlExecuteDrivers("exec AllDriversAverages '"+f+"','"+t+"'","avg");

        return view.TableAverageSumView(result,table_name,"avg");
    }

    public TableView AverageBetweenTwoDate(String table_name, int id, LocalDateTime from, LocalDateTime to)
    {
        List<List<String>> result;
        String f = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(from);
        String t = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(to);

        if(table_name.equals("cars"))
            result = model.SQlExecuteCars("exec IndividualCarAverage "+ id+",'"+f+"','"+t+"'","avg");
        else
            result = model.SQlExecuteDrivers("exec IndividualDriverAverage "+id+", '"+f+"','"+t+"'","avg");


        return view.TableAverageSumView(result,table_name,"avg");
    }

    public TableView SumsBetweenTwoDateAllTime(String table_name)
    {
        List<List<String>> result;
        if(table_name.equals("cars"))
            result = model.SQlExecuteCars("exec AllCarsSumsAllTime","sum");
        else
            result = model.SQlExecuteDrivers("exec AllDriversSumsAllTime","sum");

        return view.TableAverageSumView(result,table_name,"sum");

    }

    public TableView SumsBetweenTwoDateAll(String table_name, LocalDateTime from, LocalDateTime to)
    {
        List<List<String>> result;
        String f = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(from);
        String t = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(to);

        if(table_name.equals("cars"))
            result = model.SQlExecuteCars("exec AllCarsSums '"+f+"','"+t+"'","sum");
        else
            result = model.SQlExecuteDrivers("exec AllDriversSums '"+f+"','"+t+"'","sum");

        return view.TableAverageSumView(result,table_name,"sum");
    }

    public TableView SumBetweenTwoDate(String table_name, int id, LocalDateTime from, LocalDateTime to)
    {
        List<List<String>> result;
        String f = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(from);
        String t = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(to);

        if(table_name.equals("cars"))
            result = model.SQlExecuteCars("exec IndividualCarSum "+id+", '"+f+"','"+t+"'","sum");
        else
            result = model.SQlExecuteDrivers("exec IndividualDriverSum "+id+", '"+f+"','"+t+"'","sum");

        return view.TableAverageSumView(result,table_name,"sum");
    }

    public void switchAvailability(String table_name, String id)
    {
        // switchAvailability
    }

    public Driver getDriver(String id)
    {
        String[] res = model.GetDriver(id);
        return view.SetDriver(res);
    }

    public Car getCar(String id)
    {
        String[] res = model.GetCar(id);
        return view.SetCar(res);
    }

    public TableView getAllDrivers()
    {
        List<List<String>> result = model.GetAllDrivers();
        return view.TableObjectView(result,"drivers");
    }

    public TableView getAllCars()
    {
        List<List<String>> result = model.GetAllCars();
        return view.TableObjectView(result,"cars");
    }

    public TableView getAllTrips(int Id) {
        List<List<String>> result = model.getAllTripsInd(Id+"");
        return view.TableObjectView(result,"trips");
    }

    public Trip getTrip(String Id) {
        String[] res = model.GetTrip(Id);
        return view.SetTrip(res);
    }
}