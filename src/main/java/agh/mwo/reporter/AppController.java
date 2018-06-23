package agh.mwo.reporter;

import org.apache.commons.cli.CommandLine;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppController {
	public void run(CommandLine cmd) {

		String path = cmd.getOptionValue("path");
		String reportType = cmd.getOptionValue("reportType");

		if (!path.equals(null) && !reportType.equals(null)) {
			String startDate = cmd.getOptionValue("startDate");
			String endDate = cmd.getOptionValue("endDate");
			String outputType = cmd.getOptionValue("outputType");

			// todo pobierz arrayListe z ??parseData??

			ArrayList<Task> tasks = new ArrayList<Task>();
			tasks = Scan.getAllRecords(path);

			switch (reportType) {
			case "1":
				// report workers summary of work hours
				System.out.println("\nWork Hours Report");
				ReportEmployees reportEmployees = new ReportEmployees();
				reportEmployees.generateReport(tasks, LocalDate.parse(startDate), LocalDate.parse(endDate));
				break;
				
			case "2":
				// report per project hours

				break;
				
			case "3":
				// work hours per projects

				break;
				
			default:
				break;
			}
		} else {
			System.out.println("Given arguments are incorrect: ");
		}

	}
}
