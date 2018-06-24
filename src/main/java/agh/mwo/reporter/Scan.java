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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Scan {
	// ta funkcja eksploruje wszystkie podfoldery i zwraca w arrayli�cie string�w
	// �cie�ki do plik�w z rozszerzeneim .xls
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

	// funkcja ze �cie�ki wczytuje plik eksela ekstrahuj�c imi� i nazwisko, iteruje
	// po zak�adkach nazwa zak�adki=>project
	public static ArrayList<Task> readXls(String path) {
		ArrayList<Task> toReturn = new ArrayList<Task>();
		ArrayList<String> errorLog = new ArrayList<String>();
		try {
			Workbook wb = WorkbookFactory.create(new File(path));
				String fullPath = path;
				//System.out.println(fullPath);
				int startOfName = fullPath.lastIndexOf("_")+1;
				int endOfname = fullPath.lastIndexOf(".");
				int startOfSurname = fullPath.lastIndexOf("\\")+1;		
				String name = new String(fullPath.substring(startOfName, endOfname));
				String surname = new String(fullPath.substring(startOfSurname, startOfName-1));
			// iteruj� po sheetach
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				Sheet sheet = wb.getSheetAt(i);
				String project = sheet.getSheetName();
				for (int j = 1; j <= sheet.getLastRowNum(); j++) {
					Row r = sheet.getRow(j);
					//obsługa złych lub pustych komórek
					Cell c0 = r.getCell(0);
					Cell c1 = r.getCell(1);
					Cell c2 = r.getCell(1);
					if(c0 == null) {
						errorLog.add("Cell 0 at row " + j + " in file " + path + " is null");
						break;
					}
					if(c1 == null) {
						errorLog.add("Cell 1 at row " + j + " in file " + path + " is null");
						break;
					}
					if(c2 == null) {
						errorLog.add("Cell 2 at row " + j + " in file " + path + " is null");
						break;
					}
					
					//inicjalicacja zmiennych
					LocalDate localDate;
					String description;
					double hours;
					
					
					
					//sprawdzanie poprawności czytanych danych
					try {
					Date date = r.getCell(0).getDateCellValue();
					localDate= date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					} catch (Exception e)
					{
						errorLog.add("Cell 0 at row " + j + " in file " + path + " is not a date");
						break;
					}
					
					try {
						description = r.getCell(1).getStringCellValue();
						if(description.isEmpty()) {
							errorLog.add("Description at row " + j + " in file " + path + " is blank");
							break;	
						}
					} catch (Exception e)
					{
						errorLog.add("Cell 1 at row " + j + " in file " + path + " is not a string");
						break;
					}
					
					try {
						hours = r.getCell(2).getNumericCellValue();
					} catch (Exception e)
					{
						errorLog.add("Cell 2 at row " + j + " in file " + path + " is not a numeric");
						break;
					}
					
					if(hours>16) {
						errorLog.add("Cell 2 at row " + j + " in file " + path + " shows thas someone is working too hard!");
						break;
					}
					
					
					
					
					
					//tworzenie obiektu
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
		
		//printowanie błędów wczytywania
		if(errorLog.size()==0) {
			//System.out.println("No error encountered during .xls reading.");
		}
		else {
			System.out.println("Error(s) encounter during .xls reading:");
			for (int i = 0; i<errorLog.size(); i++) {
				System.out.println(errorLog.get(i));
			}
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
			//toReturn.addAll(toProcess);
		}
		return toReturn;
	}

}
