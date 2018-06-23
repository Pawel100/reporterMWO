package agh.mwo.reporter;

import java.util.ArrayList;

public class ReportEmployees {
	
	private String title = "Raport zbiorczy godzinowy wg pracowników";
	private ArrayList<String> reportHeader;
	private ArrayList<Employee> reportResults;
	
	private String getTitle() {
		return title;
	}
	private void setTitle(String title) {
		this.title = title;
	}
	private ArrayList<String> getReportHeader() {
		return reportHeader;
	}
	private void setReportHeader(ArrayList<String> reportHeader) {
		this.reportHeader = reportHeader;
	}
		
	// TODO
	private void setHeaders() {
		this.reportHeader.add("Nazwisko");
		this.reportHeader.add("Imiê");
		this.reportHeader.add("Liczba przepracowanych godzin");		
	}

	

	
	

}
