package com.qa.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;


public class LandingPageObjects {
	
	private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);
	
	private WebDriver driver;
	private WebDriverWait wait;
	
    //Paratmerize the constructor
    public LandingPageObjects(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }
    
    // Page Locators
    private By landingPageLogo = By.xpath("//img[@alt='Website for automation practice']");
    private By signupLoginButton = By.xpath("//a[text()=' Signup / Login']");
    private By logoutButton = By.xpath("//a[text()=' Logout']");
    private By deleteAccButton = By.xpath("//a[text()=' Delete Account']");
    private By loggedInUserNameTxt = By.xpath("//a[text()= ' Logged in as ']/b");
    
    
    // Page Methods
    public void validateAppLogo()
    {
    	WebElement landingPageLogoEle = driver.findElement(landingPageLogo);
	    Assert.assertEquals(true, landingPageLogoEle.isDisplayed());
    }
    
    public void clickOnSignUpLoginBtn()
    {
    	WebElement signupLoginButtonEle = driver.findElement(signupLoginButton);
 	   	signupLoginButtonEle.click();
    }
    
    public void validateLogoutButtonFormHeader(String logoutButtontext)
    {
		WebElement logoutButtonEle = driver.findElement(logoutButton);
		Assert.assertEquals(logoutButtontext, logoutButtonEle.getText().trim());
    }
    
    public void validateDelAccButtonFrmHeader(String deleteAccountButtontext)
    {
    	WebElement deleteAccButtonEle = driver.findElement(deleteAccButton);
		Assert.assertEquals(deleteAccountButtontext, deleteAccButtonEle.getText().trim());
    }
    
    public void validateUserNameLoggedInAs(String loggedInUserName)
    {
		WebElement loggedInUserNameTxtEle = driver.findElement(loggedInUserNameTxt);
		Assert.assertEquals(loggedInUserName, loggedInUserNameTxtEle.getText().trim());
    }
    

}
