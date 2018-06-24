package agh.mwo.reporter;

import java.time.LocalDate;
import java.time.Year;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateChecker {
	public String setDate(String opt, String dateFromCommandLine, String path) {
		if (dateFromCommandLine == null) {
			Pattern pattern = Pattern.compile(".*([0-9]{4})\\\\{0,4}(..)*");
			if( System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
			  pattern = Pattern.compile(".*([0-9]{4})/{0,4}(..)*");
		    }
			Matcher macher;
			macher = pattern.matcher(path);
			if (macher.matches()) {
				String year = macher.group(1);
				String month = (macher.group(2) == null) ? "01" : macher.group(2);
				if (opt.equals("start")) {
					//System.out.println("start");
					return year + "-" + month + "-" + "01";
				}
				if(opt.equals("end")) {
					LocalDate endDateExample = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), 01);
					//System.out.println(year + "-" + month + "-" + endDateExample.getMonth().length(Year.isLeap(Long.valueOf(year))));
					return year + "-" + month + "-" + endDateExample.getMonth().length(Year.isLeap(Long.valueOf(year)));
					
				}else {
					//System.out.println("else");
					return "3000-12-12";
				}
			} else {
				if (opt.equals("start"))
					return "1970-01-01";
				if (opt.equals("end"))
					return LocalDate.now().toString();
				else
					return "3000-12-12";
			}
		} else {
			return dateFromCommandLine;
		}
	}
}
