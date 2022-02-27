package Objects;

public class DriverInventory {
    String did,dname,phone,rate,tid,destination,source,cost,time,cid,cplatenumber,cmodelname,cmodelyear;

    public DriverInventory(String did, String dname, String phone, String rate, String tid, String destination, String source, String cost, String time, String cid, String cplatenumber, String cmodelname, String cmodelyear) {
        this.did = did;
        this.dname = dname;
        this.phone = phone;
        this.rate = rate;
        this.tid = tid;
        this.destination = destination;
        this.source = source;
        this.cost = cost;
        this.time = time;
        this.cid = cid;
        this.cplatenumber = cplatenumber;
        this.cmodelname = cmodelname;
        this.cmodelyear = cmodelyear;
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

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "DriverInventory{" +
                "did='" + did + '\'' +
                ", dname='" + dname + '\'' +
                ", phone='" + phone + '\'' +
                ", rate='" + rate + '\'' +
                ", tid='" + tid + '\'' +
                ", destination='" + destination + '\'' +
                ", source='" + source + '\'' +
                ", cost='" + cost + '\'' +
                ", time='" + time + '\'' +
                ", cid='" + cid + '\'' +
                ", cplatenumber='" + cplatenumber + '\'' +
                ", cmodelname='" + cmodelname + '\'' +
                ", cmodelyear='" + cmodelyear + '\'' +
                '}';
    }
}
