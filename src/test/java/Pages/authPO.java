package Pages;

import Utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class authPO extends BasePage {

    String signup_Btn = "//a[contains(@id,'signin')]";
    WebElement signup_BtnElem = driver.findElement(By.xpath(signup_Btn));

    String userName_TxtBox = "//input[@id='sign-username']";
    WebElement userName_TxtBoxElem = driver.findElement(By.xpath(userName_TxtBox));

    String pwd_TxtBox = "//input[@id='sign-password']";
    WebElement pwd_TxtBoxElem = driver.findElement(By.xpath(pwd_TxtBox));

    String confirmSignup_Btn = "//button[text()='Sign up']";
    WebElement confirmSignup_BtnElem = driver.findElement(By.xpath(confirmSignup_Btn));

    String login_btn = "//a[contains(@id,'login')]";
    WebElement login_btnElem = driver.findElement(By.xpath(login_btn));

    String userNameLogin_TxtBox = "//input[@id='loginusername']";
    WebElement userNameLogin_TxtBoxElem = driver.findElement(By.xpath(userNameLogin_TxtBox));

    String pwdLogin_TxtBox = "//input[@id='loginpassword']";
    WebElement pwdLogin_TxtBoxElem = driver.findElement(By.xpath(pwdLogin_TxtBox));

    String confirmLogin_Btn = "//button[text()='Log in']";
    WebElement confirmLogin_BtnElem = driver.findElement(By.xpath(confirmLogin_Btn));

    String checkLoggedinUser = "//a[@id='nameofuser']";

    String listofCategories = "//a[@id='cat']/following-sibling::a";

    String listofProducts = "//div[@class='card-block']";
    String firstProduct = "(//div[@class='card-block'])[1]";
    String addToCart = "//a[text()='Add to cart']";
    String goToCart = "//a[@id='cartur' and text()='Cart']";
    String deleteItemFromCart = "//a[text()='Delete']";
    String placeorder = "//button[text()='Place Order']";
    String placeOrder_menu = "//h5[text()='Place order']";
    String name_TxtBox = "//input[@id='name']";
    String country_TxtBox = "//input[@id='country']";
    String city_TxtBox = "//input[@id='city']";
    String card_TxtBox = "//input[@id='card']";
    String month_TxtBox = "//input[@id='month']";
    String year_TxtBox = "//input[@id='year']";
    String purchase = "//button[text()='Purchase']";

    String confirmPurchase = "//h2[text()='Thank you for your purchase!']";
}
