package entity;

import java.io.Serializable;

public class TransportAirplane implements Airplane, Serializable {

    private static final long serialVersionUID = -6006141386925090715L;

    private String airplaneName;
    private int cargoValue;
    private int fuelConsumptionPerHour;
    private int flyingRange;

    public TransportAirplane() {
    }

    public TransportAirplane(String airplaneName, int cargoValue, int fuelConsumptionPerHour, int flyingRange) {
        this.airplaneName = airplaneName;
        this.cargoValue = cargoValue;
        this.fuelConsumptionPerHour = fuelConsumptionPerHour;
        this.flyingRange = flyingRange;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public int getPassengerValue() { return 0; }

    public int getCargoValue() {
        return cargoValue;
    }

    public void setCargoValue(int cargoValue) {
        this.cargoValue = cargoValue;
    }

    public int getFuelConsumptionPerHour() {
        return fuelConsumptionPerHour;
    }

    public void setFuelConsumptionPerHour(int fuelConsumptionPerHour) {
        this.fuelConsumptionPerHour = fuelConsumptionPerHour;
    }

    public int getFlyingRange() {
        return flyingRange;
    }

    public void setFlyingRange(int flyingRange) {
        this.flyingRange = flyingRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransportAirplane that = (TransportAirplane) o;

        if (cargoValue != that.cargoValue) return false;
        if (fuelConsumptionPerHour != that.fuelConsumptionPerHour) return false;
        if (flyingRange != that.flyingRange) return false;
        return airplaneName.equals(that.airplaneName);
    }

    @Override
    public int hashCode() {
        int result = airplaneName.hashCode();
        result = 31 * result + cargoValue;
        result = 31 * result + fuelConsumptionPerHour;
        result = 31 * result + flyingRange;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TransportAirplane{");
        sb.append("airplaneName='").append(airplaneName).append('\'');
        sb.append(", cargoValue=").append(cargoValue);
        sb.append(", fuelConsumptionPerHour=").append(fuelConsumptionPerHour);
        sb.append(", flyingRange=").append(flyingRange);
        sb.append('}');
        return sb.toString();
    }
}
