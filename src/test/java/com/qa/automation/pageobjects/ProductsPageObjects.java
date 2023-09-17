package com.qa.automation.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPageObjects {
	
	private static final Logger logger = LogManager.getLogger(ProductsPageObjects.class);
	
	private WebDriver driver;
	private WebDriverWait wait;
	
    //Paratmerize the constructor
    public ProductsPageObjects(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }
    
    // Page Locators
    private By productSearchBox = By.xpath("//input[@id='search_product']");
    private By productSearchBtn = By.xpath("//button[@id='submit_search']");
    private By searchedProdList = By.xpath("//div[@class='features_items']//div[@class='productinfo text-center']/p");
    
    
    // Page Methods
    public String productsPageUrl()
    {
    	String prodPageUrl = "/products";
    	return prodPageUrl;
    }
    
    public void validateProdPageTitle(String pageTitle)
    {
	    wait.until(ExpectedConditions.titleContains(pageTitle));
	    Assert.assertEquals(pageTitle, driver.getTitle());
    }
    
    public void validateProdPageUrlKeyword(String keywordInUrl)
    {
    	wait.until(ExpectedConditions.urlContains(keywordInUrl));
		Assert.assertEquals(true, driver.getCurrentUrl().contains(keywordInUrl));
    }
    
    public void searchForProduct(String productName)
    {
    	WebElement productSearchBoxEle = driver.findElement(productSearchBox);
		productSearchBoxEle.sendKeys(productName);
    }
    
    public void clickOnProdSearchButton()
    {
    	WebElement productSearchBtnEle = driver.findElement(productSearchBtn);
		productSearchBtnEle.click();
    }
    
    public void valProdListFirstProdName(String productNameKeyowrd)
    {
    	List<WebElement> searchedProdListEle = driver.findElements(searchedProdList);
 	   Assert.assertEquals(true, searchedProdListEle.get(0).getText().contains(productNameKeyowrd));
    }

}
