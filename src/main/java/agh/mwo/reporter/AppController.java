package agh.mwo.reporter;

import org.apache.commons.cli.CommandLine;

public class AppController {
    public void run(CommandLine cmd) {

        String path = cmd.getOptionValue("path");
        String reportType = cmd.getOptionValue("reportType");

        if (!path.equals(null) && !reportType.equals(null)) {
            String startDate = cmd.getOptionValue("startDate");
            String endDate = cmd.getOptionValue("endDate");
            String outputType = cmd.getOptionValue("outputType");

            // todo - uruchomm raport jak bedzie raportgotowy


        } else {

        }


    }
}
