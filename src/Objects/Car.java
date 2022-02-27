package Objects;

public class Car extends Object {
    String id,cplatenumber,color,cmodelname,cmodelyear,cassurance;

    public Car(String cplatenumber, String color, String cmodelname, String cmodelyear, String cassurance) {
        this.cplatenumber = cplatenumber;
        this.color = color;
        this.cmodelname = cmodelname;
        this.cmodelyear = cmodelyear;
        this.cassurance = cassurance;
    }

    public Car(String id, String cplatenumber, String color, String cmodelname, String cmodelyear, String cassurance) {
        this.id = id;
        this.cplatenumber = cplatenumber;
        this.color = color;
        this.cmodelname = cmodelname;
        this.cmodelyear = cmodelyear;
        this.cassurance = cassurance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCplatenumber() {
        return cplatenumber;
    }

    public void setCplatenumber(String cplatenumber) {
        this.cplatenumber = cplatenumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getCassurance() {
        return cassurance;
    }

    public void setCassurance(String cassurance) {
        this.cassurance = cassurance;
    }

    @Override
    public String toString() {
        return
                "cplatenumber: " + cplatenumber + '\n' +
                "color: " + color + '\n' +
                "cmodelname: " + cmodelname + '\n' +
                "cmodelyear: " + cmodelyear + '\n' +
                "cassurance: " + cassurance + '\n';
    }
}
