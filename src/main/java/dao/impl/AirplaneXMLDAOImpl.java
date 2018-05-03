package dao.impl;

import dao.AirplaneXMLDAO;
import entity.Airplane;
import entity.PassengerAirplane;
import entity.TransportAirplane;
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

public class AirplaneXMLDAOImpl implements AirplaneXMLDAO {

    @Override
    public List<Airplane> createAirplaneList() {
        DocumentBuilder documentBuilder;
        Document document = null;
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = documentBuilder.parse("D://Java/task-03-oop/src/main/resources/airplane_db.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Node root = document.getDocumentElement();

        NodeList airplanes = root.getChildNodes();

        List<Airplane> airplaneList = new ArrayList<>();

        for (int i = 0; i < airplanes.getLength(); i++) {
            Node airplane = airplanes.item(i);
            if (airplane.getNodeType() != Node.TEXT_NODE) {
                NodeList airplaneVals = airplane.getChildNodes();
                List<String> list = new ArrayList<>();
                for (int j = 0; j < airplaneVals.getLength(); j++) {
                    Node airplaneVal = airplaneVals.item(j);
                    if (airplaneVal.getNodeType() != Node.TEXT_NODE) {
                        list.add(airplaneVal.getTextContent());
                        if(list.size() == 5){
                            if (list.get(0).equals("PA")){
                                airplaneList.add(new PassengerAirplane(list.get(1),Integer.parseInt(list.get(2)),
                                        Integer.parseInt(list.get(3)),Integer.parseInt(list.get(4))));
                            }
                            if (list.get(0).equals("TA")){
                                airplaneList.add(new TransportAirplane(list.get(1),Integer.parseInt(list.get(2)),
                                        Integer.parseInt(list.get(3)),Integer.parseInt(list.get(4))));
                            }
                        }
                    }
                }
            }
        }
        return airplaneList;
    }
}
