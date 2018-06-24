package agh.mwo.reports;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;

import agh.mwo.reporter.Task;

public abstract class Report implements IReport {

	private String title = "";
	private List<String> reportHeader;
	private TreeMap<String, Double> reportResults;
	private LocalDate raportStartingDate;
	private LocalDate raportEndDate;
	
	/* (non-Javadoc)
	 * @see agh.mwo.reports.IReport#getTitle()
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/* (non-Javadoc)
	 * @see agh.mwo.reports.IReport#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see agh.mwo.reports.IReport#getReportHeader()
	 */
	@Override
	public List<String> getReportHeader() {
		return reportHeader;
	}

	/* (non-Javadoc)
	 * @see agh.mwo.reports.IReport#setReportHeader(java.util.List)
	 */
	@Override
	public void setReportHeader(List<String> reportHeader) {
		this.reportHeader = reportHeader;
	}
	
	/* (non-Javadoc)
	 * @see agh.mwo.reports.IReport#getReportResults()
	 */
	@Override
	public TreeMap<String, Double> getReportResults() {
		return reportResults;
	}

	/* (non-Javadoc)
	 * @see agh.mwo.reports.IReport#setReportResults(java.util.TreeMap)
	 */
	@Override
	public void setReportResults(TreeMap<String, Double> reportResults) {
		this.reportResults = reportResults;
	}
	
	/* (non-Javadoc)
	 * @see agh.mwo.reports.IReport#getRaportStartingDate()
	 */
	@Override
	public LocalDate getRaportStartingDate() {
		return raportStartingDate;
	}

	/* (non-Javadoc)
	 * @see agh.mwo.reports.IReport#setRaportStartingDate(java.time.LocalDate)
	 */
	@Override
	public void setRaportStartingDate(LocalDate raportStartingDate) {
		this.raportStartingDate = raportStartingDate;
	}

	/* (non-Javadoc)
	 * @see agh.mwo.reports.IReport#getRaportEndDate()
	 */
	@Override
	public LocalDate getRaportEndDate() {
		return raportEndDate;
	}

	/* (non-Javadoc)
	 * @see agh.mwo.reports.IReport#setRaportEndDate(java.time.LocalDate)
	 */
	@Override
	public void setRaportEndDate(LocalDate raportEndDate) {
		this.raportEndDate = raportEndDate;
	}
	
	/* (non-Javadoc)
	 * @see agh.mwo.reports.IReport#generateReport(java.util.List, java.time.LocalDate, java.time.LocalDate)
	 */
	@Override
	public abstract void generateReport(List<Task> tasks, LocalDate startDate, LocalDate endDate);

}