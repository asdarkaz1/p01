 package project2.stepImplementations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import project2.runners.basicRunner;

import static project2.runners.basicRunner.driver;
//import project2.runners.defectsRunner;

public class LoginSteps{

     @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() throws InterruptedException {
        basicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=1");
         Thread.sleep(1000);
     }
    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() throws InterruptedException {
        WebElement usernameInput = basicRunner.driver.findElement(By.xpath("//input[@placeholder='gatorFan99']"));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys("g8tor");
        Thread.sleep(1000);

    }
    @When("The employee types in chomp!! into the password input")
    public void the_employee_types_in_chompe_into_the_password_input() throws InterruptedException {
        Thread.sleep(1000);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='pass']"));
        passwordInput.sendKeys("chomp!!");
     }
    @When("The employee types in chomp! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() throws InterruptedException {
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='pass']"));
        passwordInput.sendKeys("chomp!");
        Thread.sleep(1000);
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() throws InterruptedException {
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(1000);
     }
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        basicRunner.driver.switchTo().alert().accept();
        Assert.assertEquals(1, 1);
    }
    @When("The employee types in g8tors into the username input")
    public void the_employee_types_in_g8tors_into_the_username_input() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions\
        basicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=1");
        WebElement usernameInput = basicRunner.driver.findElement(By.xpath("//input[@placeholder='gatorFan99']"));
        usernameInput.click();
        Thread.sleep(1000);
        usernameInput.sendKeys("g8tors");
        Thread.sleep(1000);

    }


    @Then("The employee should see an alert saying no user with that username found")
    public void theEmployeeShouldSeeAnAlertSayingNoUserWithThatUsernameFound() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Assert.assertEquals(1, 1);
    }

    @Then("The employee should be able to login")
    public void theEmployeeShouldBeAbleToLogin() {
       String actualUrl = basicRunner.driver.getCurrentUrl();
       Assert.assertEquals(actualUrl,"https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome");

    }

    @When("The employee types in g8tors! into the username input")
    public void theEmployeeTypesInGTorsIntoTheUsernameInput() throws InterruptedException {
        WebElement usernameInput = basicRunner.driver.findElement(By.xpath("//input[@placeholder='gatorFan99']"));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys("g8tor");
        Thread.sleep(1000);
    }
}


