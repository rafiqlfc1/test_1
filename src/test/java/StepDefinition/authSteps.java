package StepDefinition;

import Pages.authLogic;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class authSteps {

    authLogic auth = new authLogic();

    @Given("Register to the application using {string} and {string}")
    public void register (String username, String pwd) {
        auth.register(username, pwd);
    }

    @Given("Login to the application using {string} and {string}")
    public void loginToTheApplication(String username, String pwd) throws InterruptedException {
        auth.login(username, pwd);
    }

    @When("Check the products in each category")
    public void checkProductsinCat () throws InterruptedException {
        auth.checkProductsinCat();
    }

    @Then("Add specific Item to cart")
    public void addItemtoCart () {
        auth.addItemtoCart();
    }

    @Then("Go to Cart")
    public void goToCart () {
        auth.goToCart();
    }

    @Then("Remove the added Item from cart")
    public void removeItemFromCart () {
        auth.removeItemFromCart();
    }

    @Then("Purchase the Item and add {string}, {string}, {string}, {string}, {string} and {string}")
    public void checkout (String name, String country, String city, String card, String month, String year) throws InterruptedException {
        auth.checkout(name, country, city, card, month, year);
    }
}
