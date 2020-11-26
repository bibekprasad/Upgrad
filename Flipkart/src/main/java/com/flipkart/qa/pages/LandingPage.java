package com.flipkart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.flipkart.qa.base.TestBase;
import java.awt.*;
import java.awt.event.KeyEvent;

public class LandingPage extends TestBase{

	//Page Factory
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	WebElement searchBox;

	@FindBy(xpath="//button[@class='vh79eN']//*[local-name()='svg']")
	WebElement searchButton;


	@FindBy(xpath="//body/div[@id='container']/div/div[@class='t-0M7P _2doH3V']/div[@class='_3e7xtJ']/div[@class='_1HmYoV hCUpcT']/div[@class='_1HmYoV _35HD7C']/div[2]/div[1]/div[2]/div[1]")
	WebElement secondItemPlacement;

	@FindBy(xpath="//span[contains(text(),'solid men round neck blue, grey t shirt')]")
	WebElement searchResultTag;

	@FindBy(xpath="//a[contains(text(),'Color Block Men Round or Crew Maroon, Grey T-Shirt')]")
	WebElement secondItemName;

	@FindBy(xpath="//span[@class='_35KyD6']")
	WebElement newPageItemName;

	@FindBy(xpath="//span[contains(text(),'Size Chart')]")
	WebElement sizeChartIcon;

	@FindBy(xpath="//div[@class='row irCj1C']")
	WebElement sizeChartPopup;

	@FindBy(xpath="//tr[5]//td[1]")
	WebElement sizeChartXL;


	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
	WebElement loginPopUp;


	//Initializing the Page Objects:
	public LandingPage(WebDriver driver) throws AWTException {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	Robot rb = new Robot();


	//Actions:

	public void cancelLoginPopUp() throws InterruptedException {
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ESCAPE);
		loginPopUp.click();

	}


	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public boolean validateSearchBoxIsPresent(){
		return searchBox.isDisplayed();
	}

	public void enterSearchQuery(String searchText) throws InterruptedException {

		searchBox.sendKeys(searchText);
		Thread.sleep(2000);
		searchButton.click();
	}

	public boolean verifySearchResultTag(){
		return  searchResultTag.isDisplayed();
	}


	public void clickSecondItem() throws InterruptedException {
		Thread.sleep(1000);
		secondItemPlacement.click();

	}

	public String getItemName () throws InterruptedException {
		Thread.sleep(1000);
		return secondItemName.getText();
	}


	public boolean newPageItemIsPresent(){
		return newPageItemName.isDisplayed();

	}

	public void clickSizeChart(){

		sizeChartIcon.click();

	}


	public boolean verifySizeChartPopIsPresent(){
		return sizeChartPopup.isDisplayed();

	}

	public String fetchSizeXL(){
		return sizeChartXL.getText();

	}



}
