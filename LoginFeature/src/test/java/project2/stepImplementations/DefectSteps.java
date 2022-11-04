package project2.stepImplementations;

import io.cucumber.java.en.Given;
import org.openqa.selenium.*;
import project2.runners.basicRunner;;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static project2.runners.basicRunner.driver;

public class DefectSteps {
    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
        basicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=1");
        Thread.sleep(500L);
        WebElement usernameInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[1]"));
        usernameInput.click();
        usernameInput.sendKeys("g8tor");
        WebElement passwordInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[2]"));
        Thread.sleep(500L);
        passwordInput.sendKeys("chomp!");
        WebElement logInButton = basicRunner.driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(500L);


    }

    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
            basicRunner.driver.findElement(By.xpath("//div[@id='root']//table"));

    }

    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() throws InterruptedException {
        WebElement select = basicRunner.driver.findElement(By.xpath("//tbody//tr//td//button"));
        select.click();
        Thread.sleep(1000L);

    }

    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() throws InterruptedException {
        //Here I am looking for the first bold tag which should be an h4 element but I cannot get it to look for the first bold element.
                        //options: .getCSSproperty?
        Thread.sleep(1000L);
        String weight = basicRunner.driver.findElement(By.tagName("h4")).getCssValue("font-weight");
        if(weight.equals("700")){
            Assert.assertEquals(1,1);
        }else{
            Assert.assertEquals(1,2);
        }

    }

    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() throws InterruptedException {
        WebElement selector = basicRunner.driver.findElement(By.xpath(" //body/div[@id='root']/div[1]/input[1]"));
        selector.click();
        Thread.sleep(1000L);
    }

    @When("The manager clicks assign")
    public void the_manager_clicks_assign() throws InterruptedException {
        WebElement selector = basicRunner.driver.findElement(By.xpath("//button[contains(text(),'Assign')]"));
        selector.click();
        Thread.sleep(1000L);

    }

    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        Boolean isPresent = driver.findElements(By.tagName("h4")).size() > 0;
        if(isPresent){
            Assert.assertEquals(1,2);
        }else{
            Assert.assertEquals(1,1);
        }

    }

    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page() throws InterruptedException {
        System.out.println("Scenario 2");
        basicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=1");
        Thread.sleep(500L);
        WebElement usernameInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[1]"));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys("ryeGuy");
        Thread.sleep(500L);
        WebElement passwordInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[2]"));
        Thread.sleep(500L);
        passwordInput.sendKeys("coolbeans");
        WebElement logInButton = basicRunner.driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(500L);
    }

    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() throws InterruptedException {
        boolean pendingDefects = basicRunner.driver.findElement(By.xpath("//b[contains(text(),'Pending')]")).isDisplayed();
        if (pendingDefects) {
            Assert.assertEquals(1, 1);
        } else {
            Assert.assertEquals(1, 2);
        }
        Thread.sleep(1000L);
    }


    @Given("The tester is on the Home Page")
    public void theTesterIsOnTheHomePage() throws InterruptedException {
        basicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=1");
        WebElement usernameInput = driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[1]"));
        usernameInput.click();
        Thread.sleep(1000);
        usernameInput.sendKeys("ryeGuy");
        Thread.sleep(500L);
        WebElement passwordInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[2]"));
        passwordInput.sendKeys("coolbeans");
        WebElement logInButton = basicRunner.driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(500L);
    }

    @Then("The tester can can see only defects assigned to them")
    public void theTesterCanCanSeeOnlyDefectsAssignedToThem() {

        try{
            basicRunner.driver.findElement(By.xpath("//h3[contains(text(),'My Defects')]"));
        }catch(NoSuchElementException e){
            System.out.println("Cannot find defects");
            Assert.assertEquals(1,2);
        }
        Assert.assertEquals(1,1);




    }

    @When("The tester changes to defect to any status")
    public void theTesterChangesToDefectToAnyStatus() throws InterruptedException {
        //Make sure accepted is on there
        WebElement statusButton = basicRunner.driver.findElement(By.xpath("(//b[contains(text(),'Accepted')])[1]"));
        statusButton.click();
        Thread.sleep(1000L);
        WebElement changeStatus = basicRunner.driver.findElement(By.xpath("(//button[contains(text(),'Change Status')])[1]"));
        changeStatus.click();
        Thread.sleep(1000L);
        WebElement rejected = basicRunner.driver.findElement(By.xpath("(//button[contains(text(),'Rejected')])[1]"));
        rejected.click();
        Thread.sleep(1000L);
        System.out.println("***");

    }

    @Then("The tester should see the defect has a different status")
    public void theTesterShouldSeeTheDefectHasADifferentStatus() {
         try {
             basicRunner.driver.findElement(By.xpath("//b[.='Rejected']"));
         }catch(NoSuchElementException e){
             Assert.assertEquals(1,2);
         }
        Assert.assertEquals(1,1);

    }


    @Given("The employee is on the Defect Reporter Page")
    public void theEmployeeIsOnTheDefectReporterPage() throws InterruptedException {
        basicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=1");
        WebElement usernameInput = driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[1]"));
        usernameInput.click();
        Thread.sleep(1000);
        usernameInput.sendKeys("ryeGuy");
        Thread.sleep(500L);
        WebElement passwordInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[2]"));
        passwordInput.sendKeys("coolbeans");
        WebElement logInButton = basicRunner.driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(500L);
        WebElement defectPage = basicRunner.driver.findElement(By.cssSelector("a[href='/defectreporter']"));
        defectPage.click();
    }

    @When("The employee selects todays date")
    public void theEmployeeSelectsTodaysDate() throws InterruptedException {
        WebElement dateBox = driver.findElement(By.xpath("(//input[@type='date'])[1]"));
        dateBox.click();
        dateBox.sendKeys(Keys.LEFT);
        Thread.sleep(1000L);
        dateBox.sendKeys(Keys.LEFT);
        dateBox.sendKeys("11111111");

    }

    @When("The employee clicks on description box and types")
    public void theEmployeeTypesInDescriptionBoxWith(String a) throws InterruptedException {
        WebElement DescriptionInput = basicRunner.driver.findElement(By.xpath("//textarea[@name='desc']"));
        DescriptionInput.click();
        Thread.sleep(1000L);
        DescriptionInput.sendKeys(  "Users are able to " +
                "create multiple accounts " +
                "using the same " +
                "username butwith a " +
                "different password.");
        Thread.sleep(1000L);
    }

    @When("The employee clicks on steps box and types")
    public void theEmployeeTypesInStepsBoxWith(String a) throws InterruptedException {
        WebElement StepsInput = basicRunner.driver.findElement(By.xpath("//textarea[@name='stepsToReproduce']"));
        StepsInput.click();
        Thread.sleep(1000L);
        StepsInput.sendKeys(  "meh.");
        Thread.sleep(1000L);
    }

    @When("The employee selects high priority")
    public void theEmployeeSelectsHighPriority() throws InterruptedException {
        WebElement DescriptionPriority = basicRunner.driver.findElement(By.cssSelector("input[name='priority']"));
        DescriptionPriority.click();
        Thread.sleep(2000);
        for (int i = 1; i <= 3 ; i++) {
            DescriptionPriority.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    @When("The employee selects low severity")
    public void theEmployeeSelectsLowSeverity() throws InterruptedException {
        WebElement DescriptionSeverity = basicRunner.driver.findElement(By.cssSelector("input[name='severity']"));
        DescriptionSeverity.click();
        Thread.sleep(2000);
        for (int i = 1; i <= 3 ; i++) {
            DescriptionSeverity.sendKeys(Keys.ARROW_LEFT);
        }
    }

    @When("The employee clicks the report button")
    public void theEmployeeClicksTheReportButton() throws InterruptedException {
        WebElement reportButton = basicRunner.driver.findElement(By.xpath("//button[normalize-space()='Report']"));
        reportButton.click();
        Thread.sleep(2000);
    }

    @Then("No confirmation dialog appears")
    public void noConfirmationDialogAppears() {
        try {
            basicRunner.driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert box is present!");
        }
        Assert.assertEquals(1, 1);


    }

    @Then("There should be a confirmation box")
    public void thereShouldBeAConfirmationBox() {

        basicRunner.driver.switchTo().alert().accept();
        System.out.println("***");
    }

    @Then("A modal should appear with a Defect ID")
    public void aModalShouldAppearWithADefectID() throws InterruptedException {

        Thread.sleep(1000);
        WebElement e =  basicRunner.driver.findElement(By.xpath("//div[@role='dialog']"));

    }

    @When("The employee clicks close")
    public void theEmployeeClicksClose() throws InterruptedException {
        WebElement closeButton = basicRunner.driver.findElement(By.cssSelector("div[role='dialog'] button"));
        closeButton.click();
        Thread.sleep(1000);
    }

    @Then("The modal should disappear")
    public void theModalShouldDisappear() {
        if(basicRunner.driver.findElements(By.xpath("div[role='dialog']")).size() > 0){
            Assert.assertEquals(1,2);
        }else{
            Assert.assertEquals(1,1);
        }
    }


//try page object model!

    @When("The employee clicks on description box and short types")
    public void theEmployeeClicksOnDescBoxAndshortTypes(String a) throws InterruptedException {
        WebElement DescriptionInput = basicRunner.driver.findElement(By.xpath("//textarea[@name='desc']"));
        DescriptionInput.click();
        Thread.sleep(1000L);
        DescriptionInput.sendKeys( "meh.");
        Thread.sleep(1000L);
    }

    @When("The employee clicks on steps box and long types")
    public void theEmployeeClicksOnStepsBoxAndLongTypes(String a) throws InterruptedException {
        WebElement StepsInput = basicRunner.driver.findElement(By.xpath("//textarea[@name='stepsToReproduce']"));
        StepsInput.click();
        Thread.sleep(1000L);
        StepsInput.sendKeys(   " 1. User creates a new account\n" +
                "            2. User reloads the new user page\n" +
                "            3. User creates an account with same username but different password\n" +
                "            \" ");
        Thread.sleep(1000L);
    }

}


