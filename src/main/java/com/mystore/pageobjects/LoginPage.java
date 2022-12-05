package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
* @author Umut
*
 */
public class LoginPage extends BaseClass {
    public static Action action;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement username;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement password;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement signInBtn;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement signUpNameBox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signUpEmailBox;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signUpBtn;

    public LoginPage(){
        PageFactory.initElements(driver,this);

    }
   public HomePage login(String uname, String pword) throws Throwable{
       action.type(username,uname);
       action.type(password,pword);
       action.click(driver,signInBtn);
       return new HomePage();
   }
   public AccountCreationPage createNewAccount(String newUsername, String newEmailAdress){
        action.type(signUpNameBox,newUsername);
        action.type(signUpEmailBox,newEmailAdress);
        action.click(driver,signUpBtn);
        return new AccountCreationPage();
   }
}
