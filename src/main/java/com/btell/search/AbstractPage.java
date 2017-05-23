package com.btell.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

protected WebDriver driver;
protected WebDriverWait wait;

	public AbstractPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

		wait = new WebDriverWait(driver,120);
	}
	
}
