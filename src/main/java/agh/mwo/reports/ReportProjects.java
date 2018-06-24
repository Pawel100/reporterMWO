package agh.mwo.reports;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import agh.mwo.reporter.Task;

public class ReportProjects extends Report {

	@Override
	public void generateReport(List<Task> tasks, LocalDate startDate, LocalDate endDate) {
		List<String> headers = Arrays.asList("Projekt", "Liczba przepracowanych godzin");
		this.setReportHeader(headers);
		
		this.setTitle( "Raport zbiorczy wg projektow");
		this.setRaportStartingDate(startDate);
		this.setRaportEndDate(endDate);

		TreeMap<String, Double> temporary = new TreeMap<String, Double>();
		ArrayList<Task> filteredTasks = new ArrayList<Task>();
		
		for(Task task : tasks) {
			LocalDate date = task.getDate();
			if(date.isAfter(startDate) && date.isBefore(endDate)) {
				filteredTasks.add(task);
			};
		}	
		
		for(Task filteredTask : filteredTasks) {
			if(temporary.containsKey(filteredTask.getProject())) {
				double sum = temporary.get(filteredTask.getProject()) + (filteredTask.getHours());
				temporary.put(filteredTask.getProject(), sum);
			} else {
				temporary.put(filteredTask.getProject(), filteredTask.getHours());
			}
		}		
		
		this.setReportResults(temporary);
	}

}
