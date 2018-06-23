package agh.mwo.reporter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

public class CommandParser {
    public CommandLine run(String[] args) {

        // create Options object
        Options options = new Options();

        // add options
        options.addOption("h", false, "display help");
        options.addOption("path", true, "data source path");
        options.addOption("reportType", true, "select report type(1-5)");
        options.addOption("startDate", true, "date (YYYY-MM-DD)");
        options.addOption("endDate", true, "date (YYYY-MM-DD)");
        options.addOption("outputType", true, "Console or Graph");


        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            System.out.println(cmd.getOptionValue("path"));
            return cmd;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
