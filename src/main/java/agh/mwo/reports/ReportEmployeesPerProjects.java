package agh.mwo.reports;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import agh.mwo.reporter.Task;

public class ReportEmployeesPerProjects extends Report {

	@Override
	public void generateReport(List<Task> tasks, LocalDate startDate, LocalDate endDate) {
		List<String> headers = Arrays.asList("Nazwisko i imie", "Projekt", "Liczba przepracowanych godzin");
		this.setReportHeader(headers);
		
		this.setTitle( "Raport zbiorczy godzinowy wg pracownikow i projektow");
		this.setReportStartingDate(startDate);
		this.setReportEndDate(endDate);
		
		TreeMap<String, TreeMap<String, Double>> temporary = new TreeMap<String, TreeMap<String, Double>>();
		ArrayList<Task> filteredTasks = new ArrayList<Task>();
		
		for(Task task : tasks) {
			LocalDate date = task.getDate();
			if(date.isAfter(startDate) && date.isBefore(endDate)) {
				filteredTasks.add(task);
			};
		}	
		
		for(Task filteredTask : filteredTasks) {
			if(temporary.containsKey(filteredTask.getSurname() + " " + filteredTask.getName())) {
				TreeMap<String, Double> componentMap = temporary.get(filteredTask.getSurname() + " " + filteredTask.getName());
				if(componentMap.containsKey(filteredTask.getProject())) {
					double sum = componentMap.get(filteredTask.getProject()) + (filteredTask.getHours());
					componentMap.put(filteredTask.getProject(),sum);
					
				} else {
					componentMap.put(filteredTask.getProject(),filteredTask.getHours());
				}
			} else {
				TreeMap<String, Double> componentMap = new TreeMap<String, Double>();
				componentMap.put(filteredTask.getProject(), filteredTask.getHours());
				temporary.put(filteredTask.getSurname() + " " + filteredTask.getName(), componentMap);
			}
				
		}		
		
		this.setReportThreeResults(temporary);
	}

}
