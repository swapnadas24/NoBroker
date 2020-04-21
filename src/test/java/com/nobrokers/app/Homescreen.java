package com.nobrokers.app;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class Homescreen extends ApplunchQuit {

	public void clickBuyTab() throws InterruptedException {
		// continue to Location
		driver.findElement(By.xpath(props.getProperty("loc_Continue_tab"))).click();
		Thread.sleep(1000);
		// allow make and manage calls
		driver.findElement(By.xpath(props.getProperty("make_manage_call_tab"))).click();
		Thread.sleep(500);
		// allow contact location
		driver.findElement(By.xpath(props.getProperty("contact_loc_tab"))).click();
		Thread.sleep(500);
		// allow device location
		driver.findElement(By.xpath(props.getProperty("device_loc_tab"))).click();
		Thread.sleep(500);
		Assert.assertTrue(driver.findElement(By.xpath(props.getProperty("home_screen"))).isDisplayed());
		Thread.sleep(1000);

		// click Buy
		driver.findElement(By.xpath(props.getProperty("buy_tab"))).click();

		// click Search bar to search locality
		driver.findElement(By.xpath(props.getProperty("searchBar"))).click();

		// Assert Search page
		Assert.assertTrue(driver.findElement(By.xpath(props.getProperty("search_page"))).isDisplayed());

	}

	public void fillToSearchProperty() throws InterruptedException {
		// Select dropdown on searchbar
		driver.findElement(By.xpath(props.getProperty("city_size"))).click();
		// select Mumbai
		List<AndroidElement> city = driver.findElements(By.id(props.getProperty("select_Mumbai")));
		for (int i = 0; i <= city.size();) {
			city.get(i).click();
			break;
		}

		// Search Malad and select
		driver.findElement(By.xpath(props.getProperty("select_locality"))).click();
		driver.findElement(By.xpath(props.getProperty("type_malad"))).sendKeys("Malad");
		Thread.sleep(3000);

		// select Malad West
		List<AndroidElement> m_west = driver.findElements(By.className(props.getProperty("select_malad_west")));
		for (int k = 0; k <= m_west.size();) {
			m_west.get(k).click();
			Thread.sleep(1000);
			break;
		}
		// Search and select Malad East
		driver.findElement(By.xpath(props.getProperty("select_locality"))).click();
		driver.findElement(By.xpath(props.getProperty("type_malad"))).sendKeys("Malad");
		Thread.sleep(3000);

		List<AndroidElement> m_east = driver.findElements(By.id(props.getProperty("select_malad_east")));
		for (int l = 0; l <= m_east.size();) {
			m_east.get(l).click();
			Thread.sleep(1000);
			break;
		}

		// Click on the checkbox “Include nearby Properties”
		driver.findElement(By.xpath(props.getProperty("click_new_properties"))).click();
		Thread.sleep(500);

		// Select 2BHK and 3BHK
		driver.findElement(By.id(props.getProperty("Two_bHK"))).click();
		Thread.sleep(500);
		driver.findElement(By.id(props.getProperty("Three_bHK"))).click();
		Thread.sleep(1000);

		// click Search property tab
		driver.findElement(By.id(props.getProperty("searchProperty_tab"))).click();
		Thread.sleep(1000);

	}

	public void searchfourthProperty() throws InterruptedException {

		// Select 4th property
		MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.nobroker.app:id/rv\")).getChildByText("
						+ "new UiSelector().className(\"android.widget.FrameLayout\"), \"Independent House, Marve Road, Near Atlantis Hospital, Malad West\")"));

		// Perform the action on the element
		element.click();

		// Select Description area and assert if content is there or not
		MobileElement description = driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.LinearLayout\")).getChildByText("
						+ "new UiSelector().className(\"android.widget.TextView\"), \"Description\")"));
		description.isDisplayed();

		// Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='NA']")).isDisplayed());

		if (driver.findElement(By.xpath(props.getProperty("description_NA"))).isDisplayed()) {

			System.out.println("Test Failed");
		} else {
			System.out.println("Test Passed");
		}
	}

	@Test
	public void homescreenTofourthProperty() throws InterruptedException {
		this.clickBuyTab();
		this.fillToSearchProperty();
		this.searchfourthProperty();

	}

}