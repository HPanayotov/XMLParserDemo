import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DOMParserDemo extends connect{

    private static Statement st;

    public DOMParserDemo() { }

    public static void main(String[] args) {

        String filePath = "C:\\Users\\Hristo Panayotov\\Documents\\dataBaseDemo\\src\\resource\\new.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("catalog");
            //now XML is loaded as Document in memory, lets convert it to Object List
            List<User> empList = new ArrayList<User>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                empList.add(getUser(nodeList.item(i)));
            }
            //lets print Employee list information
            for (User emp : empList) {
                System.out.println(emp.toString());
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private static User getUser(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        User emp = new User();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            emp.setName(getTagValue("name", element));
            emp.setTitle(getTagValue("title", element));
            emp.setPrice(Integer.parseInt(getTagValue("price", element)));
        }
        return emp;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
