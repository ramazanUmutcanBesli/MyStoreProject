package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement signInBtn;

    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    WebElement myStoreLogo;

    /*
    *Search box bu örnekte automationpractice.com üzerinde index pagede bulundugu
    * için bu classa konuldu fakat bizim yapmış oldugumuz örnek başka bir websitesine
    * ait oldugu için bu sayfaya eklenmemiştir
    *
    *
     */
    //TODO: Search box inspect edilecek
    //TODO: Search submit button locate edilecek
    //To initialize
    public IndexPage(){
        PageFactory.initElements(driver,this);
    }


    // According to Test cases we need to click on firstly Sigin button
    public static Action action;
    public LoginPage clickOnSignIn()throws Throwable{
        action.click(driver,signInBtn);
        return new LoginPage();
    }
    public boolean validateLogo() throws Throwable{
       return action.isDisplayed(driver,myStoreLogo);
    }
    public String getMySiteTitle(){
       String myStoreTitle= driver.getTitle();
       return myStoreTitle;
    }

}
