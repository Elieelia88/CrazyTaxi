package Objects;

public class SumCar {
    String cid,cplatenumber,cmodelname,cmodelyear,sum,numberOfTrips;

    public SumCar(String cid, String cplatenumber, String cmodelname, String cmodelyear, String sum, String numberOfTrips) {
        this.cid = cid;
        this.cplatenumber = cplatenumber;
        this.cmodelname = cmodelname;
        this.cmodelyear = cmodelyear;
        this.sum = sum;
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
