package com.fox.serenity.steps;

import java.io.IOException;

import org.jbehave.core.annotations.Then;

import com.fox.serenity.pages.Shows;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ShowDuplicatePageSteps extends ScenarioSteps  {

	
	Shows shows;
	
	@Step
	@Then("update the results in Excelsheet <name>")
	public void thenUpdateTheResultsInExcelsheetname(String name) throws IOException {
		
		shows.Read_sheet(name);
		
	}
}
