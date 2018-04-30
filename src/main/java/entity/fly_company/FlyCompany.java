package entity.fly_company;

import entity.Airplane;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class FlyCompany implements Serializable {

    private static final long serialVersionUID = 6464529389941259568L;

    private String name;
    private List<Airplane> airplaneList = new ArrayList<Airplane>();

    public FlyCompany(){
    }

    public FlyCompany(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airplane> getAirplaneList() {
        return airplaneList;
    }

    public void setAirplaneList(List<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
    }

    public void add(Airplane airplane) {
        airplaneList.add(airplane);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlyCompany that = (FlyCompany) o;

        if (!name.equals(that.name)) return false;
        return airplaneList.equals(that.airplaneList);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + airplaneList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlyCompany{");
        sb.append("name='").append(name).append('\'');
        sb.append(", airplaneList=").append(airplaneList);
        sb.append('}');
        return sb.toString();
    }
}
