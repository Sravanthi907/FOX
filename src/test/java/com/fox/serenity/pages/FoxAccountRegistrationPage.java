package com.fox.serenity.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fox.serenity.utils.SeleniumUtils;

import net.serenitybdd.core.annotations.findby.FindBy;

public class FoxAccountRegistrationPage extends BasePage {

	private String GenderSelection = "//div[text()='#']";

	public FoxAccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[text()='Sign Up']")
	private WebElement btnSignUp;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement btnSignIn;
	
	
	@FindBy(xpath = "//div[contains(text(),'Thanks')]")
	private WebElement registrationConfirmation;
	
	@FindBy(name = "signupFirstName")
	private WebElement FirstName;

	@FindBy(name = "signupLastName")
	private WebElement LastName;

	@FindBy(name = "signupEmail")
	private WebElement Email;

	@FindBy(name = "signupPassword")
	private WebElement Password;

	@FindBy(xpath = "//input[@placeholder='Birthdate']")
	private WebElement BirthDate;

	@FindBy(xpath = "//div[contains(@class,'signupButtonDesktop')]//button[text()='Create Profile']")
	private WebElement btnCompleteProfile;

	@FindBy(xpath = "//a[text()='Gender']")
	private WebElement GenderDropdown;

	@FindBy(name = "signinEmail")
	private WebElement SignInEmail;


	@FindBy(name = "signinPassword")
	private WebElement SignInPassword;

	public WebElement getSignInEmail() {
		return SignInEmail;
	}

	public WebElement getSignInPassword() {
		return SignInPassword;
	}

	public WebElement getGenderDropdown() {
		return GenderDropdown;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getBirthDate() {
		return BirthDate;
	}

	public WebElement getBtnCompleteProfile() {
		return btnCompleteProfile;
	}

	public WebElement getBtnSignIn() {
		return btnSignIn;
	}

	public WebElement getBtnSignUp() {
		return btnSignUp;
	}
	
	public WebElement getRegistrationConfirmation() {
		return registrationConfirmation;
	}
	public void clickSignUpButton() {

		sleep(5000);
		SeleniumUtils.safeclick(getDriver(), getBtnSignUp());

	}

	public void clickFinishRegistrationButton() {

		SeleniumUtils.safeclick(getDriver(), getBtnCompleteProfile());

	}

	public void enterYourInformation(String firstname, String lastname, String password) {

		SeleniumUtils.safeclearandtype(getDriver(), getFirstName(), firstname);
		SeleniumUtils.safeclearandtype(getDriver(), getLastName(), lastname);
		int random = (int) (Math.random() * 1000 + 1);
		String email = "TestFox" + (new Integer(random)).toString() + "@gmail.com";
		SeleniumUtils.safeclearandtype(getDriver(), getEmail(), email);
		SeleniumUtils.safeclearandtype(getDriver(), getPassword(), password);

	}

	public void selectGender(String Gender) {

		SeleniumUtils.safeclick(getDriver(), getGenderDropdown());
		WebElement element = getDriver().findElement(By.xpath(GenderSelection.replace("#", Gender)));
		SeleniumUtils.scrollIntoElementView(element, getDriver());
		SeleniumUtils.safeclick(getDriver(), element);

	}

	public void enterBirthDate(String Birthdate) {

		getBirthDate().sendKeys(Birthdate);
	

	}

	public void clickCompleteProfileCTA() {

		SeleniumUtils.safeclick(getDriver(), getBtnCompleteProfile());

	}

	public void enterLoginInformation(String Email, String password) {

		SeleniumUtils.safeclearandtype(getDriver(), getSignInEmail(), Email);
		SeleniumUtils.safeclearandtype(getDriver(), getSignInPassword(), password);

	}

	public void clickSignInButton() {

		SeleniumUtils.safeclick(getDriver(), getBtnSignIn());

	}
	
	public void verifyRegistrationMsg(){
		
		Assert.assertTrue(getRegistrationConfirmation().isDisplayed());
	}

}
