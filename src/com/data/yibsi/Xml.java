package com.data.yibsi;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Xml {
    public String[][]readXml() throws Exception{

            File inputFile = new File(getClass().getClassLoader().getResource("cardInfo.xml").getFile());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("card");
            System.out.println("----------------------------");

            String[][] card = new String[nList.getLength()][3];

            for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Card Id : "
                            + eElement.getAttribute("id"));
                    card[temp][0] = eElement
                            .getElementsByTagName("name")
                            .item(0)
                            .getTextContent();
                    System.out.println("Name : "
                            + card[temp][0]);
                    card[temp][1] = eElement
                            .getElementsByTagName("meaning")
                            .item(0)
                            .getTextContent();
                    System.out.println("Meaning : "
                            + card[temp][1]);
                    card[temp][2] = eElement
                            .getElementsByTagName("image")
                            .item(0)
                            .getTextContent();
                    System.out.println("Image Source : "
                            + card[temp][2]);
                    System.out.println("----------------------------");
                }
            }
            return card;
    }
}
