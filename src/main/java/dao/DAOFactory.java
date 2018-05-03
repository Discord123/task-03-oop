package dao;

import dao.impl.AirplaneXMLDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final AirplaneXMLDAO airplaneXMLDAO = new AirplaneXMLDAOImpl();

    private DAOFactory() {}

    public AirplaneXMLDAO getAirplaneXMLDAO() {
        return airplaneXMLDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
