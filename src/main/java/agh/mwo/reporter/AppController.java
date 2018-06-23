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

            Task task = new Task();
            ArrayList<Task> fetchedData = new ArrayList<Task>();

            task.setName("1");
            task.setSurname("a");
            task.setHours(23);
            task.setDescription("dane");
            task.setProject("project 1");
            task.setDate(LocalDate.of(2018, 1, 1));

            Task task2 = new Task();
            task2.setName("2");
            task2.setSurname("z");
            task2.setHours(26);
            task2.setDescription("dane 22");
            task2.setProject("project 2");
            task2.setDate(LocalDate.of(2018, 1, 1));

            fetchedData.add(task);
            fetchedData.add(task2);

            // todo - uruchomm raport jak bedzie raportgotowy

            switch (reportType) {
                case "1":
                    // report workers summary of work hours
                    ReportEmployees reportEmployees = new ReportEmployees();
                    reportEmployees.generateReport(fetchedData, LocalDate.parse(startDate), LocalDate.parse(endDate));
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
