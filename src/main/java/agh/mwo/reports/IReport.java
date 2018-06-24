package agh.mwo.reports;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;

import agh.mwo.reporter.Task;

public interface IReport {

	String getTitle();

	void setTitle(String title);

	List<String> getReportHeader();

	void setReportHeader(List<String> reportHeader);

	TreeMap<String, Double> getReportResults();

	void setReportResults(TreeMap<String, Double> reportResults);
	
	TreeMap<String, TreeMap<String, Double>> getReportThreeResults();

	void setReportThreeResults(TreeMap<String, TreeMap<String, Double>> reportThreeResults);

	LocalDate getReportStartingDate();

	void setReportStartingDate(LocalDate raportStartingDate);

	LocalDate getReportEndDate();

	void setReportEndDate(LocalDate raportEndDate);

	void generateReport(List<Task> tasks, LocalDate startDate, LocalDate endDate);

}