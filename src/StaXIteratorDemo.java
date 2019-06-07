import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaXIteratorDemo {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

        File file = new File("new.xml");
        XMLInputFactory factory = XMLInputFactory.newInstance();

        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));

        List<Catalog> catalogList = new ArrayList<Catalog>();

        Catalog catalog = null;

        while (eventReader.hasNext())
        {
            XMLEvent xmlEvent = eventReader.nextEvent();

            if(xmlEvent.isStartElement()){
                StartElement startElement = xmlEvent.asStartElement();
                if("catalog".equalsIgnoreCase(startElement.getName().getLocalPart())){
                    catalog = new Catalog();
                }
                Iterator<Attribute> iterator = startElement.getAttributes();

                while (iterator.hasNext())
                {
                    Attribute attribute = iterator.next();
                    QName name = attribute.getName();
                    if("id".equalsIgnoreCase(name.getLocalPart())) {
                        catalog.setId(Integer.valueOf(attribute.getValue()));
                    }
                }
                switch (startElement.getName().getLocalPart())
                {
                    case "name":
                        Characters nameDataEvent = (Characters) eventReader.nextEvent();
                        catalog.setName(nameDataEvent.getData());
                        break;

                    case "title":
                        Characters titleDataEvent = (Characters) eventReader.nextEvent();
                        catalog.setTitle(titleDataEvent.getData());
                        break;

                    case "price":
                        Characters priceDataEvent = (Characters) eventReader.nextEvent();
                        catalog.setPrice(priceDataEvent.getData());
                        break;
                }
            }
            if (xmlEvent.isEndElement())
            {
                EndElement endElement = xmlEvent.asEndElement();

                if("catalog".equalsIgnoreCase(endElement.getName().getLocalPart())) {
                    catalogList.add(catalog);
                }
            }
        }
        for(Catalog x:catalogList){
        System.out.println(x);
        }
    }
}
