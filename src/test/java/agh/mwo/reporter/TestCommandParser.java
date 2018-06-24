
package agh.mwo.reporter;

import java.nio.file.Path;
import java.nio.file.Paths;

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
    	
    	String path = Paths.get("src\\main\\resources\\reporter-dane\\2012\\02").toString();

        String[] yourArgs = new String[] {"-path", path, "-reportType", "1"};

        // When
        Reporter.main(yourArgs);

        // Then


    }

    @Test
    public void testRaportEmployeesFromCommandLineWithoutEndDate() {

        // Given
    	
    	String path = Paths.get("src\\main\\resources\\reporter-dane\\2012").toString();

        String[] yourArgs = new String[] {"-path", path, "-reportType", "1", "-startDate", "2012-01-01"};

        // When
        Reporter.main(yourArgs);

        // Then


    }
    
    @Test
    public void testRaportProjectsFromCommandLineWithAllValues() {

        // Given    	
    	
    	String path = Paths.get("src\\main\\resources\\reporter-dane\\2012").toString();

        String[] yourArgs = new String[] {"-path", path, "-reportType", "2", "-startDate", "2012-02-01", "-endDate", "2012-02-03"};

        // When
        Reporter.main(yourArgs);

        // Then


    }
    
    @Test
    public void testRaportProjectsFromCommandLineWithDatesFilter() {

        // Given
    	
    	String path = Paths.get("src\\main\\resources\\reporter-dane\\2012\\02").toString();

        String[] yourArgs = new String[] {"-path", path, "-reportType", "2", "-startDate", "2012-02-01", "-endDate", "2012-02-03"};

        // When
        Reporter.main(yourArgs);

        // Then


    }
    
    @Test
    public void testGraphFromCommandLineWithPath() {

        // Given
    	
    	String path = Paths.get("src\\main\\resources\\reporter-dane\\2012\\02").toString();

        String[] yourArgs = new String[] {"-path", path, "-reportType", "1", "-outputType", "graph"};

        // When
        Reporter.main(yourArgs);

        // Then


    }
    
    @Test
    public void testGraphFromCommandLineWithPathTypeProject() {

        // Given
    	
    	String path = Paths.get("src\\main\\resources\\reporter-dane\\2012\\02").toString();

        String[] yourArgs = new String[] {"-path", path, "-reportType", "2", "-outputType", "graph"};

        // When
        Reporter.main(yourArgs);

        // Then


    }


}
