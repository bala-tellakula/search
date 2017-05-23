package com.btell.search;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

	static Logger log = Logger.getLogger(SearchPage.class);
	
	ResultsPage resultsPage;
	
	@FindBy(id = "lst-ib")
	WebElement searchInputBox;
	
	@FindBy(name = "btnK")
	WebElement searchButton;

	public SearchPage(WebDriver driver) {
        super(driver);
	}
	
	/**
	 * Set the search input string
	 * 
	 * @param searchString
	 * @return SearchPage
	 */
	public SearchPage setSearchInput(String searchString) {
		clearSearchInput();
		searchInputBox.sendKeys(searchString);
		return this;
	}
	
	/**
	 * Clear the search input string
	 * 
	 * @return SearchPage
	 */
	public SearchPage clearSearchInput() {
		searchInputBox.clear();
		return this;
	}
	
	/**
	 * Click on Search button
	 */
	public ResultsPage search() {
		searchButton.submit();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		resultsPage = new ResultsPage(driver);
		
		return resultsPage;
	}
	
}
