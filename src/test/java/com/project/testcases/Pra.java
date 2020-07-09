package com.project.testcases;

import java.util.ArrayList;

import com.utility.base.ExcelDataReader;

public class Pra extends Prerequisite{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> str=new ArrayList<String>();
		ArrayList<Integer> num=new ArrayList<Integer>();
        
        str=excel.getColumnDataWithStringValues("sheet1", "StringColumn");
           for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i));}
			
			str=excel.getColumnDataWithStringValues("sheet1", "StringColumn1");
	           for (int i1 = 0; i1 < str.size(); i1++) {
				System.out.println(str.get(i1));
				} 
	           
	           num=excel.getColumnDataWithNumericValues("sheet1", "IntegerColumn");
	           for (int i1 = 0; i1 < num.size(); i1++) {
				System.out.println(num.get(i1));
				}
	}


}	
