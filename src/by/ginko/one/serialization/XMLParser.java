package by.ginko.one.serialization;


import by.ginko.one.Worker;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
public class XMLParser {
    public static boolean checkXMLforXSD(String pathXml, String pathXsd)
    {
        try {
            File xml = new File(pathXml);
            File xsd = new File(pathXsd);

            if (!xml.exists()) {
                System.out.println("Не найден XML " + pathXml);
            }

            if (!xsd.exists()) {
                System.out.println("Не найден XSD " + pathXsd);
            }

            if (!xml.exists() || !xsd.exists()) {
                return false;
            }

            SchemaFactory factory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(pathXsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(pathXml));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public static ArrayList<Worker> xmlParserMethod(String filepath){
        ArrayList<Worker> trucks = new ArrayList<Worker>();
        try {

            // Получение фабрики, чтобы после получить билдер документов.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
            Document document = dBuilder.parse(filepath);

            // Получение списка всех элементов employee внутри корневого элемента (getDocumentElement возвращает ROOT элемент XML файла).
            NodeList CarsElements = document.getDocumentElement().getElementsByTagName("Person");

            for(int i=0; i< CarsElements.getLength();i++)
            {
                Worker buffTruck = new Worker();
                Node nTruck = CarsElements.item(i);
                if (nTruck.getNodeType() == Node.ELEMENT_NODE) {
                    Element carElem = (Element) nTruck;

                    buffTruck.setName(carElem.getElementsByTagName("name").item(0).getTextContent());
                    buffTruck.setofficehours(Integer.parseInt(carElem.getElementsByTagName("office_hours").item(0).getTextContent()));
                    trucks.add(buffTruck);
                }


            }
            return trucks;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return trucks;
    }
}

