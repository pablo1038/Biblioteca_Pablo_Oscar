package biblioteca;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Archivo {
	private FileWriter fw;
	SimpleDateFormat date;
	SimpleDateFormat lineDate;

	public Archivo() {
		createFileWriter();
	}

	public void createFileWriter() {
		try {
			File file = new File("logs\\" + "Biblioteca.txt");
			file.getParentFile().mkdirs();
			fw = new FileWriter(file, true);
		} catch (IOException ex) {
			System.out.println(ex + "Directorio no encontrado");
		}
	}

	public void writeFile(String line) {
		try {
			fw.write(line + "\n");
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeWirter() {
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}