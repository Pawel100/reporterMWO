package agh.mwo.reporter;

import org.apache.commons.cli.CommandLine;

import agh.mwo.reports.Report;
import agh.mwo.reports.ReportEmployees;
import agh.mwo.reports.ReportProjects;
import agh.mwo.visualization.PrintingToConsole;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppController {
	public void run(CommandLine cmd) {

		String path = cmd.getOptionValue("path");
		String reportType = cmd.getOptionValue("reportType");
		String startDate="";
		String endDate="";

		if (!path.equals(null) && !reportType.equals(null)) {
			
			/*
			 * checking date from commandline.
			 */
			DateChecker dateChecker = new DateChecker();
			startDate = dateChecker.setDate("start", cmd.getOptionValue("startDate"), path);
			endDate = dateChecker.setDate("end", cmd.getOptionValue("endDate"), path);
			
//			if (cmd.getOptionValue("startDate")==null) {
//				Pattern pattern = Pattern.compile(".*([0-9]{4})\\\\{0,4}(..)*");
//				Matcher macher;
//				macher = pattern.matcher(path);
//				if (macher.matches()) {
//					String year = macher.group(1);
//					String month = (macher.group(2)==null) ? "01": macher.group(2);
//					startDate=year+"-"+month+"-"+"01";
//				}else {
//					startDate="2012-01-01";
//				}
//			}else {
//				startDate = cmd.getOptionValue("startDate");
//			}
//			
//			if (cmd.getOptionValue("endDate")==null) {
//				Pattern pattern = Pattern.compile(".*([0-9]{4})\\\\{0,4}(..)*");
//				Matcher macher;
//				macher = pattern.matcher(path);
//				if (macher.matches()) {
//					String endYear = macher.group(1);
//					String endMonth = (macher.group(2)==null) ? "12": macher.group(2);
//					LocalDate endDateExample = LocalDate.of(Integer.valueOf(endYear), Integer.valueOf(endMonth), 01);
//					endDate=endYear+"-"+endMonth+"-"+endDateExample.getMonth().length(Year.isLeap(Long.valueOf(endYear)));
//				}else {
//					endDate=LocalDate.now().toString();
//				}
//				
//			}else {
//				endDate = cmd.getOptionValue("endDate");
//			}
//			
			String outputType = cmd.getOptionValue("outputType");

			// todo pobierz arrayListe z ??parseData??

			ArrayList<Task> tasks = new ArrayList<Task>();
			PrintingToConsole printer =new PrintingToConsole();

			tasks = Scan.getAllRecords(path);

			switch (reportType) {
			case "1":
				// report workers summary of work hours
				Report reportEmployees = new ReportEmployees();
				reportEmployees.generateReport(tasks, LocalDate.parse(startDate), LocalDate.parse(endDate));
				printer.printReport(reportEmployees);
				break;
				
			case "2":
				// report per project hours
				ReportProjects reportProjects = new ReportProjects();
				reportProjects.generateReport(tasks, LocalDate.parse(startDate), LocalDate.parse(endDate));
				printer.printReport(reportProjects);
				break;
				
			case "3":
				// work hours per projects for each employee

				break;
				
			default:
				System.out.println("Bye!");
				break;
			}
		} else {
			System.out.println("Given arguments are incorrect: ");
		}

	}
}
