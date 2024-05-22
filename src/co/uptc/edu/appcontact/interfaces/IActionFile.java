package co.uptc.edu.appcontact.interfaces;

import co.edu.uptc.appcontact.enums.ETypeFile;

public interface IActionFile {
	public void dumpFile(ETypeFile eTypeFile);
	public void loadContact(ETypeFile eTypeFile);
}
