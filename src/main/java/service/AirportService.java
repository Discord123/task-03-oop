package service;

import entity.Airplane;
import entity.fly_company.FlyCompany;

import java.util.List;

public interface AirportService {
    List<Airplane> createAirplanes();
    int totalPassengerValue(FlyCompany flyCompany);
    int totalCargoValue(FlyCompany flyCompany);
    List<Airplane> sortAirplaneByFlyRange(FlyCompany flyCompany);
    List<Airplane> searchAirplaneWithCorrectFuelConsumption(int startValue, int endValue, FlyCompany flyCompany);
}
