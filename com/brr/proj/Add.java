package com.brr.proj;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.IOException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.util.Scanner;

public class Add {
	public static void main(String[] args) {
		try {
			// Step 1: Parse the existing XML schema
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document schemaDoc = builder.parse(new File("src/add.xsd"));

			// Step 2: Create or modify the XML data
			Document xmlDoc = builder.newDocument();
			Element rootElement = xmlDoc.createElement("employees");
			xmlDoc.appendChild(rootElement);

			Element employee1 = xmlDoc.createElement("employee1");
			rootElement.appendChild(employee1);
			
//			// setting attribute to element
//			Attr attrEmp = xmlDoc.createAttribute("type");
//			attrEmp.setValue("fulltime"); // Replace "type" and "fulltime" with your attribute name and value
//			employee1.setAttributeNode(attrEmp);

			Element empid = xmlDoc.createElement("id");
			employee1.appendChild(empid);

			Scanner input = new Scanner(System.in);
			System.err.println("enter the employee id");
			String emp1id = input.next();
			empid.setTextContent(emp1id);
			employee1.appendChild(empid);

			Element empname = xmlDoc.createElement("name");
			employee1.appendChild(empname);

			System.err.println("enter the employee name");
			String emp1name = input.next();
			empname.setTextContent(emp1name);
			employee1.appendChild(empname);

			Element salary = xmlDoc.createElement("salary");
			employee1.appendChild(salary);

			System.err.println("enter the employee salary");
			String emp1salary = input.next();
			salary.setTextContent(emp1salary);
			employee1.appendChild(salary);
			
			//set attributes for element2
			System.out.println("enter the attribute value parttime/fulltime");
			String atr1=input.next();
			Attr attb1 = xmlDoc.createAttribute("type");
			attb1.setValue(atr1); // Replace "type" and "fulltime" with your attribute name and value
			employee1.setAttributeNode(attb1);
			

			Element employee2 = xmlDoc.createElement("employee2");
			rootElement.appendChild(employee2);
			
			Element emp2id = xmlDoc.createElement("id");
			employee2.appendChild(emp2id);

			System.err.println("enter the employee id");
			String empl2id = input.next();
			emp2id.setTextContent(empl2id);
			employee2.appendChild(emp2id);

			Element emp2name = xmlDoc.createElement("name");
			employee2.appendChild(emp2name);

			System.err.println("enter the employee name");
			String empl2name = input.next();
			emp2name.setTextContent(empl2name);
			employee2.appendChild(emp2name);

			Element emp2salary = xmlDoc.createElement("salary");
			employee2.appendChild(emp2salary);

			System.err.println("enter the employee salary");
			String empl2salary = input.next();
			emp2salary.setTextContent(empl2salary);
			employee2.appendChild(emp2salary);
            
			//set attributes for element2
			System.out.println("enter the attribute value parttime/fulltime");
			String atr2=input.next();
			Attr attb2 = xmlDoc.createAttribute("type");
			attb2.setValue(atr2); // Replace "type" and "fulltime" with your attribute name and value
			employee2.setAttributeNode(attb2);

			// Step 3: Serialize the data to an XML file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");// it is used for save the elements in xml for better readability. 
			DOMSource source = new DOMSource(xmlDoc);
			StreamResult result = new StreamResult(new File("src/add.xml"));
			transformer.transform(source, result);

			// Step 4: Validate the generated XML against the schema
			SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			Schema schema = schemaFactory.newSchema(new File("src/add.xsd"));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File("src/add.xml")));
			System.out.println("Validation successful: add.xml is valid against the schema.");
		} catch (Exception e) {
			System.err.println("Validation failed: " + e.getMessage());
		}
	}
}
