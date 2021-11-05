package com.vm.SeAutomationTraining;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

public class DateTest {
	
	@Test
	public void test() {
		System.out.println("Date====" + getDateIncrementedBy(-1, "dd MMM"));
		
	}
	
	
	public String getDateIncrementedBy(int days, String dateFormatType) {
		DateFormat dateFormat = new SimpleDateFormat(dateFormatType);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		String convertedDate = dateFormat.format(cal.getTime());
		return convertedDate;
	}

}
