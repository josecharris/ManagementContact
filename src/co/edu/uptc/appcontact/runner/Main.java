package co.edu.uptc.appcontact.runner;

import co.edu.uptc.appcontact.enums.ETypeFile;
import co.edu.uptc.appcontact.model.Contact;
import co.edu.uptc.appcontact.persistence.ManagementContact;

public class Main {

	private ManagementContact management = new ManagementContact();
	public static void main(String[] args) {
		Main main = new Main();
		/* Este método crea información en el archivo plano */
		//main.dumpContactPlain();
		
		/* Este método reconoce la información cargada del archivo plano */
		//main.loadContactPlain();
		
		//main.dumpContactJSON();
		//main.loadContactJSON();
		
		//main.dumpContactCSV();
		//main.loadContactCSV();
		//main.dumpContactSer();
		main.loadContactSer();
	}
	
	public void dumpContactSer() {
		/* Se agrega información a la memoría temporal del sistema */
		management.addContact(new Contact("jose", "201511883", "1234", 
				"jose@uptc.edu.co", "COL"));
		/* Se realiza el volcado al archivo plano */
		management.dumpFile(ETypeFile.SERIALIZATE);
	}
	
	public void loadContactSer() {
		management.loadContact(ETypeFile.SERIALIZATE);
		System.out.println("Del archivo se cargaron " 
		+ management.getListContact().size() + " registros.");
		
		management.getListContact().forEach(infoContact -> {
			System.out.println(infoContact);
		});
	}
	
	public void dumpContactCSV() {
		/* Se agrega información a la memoría temporal del sistema */
		management.addContact(new Contact("jose", "201511883", "1234", 
				"jose@uptc.edu.co", "COL"));
		
		/* Se realiza el volcado al archivo plano */
		management.dumpFile(ETypeFile.CSV);
	}
	
	public void loadContactCSV() {
		management.loadContact(ETypeFile.CSV);
		System.out.println("Del archivo se cargaron " 
		+ management.getListContact().size() + " registros.");
		
		management.getListContact().forEach(infoContact -> {
			System.out.println(infoContact);
		});
	}
	
	public void dumpContactPlain() {
		/* Se agrega información a la memoría temporal del sistema */
		management.addContact(new Contact("jose", "201511883", "1234", 
				"jose@uptc.edu.co", "COL"));
		
		/* Se realiza el volcado al archivo plano */
		management.dumpFile(ETypeFile.TXT);
	}
	
	public void loadContactPlain() {
		management.loadContact(ETypeFile.TXT);
		System.out.println("Del archivo se cargaron " 
		+ management.getListContact().size() + " registros.");
		
		management.getListContact().forEach(infoContact -> {
			System.out.println(infoContact);
		});
	}
	
	public void dumpContactJSON() {
		management.addContact(new Contact("jose", "201511883", "1234", 
				"jose@uptc.edu.co", "COL"));
		management.addContact(new Contact("jose", "201511883", "1234", 
				"jose@uptc.edu.co", "COL"));
		management.dumpFile(ETypeFile.JSON);
	}
	
	public void loadContactJSON() {
		management.loadContact(ETypeFile.JSON);
		System.out.println("Del archivo se cargaron " + management.getListContact().size() + " registros.");
				
		management.getListContact().forEach(infoContact -> {
			System.out.println(infoContact);
		});
	}

}
