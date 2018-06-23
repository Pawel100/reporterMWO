package agh.mwo.reporter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class ReportEmployees {

	private String title = "Raport zbiorczy godzinowy wg pracownikow";
	private List<String> reportHeader;
	private TreeMap<String, Double> reportResults;
	
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


	public void generateReport(List<Task> tasks, LocalDate startDate, LocalDate endDate) {
		List<String> headers = Arrays.asList("Nazwisko i imie", "Liczba przepracowanych godzin");
		this.setReportHeader(headers);

		TreeMap<String, Double> temporary = new TreeMap<String, Double>();
		ArrayList<Task> filteredTasks = new ArrayList<Task>();
		
		for(Task task : tasks) {
			LocalDate date = task.getDate();
			if(date.isAfter(startDate) && date.isBefore(endDate)) {
				filteredTasks.add(task);
			};
		}	
		
		for(Task filteredTask : filteredTasks) {
			if(temporary.containsKey(filteredTask.getSurname() + " " + filteredTask.getName())) {
				double sum = temporary.get(filteredTask.getSurname() + " " + filteredTask.getName()) + (filteredTask.getHours());
				temporary.put(filteredTask.getSurname() + " " + filteredTask.getName(), sum);
			} else {
				temporary.put(filteredTask.getSurname() + " " + filteredTask.getName(), filteredTask.getHours());
			}
		}		
		
		this.setReportResults(temporary);
		
		System.out.println("\nNazwisko  Imie  Liczba Godzin");
		System.out.println("-------------------------------");
		for(String r : this.reportResults.keySet()) {
			System.out.println(r + "   " + reportResults.get(r));
		}
		System.out.println("-------------------------------");
	}

}
