package agh.mwo.reports;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import agh.mwo.reporter.Task;

public class ReportEmployees extends Report {

	@Override
	public void generateReport(List<Task> tasks, LocalDate startDate, LocalDate endDate) {
		List<String> headers = Arrays.asList("Nazwisko i imie", "Liczba przepracowanych godzin");
		this.setReportHeader(headers);
		
		this.setTitle( "Raport zbiorczy godzinowy wg pracownikow");
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
			if(temporary.containsKey(filteredTask.getSurname() + " " + filteredTask.getName())) {
				double sum = temporary.get(filteredTask.getSurname() + " " + filteredTask.getName()) + (filteredTask.getHours());
				temporary.put(filteredTask.getSurname() + " " + filteredTask.getName(), sum);
			} else {
				temporary.put(filteredTask.getSurname() + " " + filteredTask.getName(), filteredTask.getHours());
			}
		}		
		
		this.setReportResults(temporary);
	}

}
