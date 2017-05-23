package com.btell.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends AbstractPage {

	static Logger log = Logger.getLogger(ResultsPage.class);
	
	@FindBy(id="ires")
	WebElement searchResultsContainer;
	
	public ResultsPage(WebDriver driver) {
        super(driver);
    }
	
	/**
	 * Get the search result for the given index
	 * 
	 * @param index Index of the search result 
	 * @return String Result title of the given index
	 */
	public String getResultTitle(int index) {
		String title = getAllResultTitles().get(index);
		System.out.println("Result Title at Index '" + index + "' is : '" + title + "'");
		return title;
	}
	
	/**
	 * Get all search results
	 * 
	 * @return String Result title of the given index
	 */
	public ArrayList<String> getAllResultTitles() {
		ArrayList<String> resultsList = new ArrayList<String>();

		wait.until(ExpectedConditions.visibilityOf(searchResultsContainer));

		List<WebElement> resultTitles = searchResultsContainer.findElements(By.tagName("h3"));
		
		for (WebElement resultTitle : resultTitles) {
			String resultTitleText = resultTitle.getText();
			System.out.println(resultTitleText);
			
			resultsList.add(resultTitle.getText());
		}
		
		return resultsList;
	}
	
}
