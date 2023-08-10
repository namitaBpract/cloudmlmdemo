package com.bpract.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	WaitUtility waitutility = new WaitUtility();
	
	public void scrollToElement(WebElement element, WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void selectByVisibleText(WebElement element, WebDriver driver, String str) {
		Select selectText = new Select(element);
		selectText.selectByVisibleText(str);
	}
	public void selectByValue(WebElement element, WebDriver driver, String str) {
		Select selectValue = new Select(element);
		selectValue.selectByValue(str);
	}
	
	public void clearWebField(WebElement element){
		while(!element.getAttribute("value").equals("")){
			element.sendKeys(Keys.BACK_SPACE);
		}
	}
	
	public void pickColor(WebElement element, WebDriver driver, String color) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		element.sendKeys(color);
	}
	
	public void uploadFiles(WebElement element, WebDriver driver, String path) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		element.sendKeys(path);
	}
	
	public void uploadImage(WebElement element, WebDriver driver, String path) throws AWTException {
		element.click();
		Robot rb = new Robot();
	    StringSelection str = new StringSelection(path);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void selectFromAutoSuggestion(WebElement element, WebDriver driver, String username) throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(element).click().sendKeys(username).build().perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public void switchToWindow(WebDriver driver) {
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		while(I1.hasNext()){
			String child_window=I1.next();
			if(!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}
		}
	}
}
