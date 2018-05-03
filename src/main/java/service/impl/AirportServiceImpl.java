package service.impl;

import dao.AirplaneXMLDAO;
import dao.DAOFactory;
import entity.Airplane;
import entity.fly_company.FlyCompany;
import service.AirportService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AirportServiceImpl implements AirportService {

    DAOFactory factory = DAOFactory.getInstance();
    AirplaneXMLDAO airplaneXMLDAO = factory.getAirplaneXMLDAO();

    @Override
    public List<Airplane> createAirplanes() {
        return airplaneXMLDAO.createAirplaneList();
    }

    @Override
    public int totalPassengerValue(FlyCompany flyCompany) {
        List<Airplane> airplaneList = flyCompany.getAirplaneList();

        int totalPassengerValue = 0;
        for (Airplane airplane : airplaneList) {
            totalPassengerValue += airplane.getPassengerValue();
        }

        return totalPassengerValue;
    }

    @Override
    public int totalCargoValue (FlyCompany flyCompany) {
        List<Airplane> airplaneList = flyCompany.getAirplaneList();

        int totalCargoValue = 0;
        for (Airplane airplane : airplaneList) {
            totalCargoValue += airplane.getCargoValue();
        }

        return totalCargoValue;
    }

    @Override
    public List<Airplane> sortAirplaneByFlyRange (FlyCompany flyCompany) {
        List<Airplane> airplaneList = flyCompany.getAirplaneList();

        Collections.sort(airplaneList, Comparator.comparingInt(Airplane::getFlyingRange));

        return airplaneList;
    }

    @Override
    public List<Airplane> searchAirplaneWithCorrectFuelConsumption (int startValue, int endValue, FlyCompany flyCompany) {
        List<Airplane> airplaneList = new ArrayList<>();

        for (Airplane airplane : flyCompany.getAirplaneList()) {
            int fuelConsumption = airplane.getFuelConsumptionPerHour();
            if(fuelConsumption >= startValue && fuelConsumption <= endValue) {
                airplaneList.add(airplane);
            }
        }

        return airplaneList;
    }
}
