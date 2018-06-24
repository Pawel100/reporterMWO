package agh.mwo.reporter;

import org.junit.Test;

public class TestCommandParser {

    @Test
    public void testCommandHelpLine() {

        // Given

        String[] yourArgs = new String[] {"-h"};

        // When
        Reporter.main(yourArgs);

        // Then


    }

    @Test
    public void testCommandLineWithPath() {

        // Given

        String[] yourArgs = new String[] {"-path", "src\\main\\resources\\reporter-dane\\2012\\02", "-reportType", "1"};

        // When
        Reporter.main(yourArgs);

        // Then


    }

    @Test
    public void testRaportEmployeesFromCommandLineWithoutEndDate() {

        // Given

        String[] yourArgs = new String[] {"-path", "src\\main\\resources\\reporter-dane\\2012", "-reportType", "1", "-startDate", "2012-07-01"};

        // When
        Reporter.main(yourArgs);

        // Then


    }
    
    @Test
    public void testRaportProjectsFromCommandLineWithAllValues() {

        // Given

        String[] yourArgs = new String[] {"-path", "src\\main\\resources\\reporter-dane\\2012\\02", "-reportType", "2", "-startDate", "2012-02-01", "-endDate", "2012-02-03"};

        // When
        Reporter.main(yourArgs);

        // Then


    }
    
    @Test
    public void testRaportProjectsFromCommandLineWithDatesFilter() {

        // Given

        String[] yourArgs = new String[] {"-path", "src\\main\\resources\\reporter-dane\\2012", "-reportType", "2", "-startDate", "2012-02-01", "-endDate", "2012-02-03"};

        // When
        Reporter.main(yourArgs);

        // Then


    }


}
