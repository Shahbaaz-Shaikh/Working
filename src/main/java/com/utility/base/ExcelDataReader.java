package com.utility.base;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

	String ProjectPath=System.getProperty("user.dir");
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	public ExcelDataReader() {
			try {	
				FileInputStream fis=new FileInputStream(ProjectPath+"/src/test/java/com/project/config/Testdata.xlsx");
				wb=new XSSFWorkbook(fis);
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Unabcle to read excel file "+e.getMessage());
			}
	} //closing of constructor
	
	public ExcelDataReader(String sheetName) {
		try {	
			FileInputStream fis=new FileInputStream(ProjectPath+"/src/test/java/com/project/config/"+sheetName);
			wb=new XSSFWorkbook(fis);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unabcle to read excel file "+e.getMessage());
		}
	}  //closing of parameterized constructor
	
	public ArrayList<String> getColumnDataWithStringValues(String sheetName,String colName)
	{
		
		int sheetcount=wb.getNumberOfSheets(); //stores sheet count
		int columnIndex=0;
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<sheetcount;i++)   //loop to traverse to required sheet
		{
			
			if(wb.getSheetName(i).equalsIgnoreCase(sheetName))
			{
				sheet=wb.getSheetAt(i);
				Iterator<Row> rowIterator=sheet.iterator();
				Row fisrtRow=rowIterator.next();
				Iterator<Cell> cellIterator=fisrtRow.iterator();
				int index=0;
				while (cellIterator.hasNext()) {
					Cell cellValue=cellIterator.next();
					if(cellValue.getStringCellValue().equalsIgnoreCase(colName))
						columnIndex=index;
					index++;
				}
				
				while(rowIterator.hasNext()) {
					Row r=rowIterator.next();
					String str=(String) r.getCell(columnIndex).getStringCellValue();
					list.add(str);
				}
			}
		}
		
		return list;
		
	}
	public ArrayList<Integer> getColumnDataWithNumericValues(String sheetName,String colName)
	{
		int sheetCount=wb.getNumberOfSheets();
		int columnIndex=0;
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<sheetCount;i++)
		{
			sheet=wb.getSheetAt(i);
			if(sheet.getSheetName().equalsIgnoreCase(sheetName))
			{
				Iterator<Row> rowIterator=sheet.iterator();
				Row firstRow=rowIterator.next();
				Iterator<Cell> cellIterator=firstRow.iterator();
				int index=0;
				while(cellIterator.hasNext()) {
					Cell cellValue=cellIterator.next();
					if(cellValue.getStringCellValue().equalsIgnoreCase(colName))
						columnIndex=index;
					index++;
				}
				
				while(rowIterator.hasNext()) {
					Row r=rowIterator.next();
					int value=(int) r.getCell(columnIndex).getNumericCellValue();
					list.add(value);
				}
				
			}
		}
		
		return list;
	}
}
	
	
