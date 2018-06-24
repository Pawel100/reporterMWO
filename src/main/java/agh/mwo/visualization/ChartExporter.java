package agh.mwo.visualization;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map.Entry;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.style.Styler.LegendPosition;

import agh.mwo.reports.IReport;
import agh.mwo.reports.Report;

public class ChartExporter {
	
	public CategoryChart generateChart(IReport report, String chartType) {
		String seriesName = "";
		if(chartType == "1") {
			seriesName = "Pracownicy";
		} else {
			seriesName = "Projekty";
		}
		CategoryChart chart = new CategoryChartBuilder().width(1200).height(800).title(report.getTitle()).xAxisTitle(report.getReportHeader().get(0)).yAxisTitle(report.getReportHeader().get(1)).build();
	    // Customize Chart
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
	    chart.getStyler().setHasAnnotations(true);
	   
	    
	    String[] names = new String[report.getReportResults().size()];
	    Double[] hours = new Double[report.getReportResults().size()];
	    
	    int i = 0;
	    
	    for(Entry<String, Double> entry : report.getReportResults().entrySet()) {	    	
	    	if(chartType == "1") {
	    		String[] nameToBeShortened = entry.getKey().split("\\s+");	    	
		    	names[i] = nameToBeShortened[0] + " " + nameToBeShortened[1].charAt(0) + ".";
			} else {
				names[i] = entry.getKey();
			}
	    
	    	hours[i] = entry.getValue();	    	
	    	i++;    	
	    }
	    
	 
	    // Series
	    chart.addSeries(seriesName, Arrays.asList(names), Arrays.asList(hours));
	    
	    return chart;
	}
	
	public void saveReportAsChart(IReport report, String chartType) throws IOException {	    
	    BitmapEncoder.saveBitmap(this.generateChart(report, chartType), "./Sample_Chart_" + chartType, BitmapFormat.PNG);
	    
	    if( System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
	    	Runtime.getRuntime().exec("cmd.exe /c \"start Sample_Chart_" + chartType + ".png\"");
	    }
	}

}
