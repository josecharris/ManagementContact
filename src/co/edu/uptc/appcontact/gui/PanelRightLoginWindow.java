package co.edu.uptc.appcontact.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelRightLoginWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel lblTitleApp;
	private JLabel lblUserName;
	private StyledTextField inputUserNameField;
	private JLabel lblPassword;
	private StyledTextField inputPasswordField;
	private JButton buttonSignUp;
	
	public PanelRightLoginWindow() {
		this.initComponents();
		this.buildComponent();
	}
	
	private void initComponents() {
		this.lblTitleApp = new JLabel("				TITULO");
		this.lblUserName = new JLabel("  Usuario");
		this.lblPassword = new JLabel("  Contraseña");
		this.inputUserNameField = new StyledTextField();
		this.inputPasswordField = new StyledTextField();
		this.buttonSignUp = new JButton("Aceptar");
		this.buttonSignUp.setActionCommand(ManagementEvents.VERIFY_CREDENTIALS);
		this.buttonSignUp.addActionListener(ManagementEvents.getInstance());
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de construir los componentes
	 * propios del panel
	 * @author jcharris
	 */
	private void buildComponent() {
		this.defineLayout();
		this.defineStyles();
		this.defineFonts();
		this.addComponents();
	}
	
	private void defineLayout() {
		setBackground(Color.WHITE);
        setLayout(new GridLayout(12, 2));
	}
	
	private void defineStyles() {
		this.buttonSignUp.setBackground(GUIUtils.getPrincipalColor());
		this.buttonSignUp.setForeground(Color.WHITE);
	}

	private void defineFonts() {
		try {
			Font customFontTitle = Font.createFont(Font.TRUETYPE_FONT, 
					new File("fonts/roboto/Roboto-Regular.ttf")).deriveFont(26f);
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, 
					new File("fonts/roboto/Roboto-Regular.ttf")).deriveFont(20f);
			this.lblTitleApp.setFont(customFontTitle);
			this.lblUserName.setFont(customFont);
			this.lblPassword.setFont(customFont);
			this.buttonSignUp.setFont(customFont);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addComponents() {
		JPanel panelSeparator1 = new JPanel();
		JPanel panelSeparator2 = new JPanel();
		JPanel panelSeparator3 = new JPanel();
		JPanel panelSeparator4 = new JPanel();
		panelSeparator1.add(this.lblTitleApp);
		panelSeparator1.setBackground(Color.WHITE);
		panelSeparator2.setBackground(Color.WHITE);
		panelSeparator3.setBackground(Color.WHITE);
		panelSeparator4.setBackground(Color.WHITE);
		add(panelSeparator1);
		/* Asignación del tamaño */
		setPreferredSize(new Dimension(484, 70));
        /* Nombre de usuario*/
		add(lblUserName);
		add(inputUserNameField);
		add(panelSeparator2);
		/* Contraseña*/
		add(lblPassword);
		add(inputPasswordField);
		add(panelSeparator3);
		add(panelSeparator4);
		add(this.buttonSignUp);
	}

}
