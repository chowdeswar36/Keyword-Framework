package DriverPackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import BasePackage.ActionKeywords;
import BasePackage.Constants;
import utilies.ReadExcelData;

public class DriverScript {

	static ActionKeywords action;
	static Method[] method;

	public static void main(String[] args) throws IOException, InterruptedException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		action = new ActionKeywords();
		method = action.getClass().getDeclaredMethods();
		System.out.println("Total methods :" + method.length);

		for (int i = 1; i <= ReadExcelData.getRowCount(Constants.xlfilepath, Constants.sheetName); i++) {
			String actionValue = ReadExcelData.getActionData(Constants.xlfilepath, Constants.sheetName, i,
					Constants.act_colNum);
			String objectValue = ReadExcelData.getObjectData(Constants.xlfilepath, Constants.sheetName, i,
					Constants.obj_colNum);
			System.out.println(actionValue + "------------" + objectValue);
			boolean flag = excuteTestCase(actionValue, objectValue);
			if (flag) {
				ReadExcelData.setCellData(Constants.xlfilepath, Constants.sheetName, i, 5, "PASS");
			} else {
				ReadExcelData.setCellData(Constants.xlfilepath, Constants.sheetName, i, 5, "FAIL");
			}
			Thread.sleep(1000);
		}
	}

	public static boolean excuteTestCase(String actionValue, String objectValue)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		boolean flag = false;
		for (int j = 0; j < method.length; j++) {
			if (method[j].getName().equals(actionValue)) {
				System.out.println("Action Matched");
				method[j].invoke(action, objectValue);
				flag=true;
				break;
			}
		}
		return flag;

		///////////////
//		(((i)))	for (int i = 1; i <= 7; i++) {
		//
//					String keyword = ReadExcelData.getActionData("KeywordFile.xlsx", "Sheet 1", i, 3);
//					System.out.println(keyword);
		//
//					if (keyword.equals("open_browser")) {
//						action.open_browser();
//						ExcelUtils.setCellData("KeywordFile.xlsx", "Sheet 1", i, 4, "PASS");
//					} else if (keyword.equals("navigate_to_page")) {
//						action.navigate_to_page();
//						ExcelUtils.setCellData("KeywordFile.xlsx", "Sheet 1", i, 4, "PASS");
//					} else if (keyword.equals("enter_username")) {
//						action.enter_username();
//						ExcelUtils.setCellData("KeywordFile.xlsx", "Sheet 1", i, 4, "PASS");
//					} else if (keyword.equals("enter_password")) {
//						action.enter_password();
//						ExcelUtils.setCellData("KeywordFile.xlsx", "Sheet 1", i, 4, "PASS");
//					} else if (keyword.equals("click_login")) {
//						action.click_login();
//						ExcelUtils.setCellData("KeywordFile.xlsx", "Sheet 1", i, 4, "PASS");
//					} else if (keyword.equals("click_logout")) {
//						action.click_logout();
//						ExcelUtils.setCellData("KeywordFile.xlsx", "Sheet 1", i, 4, "PASS");
//					} else if (keyword.equals("close_browser")) {
//						action.close_browser();
//						ExcelUtils.setCellData("KeywordFile.xlsx", "Sheet 1", i, 4, "PASS");
//					}
		//
//				}

//				Method[] method = action.getClass().getDeclaredMethods();
//				System.out.println(method.length);
//				for (int i = 1; i <= ReadExcelData.getRowCount(Constants.xlfilepath, Constants.sheetName); i++) {
//					String keyword = ReadExcelData.getActionData(Constants.xlfilepath, Constants.sheetName, i, Constants.act_colNum);
//					System.out.println(keyword);
//					for (int j = 0; j < method.length; j++) {
//						System.out.println("method  " + method[j].getName());
//						if (method[j].getName().equals(keyword)) {
//							System.out.println("Match");
//							method[j].invoke(action);
//							break;
//						}
//					}
//				}
	}
}
