package agh.mwo.reporter;

import java.util.ArrayList;

public class Printer {

	public static String title = "Raport godzinowy";
	public static ArrayList<String> reportHeader;
	

	public static void main(String[] args) {
		
		//ArrayList<String> reportHeader = new ArrayList<String>();
		 ReportEmployees re = new ReportEmployees();
		 
		
		
		
		System.out.println(re.getTitle());
		for (int i = 0; i < re.getTitle().length(); i++) {
			System.out.print("-");
		}
		System.out.println("");
		
		System.out.println(re.getReportHeader());
		
		// Drukowanie nag��wk�w wszystkich kolumn z danego raportu
		for (int i = 0; i < re.getReportHeader().size(); i++) {
			if (i < re.getReportHeader().size() - 1)
				System.out.print(re.getReportHeader().get(i) + "    -    ");
			else
				System.out.println(re.getReportHeader().get(i));
		}
		System.out.println("--------------------------------------------------------------------");
		
		//Employee e = new Employee();
		//System.out.println(e.)
		
		/*
		for (int i = 0; i < reportHeader.size(); i++) {
			if (i < reportHeader.size() - 1)
				System.out.print(reportHeader.get(i) + "    -    ");
			else
				System.out.println(reportHeader.get(i));
		}
		*/
	}
}