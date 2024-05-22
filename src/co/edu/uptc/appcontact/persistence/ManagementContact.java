package co.edu.uptc.appcontact.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import co.edu.uptc.appcontact.constants.CommonConstants;
import co.edu.uptc.appcontact.enums.ETypeFile;
import co.edu.uptc.appcontact.model.Contact;
import co.uptc.edu.appcontact.interfaces.IActionFile;

public class ManagementContact extends FilePlain implements IActionFile {
	private final String NAME_TAG_CONTACT = "contact";
	private List<Contact> listContact;
	
	public ManagementContact() {
		this.listContact = new ArrayList<>();
	}
	
	public void addContact(Contact contact) {
		listContact.add(contact);
	}
	
	public void deleteContactByName(String name) {
		if(!Objects.isNull(findContactByName(name))) {
			this.listContact.remove(findContactByName(name));
		}
	}
	
	public Contact findContactByName(String name) {
		for(Contact contact: this.listContact) {
			if(contact.getName().equals(name)) {
				return contact;
			}
		}
		return null;
	}
	
	
	
	@Override
	public void dumpFile(ETypeFile eTypeFile) {
		if(ETypeFile.TXT.equals(eTypeFile)) {
			this.dumpFilePlain(confValue.getPath().concat(confValue.getNameFileTXT()));
		}
		if(ETypeFile.XML.equals(eTypeFile)) {
			this.dumpFileXML();
		}
		if(ETypeFile.JSON.equals(eTypeFile)) {
			this.dumpFileJSON();
		}
		if(ETypeFile.CSV.equals(eTypeFile)) {
			this.dumpFileCSV(confValue.getPath().concat(confValue.getNameFileCSV()));
		}
		if(ETypeFile.SERIALIZATE.equals(eTypeFile)) {
			this.dumpFileSerializate();
		}
	}

	@Override
	public void loadContact(ETypeFile eTypeFile) {
		if(ETypeFile.TXT.equals(eTypeFile)) {
			this.loadFilePlain(confValue.getPath().concat(confValue.getNameFileTXT()));
		}
		if(ETypeFile.XML.equals(eTypeFile)) {
			this.loadFileXML();
		}
		if(ETypeFile.JSON.equals(eTypeFile)) {
			this.loadFileJSON();
		}
		if(ETypeFile.CSV.equals(eTypeFile)) {
			this.loadFileCSV(confValue.getPath().concat(confValue.getNameFileCSV()));
		}
		if(ETypeFile.SERIALIZATE.equals(eTypeFile)) {
			this.loadFileSerializate();
		}
	}
	
	private void dumpFilePlain(String rutaArchivo) {
		List<String> records = new ArrayList<>();
		 for(Contact contact : listContact){
			 StringBuilder contentContact = new StringBuilder();
			 contentContact.append(contact.getName()).append(CommonConstants.SEMI_COLON);
			 contentContact.append(contact.getCodDoc()).append(CommonConstants.SEMI_COLON);
			 contentContact.append(contact.getPhoneNumber()).append(CommonConstants.SEMI_COLON);
			 contentContact.append(contact.getEmail()).append(CommonConstants.SEMI_COLON);
			 contentContact.append(contact.getCountryCode());
			 records.add(contentContact.toString());
		 }
		 this.writer(rutaArchivo, records);
	}
	
	private void loadFilePlain(String rutaNombreArchivo) {
		List<String> contentInLine = this.reader(rutaNombreArchivo);
		contentInLine.forEach(row -> {
			StringTokenizer tokens = new StringTokenizer(row, CommonConstants.SEMI_COLON);
			while(tokens.hasMoreElements()){
				String name = tokens.nextToken();
				String codDoc = tokens.nextToken();
				String phoneNumber = tokens.nextToken();
				String email = tokens.nextToken();
				String countryCode = tokens.nextToken();
				listContact.add(new Contact(name, codDoc, phoneNumber, email, countryCode));
			}
		});
	}
	
	private void dumpFileCSV(String rutaArchivo) {
		this.dumpFilePlain(rutaArchivo);
	}
	
	private void loadFileCSV(String rutaArchivo) {
		this.loadFilePlain(rutaArchivo);
	}
	
	private void dumpFileXML() {
		String rutaArchivo = confValue.getPath().concat(confValue.getNameFileXML());
		StringBuilder lines = new StringBuilder();
		lines.append("<XML version=\"1.0\" encoding=\"UTF-8\"> \n");
		for (Contact contact : this.listContact) {
			lines.append("<contact>\n");
			lines.append("<name>"+contact.getName()+"</name>\n");
			lines.append("<codDoc>"+contact.getCodDoc()+"</codDoc>\n");
			lines.append("<phoneNumber>"+contact.getPhoneNumber()+"</phoneNumber>\n");
			lines.append("<email>"+contact.getEmail()+"</email>\n");
			lines.append("<countryCode>"+contact.getCountryCode()+"</countryCode>\n");
			lines.append("</contact>\n");
		}
		lines.append("</XML>");
		this.writeFile(rutaArchivo, lines.toString());
	}
	
	private void loadFileXML() {
		try {
			File file = new File(confValue.getPath().concat(confValue.getNameFileXML()));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			NodeList list = document.getElementsByTagName(NAME_TAG_CONTACT);
			for (int i = 0; i < list.getLength(); i++) {
				String name = document.getElementsByTagName("name").item(i).getTextContent();
				String codDoc = document.getElementsByTagName("codDoc").item(i).getTextContent();
				String phoneNumber = document.getElementsByTagName("phoneNumber").item(i).getTextContent();
				String email = document.getElementsByTagName("email").item(i).getTextContent();
				String countryCode = document.getElementsByTagName("countryCode").item(i).getTextContent();
				this.listContact.add(new Contact(name, codDoc, phoneNumber, email, countryCode));
			}
		}catch(Exception e) {
			System.out.println("Se presentó un error en el cargue del archivo XML");
		}
	}
	
	private void dumpFileJSON() {
		String rutaArchivo = confValue.getPath().concat(confValue.getNameFileJSON());
		StringBuilder stringJSON = new StringBuilder();
		stringJSON.append("[\n");
		for(int i=0; i<this.listContact.size(); i++) {
			stringJSON.append("{\n");
			stringJSON.append("\"name\":\"").append(listContact.get(i).getName())
				.append("\",\n");
			stringJSON.append("\"codDoc\":\"").append(listContact.get(i).getCodDoc())
				.append("\",\n");
			stringJSON.append("\"phoneNumber\":\"").append(listContact.get(i)
					.getPhoneNumber()).append("\",\n");
			stringJSON.append("\"email\":\"").append(listContact.get(i).getEmail())
				.append("\",\n");
			stringJSON.append("\"countryCode\":\"").append(listContact.get(i)
					.getCountryCode()).append("\"\n");
			stringJSON.append("}");
			if(i < this.listContact.size() - 1) {
				stringJSON.append(", \n");
			}else {
				stringJSON.append("\n");
			}
		}
		stringJSON.append("]");
		this.writeFile(rutaArchivo, stringJSON.toString());
	}
	
	private void loadFileJSON() {
		StringBuilder fileName = new StringBuilder();
		fileName.append(this.confValue.getPath());
		fileName.append(this.confValue.getNameFileJSON());
		String content = this.readFile(fileName.toString());
		content = content.trim();
		
		// Eliminar los corchetes inicial y final
        if (content.startsWith("[") && content.endsWith("]")) {
        	content = content.substring(1, content.length() - 1);
        }
        
        // Dividir por "},{" para obtener cada objeto individual
        String[] objects = content.split("\\}, \n\\{");
        for (String obj : objects) {
        	// Eliminar posibles llaves restantes
            obj = obj.replace("{", "").replace("}", "");
            String[] fields = obj.split(",");
            String name = "", codDoc = "", phoneNumber = "", email = "", countryCode = "";
            for(String field: fields) {
            	String[] keyValue = field.split(":");
            	String key = keyValue[0].trim().replace("\"", "");
                String value = keyValue[1].trim().replace("\"", "");
                switch(key) {
	                case "name":
	                	name = value;
	                	break;
	                case "codDoc":
	                	codDoc = value;
	                	break;
	                case "phoneNumber":
	                	phoneNumber = value;
	                	break;
	                case "email":
	                	email = value;
	                	break;
	                case "countryCode":
	                	countryCode = value;
	                	break;
                }
            }
            this.listContact.add(new Contact(name, codDoc, phoneNumber, email, countryCode));
        }
	}
	
	private void dumpFileSerializate() {
		try (FileOutputStream fileOut = new FileOutputStream(
				this.confValue.getPath()
				.concat(this.confValue.getNameFileSer()));
	             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
	            out.writeObject(this.listContact);
	    } catch (IOException i) {
	    	i.printStackTrace();
	    }
	}
	
	@SuppressWarnings("unchecked")
	private void loadFileSerializate() {
		try (FileInputStream fileIn = new FileInputStream(
				this.confValue.getPath()
				.concat(this.confValue.getNameFileSer()));
	             ObjectInputStream in = new ObjectInputStream(fileIn)) {
	            this.listContact = (List<Contact>) in.readObject();
	        } catch (IOException i) {
	            i.printStackTrace();
	        } catch (ClassNotFoundException c) {
	            c.printStackTrace();
	        }
	}

	public List<Contact> getListContact() {
		return listContact;
	}

	public void setListContact(List<Contact> listContact) {
		this.listContact = listContact;
	}
	
}
