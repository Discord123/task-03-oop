package main;

import entity.Airplane;
import entity.fly_company.FlyCompany;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import service.AirportService;
import service.ServiceFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static int totalPassengerValue;
    private static int totalCargoValue;
    private static List<Airplane> sortAirplaneListByFlyRange;
    private static List<Airplane> airplaneListWithCorrectFuelConsumption;

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        try {
            ServiceFactory factory = ServiceFactory.getInstance();
            AirportService service = factory.getAirportService();

            FlyCompany flyCompany = new FlyCompany("Belavia");

            List<Airplane> airplaneList = service.createAirplanes();
            flyCompany.setAirplaneList(airplaneList);

            /////////////////////////////////////////////////////////////////////////////////////////////


            totalPassengerValue = service.totalPassengerValue(flyCompany);
            PrintMainInfo.printInfo("total passenger value = " + totalPassengerValue);

            /////////////////////////////////////////////////////////////////////////////////////////////

            totalCargoValue = service.totalCargoValue(flyCompany);
            PrintMainInfo.printInfo("total cargo value = " + totalCargoValue);

            /////////////////////////////////////////////////////////////////////////////////////////////

            sortAirplaneListByFlyRange = service.sortAirplaneByFlyRange(flyCompany);
            PrintMainInfo.printInfo(sortAirplaneListByFlyRange);

            /////////////////////////////////////////////////////////////////////////////////////////////

            airplaneListWithCorrectFuelConsumption
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
