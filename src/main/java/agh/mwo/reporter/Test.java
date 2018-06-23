package agh.mwo.reporter;

import java.util.ArrayList;

public class Test {
public static void main(String[] args) {
String path = "C:\\Users\\student27\\Desktop\\asitko_reporterMWO\\reporterMWO\\src\\main\\resources";
ArrayList<Task> toTest = Scan.getAllRecords(path);
System.out.println(toTest.size());
Task my = toTest.get(0);
System.out.println(my.getDescription());
System.out.println(my.getName());
System.out.println(my.getSurname());
System.out.println(my.getProject());
System.out.println(my.getDate());
System.out.println(my.getHours());
}
}
