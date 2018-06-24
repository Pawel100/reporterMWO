package agh.mwo.reports;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import agh.mwo.reporter.Task;

public class ReportDays extends Report {
	
	@Override
	public void generateReport(List<Task> tasks, LocalDate startDate, LocalDate endDate) {
		List<String> headers = Arrays.asList("Dzien tygodnia", "Liczba przepracowanych godzin");
		this.setReportHeader(headers);
		
		this.setTitle( "Raport zbiorczy godzinowy wg dni tygodnia");
		this.setReportStartingDate(startDate);
		this.setReportEndDate(endDate);
		
		TreeMap<String, Double> temporary = new TreeMap<String, Double>();
		TreeMap<String, Double> toReturn = new TreeMap<String, Double>();
		ArrayList<Task> filteredTasks = new ArrayList<Task>();
		
		for(Task task : tasks) {
			LocalDate date = task.getDate();
			if(date.isAfter(startDate) && date.isBefore(endDate)) {
				filteredTasks.add(task);
			};
		}
		
		for(Task task : tasks) {
			LocalDate date = task.getDate();
			if(date.isAfter(startDate) && date.isBefore(endDate)) {
				filteredTasks.add(task);
			};
		}	
				
		for(Task filteredTask : filteredTasks) {
			String day = filteredTask.getDate().getDayOfWeek().toString();
			if(temporary.containsKey(day)) {
				double sum = temporary.get(filteredTask.getDate().getDayOfWeek().toString()) + (filteredTask.getHours());
				temporary.put(filteredTask.getDate().getDayOfWeek().toString(), sum);
			}else {
					temporary.put(filteredTask.getDate().getDayOfWeek().toString(), filteredTask.getHours());
					
				}
			}
		toReturn.put("1. MONDAY",temporary.get("MONDAY"));
		toReturn.put("2. TUESDAY",temporary.get("TUESDAY"));
		toReturn.put("3. WEDNESDAY",temporary.get("WEDNESDAY"));
		toReturn.put("4. THURSDAY",temporary.get("THURSDAY"));
		toReturn.put("5. FRIDAY",temporary.get("FRIDAY"));
		toReturn.put("6. SATURDAY",temporary.get("SATURDAY"));
		toReturn.put("7. SUNDAY",temporary.get("SUNDAY"));
		this.setReportResults(toReturn);
	}
}
			

