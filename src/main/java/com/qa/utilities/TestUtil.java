package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
public static long PAGE_LOAD_TIMEOUT= 20;
public static long IMPLICIT_WAIT =20;
public static String TEST_DATA_PATH = "//";

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

}
