package dao.impl;

import dao.AirplaneXMLDAO;
import entity.Airplane;
import entity.PassengerAirplane;
import entity.TransportAirplane;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class AirplaneXMLDAOImpl implements AirplaneXMLDAO {

    private static final Logger LOGGER = LogManager.getLogger(AirplaneXMLDAOImpl.class);
    private static final ClassLoader CLASS_LOADER = AirplaneXMLDAO.class.getClassLoader();
    private static final String FILE_PATH = CLASS_LOADER.getResource("airplane_db.xml").toString();
    private static final List<Airplane> airplaneList = new ArrayList<>();

    @Override
    public List<Airplane> createAirplaneList() {

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(FILE_PATH);
            airplaneList.addAll(buildXMLObjectList(document));
        } catch (ParserConfigurationException | SAXException e) {
            LOGGER.log(Level.ERROR,"XMLBuilder error in createAirplaneList");
        } catch (IOException e) {
            LOGGER.log(Level.ERROR,"IO Error in createAirplaneList");
        } catch (NullPointerException e) {
            LOGGER.log(Level.ERROR,"NullPointerException in createAirplaneList");
        }

        return airplaneList;
    }

    private static List<Airplane> buildXMLObjectList(Document document) {

        List<Airplane> airplanes = new ArrayList<>();

        Node root = document.getDocumentElement();

        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node airplane = childNodes.item(i);
            if (airplane.getNodeType() != Node.TEXT_NODE) {
                NodeList airplaneValues = airplane.getChildNodes();
                List<String> list = new ArrayList<>();
                for (int j = 0; j < airplaneValues.getLength(); j++) {
                    Node airplaneVal = airplaneValues.item(j);
                    if (airplaneVal.getNodeType() != Node.TEXT_NODE) {
                        list.add(airplaneVal.getTextContent());
                        if (list.size() == 5) {
                            airplanes.add(createAirplane(list));
                        }
                    }
                }
            }
        }
        return airplanes;
    }

    private static Airplane createAirplane(List<String> list) {
        Airplane airplane = null;
        if (list.get(0).equals("PA")){
            airplane = new PassengerAirplane(list.get(1),Integer.parseInt(list.get(2)),
                    Integer.parseInt(list.get(3)),Integer.parseInt(list.get(4)));
        }
        if (list.get(0).equals("TA")){
            airplane = new TransportAirplane(list.get(1),Integer.parseInt(list.get(2)),
                    Integer.parseInt(list.get(3)),Integer.parseInt(list.get(4)));
        }
        return airplane;
    }
}
