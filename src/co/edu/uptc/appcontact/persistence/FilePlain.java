package co.edu.uptc.appcontact.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import co.edu.uptc.appcontact.constants.CommonConstants;
import co.edu.uptc.appcontact.config.Config;

public class FilePlain {
	protected Config confValue;
	
	public FilePlain() {
		confValue = Config.getInstance();
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de leer el archivo agregando el carácter de salto de línea
	 * @author jcharris
	*/
	public String readFile(String rutaNombre) {
		StringBuilder contenido = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaNombre));
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append(CommonConstants.NEXT_LINE);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Se presentó un error al leer el archivo específicado");
        }
        return contenido.toString();
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de escribir en el archivo sobreescribiendo el contennido
	 * @author jcharris
	*/
	public void writeFile(String rutaNombreArchivo, String content) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaNombreArchivo))) {
			writer.write(content);
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	/**
	 * <b>Descripción:</b> Método encargado de la lectura y organización de las líneas encontradas en el fichero<br>
	 * @author jcharris
	 */
	protected List<String> reader(String rutaNombre){
		List<String> output = new ArrayList<>();
		StringTokenizer tokens = new StringTokenizer(this.readFile(rutaNombre), 
				CommonConstants.NEXT_LINE);
		while (tokens.hasMoreElements()) {
			output.add(tokens.nextToken());	
		}
		return output;
	}
	
	/**
	 * <b>Descripción:</b> Método encargado de la escritura en el fichero<br>
	 * @author jcharris
	 */
	protected void writer(String rutaNombre, List<String> file){
		StringBuilder strContent = new StringBuilder();
		file.forEach(record -> strContent.append(record)
				.append(CommonConstants.NEXT_LINE));
		writeFile(rutaNombre, strContent.toString());
	}
}
