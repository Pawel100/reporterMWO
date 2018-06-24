package agh.mwo.reports;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;

import agh.mwo.reporter.Task;

public abstract class Report {

	private String title = "";
	private List<String> reportHeader;
	private TreeMap<String, Double> reportResults;
	private LocalDate raportStartingDate;
	private LocalDate raportEndDate;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getReportHeader() {
		return reportHeader;
	}

	public void setReportHeader(List<String> reportHeader) {
		this.reportHeader = reportHeader;
	}
	
	public TreeMap<String, Double> getReportResults() {
		return reportResults;
	}

	public void setReportResults(TreeMap<String, Double> reportResults) {
		this.reportResults = reportResults;
	}
	
	public LocalDate getRaportStartingDate() {
		return raportStartingDate;
	}

	public void setRaportStartingDate(LocalDate raportStartingDate) {
		this.raportStartingDate = raportStartingDate;
	}

	public LocalDate getRaportEndDate() {
		return raportEndDate;
	}

	public void setRaportEndDate(LocalDate raportEndDate) {
		this.raportEndDate = raportEndDate;
	}
	
	public abstract void generateReport(List<Task> tasks, LocalDate startDate, LocalDate endDate);

}