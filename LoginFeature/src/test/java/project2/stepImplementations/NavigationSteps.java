package project2.stepImplementations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import project2.runners.basicRunner;

import java.util.List;
import java.util.NoSuchElementException;

public class NavigationSteps {



    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {

        try {
            WebElement navBar = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/nav[1]"));
            WebElement matrices = basicRunner.driver.findElement(By.linkText("Matrices"));
            WebElement testcases = basicRunner.driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]"));
            WebElement reportDefect = basicRunner.driver.findElement(By.xpath("//a[contains(text(),'Report a Defect')]"));
            WebElement defectOverview = basicRunner.driver.findElement(By.linkText("Defect Overview"));

        } catch (NoSuchElementException e) {
            System.out.println(" Element not found");
            Assert.assertEquals(1, 2);
        }

        Assert.assertEquals(1, 1);
    }

    //Scenario 2
    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() throws InterruptedException {
        WebElement matrices = basicRunner.driver.findElement(By.linkText("Matrices"));
        matrices.click();
        Thread.sleep(1000);

    }

    @Then("The header of the page should be Matrices")
    public void the_title_of_the_page_should_be_matrix_page() {
        try {
            WebElement title = basicRunner.driver.findElement(By.xpath("//h1[normalize-space()='Matrices']"));
        } catch (NoSuchElementException e) {
            System.out.println("Title of page with 'Matrix Page' not found ");
            Assert.assertEquals(1, 2);
        }

        Assert.assertEquals(1, 1);
    }

    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() throws InterruptedException {
        basicRunner.driver.navigate().back();
        Thread.sleep(3000);

    }

    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {

        if (basicRunner.driver.getCurrentUrl().equals("https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome")) {
            try {
                WebElement title = basicRunner.driver.findElement(By.xpath("//head//title[contains(text(),'Home')]"));
            } catch (NoSuchElementException e) {
                System.out.println("Element not found");
                Assert.assertEquals(1, 2);
            }
            Assert.assertEquals(1, 1);
        }
    }


    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() throws InterruptedException {
        WebElement testCase = basicRunner.driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]"));
        testCase.click();


    }


    @When("The manager clicks on Report a Defect")
    public void the_manager_clicks_on_report_a_defect() throws InterruptedException {
        WebElement titleName = basicRunner.driver.findElement(By.xpath("//a[normalize-space()='Report a Defect']"));
        titleName.click();
        Thread.sleep(500);
      }

    @When("The manager clicks on Defect Overview")
    public void the_manager_clicks_on_defect_overview() throws InterruptedException {
        WebElement titleName = basicRunner.driver.findElement(By.xpath("//a[normalize-space()='Defect Overview'] "));
        titleName.click();
        Thread.sleep(500);

    }


    @Then("The title of page should be Matrix Overview")
    public void the_title_of_page_should_be_matrix_overivew() {
        WebElement titleName = basicRunner.driver.findElement(By.xpath("//h1[contains(text(),'Matrices')]"));

     }

    @Then("The title of page should be Test Case Overview")
    public void the_title_of_page_should_be_test_case_overivew() {
        WebElement titleName = basicRunner.driver.findElement(By.xpath("//h1[normalize-space()='Test Case Dashboard']"));
     }
    @Then("The title of page should be Defect Reporter")
    public void the_title_of_page_should_be_defect_reporter() {
        WebElement titleName = basicRunner.driver.findElement(By.xpath("//h1[normalize-space()='Defect Reporter']"));
     }

    @Then("The title of page should be Defect Overview")
    public void the_title_of_page_should_be_defect_overview() {
        WebElement titleName = basicRunner.driver.findElement(By.xpath("//h1[normalize-space()='Defect Overview']"));

    }
    }



