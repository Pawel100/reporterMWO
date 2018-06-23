package agh.mwo.reporter;

import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.commons.cli.CommandLine;

public class Reporter {

    public static void main(String[] args) {

        System.out.println("Welcome to Reporter Project - MWO2017/2018");

        CommandParser commandLineParser = new CommandParser();
        CommandLine cmd = commandLineParser.run(args);

    }
}
