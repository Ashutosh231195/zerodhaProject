package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.extractor.MainExtractorFactory;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrisation {
	public static String exelData(int row, int cell) throws EncryptedDocumentException, IOException {
		     FileInputStream file=   new FileInputStream("C:\\Users\\Aashuu\\eclipse-workspace\\KiteZerodha\\src\\test\\resources\\Zerodha.xlsx");
		   String Data=  WorkbookFactory.create(file).getSheet("TestData").getRow(row).getCell(cell).getStringCellValue();
	
		
		return Data;
	}
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	}
}
