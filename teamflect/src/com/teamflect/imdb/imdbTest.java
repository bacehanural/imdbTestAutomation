package com.teamflect.imdb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class imdbTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/burcu/Desktop/3- Setup Files/chromedriver-mac-x64/chromedriver");
		driver = new ChromeDriver(); //launch Chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();


		driver.get("https://www.imdb.com/");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div/button[2]"))).isDisplayed();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div/button[2]"))).click();
	}
	
	
	@Test
	public void oscarsLinkTest()
	{
		driver.findElement(By.id("imdbHeader-navDrawerOpen")).click();
		driver.findElement(By.linkText("Oscars")).isDisplayed();
		driver.findElement(By.linkText("Oscars")).click();
		driver.findElement(By.linkText("Event history")).isDisplayed();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section:nth-child(9) li:nth-child(5)"))).isDisplayed();

		
		try {
            Thread.sleep(1000); // Add a small delay to ensure element visibility
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		WebElement tab1980s = driver.findElement(By.cssSelector("section:nth-child(9) li:nth-child(5)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tab1980s);
		
		
        try {
            Thread.sleep(1000); // Add a small delay to ensure element visibility
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"event-history-edition-2\"]"))).isDisplayed();
		WebElement tab1987 = driver.findElement(By.xpath("//*[@id=\"event-history-edition-2\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tab1987);
        
        //Best Foreign Language Film//
		driver.findElement(By.cssSelector("div:nth-child(14) > div.event-widgets__award-category-name")).isDisplayed();
		
		//Click on the "Betty Blue"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(14) div:nth-child(2) > div:nth-child(1) > div.event-widgets__nomination-details > div.event-widgets__nominees > div.event-widgets__primary-nominees > span > span > a"))).click();
		
		
        try {
            Thread.sleep(1000); // Add a small delay to ensure element visibility
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        //Record the details of the Director
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li:nth-child(1) > div > ul > li > a"))).isDisplayed();
        WebElement directorElement = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li:nth-child(1) > div > ul > li > a"));
        String director = directorElement.getText();
        
        //Record the details of the Writers
        WebElement writerElement1 = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li:nth-child(2) > div > ul > li:nth-child(1) > a"));
        String writer1 = writerElement1.getText();
        
        WebElement writerElement2 = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li:nth-child(2) > div > ul > li:nth-child(2) > a"));
        String writer2 = writerElement2.getText();
        
        //Record the details of the Stars
        WebElement starElement1 = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li.ipc-metadata-list__item.ipc-metadata-list-item--link > div > ul > li:nth-child(1) > a"));
        String star1 = starElement1.getText();
                
        WebElement starElement2 = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li.ipc-metadata-list__item.ipc-metadata-list-item--link > div > ul > li:nth-child(2) > a"));
        String star2 = starElement2.getText();
                
        WebElement starElement3 = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li.ipc-metadata-list__item.ipc-metadata-list-item--link > div > ul > li:nth-child(3) > a"));
        String star3 = starElement3.getText();
        
        
        //Return to HomePage by clicking on "IMDB" Logo from the Global Header 
        driver.findElement(By.xpath("//*[@id=\"home_img_holder\"]")).click();
        
        //Perform a direct search for "Betty Blue"
        WebElement searchBox = driver.findElement(By.id("suggestion-search"));
        searchBox.sendKeys("Betty Blue");
        
        //Select the Search Option for "Betty Blue"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-autowhatever-navSuggestionSearch--item-0 > a"))).isDisplayed();
        WebElement bettyBlueSearchOption = driver.findElement(By.cssSelector("#react-autowhatever-navSuggestionSearch--item-0 > a"));
        System.out.println(bettyBlueSearchOption);
        bettyBlueSearchOption.click();
        
        	//Director found by Searching
        	WebElement directorElementSearchPage = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li:nth-child(1) > div > ul > li > a"));
        	String directorSearchPage = directorElementSearchPage.getText();
        
        	//Writers found by Searching
        	WebElement writer1ElementSearchPage = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li:nth-child(2) > div > ul > li:nth-child(1) > a"));
        	String writer1SearchPage = writer1ElementSearchPage.getText();
        	
        	WebElement writer2ElementSearchPage = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li:nth-child(2) > div > ul > li:nth-child(2) > a"));
        	String writer2SearchPage = writer2ElementSearchPage.getText();
        
        	//Stars found by Searching
        	WebElement star1ElementSearchPage = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li.ipc-metadata-list__item.ipc-metadata-list-item--link > div > ul > li:nth-child(1) > a"));
        	String star1SearchPage = star1ElementSearchPage.getText();
        	
        	WebElement star2ElementSearchPage = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li.ipc-metadata-list__item.ipc-metadata-list-item--link > div > ul > li:nth-child(2) > a"));
        	String star2SearchPage = star2ElementSearchPage.getText();
        	
        	WebElement star3ElementSearchPage = driver.findElement(By.cssSelector("section > div.sc-69e49b85-3.dIOekc > div > ul > li.ipc-metadata-list__item.ipc-metadata-list-item--link > div > ul > li:nth-child(3) > a"));
        	String star3SearchPage = star3ElementSearchPage.getText();
        	
        	
        //Compare the details recorded from two access methods
        Assert.assertEquals(director, directorSearchPage, "Director Info is matched");
        
        Assert.assertEquals(writer1, writer1SearchPage, "Writer1 Info is matched");
        Assert.assertEquals(writer2, writer2SearchPage, "Writer2 Info is matched");
        
        Assert.assertEquals(star1, star1SearchPage, "Star1 Info is matched");
        Assert.assertEquals(star2, star2SearchPage, "Star2 Info is matched");
        Assert.assertEquals(star3, star3SearchPage, "Star3 Info is matched");       
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
