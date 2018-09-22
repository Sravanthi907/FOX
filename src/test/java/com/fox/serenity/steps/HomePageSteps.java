package com.fox.serenity.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.fox.serenity.pages.FoxAccountRegistrationPage;
import com.fox.serenity.utils.SeleniumUtils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps {

	FoxAccountRegistrationPage AccountRegistration;

	@Step
	@Given("the user on the registration Page")
	public void givenTheUserOnTheRegistrationPage() {

		AccountRegistration.openAt(SeleniumUtils.getBaseURL() + "account/");
		
	}
	@Step
	@When("the user enters contact details- <firstname>, <lastname>,<password>")
	public void whenTheUserEntersContactDetailsfirstnamelastnamepassword(String firstname, String lastname,
			String password) {

		AccountRegistration.clickSignUpButton();
		AccountRegistration.enterYourInformation(firstname, lastname, password);
	}

	@Step
	@When("select the Gender <Gender>")
	public void whenSelectTheGenderGender(String Gender) {

		AccountRegistration.selectGender(Gender);

	}

	@Step
	@When("enter the Birthdate <Birthdate>")
	public void whenEnterTheBirthdateBirthdate(String Birthdate) {

		AccountRegistration.enterBirthDate(Birthdate);

	}

	@Step
	@When("Clicks the Complete Profile CTA")
	public void whenClicksTheCompleteProfileCTA() {

		AccountRegistration.clickCompleteProfileCTA();
	}

	@Step
	@Then("verify that the user can be registered")
	public void thenVerifyThatTheUserCanBeRegistered() {

		AccountRegistration.verifyRegistrationMsg();
	}

	@Step
	@When("the user enters contact details- <Email>,<password>")
	public void whenTheUserEntersContactDetailsEmailpassword(String Email, String password) {

		AccountRegistration.enterLoginInformation(Email, password);

	}

	@Step
	@When("Clicks Sign In CTA")
	public void whenClicksSignInCTA() {

		AccountRegistration.clickSignInButton();
	}

	@Step
	@Then("verify that user can be logged In.")
	public void thenVerifyThatUserCanBeLoggedIn() {

		AccountRegistration.verifysignIn();
	}

}
