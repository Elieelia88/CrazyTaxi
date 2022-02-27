package Objects;

public class AverageDriver {
    String did,dname,phone,rate,average,numberOfTrips;

    public AverageDriver(String did, String dname, String phone, String rate, String average, String numberOfTrips) {
        this.did = did;
        this.dname = dname;
        this.phone = phone;
        this.rate = rate;
        this.average = average;
        this.numberOfTrips = numberOfTrips;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(String numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }
}
