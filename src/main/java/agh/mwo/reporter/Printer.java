package agh.mwo.reporter;

import java.util.ArrayList;

public class Printer {

	public static String title;
	public static ArrayList<String> reportHeader;

	public static void main(String[] args) {

		System.out.println("Raport " + title);
		ArrayList<String> reportHeader = new ArrayList<String>();
		
		for (int i = 0; i < reportHeader.size(); i++) {
			System.out.print(reportHeader.get(i) + "    -    ");
		}
		
		
	}
}