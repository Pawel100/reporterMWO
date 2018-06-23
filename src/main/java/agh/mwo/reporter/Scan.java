package agh.mwo.reporter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Scan {
	// ta funkcja eksploruje wszystkie podfoldery i zwraca w arrayliœcie stringów
	// œcie¿ki do plików z rozszerzeneim .xls
	public static ArrayList<String> exploreFolders(String path) {
		ArrayList<String> toReturn = new ArrayList<String>();

		File dir = new File(path);
		String[] extensions = new String[] { "xls", "xlsx" };
		try {
			dir.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
		for (File file : files) {
			try {
				toReturn.add(file.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return toReturn;
	}

	// funkcja ze œcie¿ki wczytuje plik eksela ekstrahuj¹c imiê i nazwisko, iteruje
	// po zak³adkach nazwa zak³adki=>project
	public static ArrayList<Task> readXls(String path) {
		ArrayList<Task> toReturn = new ArrayList<Task>();
		try {
			Workbook wb = WorkbookFactory.create(new File(path));
				String fullPath = path;
				//System.out.println(fullPath);
				int startOfName = fullPath.lastIndexOf("_")+1;
				int endOfname = fullPath.indexOf(".");
				int startOfSurname = fullPath.lastIndexOf("\\")+1;		
				String name = new String(fullPath.substring(startOfName, endOfname));
				String surname = new String(fullPath.substring(startOfSurname, startOfName-1));
			// iterujê po sheetach
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				Sheet sheet = wb.getSheetAt(i);
				String project = sheet.getSheetName();
				for (int j = 1; j <= sheet.getLastRowNum(); j++) {
					Row r = sheet.getRow(j);
					Date date = r.getCell(0).getDateCellValue();
					String description = r.getCell(1).getStringCellValue();
					double hours = r.getCell(2).getNumericCellValue();
					DateTimeFormatter formatter_3=DateTimeFormatter.ofPattern("dd/MM/yy");
					LocalDate localDate= date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					Task toAdd = new Task();
					toAdd.setDate(localDate);
					toAdd.setDescription(description);
					toAdd.setHours(hours);
					toAdd.setProject(project);
					toAdd.setName(name);
					toAdd.setSurname(surname);
					toReturn.add(toAdd);

				}

			}
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return toReturn;
	}

	public static ArrayList<Task> getAllRecords(String path) {
		ArrayList<Task> toReturn = new ArrayList<Task>();
		ArrayList<String> listOfFiles = exploreFolders(path);
		for (int i = 0; i < listOfFiles.size(); i++) {
			ArrayList<Task> toProcess = readXls(listOfFiles.get(i));
			for (int j = 0; j < toProcess.size(); j++) {
				toReturn.add(toProcess.get(j));
			}
		}
		return toReturn;
	}

}
