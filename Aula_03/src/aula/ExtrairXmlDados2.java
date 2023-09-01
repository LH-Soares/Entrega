package aula;

import java.io.File;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ExtrairXmlDados2 {

	public static void main(String[] args) {
		
        try {
            File inputFile = new File("alunos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("aluno");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nome = element.getElementsByTagName("nome").item(0).getTextContent();
                    System.out.println("Nome do aluno: " + nome);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	}


