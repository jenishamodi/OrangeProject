package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] readdata(String Sheetname) {
		FileInputStream file=null;
		try {
			file=new FileInputStream("D:\\Jenisha\\OrangeHRM\\src\\test\\java\\testdata\\Details.xlsx"); //read excel file as a Details.xlsx file
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book =  WorkbookFactory.create(file); //created workbook //HSSF  //XSSF
		} catch (IOException a) {
		    a.printStackTrace();
		}
		
		//read worksheet under workbook
		sheet= book.getSheet(Sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//fetch row and coloum data from worksheet under workbook
		for(int i=0;i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}

}
