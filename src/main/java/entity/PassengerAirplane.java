package entity;

import java.io.Serializable;

public class PassengerAirplane implements Airplane, Serializable {

    private static final long serialVersionUID = -6095944243876553986L;

    private String airplaneName;
    private int passengerValue;
    private int fuelConsumptionPerHour;
    private int flyingRange;

    public PassengerAirplane() {
    }

    public PassengerAirplane(String airplaneName, int passengerValue, int fuelConsumptionPerHour, int flyingRange) {
        this.airplaneName = airplaneName;
        this.passengerValue = passengerValue;
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

    public int getPassengerValue() {
        return passengerValue;
    }

    public int getCargoValue() { return 0; }

    public void setPassengerValue(int passengerValue) {
        this.passengerValue = passengerValue;
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

        PassengerAirplane that = (PassengerAirplane) o;

        if (passengerValue != that.passengerValue) return false;
        if (fuelConsumptionPerHour != that.fuelConsumptionPerHour) return false;
        if (flyingRange != that.flyingRange) return false;
        return airplaneName.equals(that.airplaneName);
    }

    @Override
    public int hashCode() {
        int result = airplaneName.hashCode();
        result = 31 * result + passengerValue;
        result = 31 * result + fuelConsumptionPerHour;
        result = 31 * result + flyingRange;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PassengerAirplane{");
        sb.append("airplaneName='").append(airplaneName).append('\'');
        sb.append(", passengerValue=").append(passengerValue);
        sb.append(", fuelConsumptionPerHour=").append(fuelConsumptionPerHour);
        sb.append(", flyingRange=").append(flyingRange);
        sb.append('}');
        return sb.toString();
    }
}
