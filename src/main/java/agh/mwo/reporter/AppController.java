package agh.mwo.reporter;

import org.apache.commons.cli.CommandLine;

import agh.mwo.reports.IReport;
import agh.mwo.reports.ReportEmployees;
import agh.mwo.reports.ReportProjects;
import agh.mwo.visualization.IPrinter;
import agh.mwo.visualization.PrintingToConsole;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppController {
	public void run(CommandLine cmd) {

		String path = cmd.getOptionValue("path");
		String reportType = cmd.getOptionValue("reportType");
		String startDate="";
		String endDate="";

		if (path!=null && reportType!=null) {

			// checking date from commandline.
			DateChecker dateChecker = new DateChecker();
			startDate = dateChecker.setDate("start", cmd.getOptionValue("startDate"), path);
			endDate = dateChecker.setDate("end", cmd.getOptionValue("endDate"), path);

			String outputType = cmd.getOptionValue("outputType");

			ArrayList<Task> tasks;
			IPrinter printer = new PrintingToConsole();

			tasks = Scan.getAllRecords(path);

			switch (reportType) {
			case "1":
				// report workers summary of work hours
				IReport reportEmployees = new ReportEmployees();
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
