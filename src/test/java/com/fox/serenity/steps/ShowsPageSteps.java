package com.fox.serenity.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.fox.serenity.pages.Shows;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ShowsPageSteps extends ScenarioSteps  {

	Shows shows;
	
	@Step
	@When("User Selects Navigation Tab <Tab>")
	public void whenUserSelectsNavigationTabTab(String Tab) {
		
		
		shows.sleep(5000);
		shows.selectTopNavigationTabs(Tab);
	}

	
	@Step
	@When("select the shows sub tab <subTab>")
	public void whenSelectThesubTab(String subTab) {
		
		shows.selectShowsSubNavigationTab(subTab);
	}


	@Step
	@Then("capture the last 4 shows")
	public void whenCaptureTheLast4Shows() {
		
		shows.captureShows();
		
		
	}


}
