package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    public static Action action;
    @FindBy(xpath = "//li/a[@href='/view_cart']")
    WebElement myWishList;

    @FindBy(xpath = "//li/a[@href='/products']")
    WebElement productsPage;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public boolean validateMyWishList(){
        return action.isDisplayed(driver,myWishList);
    }
    public boolean validateProductsPage(){
        return action.isDisplayed(driver,productsPage);
    }


}
