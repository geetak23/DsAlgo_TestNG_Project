package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Xls_Reader {

	
	 public static Object[][] getExcelData(String filePath, String sheetName) {
		 Object[][] data = null;

	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheet(sheetName);
	            int rowCount = sheet.getPhysicalNumberOfRows();
	            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	            data = new Object[rowCount - 1][colCount];
	            
	            for (int i = 1; i < rowCount; i++) {
	                Row row = sheet.getRow(i);
	                if(row!=null)
	                {
	                for (int j = 0; j < colCount; j++) {
	                    Cell cell = row.getCell(j);
	                    data[i - 1][j] = (cell == null) ? "" : cell.getStringCellValue().toString(); // Handle empty cells
	                }   
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return data;
	    }	
	
	
	public List<Map<String, String>> getData(String excelFilePath, String sheetName)
			throws InvalidFormatException, IOException
	{
		Sheet sheet = getSheetByName(excelFilePath, sheetName);
		return readSheet(sheet);
	}

	public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
			throws InvalidFormatException, IOException 
	{
		Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
		return readSheet(sheet);
	}

	private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException 
	{
		Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
		return sheet;
	}

	private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException
	{
		Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
		return sheet;
	}

	private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException
	{
		return WorkbookFactory.create(new File(excelFilePath));
	}

	private List<Map<String, String>> readSheet(Sheet sheet) 
	{
		System.out.println("Reading Excel sheet "+sheet);
		Row row;
		int totalRow = sheet.getPhysicalNumberOfRows();
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		int headerRowNumber = getHeaderRowNumber(sheet);
		if (headerRowNumber != -1) {
			int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
			int setCurrentRow = 1;
			for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
				row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
				}
				excelRows.add(columnMapdata);
			}
		}
		return excelRows;
	}

	private int getHeaderRowNumber(Sheet sheet) 
	{
		Row row;
		int totalRow = sheet.getLastRowNum();
		for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
			row = getRow(sheet, currentRow);
			if (row != null) {
				int totalColumn = row.getLastCellNum();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					Cell cell;
					cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell.getCellType() == CellType.STRING) {
						return row.getRowNum();

					} else if (cell.getCellType() == CellType.NUMERIC) {
						return row.getRowNum();

					} else if (cell.getCellType() == CellType.BOOLEAN) {
						return row.getRowNum();
					} else if (cell.getCellType() == CellType.ERROR) {
						return row.getRowNum();
					}
				}
			}
		}
		return (-1);
	}

	private Row getRow(Sheet sheet, int rowNumber) 
	{
		return sheet.getRow(rowNumber);
	}

    // Retrieves the value of a cell
    private Map<String, String> getCellValue(Sheet sheet, Row row, int currentColumn)
    {
        Map<String, String> cellData = new LinkedHashMap<>();
        Cell cell;
        
        Row headerRow = sheet.getRow(sheet.getFirstRowNum());
        String columnHeaderName = headerRow.getCell(currentColumn).getStringCellValue();

        if (row == null) {
            cellData.put(columnHeaderName, "");
            return cellData;
        }

        cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

        switch (cell.getCellType()) {
            case STRING:
                cellData.put(columnHeaderName, cell.getStringCellValue());
                break;
            case NUMERIC:
                cellData.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                break;
            case BOOLEAN:
                cellData.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                break;
            case ERROR:
                cellData.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
                break;
            default:
                cellData.put(columnHeaderName, "");
        }
        return cellData;
    }
}