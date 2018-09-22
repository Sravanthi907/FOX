package com.fox.serenity.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel {

	String Shows = "";
	DataFormatter formatter = new DataFormatter();
	File fileName = new File("Results\\Results.xls");

	public static void Create_sheet(String File_Location) {

		if (!File_Location.contains("null")) {

			File fileName = new File(File_Location);

			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook();
			Sheet Sheet0 = workbook.createSheet("Results");
			Cell Summary_cell0 = Sheet0.createRow(0).createCell(0);

			Summary_cell0.setCellValue("Shows");

			try {
				FileOutputStream fos = new FileOutputStream(fileName);
				workbook.write(fos);
				fos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

	public static void update_sheet(String Shows, String file_location) throws IOException {

		// String file_location = "Results\\Results.xls";

		if (!file_location.contains("null")) {

			File fileName = new File(file_location);

			@SuppressWarnings("resource")
			FileInputStream fis1 = new FileInputStream(file_location);
			Workbook wb = new HSSFWorkbook(fis1);
			Sheet sheet0 = wb.getSheetAt(0);
			Cell Summary_cell = sheet0.createRow(0).createCell(0);
			Summary_cell.setCellValue("Shows");
			int mc = sheet0.getLastRowNum();
			Cell Summary_cell0 = sheet0.createRow(mc + 1).createCell(0);
			Summary_cell0.setCellValue(Shows);

			try {
				FileOutputStream fos = new FileOutputStream(fileName);
				wb.write(fos);
				fos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		else {

			Create_sheet(file_location);
			File fileName = new File(file_location);

			@SuppressWarnings("resource")
			FileInputStream fis1 = new FileInputStream(file_location);
			Workbook wb = new HSSFWorkbook(fis1);
			Sheet sheet0 = wb.getSheetAt(0);
			int mc = sheet0.getLastRowNum();
			Cell Summary_cell0 = sheet0.createRow(mc + 1).createCell(0);
			Summary_cell0.setCellValue(Shows);

			try {
				FileOutputStream fos = new FileOutputStream(fileName);
				wb.write(fos);
				fos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

	public static void update_sheets(String duplicated, String file_location, String name) throws IOException {

		if (!file_location.contains("null")) {

			File fileName = new File(file_location);

			@SuppressWarnings("resource")
			FileInputStream fis1 = new FileInputStream(file_location);
			Workbook wb = new HSSFWorkbook(fis1);
			Sheet sheet0 = wb.getSheetAt(0);
			Sheet sheet1 = wb.getSheetAt(1);
			Sheet sheet2 = wb.getSheetAt(2);
			Sheet sheet3 = wb.getSheetAt(3);
			if (name.equalsIgnoreCase("FX")) {
				Cell Summary_cell = sheet0.createRow(0).createCell(0);
				Cell Summary_cel2 = sheet0.createRow(0).createCell(1);
				Summary_cel2.setCellValue("Results");
				int mc = sheet0.getLastRowNum();
				Cell Summary_cell0 = sheet0.createRow(mc + 1).createCell(0);
				Cell Summary_cell1 = sheet0.createRow(mc + 1).createCell(1);
				Summary_cell1.setCellValue(duplicated);
				try {
					FileOutputStream fos = new FileOutputStream(fileName);
					wb.write(fos);
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if (name.equalsIgnoreCase("National Geographic")) {
				Cell Summary_cell = sheet1.createRow(0).createCell(0);
				Cell Summary_cel2 = sheet1.createRow(0).createCell(1);
				Summary_cel2.setCellValue("Results");
				int mc = sheet1.getLastRowNum();
				Cell Summary_cell0 = sheet1.createRow(mc + 1).createCell(0);
				Cell Summary_cell1 = sheet1.createRow(mc + 1).createCell(1);
				Summary_cell1.setCellValue(duplicated);
				try {
					FileOutputStream fos = new FileOutputStream(fileName);
					wb.write(fos);
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} else if (name.equalsIgnoreCase("National Geographic")) {

				Cell Summary_cell = sheet2.createRow(0).createCell(0);
				Cell Summary_cel2 = sheet2.createRow(0).createCell(1);
				Summary_cel2.setCellValue("Results");
				int mc = sheet2.getLastRowNum();
				Cell Summary_cell0 = sheet2.createRow(mc + 1).createCell(0);
				Cell Summary_cell1 = sheet2.createRow(mc + 1).createCell(1);
				Summary_cell1.setCellValue(duplicated);
				try {
					FileOutputStream fos = new FileOutputStream(fileName);
					wb.write(fos);
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} else {

				Cell Summary_cell = sheet3.createRow(0).createCell(0);
				Cell Summary_cel2 = sheet3.createRow(0).createCell(1);
				Summary_cel2.setCellValue("Results");
				int mc = sheet3.getLastRowNum();
				Cell Summary_cell0 = sheet3.createRow(mc + 1).createCell(0);
				Cell Summary_cell1 = sheet3.createRow(mc + 1).createCell(1);
				Summary_cell1.setCellValue(duplicated);
				try {
					FileOutputStream fos = new FileOutputStream(fileName);
					wb.write(fos);
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

			

		}
	}

	public static String ts() {
		return "[" + new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()) + "] ";
	}

}
