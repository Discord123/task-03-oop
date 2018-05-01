package service;

import service.impl.AirportServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final AirportService airportService = new AirportServiceImpl();

    private ServiceFactory() {
    }

    public AirportService getAirportService() {
        return airportService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
