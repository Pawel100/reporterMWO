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

        String[] yourArgs = new String[] {"-path", "C:/cos"};

        // When
        Reporter.main(yourArgs);

        // Then


    }

    @Test
    public void testCommandLineWithAllValues() {

        // Given

        String[] yourArgs = new String[] {"-path", "C:/test", "-reportType", "1", "-startDate", "2012-02-02", "-endDate", "2018-04-04"};

        // When
        Reporter.main(yourArgs);

        // Then


    }


}
