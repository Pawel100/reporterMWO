package agh.mwo.reporter;

import java.util.List;

public class Printer {

	public void printToConsole(ReportEmployees reportEmployees) {
		int maxLength = 0;

		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n" + reportEmployees.getTitle() + "\n");
		for (String header : reportEmployees.getReportHeader()) {
			System.out.print(header + "\t");
		}
		System.out.println("\n-------------------------------");
		for (String r : reportEmployees.getReportResults().keySet()) {
			if (r.length() > maxLength) {
				maxLength = r.length();
			}
		}
		for (String r : reportEmployees.getReportResults().keySet()) {
			int spaceLength = maxLength - r.length();
			String space = "";
			for (int i = 0; i < spaceLength; i++) {
				space = space + " ";
			}
			System.out.println(r + space + "\t" + reportEmployees.getReportResults().get(r));
		}
		System.out.println("-------------------------------");
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