package com.fox.serenity.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fox.serenity.utils.SeleniumUtils;

import net.serenitybdd.core.annotations.findby.FindBy;

public class Shows extends BasePage {

	public Shows(WebDriver driver) {
		super(driver);
	}

	Excel excel;
	private String ShowsSubNavigationTabs = "//div/a[text()='#']";

	@FindBy(xpath = "//div[@class='Shows_screen_3dtIQ']//div[contains(@class,'Tile_tile_3qaLc')]")
	private WebElement showsList;

	public WebElement getShowsList() {
		return showsList;
	}

	public void selectShowsSubNavigationTab(String subTab) {
		WebElement element = getDriver().findElement(By.xpath(ShowsSubNavigationTabs.replace("#", subTab)));
		SeleniumUtils.safeclick(getDriver(), element);

	}

	public void captureShows() {

		List<WebElement> showlist = getDriver().findElements(By.xpath(
				"//div[@class='Shows_screen_3dtIQ']//div[contains(@class,'Tile_tile_3qaLc')]/div[2]//a//div[1]/div[1]"));
		for (int i = showlist.size() - 1; i > showlist.size() - 5; i--) {
			String shows = showlist.get(i).getText();

			try {
				Excel.update_sheet(shows, "Results\\Results.xls");
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.println("**********"+showlist.get(i).getText());

		}
	}

	public void Read_sheet(String name) throws IOException {

		FileInputStream fis1 = new FileInputStream(
				"src\\test\\resources\\Book1.xlsx");
		@SuppressWarnings("resource")
		Workbook wb = new XSSFWorkbook(fis1);
		Sheet Summary_Sheet = wb.getSheetAt(0);
		int mc = Summary_Sheet.getLastRowNum();
		String duplicated = "";
		String showslistactual = "";

		try {
			for (int j = 1; j <= mc; j++)

			{

				duplicated = "";
				showslistactual = "";
				showslistactual = Summary_Sheet.getRow(j).getCell(0).getStringCellValue();
				List<WebElement> showlist = getDriver().findElements(By.xpath(
						"//div[@class='Shows_screen_3dtIQ']//div[contains(@class,'Tile_tile_3qaLc')]/div[2]//a//div[1]/div[1]"));
				for (int i = 0; i < showlist.size(); i++) {
					String shows = showlist.get(i).getText();
					if (!showslistactual.equals(null)) {

						if (showslistactual.equalsIgnoreCase(shows)) {
							duplicated = shows+"duplicated in" + name;

						}
						
					}

					else if (showslistactual.equals(null)) {

						getDriver().close();
					}
					Excel.update_sheets(duplicated, "Results\\showresults.xls",name);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		getDriver().close();

	}

}
