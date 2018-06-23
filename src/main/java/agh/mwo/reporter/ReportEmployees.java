package agh.mwo.reporter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReportEmployees {
	
	private String title = "Raport zbiorczy godzinowy wg pracowników";
	private ArrayList<String> reportHeader;
	private HashMap<String, Double> reportResults;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<String> getReportHeader() {
		return reportHeader;
	}
	public void setReportHeader(ArrayList<String> reportHeader) {
		this.reportHeader = reportHeader;
	}
	
	public HashMap<String, Double> getReportResults() {
		return reportResults;
	}
	public void setReportResults(HashMap<String, Double> reportResults) {
		this.reportResults = reportResults;
	}
	// TODO
	private void setHeaders() {
		this.reportHeader.add("Nazwisko");
		this.reportHeader.add("Imiê");
		this.reportHeader.add("Liczba przepracowanych godzin");		
	}
	
	public void generateReport(ArrayList<Task> tasks, LocalDate startDate, LocalDate endDate) {
		this.setHeaders();
		HashMap<String, Double> temporary = new HashMap<String, Double>();
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
		
		this.setReportResults(this.sortByValues(temporary));	
	}	
	
	private static HashMap sortByValues(HashMap map) { 

	       List list = new LinkedList(map.entrySet());

	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {

	            public int compare(Object o1, Object o2) {

	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });

	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order

	     HashMap sortedHashMap = new LinkedHashMap();

	       for (Iterator it = list.iterator(); it.hasNext();) {

	              Map.Entry entry = (Map.Entry) it.next();

	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	  }

}
