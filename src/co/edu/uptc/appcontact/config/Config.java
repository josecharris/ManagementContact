package co.edu.uptc.appcontact.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	/** Atributo que determina la instancia de configuración */
	private static Config config;
	
	/* Atributo que determina la instancia que contiene la información del archivo properties */
	private Properties propiedades;
	
	/* Atributo que determina la ruta donde se cuentra ubicado el archivo W*/
	private String path;
	
	/* Atributo que determina el nombre del archivo TXT */
	private String nameFileTXT;
	
	/* Atributo que determina el nombre del archivo XML */
	private String nameFileXML;
	
	private String nameFileJSON;
	
	private String nameFileCSV;
	
	private String nameFileSer;
	
	/* Atributo que determina el valor R del color principal de la aplicación */
	private String principalColorR;
	
	/* Atributo que determina el valor G del color principal de la aplicación */
	private String principalColorG;
	
	/* Atributo que determina el valor B del color principal de la aplicación */
	private String principalColorB;
	
	private Config() {
		this.propiedades= new Properties();
		try (FileInputStream entrada = new FileInputStream("resource/conf/appconfig.properties")) {
            propiedades.load(entrada);
            this.path = propiedades.getProperty("app.file.path.txt");
            this.nameFileTXT =  propiedades.getProperty("app.file.name.txt");
            this.nameFileXML = propiedades.getProperty("app.file.name.xml");
            this.nameFileJSON = propiedades.getProperty("app.file.name.json");
            this.nameFileCSV = propiedades.getProperty("app.file.name.csv");
            this.nameFileSer = propiedades.getProperty("app.file.name.ser");
            this.principalColorR = propiedades.getProperty("gui.principal.color.r");
            this.principalColorG = propiedades.getProperty("gui.principal.color.g");
            this.principalColorB = propiedades.getProperty("gui.principal.color.b");
        } catch (IOException ex) {
            System.err.println("Error al cargar el archivo properties de configuración: " + ex.getMessage());
        }
	}
	
	public static Config getInstance() {
		if(config == null) {
			config = new Config();
		}
		return config;
	}

	public Properties getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Properties propiedades) {
		this.propiedades = propiedades;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNameFileTXT() {
		return nameFileTXT;
	}

	public void setNameFileTXT(String nameFileTXT) {
		this.nameFileTXT = nameFileTXT;
	}

	public String getNameFileXML() {
		return nameFileXML;
	}

	public void setNameFileXML(String nameFileXML) {
		this.nameFileXML = nameFileXML;
	}

	public String getNameFileJSON() {
		return nameFileJSON;
	}

	public void setNameFileJSON(String nameFileJSON) {
		this.nameFileJSON = nameFileJSON;
	}

	public String getNameFileCSV() {
		return nameFileCSV;
	}

	public void setNameFileCSV(String nameFileCSV) {
		this.nameFileCSV = nameFileCSV;
	}

	public String getNameFileSer() {
		return nameFileSer;
	}

	public void setNameFileSer(String nameFileSer) {
		this.nameFileSer = nameFileSer;
	}

	public String getPrincipalColorR() {
		return principalColorR;
	}

	public void setPrincipalColorR(String principalColorR) {
		this.principalColorR = principalColorR;
	}

	public String getPrincipalColorG() {
		return principalColorG;
	}

	public void setPrincipalColorG(String principalColorG) {
		this.principalColorG = principalColorG;
	}

	public String getPrincipalColorB() {
		return principalColorB;
	}

	public void setPrincipalColorB(String principalColorB) {
		this.principalColorB = principalColorB;
	}
	
}
