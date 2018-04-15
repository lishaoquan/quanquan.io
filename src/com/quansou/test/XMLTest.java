package com.quansou.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLTest {
    public static  void  main(String[] args) throws Exception{
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
