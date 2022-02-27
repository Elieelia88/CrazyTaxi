package Objects;

public class Driver extends Object {
    String id,driverName,birthDate,phone,address,rate,password;



    public Driver(String driverName, String birthDate, String phone, String address) {
        this.driverName = driverName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
    }

    public Driver(String driverName, String birthDate, String phone, String address, String rate) {
        this.driverName = driverName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.rate = rate;
    }

    public Driver(String id, String driverName, String birthDate, String phone, String address, String rate,String password) {
        this.id = id;
        this.driverName = driverName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.rate = rate;
        this.password = password;
    }

    public Driver(String driverName, String birthDate, String phone, String address, String rate, String password) {
        this.driverName = driverName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.rate = rate;
        this.password = password;
    }



    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return
                "driverName: " + driverName + '\n' +
                "birthDate: " + birthDate + '\n' +
                "phone: " + phone + '\n' +
                "address: " + address+"\n";

    }
}
