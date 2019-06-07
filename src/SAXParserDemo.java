import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXParserDemo {

    public static void main(String[] args) {

        try {
            File inputFile = new File("C:\\Users\\Hristo Panayotov\\Documents\\dataBaseDemo\\src\\resource\\new.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    class UserHandler extends DefaultHandler {

        boolean bName = false;
        boolean bTitle = false;
        boolean bPrice = false;


        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("catalog")) {
                String rollNo = attributes.getValue("id");
                System.out.println("Catalog : " + rollNo);
            } else if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            } else if (qName.equalsIgnoreCase("price")) {
                bPrice = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("catalog")) {
                System.out.println("End Element :" + qName);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("name: " + new String(ch, start, length));
                bName = false;
            } else if (bTitle) {
                System.out.println("title: " + new String(ch, start, length));
                bTitle = false;
            } else if (bPrice) {
                System.out.println("price: " + new String(ch, start, length));
                bPrice = false;
            }
        }
    }





