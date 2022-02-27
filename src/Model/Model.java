package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private String sql;
    private final String sqlCreateDriversInventory =
            "create view DriversInventory " +
            "as " +
            "select drivers.did,dname,phone,rate,tid,destination,source,cost,time,cars.cid,cplatenumber,cmodelname,cmodelyear " +
            "from cars " +
            "right join trips " +
            "on cars.cid = trips.cid " +
            "right join drivers " +
            "on trips.did = drivers.did ";

    private final String getSqlCreateCarsInventory =
            "create view CarsInventory " +
                    "as " +
                    "select cars.cid,cplatenumber,cmodelname,cmodelyear,tid,destination,source,cost,time,drivers.did,dname,phone,rate " +
                    "from cars " +
                    "left join trips " +
                    "on cars.cid = trips.cid " +
                    "left join drivers " +
                    "on trips.did = drivers.did";

    private final String sqlDropInventory = "drop view ";


    private String[] rowNames;

    private static final String INSERT_INTO_DRIVERS = "insert into drivers (dname,dbirthdate,phone,address) values ";
    private static final String DELETE_DRIVERS = "delete drivers where did = ";
    private static final String UPDATE_DRIVERS = "update drivers set ";
    private static final String WHERE_UPDATE_DRIVERS = " where did = ";
    private static final String[] driversRow = {"msg","dname","dbirthdate","phone","address","error"};

    private static final String INSERT_INTO_CARS = "insert into cars (cplatenumber,ccolor,cmodelname,cmodelyear,cassurance) values ";
    private static final String DELETE_CAR = "delete cars where cid = ";
    private static final String UPDATE_CARS = "update cars set ";
    private static final String WHERE_UPDATE_CARS = " where cid = ";
    private static final String[] carsRow = {"msg","cplatenumber","ccolor","cmodelname","cmodelyear","cassurance","error"};


    private static final String INSERT_INTO_TRIPS = "insert into trips values ";
    private static final String DELETE_TRIPS = "delete trips where tid = ";
    private static final String UPDATE_TRIPS = "update trips set ";
    private static final String WHERE_UPDATE_TRIPS = " where tid = ";
    private static final String[] tripsRow = {"msg","driverName","source","destination","tripDateTime","cost","error"};

    private static final String[] InventoryDriversRow ={"did","dname","phone","rate","tid","destination","source","cost","time","cid","cplatenumber","cmodelname","cmodelyear"};
    private static final String[] InventoryCarsRow ={"cid","cplatenumber","cmodelname","cmodelyear","tid","destination","source","cost","time","did","dname","phone","rate"};


    private static final String[] AvgDriverRow = {"did","dname","phone","rate","average","numberOfTrips"};
    private static final String[] SumDriverRow = {"did","dname","phone","rate","sum","numberOfTrips"};
    private static final String[] AvgCarRow = {"cid","cplatenumber","cmodelname","cmodelyear","average","numberOfTrips"};
    private static final String[] SumCarRow = {"cid","cplatenumber","cmodelname","cmodelyear","sum","numberOfTrips"};

    /*
     Execute Method for the three methods
     that generate SQL direct connected with
     the triggers and return an array string
     for the result
    */
    public String[] GetDriver(String id)
    {
        String[] resultRow = null;
        String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=CrazyTaxi";
        String user = "Elie";
        String pwd = "12345";
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            Statement statement = connection.createStatement();
            String sql = "select * from drivers where did = "+id;
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next())
            {
                resultRow = new String[]{resultSet.getString("dname"),resultSet.getString("dbirthdate"),
                        resultSet.getString("phone"),resultSet.getString("address"),
                        resultSet.getString("rate"),resultSet.getString("password")};
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data base not connected");
            return resultRow;
        }
        return resultRow;
    }


    public String[] GetCar(String id)
    {
        String[] resultRow = null;
        String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=CrazyTaxi";
        String user = "Elie";
        String pwd = "12345";
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            Statement statement = connection.createStatement();
            String sql = "select * from cars where cid = "+id;
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next())
            {
                resultRow = new String[]{resultSet.getString("cplatenumber"),
                        resultSet.getString("ccolor"),resultSet.getString("cmodelname"),resultSet.getString("cmodelyear"),
                        resultSet.getString("cassurance")};
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data base not connected");
            return resultRow;
        }
        return resultRow;
    }


    public String[] ExecuteInsertUpdateDelete()
    {
        String[] resultRow = null;
        String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=CrazyTaxi";
        String user = "Elie";
        String pwd = "12345";
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);

            resultRow = new String[rowNames.length];

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();


            if(resultSet.getString("error").equals("1"))
            {
                System.out.println(resultSet.getString("msg"));
            }
            else
            {
                for(int i = 0; i < rowNames.length; i++)
                    resultRow[i] = resultSet.getString(rowNames[i]);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data base not connected");
            return resultRow;
        }
        return resultRow;
    }

    // method that generate Insert SQL for driver/car/trip
    public String[] generateSQlInsert(String[] data,String table_Name)
    {
            if(table_Name.equals("drivers")) {
                sql = INSERT_INTO_DRIVERS;
                rowNames = driversRow;
            }
            else if (table_Name.equals("cars")){
                sql = INSERT_INTO_CARS;
                rowNames = carsRow;
            }
            else {
                sql = INSERT_INTO_TRIPS;
                rowNames = tripsRow;
            }

            sql += "("+String.join(",",data)+")";
            return ExecuteInsertUpdateDelete();
        }

    // method that generate Delete SQL for driver/car/trip
    public String[] generateSQlDelete(String id,String table_Name)
    {

            if(table_Name.equals("drivers")) {
                sql = DELETE_DRIVERS;
                rowNames = driversRow;
            }
            else if (table_Name.equals("cars")){
                sql = DELETE_CAR;
                rowNames = carsRow;
            }
            else {
                sql = DELETE_TRIPS;
                rowNames = tripsRow;
            }

            sql += id;
      return ExecuteInsertUpdateDelete();
    }

    // method that generate Update SQL for driver/car/trip
    public String[] generateSQlUpdate(String[] newValue,String[] column,String id, String table_Name)
    {
        String where;
        if(table_Name.equals("drivers")) {
            sql = UPDATE_DRIVERS;
            rowNames = driversRow;
            where = WHERE_UPDATE_DRIVERS;
        }
        else if (table_Name.equals("cars")){
            sql = UPDATE_CARS;
            rowNames = carsRow;
            where = WHERE_UPDATE_CARS;
        }
        else {
            sql = UPDATE_TRIPS;
            rowNames = tripsRow;
            where = WHERE_UPDATE_TRIPS;
        }

        StringBuilder set = new StringBuilder(column[0] + "=" + newValue[0]);
        for(int i = 1; i < newValue.length; i++)
            set.append(",").append(column[i]).append("=").append(newValue[i]);
        sql +=set + where + id;
        System.out.println(sql);
        return ExecuteInsertUpdateDelete();
    }

    //just execute without returning anything
    public void Execute_Simple_Sql(List<String> SQLs)
    {
        String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=CrazyTaxi";
        String user = "Elie";
        String pwd = "12345";
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            Statement statement = connection.createStatement();

            for(String sql : SQLs)
            {
                statement.execute(sql);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
     //                   System.out.println("Data base not connected");
        }
    }

    public List<List<String>> Execute_Inventories(String table_name)
    {
        String[] InventoryRow = null;
        List<List<String>> result;
        result = new ArrayList<>();
        if(table_name.equals("drivers"))
            InventoryRow = InventoryDriversRow;
        else
            InventoryRow = InventoryCarsRow;

        String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=CrazyTaxi";
        String user = "Elie";
        String pwd = "12345";
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next())
            {
                List<String> data = new ArrayList<>();

                for (String Col_Name : InventoryRow)
                {
                    String res = resultSet.getString(Col_Name);
                    if(res == null)
                        data.add(resultSet.getString(Col_Name)+"   ");
                    else
                        data.add(resultSet.getString(Col_Name).trim()+"  ");

                }

                result.add(data);

//                for(String s:data)
//                    System.out.print(s);
//                System.out.println();

            //    System.out.println();
            }
            connection.close();

        } catch (SQLException e) {
           e.printStackTrace();
//            System.out.println("Data base not connected");
        }

        return result;
    }

    public List<List<String>> generateSQLInventories(String table_Name, String from, String to,LocalDateTime toDate)
    {
        LocalDateTime lastDateInventoryCreated = getLastDateInventoryCreated(table_Name);
        ArrayList<String> SQLs = new ArrayList<>();

        if(lastDateInventoryCreated == null){
            // create Drivers_Inventory
            if(table_Name.equals("drivers"))
                SQLs.add(sqlCreateDriversInventory);
            else
                SQLs.add(getSqlCreateCarsInventory);

        }
        else if(toDate.isAfter(lastDateInventoryCreated))
        {
            SQLs.add(sqlDropInventory+table_Name+"Inventory");
            if(table_Name.equals("drivers"))
                SQLs.add(sqlCreateDriversInventory);
            else
                SQLs.add(getSqlCreateCarsInventory);

        }

        if(table_Name.equals("drivers"))
            sql = "select * from "+table_Name+"Inventory where time between '"+from+"' and '"+to+"' order by did ";
        else
            sql = "select * from "+table_Name+"Inventory where  time between '"+from+"' and '"+to+"' order by cid ";

            Execute_Simple_Sql(SQLs);
            return Execute_Inventories(table_Name);
    }

    // read the file for the last added date for inventory
    private LocalDateTime getLastDateInventoryCreated(String table_name)
    {
         LocalDateTime dateTime = null;
         String line;
         try {
             FileReader fileReader = new FileReader("src/Model/"+table_name+"InventoryLastDate.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader);

             line = bufferedReader.readLine();

             if(!line.equals("null"))
             {
                 String[] timeData = line.trim().split("\\s+");
                 dateTime = LocalDateTime.of(Integer.parseInt(timeData[0]),
                                             Integer.parseInt(timeData[1]),
                                             Integer.parseInt(timeData[2]),
                                             Integer.parseInt(timeData[3]),
                                             Integer.parseInt(timeData[4]));
             }
             fileReader.close();
         }
         catch (IOException e){
             e.printStackTrace();
         }

         try{
             FileWriter fileWriter = new FileWriter("src/Model/"+table_name+"InventoryLastDate.txt");
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss");
             LocalDateTime now = LocalDateTime.now();
             fileWriter.write(dtf.format(now));
             fileWriter.close();
         }
         catch (IOException e){
             e.printStackTrace();
         }
         return dateTime;
    }

    public List<List<String>> SQlExecuteCars(String SQL, String fun)
    {
        List<List<String>> result;
        result = new ArrayList<>();
        String row[] = GetFunRowCar(fun);

        String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=CrazyTaxi";
        String user = "Elie";
        String pwd = "12345";
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next())
            {
                List<String> data = new ArrayList<>();

                for (String Col_Name : row)
                {
                    String res = resultSet.getString(Col_Name);
                    if(res == null)
                        data.add(resultSet.getString(Col_Name)+"   ");
                    else
                        data.add(resultSet.getString(Col_Name).trim()+"  ");

                }

                result.add(data);

//                for(String s:data)
//                    System.out.print(s);
//                System.out.println();

//                System.out.println();
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println("Data base not connected");
        }
        return result;
    }

    public List<List<String>> SQlExecuteDrivers(String SQL, String fun)
    {
        List<List<String>> result;
        result = new ArrayList<>();
        String row[] = GetFunRowDriver(fun);

        String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=CrazyTaxi";
        String user = "Elie";
        String pwd = "12345";
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next())
            {
                List<String> data = new ArrayList<>();

                for (String Col_Name : row)
                {
                    String res = resultSet.getString(Col_Name);
                    if(res == null)
                        data.add(resultSet.getString(Col_Name)+"   ");
                    else
                        data.add(resultSet.getString(Col_Name).trim()+"  ");

                }

                result.add(data);

//                for(String s:data)
//                    System.out.print(s);
//                System.out.println();

//                System.out.println();
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println("Data base not connected");
        }

        return result;
    }

    private String[] GetFunRowCar(String fun)
    {
        if(fun.equals("sum"))
            return SumCarRow;
        else
            return AvgCarRow;
    }

    private String[] GetFunRowDriver(String fun)
    {
        if(fun.equals("sum"))
            return SumDriverRow;
        else
            return AvgDriverRow;
    }


    public List<List<String>> generateSQLInventoriesInd(int id, String table_Name, String from, String to,LocalDateTime dateTime)
    {

        LocalDateTime lastDateInventoryCreated = getLastDateInventoryCreated(table_Name);
        ArrayList<String> SQLs = new ArrayList<>();

        if(lastDateInventoryCreated == null){
            // create Drivers_Inventory
            if(table_Name.equals("drivers"))
                SQLs.add(sqlCreateDriversInventory);
            else
                SQLs.add(getSqlCreateCarsInventory);

        }
        else if(dateTime.isAfter(lastDateInventoryCreated))
        {
            SQLs.add(sqlDropInventory+table_Name+"Inventory");
            if(table_Name.equals("drivers"))
                SQLs.add(sqlCreateDriversInventory);
            else
                SQLs.add(getSqlCreateCarsInventory);

        }
        if(table_Name.equals("drivers"))
            sql = "select * from "+table_Name+"Inventory where did = "+id+" and time between '"+from+"' and '"+to+"' order by did ";
        else
            sql = "select * from "+table_Name+"Inventory where cid = "+id+" and time between '"+from+"' and '"+to+"' order by cid ";

        Execute_Simple_Sql(SQLs);
        return Execute_Inventories(table_Name);
    }


    public List<List<String>> GetAllDrivers() {
        List<List<String>> result = new ArrayList<>();
        String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=CrazyTaxi";
        String user = "Elie";
        String pwd = "12345";
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            Statement statement = connection.createStatement();
            String sql = "select * from drivers ";
            ResultSet resultSet = statement.executeQuery(sql);
            String[] row = {"did","dname","dbirthdate","phone","address","rate","password"};

            while (resultSet.next())
            {
                List<String> data = new ArrayList<>();

                for (String Col_Name : row)
                {
                    String res = resultSet.getString(Col_Name).trim();
                    data.add(res);
                }

                result.add(data);


            }



            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println("Data base not connected");
        }
        return result;
    }

    public List<List<String>> GetAllCars() {
        List<List<String>> result = new ArrayList<>();
        String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=CrazyTaxi";
        String user = "Elie";
        String pwd = "12345";
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            Statement statement = connection.createStatement();
            String sql = "select * from cars ";
            ResultSet resultSet = statement.executeQuery(sql);
            String[] row = {"cid","cplatenumber","ccolor","cmodelname","cmodelyear","cassurance"};

            while (resultSet.next())
            {
                List<String> data = new ArrayList<>();

                for (String Col_Name : row)
                {
                    String res = resultSet.getString(Col_Name).trim();
                    data.add(res);
                }

                result.add(data);


            }



            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println("Data base not connected");
        }
        return result;
    }

    public List<List<String>> getAllTripsInd(String Id) {
        List<List<String>> result = new ArrayList<>();
        String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=CrazyTaxi";
        String user = "Elie";
        String pwd = "12345";
        try {
            Connection connection = DriverManager.getConnection(url,user,pwd);
            Statement statement = connection.createStatement();
            String sql = "select * from trips where did = "+Id;
            ResultSet resultSet = statement.executeQuery(sql);
            String[] row = {"tid","cid","destination","source","cost","time"};

            while (resultSet.next())
            {
                List<String> data = new ArrayList<>();

                for (String Col_Name : row)
                {
                    String res = resultSet.getString(Col_Name).trim();
                    data.add(res);
                }

                result.add(data);


            }



            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println("Data base not connected");
        }
        return result;
    }

    public String[] GetTrip(String id) {
            String[] resultRow = null;
            String url = "jdbc:sqlserver://LAPTOP-BU8JH8SR;databaseName=CrazyTaxi";
            String user = "Elie";
            String pwd = "12345";
            try {
                Connection connection = DriverManager.getConnection(url,user,pwd);
                Statement statement = connection.createStatement();
                String sql = "select * from trips where tid = "+id;
                ResultSet resultSet = statement.executeQuery(sql);

                if(resultSet.next())
                {
                    resultRow = new String[]{resultSet.getString("destination"),
                            resultSet.getString("source"),resultSet.getString("cost")};
                }
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Data base not connected");
                return resultRow;
            }
            return resultRow;
    }
}
