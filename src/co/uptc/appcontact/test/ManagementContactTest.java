package co.uptc.appcontact.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import co.edu.uptc.appcontact.enums.ETypeFile;
import co.edu.uptc.appcontact.model.Contact;
import co.edu.uptc.appcontact.persistence.ManagementContact;

class ManagementContactTest {

	private ManagementContact managementContact = new ManagementContact();
	
	private void escenarieOne() {
		managementContact.addContact(new Contact("CODE1", "CC", "323848232", "jose.charris@uptc.edu.co", "COL"));
		managementContact.addContact(new Contact("CODE2", "CC", "323248752", "juan.perez@uptc.edu.co", "COL"));
		managementContact.addContact(new Contact("CODE3", "CC", "323238442", "pedro.hernandez@uptc.edu.co", "COL"));
		managementContact.addContact(new Contact("CODE4", "CC", "323232059", "maria.rodriguez@uptc.edu.co", "COL"));
		managementContact.addContact(new Contact("CODE5", "CC", "323232949", "angela.perez@uptc.edu.co", "COL"));
		managementContact.dumpFile(ETypeFile.XML);
		/* Se va a probar que se haya hecho el volcado sin errores */
	}
	
	private void escenarieTwo() {
		managementContact.setListContact(new ArrayList<>());
		managementContact.loadContact(ETypeFile.XML);
	}
	
	private void escenarieThree() {
		/* Se debe agregar registros a la memoria para realizar posteriormente el volcado*/
		managementContact.addContact(new Contact("CODE1", "CC", "323848232", "jose.charris@uptc.edu.co", "COL"));
		managementContact.addContact(new Contact("CODE2", "CC", "323248752", "juan.perez@uptc.edu.co", "MEX"));
		managementContact.addContact(new Contact("CODE3", "CC", "323238442", "pedro.hernandez@uptc.edu.co", "USA"));
		managementContact.addContact(new Contact("CODE4", "CC", "323232059", "maria.rodriguez@uptc.edu.co", "COL"));
		managementContact.addContact(new Contact("CODE5", "CC", "323232949", "angela.perez@uptc.edu.co", "PER"));
		/* Se vuelva toda la información al archivo plano */
		managementContact.dumpFile(ETypeFile.SERIALIZATE);
		/* Se vacía la información de la lista simulando una interrupción de la app */
		managementContact.setListContact(new ArrayList<>());
	}
	
	private void escenarieFour() {
		managementContact.loadContact(ETypeFile.SERIALIZATE);
	}
	
	private void escenarieFive() {
		this.escenarieThree();
		this.escenarieFour();
		managementContact.deleteContactByName("CODE1");
		managementContact.dumpFile(ETypeFile.SERIALIZATE);
	}
	
	private void escenarieSix() {
		managementContact.setListContact(new ArrayList<>());
		managementContact.loadContact(ETypeFile.SERIALIZATE);
	}
	
	@Test
	void testPersistenceXML() {
		this.escenarieOne();
		this.escenarieTwo();
		List<Contact> listContact = managementContact.getListContact();
		assertNotNull(listContact);
		/* Esperamos que hayan 5 registros*/
		assertEquals(5, listContact.size());
	}
	
	@Test
	void testPersistenceSerializate() {
		this.escenarieThree();
		this.escenarieFour();
		assertEquals(5, managementContact.getListContact().size());
	}
	
	@Test
	void testDeleteObject() {
		this.escenarieFive();
		this.escenarieSix();
		assertEquals(4, managementContact.getListContact().size());
		Contact contacto = managementContact.findContactByName("CODE1");
		assertNull(contacto);
	}

}
