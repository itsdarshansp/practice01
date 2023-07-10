package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src= new File("./testdata/testdata.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Problem in Exceldataprovider: "+ e.getMessage());
		}	
	}
	
	public String getStringData(int sheetIndex,int row,int column) {
		return wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
	}
	
	public double getNumericData(int sheetIndex,int row,int column) {
		return wb.getSheetAt(0).getRow(0).getCell(0).getNumericCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
}
