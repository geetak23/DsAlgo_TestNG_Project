package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excel_DataProvider {
@DataProvider(name="codeDp")
//public static void main(String[] args) throws Exception {
	public  Object[][] getvalidCode() throws Exception {
		File excelFile=new File("./src/test/resources/testData/Excel_Test_Data.xlsx");
		System.out.println(excelFile.exists());
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheet("Testcode");
		int Rowno=sheet.getPhysicalNumberOfRows();
		System.out.println(Rowno);
		System.out.println(sheet.getLastRowNum());
		int Cellno=sheet.getRow(0).getLastCellNum();
		System.out.println(Cellno);
		//System.out.println(Cellno);
		Object[][] testcode=new Object[Rowno-1][Cellno]; 
		for(int i=0;i<Rowno-1;i++) {
			for(int j=0; j<Cellno; j++ ) {
				DataFormatter df=new DataFormatter();
				testcode[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			
				//System.out.println( sheet.getRow(i).getCell(j).getStringCellValue());
			}

		}

		workbook.close();
		fis.close();
		return testcode;
		
			
		
	}


@DataProvider(name="Valid code topic no")
//public static void main(String[] args) throws Exception {
public Object[][] topicValidCode() throws Exception{
	File excelFile=new File("./src/test/resources/testData/Excel_Test_Data.xlsx");
	System.out.println(excelFile.exists());
	FileInputStream fis=new FileInputStream(excelFile);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet= workbook.getSheet("TopicValidCode");
	int Rowno=sheet.getPhysicalNumberOfRows();
	System.out.println(Rowno+"no of rows");
	System.out.println(sheet.getLastRowNum());
	int Cellno=sheet.getRow(0).getLastCellNum();
	System.out.println(Cellno+"no of columns");
	Object[][] topicValidcode=new Object[Rowno-1][Cellno]; 
	
	for(int i=0;i<Rowno-1;i++) {
		for(int j=0; j<Cellno; j++ ) {
			DataFormatter df=new DataFormatter();
			topicValidcode[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			//System.out.println(sheet.getRow(i+1).getCell(j).getStringCellValue());
		}
	}
	
	workbook.close();
	fis.close();
	return topicValidcode;
}
@DataProvider(name="Invalid code topic no")
public Object[][] topicInvalidCode() throws Exception{
	File excelFile=new File("./src/test/resources/testData/Excel_Test_Data.xlsx");
	//System.out.println(excelFile.exists());
	FileInputStream fis=new FileInputStream(excelFile);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet= workbook.getSheet("TopicInvalidCode");
	int Rowno=sheet.getPhysicalNumberOfRows();
	//System.out.println(Rowno+"no of rows");
	System.out.println(sheet.getLastRowNum());
	int Cellno=sheet.getRow(0).getLastCellNum();
	System.out.println(Cellno+"no of columns");
	Object[][] topicInvalidcode=new Object[Rowno-1][Cellno]; 
	
	for(int i=0;i<Rowno-1;i++) {
		for(int j=0; j<Cellno; j++ ) {
			DataFormatter df=new DataFormatter();
			topicInvalidcode[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			//System.out.println(sheet.getRow(i+1).getCell(j).getStringCellValue());
		}
	}
	
	workbook.close();
	fis.close();
	return topicInvalidcode;
}

}
/*XSSFSheet sheet= workbook.getSheet("Testcode");
int Rowno=sheet.getPhysicalNumberOfRows();
//System.out.println(sheet.getLastRowNum());
int Cellno=sheet.getRow(0).getLastCellNum();
//System.out.println(Cellno);
Object[][] validcode=new String[Rowno-1][Cellno-1]; 
for(int i=0;i<Rowno-1;i++) {
	for(int j=0; j<Cellno; j++ ) {
		DataFormatter df=new DataFormatter();
		validcode[i][j]=	sheet.getRow(i+1).getCell(j);
	
		//System.out.println( sheet.getRow(i).getCell(j).getStringCellValue());
	}

}

workbook.close();
fis.close();
for (Object[] code : testcode) {
			System.out.println(Arrays.toString(code));*/