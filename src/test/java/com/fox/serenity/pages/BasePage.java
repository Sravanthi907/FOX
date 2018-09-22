package com.fox.serenity.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fox.serenity.utils.SeleniumUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;


public abstract class BasePage extends PageObject {

	public BasePage(WebDriver driver) {
		super(driver);

		getDriver().manage().window().maximize();
	}

	private String TopNavigationTabs = "//div/a[text()='#']";

	
	@FindBy(xpath = "//div/a[text()='Shows']")
	private WebElement showsTab;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOut;
	
	@FindBy(id = "path-1")
	private WebElement profileIcon;
	
	
	public WebElement getSignOut() {
		return signOut;
	}



	public WebElement getProfileIcon() {
		return profileIcon;
	}



	public WebElement getShowsTab() {
		return showsTab;
	}



	public void selectTopNavigationTabs(String Tab) {
		WebElement element = getDriver().findElement(By.xpath(TopNavigationTabs.replace("#", Tab)));
		SeleniumUtils.safeclick(getDriver(), element);

	}
	
	public void clickProfileIcon(){
		
		getProfileIcon().click();
	}
	
	public void verifysignIn(){
		
		clickProfileIcon();
		Assert.assertTrue(getSignOut().isDisplayed());
	}



	public void sleep(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			System.out.println("----------Sleep interrupted----------");
		}
	}


	
}
