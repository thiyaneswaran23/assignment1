package com.securin.cpeapi.xmlparser;

import com.securin.cpeapi.model.CpeEntity;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class XmlParser {

    public static List<CpeEntity> parse(File xmlFile) throws Exception {

        List<CpeEntity> list = new ArrayList<>();

        DocumentBuilder builder =
                DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        NodeList items = doc.getElementsByTagName("cpe-item");

        for (int i = 0; i < items.getLength(); i++) {

            Element item = (Element) items.item(i);

            String title = item.getElementsByTagName("title")
                    .item(0).getTextContent();

            String cpe22 = item.getAttribute("name");

            String cpe23 = null;
            NodeList cpe23Nodes = item.getElementsByTagName("cpe23-item");
            if (cpe23Nodes.getLength() > 0) {
                cpe23 = ((Element) cpe23Nodes.item(0)).getAttribute("name");
            }

            List<String> refs = new ArrayList<>();
            NodeList refNodes = item.getElementsByTagName("reference");
            for (int j = 0; j < refNodes.getLength(); j++) {
                refs.add(((Element) refNodes.item(j)).getAttribute("href"));
            }

            CpeEntity entity = new CpeEntity();
            entity.setCpeTitle(title);
            entity.setCpe22Uri(cpe22);
            entity.setCpe23Uri(cpe23);
            entity.setReferenceLinks(refs);

            list.add(entity);
        }
        return list;
    }
}