package com.btell.search;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

public class SearchTest {
	static Logger log = Logger.getLogger(SearchTest.class);

	private static WebDriver driver;

	private static SearchPage searchPage;
	private static ResultsPage resultsPage;

	@BeforeClass
	public static void loadDriver() {
		System.setProperty("webdriver.gecko.driver","webdriver/geckodriver");
		driver = new FirefoxDriver();	
		driver.manage().window().maximize();
		searchPage = PageFactory.initElements(driver, SearchPage.class);
	}

	@AfterClass
	public static void afterClass() {
		driver.quit();
	}

	@Before
	public void gotoSearchPage() {
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void searchForEighthResultTitle() throws Exception {
		String expectedTitle = "Olympic - YouTube";
		
		searchPage.setSearchInput("Olympics");
		resultsPage = searchPage.search();
		
		String actualTitle = resultsPage.getResultTitle(8);
		Assert.assertEquals(expectedTitle, actualTitle);
	}

}
