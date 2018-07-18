package com.company.project.PageObject;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.company.project.PageConstants.KayakFlightPageConstants;


public class FlightPage {
	protected WebDriver driver;
	

	
	@FindBy(xpath=KayakFlightPageConstants.ORIGIN_AIRPORT_FIELD)
	private WebElement OriginAirportField;
	
	@FindBy(xpath=KayakFlightPageConstants.ORIGIN_AIRPORT_EDIT_FIELD)
	private WebElement OriginAirportEditField;
	
	@FindBy(xpath=KayakFlightPageConstants.FLIGHT_DESTINATION_FIELD)
	private WebElement flightDestinationField;
	
	@FindBy(xpath=KayakFlightPageConstants.FLIGHT_DESTINATION_EDIT_FIELD)
	private WebElement flightDestinationEditField;
	
	@FindBy(xpath=KayakFlightPageConstants.DROP_DOWN_VALUE)
	private WebElement DropDownValue;
	
	@FindBy(xpath=KayakFlightPageConstants.START_DATE_FIELD)
	private WebElement StartDateField;
	
	@FindBy(xpath=KayakFlightPageConstants.DEPART_INPUT_FIELD)
	private WebElement DepartInputField;
	
	@FindBy(xpath=KayakFlightPageConstants.RETURN_INPUT_FIELD)
	private WebElement returnInputField;
	
	@FindBy(xpath=KayakFlightPageConstants.SEARCH_BUTTON)
	private WebElement searchButtoon;
	
	@FindBy(xpath=KayakFlightPageConstants.SORTING_DISPLAY_BUTTON)
	private WebElement sortingDisplayButton;
	
	@FindBy(xpath=KayakFlightPageConstants.SORTING_OPTION2)
	private WebElement sortingOption2n;
	
	@FindBy(xpath=KayakFlightPageConstants.PRICE_OPTION)
	private List<WebElement> priceOption;
	

	@FindBy(xpath=KayakFlightPageConstants.PROVIDERNAME_OPTION)
	private List<WebElement> providerNameOption;
	
	

	public WebElement getSortingDisplayButton() {
		return sortingDisplayButton;
	}

	public WebElement getSortingOption2n() {
		return sortingOption2n;
	}

	public List<WebElement> getPriceOption() {
		return  priceOption;
	}

	public List<WebElement> getProviderNameOption() {
		return providerNameOption;
	}

	public WebElement getOriginAirportField() {
		return OriginAirportField;
	}

	public WebElement getOriginAirportEditField() {
		return OriginAirportEditField;
	}

	public WebElement getFlightDestinationEditField() {
		return flightDestinationEditField;
	}

	public WebElement getDropDownValue() {
		return DropDownValue;
	}

	public WebElement getStartDateField() {
		return StartDateField;
	}

	public WebElement getDepartInputField() {
		return DepartInputField;
	}

	public WebElement getReturnInputField() {
		return returnInputField;
	}

	public WebElement getSearchButtoon() {
		return searchButtoon;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFlightDestinationField() {
		return flightDestinationField;
	}

	public void setFlightDestinationField(WebElement flightDestinationField) {
		this.flightDestinationField = flightDestinationField;
	}
	
	public static FlightPage init(WebDriver driver) throws MalformedURLException {
		FlightPage home = PageFactory.initElements(driver, FlightPage.class);
		home.setDriver(driver);
		return home;
	}

}
