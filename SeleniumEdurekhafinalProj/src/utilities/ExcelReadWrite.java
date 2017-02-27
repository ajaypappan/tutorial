package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReadWrite {

	static XSSFWorkbook  wb;
	static XSSFSheet ws;
	static Row r;
	static Cell c;
	
	public static void openExcelFile(String path) throws Exception{
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
	}
	
	public static int sheetCount(String sheetname){
		ws = wb.getSheet(sheetname);
		int sCount = ws.getLastRowNum()+1;
		return sCount;
	}
	
	public static String getSheetData(String sheetname, int row, int col){
		ws = wb.getSheet(sheetname);
		c = ws.getRow(row).getCell(col);
		String cellValue = c.getStringCellValue();
		return cellValue;
	}
	
	public static void setExlValues(String sheetname, int ro, int co, String bResult) throws Exception{
		ws = wb.getSheet(sheetname);
		r = ws.getRow(ro);
		c = r.getCell(co);
		
		c.setCellValue(bResult);
		
		
		FileOutputStream fos = new FileOutputStream("");
		wb.write(fos);
		fos.flush();
		fos.close();	
	}
	
	public static int getRowContains(String Sheetname, String sTestCaseName, int colNum) throws Exception{
		int i;
		
			int rowCount = ExcelReadWrite.getRowUsed(Sheetname);
			for ( i=0 ; i<rowCount; i++){
				if  (ExcelReadWrite.getSheetData(Sheetname, i,colNum).equalsIgnoreCase(sTestCaseName)){
					break;
			}
			}
			return i;
		}
	
	public static int getRowUsed(String sheetname) throws Exception {
		
			int RowCount = ExcelReadWrite.sheetCount(sheetname);	
			return RowCount;
		}
	
	
}
