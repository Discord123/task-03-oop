package main;

import entity.Airplane;
import entity.PassengerAirplane;
import entity.TransportAirplane;
import entity.fly_company.FlyCompany;
import service.AirportService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        FlyCompany flyCompany = new FlyCompany("Belavia");

        flyCompany.add(new PassengerAirplane("A380",350,2300,3500));
        flyCompany.add(new PassengerAirplane("777",400,2600,4000));
        flyCompany.add(new PassengerAirplane("737",300,2550,3000));
        flyCompany.add(new PassengerAirplane("A310",200,4400,4000));
        flyCompany.add(new PassengerAirplane("A320",150,2600,6500));
        flyCompany.add(new PassengerAirplane("A330",290,2000,12000));

        flyCompany.add(new TransportAirplane("АН-225",200,4000,4000));
        flyCompany.add(new TransportAirplane("АН-124",150,3700,4800));
        flyCompany.add(new TransportAirplane("747-400",180,3400,5000));

        /////////////////////////////////////////////////////////////////////////////////////////////

        int totalPassengerValue = AirportService.totalPassengerValue(flyCompany);
        PrintMainInfo.printInfo(totalPassengerValue);

        /////////////////////////////////////////////////////////////////////////////////////////////

        int totalCargoValue = AirportService.totalCargoValue(flyCompany);
        PrintMainInfo.printInfo(totalCargoValue);

        /////////////////////////////////////////////////////////////////////////////////////////////

        List<Airplane> sortAirplaneListByFlyRange = AirportService.sortAirplaneByFlyRange(flyCompany);
        PrintMainInfo.printInfo(sortAirplaneListByFlyRange);

        /////////////////////////////////////////////////////////////////////////////////////////////

        List<Airplane> airplaneListWithCorrectFuelConsumption
                = AirportService.searchAirplaneWithCorrectFuelConsumption(2000,2600,flyCompany);
        PrintMainInfo.printInfo(airplaneListWithCorrectFuelConsumption);

        /////////////////////////////////////////////////////////////////////////////////////////////

        airplaneListWithCorrectFuelConsumption
                = AirportService.searchAirplaneWithCorrectFuelConsumption(2800,4400,flyCompany);
        PrintMainInfo.printInfo(airplaneListWithCorrectFuelConsumption);
    }
}
