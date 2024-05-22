package co.edu.uptc.appcontact.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class LoginWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private PanelLeftLoginWindow panelLeftLoginWindow;
	private PanelRightLoginWindow panelRightLoginWindow;
	public LoginWindow() {
		this.panelLeftLoginWindow = new PanelLeftLoginWindow();
		this.panelRightLoginWindow = new PanelRightLoginWindow();
		/* Asignación de tamaños*/
		setSize(800, 480);
		/* Centrar la pantalla*/
		setLocationRelativeTo(null);
		/* Asignar layouts */
		setLayout(new BorderLayout());
		
		/* Adición de componente */
		add(panelLeftLoginWindow, BorderLayout.WEST);
		add(panelRightLoginWindow, BorderLayout.EAST);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		LoginWindow login = new LoginWindow();
		/* Propiedad para mostrar el componente en pantalla*/
		login.setVisible(Boolean.TRUE);
	}
}
