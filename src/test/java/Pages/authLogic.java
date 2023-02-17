package Pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;

public class authLogic extends authPO {


    public void register (String username, String pwd) {
        wait(signup_BtnElem);
        signup_BtnElem.click();
        wait(userName_TxtBoxElem);
        userName_TxtBoxElem.sendKeys(username);
        pwd_TxtBoxElem.sendKeys(pwd);
        confirmSignup_BtnElem.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert a = driver.switchTo().alert();
        String s = a.getText();
        System.out.println(s);
        if (s.contains("Sign up successful.")) {
            a.accept();
        }

    }

    public void login (String username, String pwd) throws InterruptedException {
        login_btnElem.click();
        wait(userNameLogin_TxtBoxElem);
        sleep(1000);
        userNameLogin_TxtBoxElem.sendKeys(username);
        pwdLogin_TxtBoxElem.sendKeys(pwd);
        confirmLogin_BtnElem.click();
        sleep(5000);
        WebElement checkLoggedinUserElem = driver.findElement(By.xpath(checkLoggedinUser));
        wait(checkLoggedinUserElem);
        Assert.assertTrue(checkLoggedinUserElem.getText().contains(username));
    }

    public void checkProductsinCat () throws InterruptedException {
        List<WebElement> categories = driver.findElements(By.xpath(listofCategories));

        for (int i=0; i<categories.size(); i++) {
            categories.get(i).click();
            sleep(5000);
            WebElement firstProductElem = driver.findElement(By.xpath(firstProduct));
            wait(firstProductElem);
            List<WebElement> products = driver.findElements(By.xpath(listofProducts));
            if (products.size()>1) {
                System.out.println("Number of products in "+categories.get(i).getText()+" are "+products.size());
            }
            else {
                System.out.println(categories.get(i).getText()+" has no products");
            }
        }
    }

    public void addItemtoCart () {
        WebElement firstProductElem = driver.findElement(By.xpath(firstProduct+"/h4/a"));
        firstProductElem.click();
        WebElement addToCart_Btn = driver.findElement(By.xpath(addToCart));
        wait(addToCart_Btn);
        addToCart_Btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert a = driver.switchTo().alert();
        String s = a.getText();
        System.out.println(s);
        if (s.contains("Product added.")) {
            a.accept();
        }
    }

    public void goToCart () {
        WebElement goToCartElem = driver.findElement(By.xpath(goToCart));
        goToCartElem.click();
    }

    public void removeItemFromCart () {
        WebElement removeFromCartElem = driver.findElement(By.xpath(deleteItemFromCart));
        removeFromCartElem.click();
    }

    public void checkout (String name, String country, String city, String card, String month, String year) throws InterruptedException {
        WebElement placeOrder_Btn = driver.findElement(By.xpath(placeorder));
        placeOrder_Btn.click();
        WebElement placeOrder_menuElem = driver.findElement(By.xpath(placeOrder_menu));
        wait(placeOrder_menuElem);

        WebElement nameElem = driver.findElement(By.xpath(name_TxtBox));
        WebElement countryElem = driver.findElement(By.xpath(country_TxtBox));
        WebElement cityElem = driver.findElement(By.xpath(city_TxtBox));
        WebElement cardElem = driver.findElement(By.xpath(card_TxtBox));
        WebElement monthElem = driver.findElement(By.xpath(month_TxtBox));
        WebElement yearElem = driver.findElement(By.xpath(year_TxtBox));
        WebElement purchase_Btn = driver.findElement(By.xpath(purchase));


        wait(nameElem);
        nameElem.sendKeys(name);
        countryElem.sendKeys(country);
        cityElem.sendKeys(city);
        cardElem.sendKeys(card);
        monthElem.sendKeys(month);
        yearElem.sendKeys(year);
        purchase_Btn.click();
        WebElement confirmPurchaseElem = driver.findElement(By.xpath(confirmPurchase));
        wait(confirmPurchaseElem);
        Assert.assertTrue(confirmPurchaseElem.getText().contains("Thank you for your purchase!"));
    }
}
