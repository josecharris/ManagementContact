package co.edu.uptc.appcontact.gui;

import java.awt.Color;

import co.edu.uptc.appcontact.config.Config;


public class GUIUtils {
	
	public static Color getPrincipalColor() { 
		return new Color(Integer.parseInt(Config.getInstance().getPrincipalColorR()), 
				Integer.parseInt(Config.getInstance().getPrincipalColorG()), 
				Integer.parseInt(Config.getInstance().getPrincipalColorB()));
	}
}
