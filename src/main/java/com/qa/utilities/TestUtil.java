package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
import com.qa.baseclass.BaseClass;

public class TestUtil extends BaseClass{
public static long PAGE_LOAD_TIMEOUT= 20;
public static long IMPLICIT_WAIT =20;
public static String TEST_DATA_PATH = "//src//main//java//com//qa//testdata//TestData.xlsx";

static Workbook book;
static Sheet sheet;

public static Object[][] getTestData(String sheetName)
{
	FileInputStream file =null;
	
try {
	file= new FileInputStream (System.getProperty("user.dir")+ TEST_DATA_PATH);
}
catch(FileNotFoundException fe)
{fe.printStackTrace();
	
}
try {
	book=WorkbookFactory.create(file);
	
}catch(IOException e) {
	e.printStackTrace();
}
sheet= book.getSheet(sheetName);
Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
for (int i=0;i<sheet.getLastRowNum();i++)
	for (int j=0; j<sheet.getRow(0).getLastCellNum();j++)
		data[i][j] = sheet.getRow(i+1).getCell(j).toString();
return data;

}


//Method for taking screenshots 
public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir=System.getProperty("user.dir");
	FileUtils.copyFile(scrFile, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
}

}
