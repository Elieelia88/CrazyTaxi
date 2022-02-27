package Objects;

public class SumDriver {
    String did,dname,phone,rate,sum,numberOfTrips;

    public SumDriver(String did, String dname, String phone, String rate, String sum, String numberOfTrips) {
        this.did = did;
        this.dname = dname;
        this.phone = phone;
        this.rate = rate;
        this.sum = sum;
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

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(String numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }
}
