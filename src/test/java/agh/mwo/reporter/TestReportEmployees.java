package agh.mwo.reporter;

import java.time.LocalDate;
import java.util.ArrayList;

import agh.mwo.reports.Report;
import agh.mwo.reports.ReportEmployees;

public class TestReportEmployees {
	
//	@Test
	public void testReport() {
        
        Task task = new Task();
        ArrayList<Task> tasks = new ArrayList<Task>();
        
        task.setName("1");
        task.setSurname("a");
        task.setHours(23);
        task.setDescription("dane");
        task.setProject("project 1");
        task.setDate(LocalDate.of(2018, 1, 1));
        
        Task task2 = new Task();
        task2.setName("2");
        task2.setSurname("z");
        task2.setHours(26);
        task2.setDescription("dane 22");
        task2.setProject("project 2");
        task2.setDate(LocalDate.of(2018, 1, 1));
        
        tasks.add(task);
        tasks.add(task2);
        
        Report newRep = new ReportEmployees();
        newRep.generateReport(tasks, LocalDate.of(2017, 12, 12), LocalDate.of(2018, 12, 12));
	}

}
