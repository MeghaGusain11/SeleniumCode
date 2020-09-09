package com.qa.utilities;

import java.io.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT=40;
	public static long IMPLICIT_WAIT=20;
	//public static String TEST_DATA_PATH = "C:\\Users\\meghagusain\\eclipse-workspace1\\AID1\\src\\main\\java\\com\\qa\\testdata\\TestData.xlsx";
	public static String TEST_DATA_PATH = "C:\\Users\\meghagusain\\eclipse-workspace1\\AID1\\src\\main\\java\\com\\qa\\testdata\\TestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		try {
			file = new FileInputStream (System.getProperty("user.dir")+TEST_DATA_PATH);
		}
		catch(FileNotFoundException fe )
		{
			fe.printStackTrace();
		}
		
		
			try {
				book= WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		sheet =  book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()] ;
		
		for(int i=0; i< sheet.getLastRowNum();i++)
			for (int j=0; j <sheet.getRow(0).getLastCellNum() ; j++)
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
	return data;
	}
	
}
	

