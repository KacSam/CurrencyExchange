package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class Parser {
    public void parse(String xmlData, CurrencyCollection currencyCollection) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xmlData)));

        document.getDocumentElement().normalize();

        NodeList rateList = document.getElementsByTagName("Rate");


        for (int i = 0; i < rateList.getLength(); i++) {
            Node rateNode = rateList.item(i);

            if (rateNode.getNodeType() == Node.ELEMENT_NODE) {
                Element rateElement = (Element) rateNode;


                String currencyName = rateElement.getElementsByTagName("Currency").item(0).getTextContent();

                String code = rateElement.getElementsByTagName("Code").item(0).getTextContent();

                double mid = Double.parseDouble(rateElement.getElementsByTagName("Mid").item(0).getTextContent());

                Currency currency = new Currency(code, currencyName, mid);
                currencyCollection.add(currency);
            }
        }
    }
}
