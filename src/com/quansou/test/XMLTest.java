package com.quansou.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;

public class XMLTest {
    public static  void  main(String[] args) throws Exception{
        //DomParse();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(XMLTest.class.getClassLoader().getResourceAsStream("a.xml"));
        while(reader.hasNext()){
            int event = reader.next();
            if (XMLStreamConstants.START_ELEMENT == event){
                System.out.print(reader.getLocalName() + ":");
            }else if (XMLStreamConstants.CHARACTERS == event){
                System.out.println(reader.getText().trim());
            }
        }
    }

    public static void DomParse() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = fac.newDocumentBuilder();
        Document doc = db.parse(XMLTest.class.getClassLoader().getResourceAsStream("a.xml"));
        Element root = doc.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        for(int i = 0;i<nodeList.getLength();i++){
            if (nodeList.item(i) instanceof Element){
                Element node = (Element)nodeList.item(i);
                NodeList children = node.getChildNodes();
                for (int j = 0;j<children.getLength();j++){
                    if (children.item(j) instanceof Element){
                        Text child = (Text)children.item(j).getFirstChild();
                        System.out.println(children.item(j).getNodeName() + ":" + child.getData().trim());
                    }
                }
            }
        }
    }
}
