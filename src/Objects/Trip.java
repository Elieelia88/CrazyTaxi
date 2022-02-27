package Objects;

public class Trip extends Object {
    private String tid,cid,driverName, destination,source,cost,time;

    public Trip(String destination, String source, String cost) {
        this.destination = destination;
        this.source = source;
        this.cost = cost;
    }

    public Trip(String driverName, String destination, String source, String cost, String time) {
        this.driverName = driverName;
        this.destination = destination;
        this.source = source;
        this.cost = cost;
        this.time = time;
    }

    public Trip(String tid, String cid, String destination, String source, String cost, String time) {
        this.tid = tid;
        this.cid = cid;
        this.destination = destination;
        this.source = source;
        this.cost = cost;
        this.time = time;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
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

    @Override
    public String toString() {
        return
                "driverName: " + driverName + '\n' +
                "destination: " + destination + '\n' +
                "source: " + source + '\n' +
                "cost: " + cost + '\n' +
                "time: " + time + '\n';
    }
}
