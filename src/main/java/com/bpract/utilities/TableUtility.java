package com.bpract.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableUtility {
	public void searchInUserTicketTable(WebElement mytable, WebDriver driver, String value) {
	      List<WebElement> r_table = mytable.findElements(By.tagName("tr"));
	      String b_xpath = "//*[@name=\"all-tickets\"]/tbody/tr[";
	      String a_xpath = "]/td[2]";
	      int rs_c = r_table.size();
	      for (int r = 1;r <= rs_c; r++) {
	         String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
	         if(n.contains(value)){
	            String celtxt=driver.findElement(By.xpath("//*[@name=\"all-tickets\"]/tbody/tr["+r+"]/td[2]")).getText();
	            System.out.println("The subject of ticket created is :" + celtxt);
	            break;
	         }
	      }
	}
	
	
	public void searchInDepartmentTable(WebElement deptTable, WebDriver driver, String deptValue) {
		List<WebElement> r_table = deptTable.findElements(By.tagName("tr"));
	      String b_xpath = "//table[@name=\"department-table\"]/tbody/tr[";
	      String a_xpath = "]/td[2]";
	      int rs_c = r_table.size();
	      for (int r = 1;r <= rs_c; r++) {
	         String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
	         if(n.contains(deptValue)){
	            String celtxt=driver.findElement(By.xpath("//table[@name=\"department-table\"]/tbody/tr["+r+"]/td[2]")).getText();
	            System.out.println("Department created is :" + celtxt);
	            break;
	         }
	      }
	}
	
	public void searchInDocumentsTable(WebElement docTable, WebDriver driver, String docValue, String sortOrder) {
		List<WebElement> table_row = docTable.findElements(By.tagName("tr"));
	      String b_xpath = "//table[@name=\"tools-documents\"]/tbody/tr[";
	      String a_xpath = "]/td[2]";
	      String a2_xpath = "]/td[3]";
	      int rows_c = table_row.size();
	      for (int r = 1; r <= rows_c; r++) {
	         String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();

	         if(n.contains(docValue)){
	            String cellValue1 = driver.findElement(By.xpath("//table[@name=\"tools-documents\"]/tbody/tr[" + r + "]/td[2]")).getText();
//	            String cellValue2 = driver.findElement(By.xpath("//table[@name=\"tools-documents\"]/tbody/tr[" + r + "]/td[3]")).getText();
	            System.out.println("New Document Created is :" + cellValue1);
	            break;
	         }
	      }
	      for(int s = 1; s <= rows_c; s++) {
	    	  String n2 = driver.findElement(By.xpath(b_xpath + s + a2_xpath)).getText();
	    	  if(n2.contains(sortOrder)) {
	    		  String cellValue2 = driver.findElement(By.xpath("//table[@name=\"tools-documents\"]/tbody/tr[" + s + "]/td[3]")).getText();
	    		  System.out.println("Sort Order of New Document Created is :" + cellValue2);
	    		  break;
	    	  }
	      }
	}
}
