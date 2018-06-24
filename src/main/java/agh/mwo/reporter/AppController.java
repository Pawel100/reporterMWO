package agh.mwo.reporter;

import org.apache.commons.cli.CommandLine;

import agh.mwo.reports.IReport;
import agh.mwo.reports.ReportEmployees;
import agh.mwo.reports.ReportProjects;
import agh.mwo.visualization.ChartExporter;
import agh.mwo.visualization.IPrinter;
import agh.mwo.visualization.PrintingToConsole;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppController {
	Map<String, IReport> reportsMap = new HashMap<>();

	public void run(CommandLine cmd) {
		
		String START = "start";
		String END = "end";
		
		if (cmd.hasOption("h")) {
			System.out.println("help");
		}
		;

		reportsMap.put("1", new ReportEmployees());
		reportsMap.put("2", new ReportProjects());
		// add upcoming reports above

		String path = cmd.getOptionValue("path");
		String reportType = cmd.getOptionValue("reportType");
		String startDate = "";
		String endDate = "";

		if (path != null && reportType != null) {

			// checking date from commandline.
			try {
				DateChecker dateChecker = new DateChecker();
				startDate = dateChecker.setDate(START, cmd.getOptionValue("startDate"), path);
				endDate = dateChecker.setDate(END, cmd.getOptionValue("endDate"), path);
			} catch (TypeOfDateException ex) {
				System.out.println("SET KIND OF DATE: START OR END");
			} catch (Exception e) {
				e.printStackTrace();
			}

			String outputType = cmd.getOptionValue("outputType");

			ArrayList<Task> tasks;
			IPrinter printer = new PrintingToConsole();

			tasks = Scan.getAllRecords(path);

			// select report
			IReport report = reportsMap.get(reportType);
			report.generateReport(tasks, LocalDate.parse(startDate), LocalDate.parse(endDate));

			if (outputType != null && outputType == "Graph") {
				ChartExporter chart = new ChartExporter();
				try {
					chart.saveReportAsChart(report, reportType);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Chart export failed, displaying results in the console window");
					printer.printReport(report);
				}
				;
			} else {
				printer.printReport(report);
			}

		} else {
			if (!cmd.hasOption("h")) {
				System.out.println("Given arguments are incorrect: ");
			}
		}

	}
}