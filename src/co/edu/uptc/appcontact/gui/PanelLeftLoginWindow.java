package co.edu.uptc.appcontact.gui;

import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelLeftLoginWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelLeftLoginWindow() {
		/* Asignación del tamaño */
		setPreferredSize(new Dimension(300, getHeight()));
		/* Asignación del color */
		setBackground(GUIUtils.getPrincipalColor());
	}
}
