package utilities;

import org.testng.annotations.DataProvider;
import utilities.Xls_Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProvider_Inputs {
	private static String filePath = "src\\test\\resources\\TestData\\Excel_Register_Login_Pythoncode_Practice.xlsx";

	@DataProvider(name = "getInvalidRegistrationStaticData")
	protected static Object[][] getInvalidRegistrationStaticData()
	{
		Object[][] data= {
				{"","","","Please enter User Name, Password and Confirm Password"},
				{"","Numpysdet176","Numpysdet176","Please fill out this field. below User Name"},
				{"Scrutinizers","","","Please fill out this field.below Password"},
				{"Scrutinizers","Numpysdet176","","Please fill out this field.below Confirm Password"},
				{"Scrutinizers","Numpysdet176","Numpysdet176!","password_mismatch:The two password fields didn’t match."},
				{"Scrutinizers","123456789","123456789","password cannot be only numeric"},
				{"Scrutinizers","123sA","123sa","password length doesnot meet"},
				//password_mismatch:The two password fields didn’t match.
				//{"Scrutinizers_testng","Numpysdet176!","Numpysdet176!"},
				{"Scrutinizers","123sA","123sa","password length is less than 8"},
				{"123123412","123sA","123sa","user name cannot be only numeric"}
		};
		return data;
	}

	@DataProvider(name = "getRegistrationExcelData")
	protected static Object[][] getRegistrationExcelData()
	{
		String sheetName = "Register";
		return Xls_Reader.getExcelData(filePath, sheetName);
	}
	@DataProvider(name = "getSignInInvalidData")
	protected static Object[][] getSignInInvalidData()
	{
		String sheetName = "Invalid_LogIn";
		return Xls_Reader.getExcelData(filePath, sheetName);
	}
	@DataProvider(name = "getSignInValidData")
	protected static Object[][] getSignInValidData()
	{
		String sheetName = "Valid_LogIn";
		return Xls_Reader.getExcelData(filePath, sheetName);
	}
	@DataProvider(name = "dataStructuresProvider")
	public Object[][] dataStructuresProvider() throws IOException, ParseException {
		
		// Path to your JSON file
		String dsfilePath ="src\\test\\resources\\TestData\\DScollection.json"; 
		System.out.println("In dataStructuresProvider");
		JSONParser parser = new JSONParser();
		JSONObject root = (JSONObject) parser.parse(new FileReader(dsfilePath));
		JSONArray dataStructuresArray = (JSONArray) root.get("datastructures");
		System.out.println("before dataStructuresProvider");
		// Prepare data for TestNG
		Object[][] data = new Object[dataStructuresArray.size()][1];
		for (int i = 0; i < dataStructuresArray.size(); i++) {			
			JSONObject dataStructure = (JSONObject) dataStructuresArray.get(i);
			Map<String, String> dataMap = new HashMap<>();
			dataMap.put("type", (String) dataStructure.get("type"));
			dataMap.put("index", (String) dataStructure.get("index"));
			data[i][0] = dataMap;
		}
		return data;
	}
	@DataProvider(name = "arrayPracticeCode")
	public Object[][] arrayPracticeCode() throws IOException, ParseException {
		
		// Path to your JSON file
		String dsfilePath ="src\\test\\resources\\TestData\\ArrayPractices.json"; 
		System.out.println("In arrayPracticeCode");
		JSONParser parser = new JSONParser();
		JSONObject root = (JSONObject) parser.parse(new FileReader(dsfilePath));
		JSONArray practiceArray = (JSONArray) root.get("arraysPractice");
		System.out.println("before arrayPracticeCode");
		// practice 
		Object[][] data = new Object[practiceArray.size()][1];
		for (int i = 0; i < practiceArray.size(); i++) 
		{			
			JSONObject dataStructure = (JSONObject) practiceArray.get(i);
			Map<String, String> dataMap = new HashMap<>();
			dataMap.put("type", (String) dataStructure.get("list-group-item"));
			dataMap.put("index", (String) dataStructure.get("index"));
			dataMap.put("url", (String) dataStructure.get("url"));
			dataMap.put("rowNum", (String) dataStructure.get("rowNum"));
			dataMap.put("code", (String) dataStructure.get("code"));
			dataMap.put("result", (String) dataStructure.get("result"));			
			data[i][0] = dataMap;
		}
		return data;
	}
	@DataProvider(name = "arrayPracticeCodeExcel")
	public Object[][] arrayPracticeCodeExcel() throws IOException, ParseException {		
	
			String sheetName = "pythonCode";
			return Xls_Reader.getExcelData(filePath, sheetName);		
	}
	
	
	@DataProvider(name="Array Topics")
	public Object[][] topicsLinkedlist() {
		return new Object[][] {
			{0,"Arrays in Python"},
			{1,"Arrays Using List"},
			{2,"Basic Operations in Lists"},
			{3,"Applications of Array"}
		};
		
	}
	@DataProvider(name="validcode Arrays Topics")
	public Object[][] validcodeTopics() {
		return new Object[][] {
			{0,"print'Hello'"},
			{1,"print'Hello'"},
			{2,"print'Hello'"},
			{3,"print'Hello'"}			
		};		
	}
	@DataProvider(name="invalidcode Arrays Topics")
	public Object[][] invalidcodeTopics() {
		return new Object[][] {
			{0,"printhello"},
			{1,"printhello"},
			{2,"printhello"},
			{3,"printhello"}			
		};		
	}
	@DataProvider(name = "getArrayTopicCodeExcelData")
	protected static Object[][] getArrayTopicCodeExcelData()
	{
		String sheetName = "ArrayTopicCode";
		return Xls_Reader.getExcelData(filePath, sheetName);
	}
	
	@DataProvider(name="topicsDS")
	public Object[][] topicsDS() {
		return new Object[][] {
			{0,"Time Complexity"}			
		};		
	}
	@DataProvider(name = "topicsDSValidExcelCode")
	protected static Object[][] topicsDSValidExcelCode()
	{
		String sheetName = "DsTimeComplexityValid";
		return Xls_Reader.getExcelData(filePath, sheetName);
	}
	@DataProvider(name = "topicsDSInvalidExcelCode")
	protected static Object[][] topicsDSInvalidExcelCode()
	{
		String sheetName = "DsTimeComplexityInvalid";
		return Xls_Reader.getExcelData(filePath, sheetName);
	}
}
