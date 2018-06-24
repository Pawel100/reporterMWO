package agh.mwo.visualization;

import java.util.List;

import agh.mwo.reports.Report;

public class PrintingToConsole {

	public void printReport(Report report) {
		int maxLength = 0;

		System.out.println("-------------------------------------------------------------");
		System.out.println("\n" + report.getTitle());
		System.out.println("w okresie: "+report.getRaportStartingDate()+" - "+report.getRaportEndDate()+"\n");
		for (String header : report.getReportHeader()) {
			System.out.print(header + "\t\t");
		}
		System.out.println("\n-------------------------------------------------------------");
		for (String r : report.getReportResults().keySet()) {
			if (r.length() > maxLength) {
				maxLength = r.length();
			}
		}
		for (String r : report.getReportResults().keySet()) {
			int spaceLength = maxLength - r.length();
			String space = "";
			for (int i = 0; i < spaceLength; i++) {
				space = space + " ";
			}
			System.out.println(r + space + "\t" + report.getReportResults().get(r));
		}
		System.out.println("-------------------------------------------------------------");
	}

	/*
	 * public static String title = "Raport godzinowy"; public static List<String>
	 * reportHeader;
	 * 
	 * public static void main(String[] args) {
	 * 
	 * ReportEmployees re = new ReportEmployees();
	 * 
	 * System.out.println(re.getTitle()); for (int i = 0; i <
	 * re.getTitle().length(); i++) { System.out.print("-"); }
	 * System.out.println("");
	 * 
	 * System.out.println(re.getReportHeader());
	 * 
	 * // Drukowanie nag��wk�w wszystkich kolumn z danego raportu for (int i =
	 * 0; i < re.getReportHeader().size(); i++) { if (i <
	 * re.getReportHeader().size() - 1) System.out.print(re.getReportHeader().get(i)
	 * + "    -    "); else System.out.println(re.getReportHeader().get(i)); }
	 */

	// Employee e = new Employee();
	// System.out.println(e.)

	/*
	 * for (int i = 0; i < reportHeader.size(); i++) { if (i < reportHeader.size() -
	 * 1) System.out.print(reportHeader.get(i) + "    -    "); else
	 * System.out.println(reportHeader.get(i)); }
	 */
	// }

}