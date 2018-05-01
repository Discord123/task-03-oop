package main;

import entity.Airplane;
import entity.PassengerAirplane;
import entity.TransportAirplane;
import entity.fly_company.FlyCompany;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.AirportService;
import service.ServiceFactory;
import service.impl.AirportServiceImpl;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            ServiceFactory factory = ServiceFactory.getInstance();
            AirportService service = factory.getAirportService();

            FlyCompany flyCompany = new FlyCompany("Belavia");

            flyCompany.addAirplane(new PassengerAirplane("A380", 350, 2300, 3500));
            flyCompany.addAirplane(new PassengerAirplane("777", 400, 2600, 4000));
            flyCompany.addAirplane(new PassengerAirplane("737", 300, 2550, 3000));
            flyCompany.addAirplane(new PassengerAirplane("A310", 200, 4400, 4000));
            flyCompany.addAirplane(new PassengerAirplane("A320", 150, 2600, 6500));
            flyCompany.addAirplane(new PassengerAirplane("A330", 290, 2000, 12000));

            flyCompany.addAirplane(new TransportAirplane("АН-225", 200, 4000, 4000));
            flyCompany.addAirplane(new TransportAirplane("АН-124", 150, 3700, 4800));
            flyCompany.addAirplane(new TransportAirplane("747-400", 180, 3400, 5000));

            /////////////////////////////////////////////////////////////////////////////////////////////

            int totalPassengerValue = service.totalPassengerValue(flyCompany);
            PrintMainInfo.printInfo("total passenger value = " + totalPassengerValue);

            /////////////////////////////////////////////////////////////////////////////////////////////

            int totalCargoValue = service.totalCargoValue(flyCompany);
            PrintMainInfo.printInfo("total cargo value = " + totalCargoValue);

            /////////////////////////////////////////////////////////////////////////////////////////////

            List<Airplane> sortAirplaneListByFlyRange = service.sortAirplaneByFlyRange(flyCompany);
            PrintMainInfo.printInfo(sortAirplaneListByFlyRange);

            /////////////////////////////////////////////////////////////////////////////////////////////

            List<Airplane> airplaneListWithCorrectFuelConsumption
                    = service.searchAirplaneWithCorrectFuelConsumption(2000, 2600, flyCompany);
            PrintMainInfo.printInfo(airplaneListWithCorrectFuelConsumption);

            /////////////////////////////////////////////////////////////////////////////////////////////

            airplaneListWithCorrectFuelConsumption
                    = service.searchAirplaneWithCorrectFuelConsumption(2800, 4400, flyCompany);
            PrintMainInfo.printInfo(airplaneListWithCorrectFuelConsumption);

        } catch (Exception e) {
            LOGGER.log(Level.FATAL,"Critical error in Main");
        }
    }
}
