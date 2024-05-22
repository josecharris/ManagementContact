package co.edu.uptc.appcontact.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ManagementEvents implements ActionListener{
	
	private static ManagementEvents managementEvents;
	public static final String VERIFY_CREDENTIALS = "VERIFY_CREDENTIALS";
	
	private ManagementEvents() { }
	public static ManagementEvents getInstance() {
		if(Objects.isNull(managementEvents)) {
			managementEvents = new ManagementEvents();
		}
		return managementEvents;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case VERIFY_CREDENTIALS:
				System.out.println("Presionado botón de credenciales.");
				 break;
		}
		
	}

}
