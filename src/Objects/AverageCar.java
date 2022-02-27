package Objects;

public class AverageCar {
    String cid,cplatenumber,cmodelname,cmodelyear,average,numberOfTrips;

    public AverageCar(String cid, String cplatenumber, String cmodelname, String cmodelyear, String average, String numberOfTrips) {
        this.cid = cid;
        this.cplatenumber = cplatenumber;
        this.cmodelname = cmodelname;
        this.cmodelyear = cmodelyear;
        this.average = average;
        this.numberOfTrips = numberOfTrips;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCplatenumber() {
        return cplatenumber;
    }

    public void setCplatenumber(String cplatenumber) {
        this.cplatenumber = cplatenumber;
    }

    public String getCmodelname() {
        return cmodelname;
    }

    public void setCmodelname(String cmodelname) {
        this.cmodelname = cmodelname;
    }

    public String getCmodelyear() {
        return cmodelyear;
    }

    public void setCmodelyear(String cmodelyear) {
        this.cmodelyear = cmodelyear;
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
