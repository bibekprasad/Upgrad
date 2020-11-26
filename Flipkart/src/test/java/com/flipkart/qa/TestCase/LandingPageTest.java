package com.flipkart.qa.TestCase;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LandingPageTest extends TestBase{
	LandingPage landingPage;


	public LandingPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() throws MalformedURLException, AWTException {
		initialization();
		landingPage = new LandingPage(driver);
	}

	@Test(priority=1)
	public void landingPageTitleTest() throws InterruptedException {

		Thread.sleep(2000);
		landingPage.cancelLoginPopUp();

		String title = landingPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}

	@Test(priority=2)
	public void searchBoxTest(){
		boolean flag = landingPage.validateSearchBoxIsPresent();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void searchTextTestAndVerifySame() throws InterruptedException {
		landingPage.enterSearchQuery("Solid Men Round Neck Blue, Grey T-Shirt");
		Thread.sleep(4000);
			/*landingPage.verifySearchResultTag();
			landingPage.getItemName();*/

		String currentPageHandle = driver.getWindowHandle();
		landingPage.clickSecondItem();


		driver.manage().timeouts().pageLoadTimeout(2,TimeUnit.SECONDS);


		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());

		String pageTitle = "Icable Color Block Men Round or Crew Maroon, Grey T-Shirt - Buy Icable Color Block Men Round or Crew Maroon, Grey T-Shirt Online at Best Prices in India | Flipkart.com";
		boolean myNewTabFound = false;

		for(String eachHandle : tabHandles)
		{
			driver.switchTo().window(eachHandle);
			// Check Your Page Title
			if(driver.getTitle().equalsIgnoreCase(pageTitle))
			{
				// Report ur new tab is found with appropriate title

				//Close the current tab
				driver.close(); // Note driver.quit() will close all tabs

				//Swithc focus to Old tab
				driver.switchTo().window(currentPageHandle);
				myNewTabFound = true;
			}
		}

		if(myNewTabFound)
		{
			System.out.println("Page Not opened as expected");
		}

	}

	@Test(priority=4)
	public void verifyNewPageItem() throws InterruptedException {
		landingPage.newPageItemIsPresent();
		landingPage.clickSizeChart();
		Thread.sleep(1000);
		String size = landingPage.fetchSizeXL();
		System.out.println("SIZE of Tshirt "+size);

	}


	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	

}
