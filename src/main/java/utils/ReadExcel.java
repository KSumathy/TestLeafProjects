package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static Object readExcelData(String fileName) throws IOException 
	{
		XSSFWorkbook workBook =  new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet sheet = workBook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		Object data[][]= new Object[rowCount][columnCount];
		for(int i=1;i<=rowCount;i++)
		{								
			for(int j=0;j<columnCount;j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;

	}

}
