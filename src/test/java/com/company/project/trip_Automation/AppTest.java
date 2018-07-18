package com.company.project.trip_Automation;


import java.net.MalformedURLException;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.company.project.BaseClasses.BaseConstant;
import com.company.project.BaseClasses.SeleniumBaseClass;
import com.company.project.PageObject.FlightPage;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends SeleniumBaseClass
{

	@Test
	public void findCheapestAndExpensiveTrip() throws Exception
	{
		WebDriver driver=null;
		FlightPage homePage=null;
		
		try
		{
			
			
			driver=setUp();
			driver.switchTo().defaultContent();
			findCheapestAndExpensive(BaseConstant.depatureData1,BaseConstant.arrivalData1,BaseConstant.startDate1,BaseConstant.returnDate1,driver);
			
			findCheapestAndExpensive(BaseConstant.depatureData2,BaseConstant.arrivalData2,BaseConstant.startDate2,BaseConstant.returnDate2,driver);
			
			
		}
		catch (Exception e) {
			//Log.writeLog("Run test failed, test: testSanity, " + e.getMessage(), "error");
			e.printStackTrace();
			throw e;
		} finally {
			
			//tearDown(driver);
		}
		
	}

	public void findCheapestAndExpensive(String depatureData1, String arrivalData1, String startDate1,
			String returnDate1, WebDriver driver) throws MalformedURLException {
		// TODO Auto-generated method stub
		String cheapeast="";
		String cheapestFlight="";
		String timing="";
		String expFlight="";
		String expensive="";
		
		try
		{
		FlightPage home=FlightPage.init(driver);
		
		home.getOriginAirportField().click();
		home.getOriginAirportEditField().clear();
		home.getOriginAirportEditField().sendKeys(BaseConstant.depatureData1);
		home.getDropDownValue().click();
		
		home.getFlightDestinationField().click();
		home.getFlightDestinationEditField().sendKeys(BaseConstant.arrivalData1);
		home.getDropDownValue().click();
		
		home.getStartDateField().click();
		String departDate = addDate(Integer.valueOf(BaseConstant.startDate1));
		String returnDate = addDate(Integer.valueOf(BaseConstant.returnDate1));
		System.out.print("dates" +departDate +" d2: "+returnDate);
		
		home.getDepartInputField().sendKeys(departDate);
		home.getReturnInputField().sendKeys(returnDate);
		
		home.getSearchButtoon().click();
		
		//sort by cheapest
		home.getSortingDisplayButton().click();
		home.getSortingOption2n().click();
		cheapeast= home.getPriceOption().get(0).getText();
		cheapestFlight=home.getProviderNameOption().get(0).getText();
		
		int count=home.getPriceOption().size();
		expFlight= home.getProviderNameOption().get(count-1).getText();
		expensive= home.getPriceOption().get(0).getText();
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			
		}
		
		
		
		
	}
	
	public String addDate(int days) throws Exception {
	    final DateFormat dateFormat = new SimpleDateFormat(
	        "MM/ddd/yyyy");
	    Calendar c = Calendar.getInstance();
	    c.setTime(new Date()); // Now use today date.
	    c.add(Calendar.DATE, days); // Adding 5 days
	    return dateFormat.format(c.getTime());
	}
}
