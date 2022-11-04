package project2.stepImplementations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import project2.runners.basicRunner;

import java.time.Duration;
import java.util.NoSuchElementException;

import static project2.runners.basicRunner.driver;

public class testCasesSteps {
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() throws InterruptedException {
        basicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=1");
        Thread.sleep(500);
        WebElement usernameInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[1]"));
        usernameInput.click();
        usernameInput.sendKeys("ryeGuy");
        Thread.sleep(500);
        WebElement passwordInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[2]"));
        Thread.sleep(500);
        passwordInput.sendKeys("coolbeans");
        WebElement logInButton = basicRunner.driver.findElement(By.tagName("button"));
        Thread.sleep(500);
        logInButton.click();
        Thread.sleep(500);
        WebElement TestCases = basicRunner.driver.findElement(By.cssSelector("a[href='/testcases']"));
        TestCases.click();
        Thread.sleep(500);
    }

    @When("The tester types Description into input with")
    public void the_tester_typesD_into_input_with(String a) throws InterruptedException {
        WebElement desc = basicRunner.driver.findElement(By.xpath("//textarea[@name='desc']"));
        desc.click();
        Thread.sleep(500);
        desc.sendKeys("xxx");
        Thread.sleep(500);
    }

    @When("The tester types Steps into input with")
    public void the_tester_typesS_into_input_with(String b) throws InterruptedException {
        WebElement steps = basicRunner.driver.findElement(By.xpath("//textarea[@name='steps']"));
        steps.click();
        Thread.sleep(500);
        steps.sendKeys("xxx");

        Thread.sleep(500);



    }

    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() throws InterruptedException {
        WebElement submit = basicRunner.driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submit.click();
        Thread.sleep(500);
    }
    @When("The tester presses on details")
    public void the_tester_presses_on_details() throws InterruptedException {
        WebElement submit = basicRunner.driver.findElement(By.xpath("(//button[contains(text(),'Details')])[last()]"));
        submit.click();
        Thread.sleep(500);

    }

    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        try {
            WebElement lastRow = basicRunner.driver.findElement(By.xpath("//td[normalize-space()='xxx']"));
        } catch (NoSuchElementException e) {
            System.out.println("Can't find appropriate test case");
            Assert.assertEquals(1, 2);
        }
        Assert.assertEquals(1, 1);


    }

    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() throws InterruptedException {

        WebElement modal = basicRunner.driver.findElement(By.xpath("//div[@role='dialog']"));
        System.out.println("5");
    }

    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() throws InterruptedException {

       Thread.sleep(1000);
       WebElement caseID = basicRunner.driver.findElement(By.cssSelector("div[role='dialog'] h3"));



       Assert.assertEquals(1,1);


    }

    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
      basicRunner.driver.findElement(By.xpath("//p[normalize-space()='No One']"));

      System.out.println("3");
      Thread.sleep(2000);

    }

    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() throws InterruptedException {
        basicRunner.driver.findElement(By.xpath("//div[@role='dialog']"));
       WebElement close = basicRunner.driver.findElement(By.xpath("//button[normalize-space()='Close']"));
        close.click();
    Thread.sleep(1000);
    System.out.println("6");
    }

    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {

        if(basicRunner.driver.findElements(By.xpath("div[role='dialog']")).size() > 0){
            Assert.assertEquals(1,2);
        }else{
            Assert.assertEquals(1,1);
        }
        System.out.println("***");

    }



    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() throws InterruptedException {
        WebElement edit = basicRunner.driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
        edit.click();
        Thread.sleep(500);

    }

    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        try {
            WebElement caseEditor = basicRunner.driver.findElement(By.xpath("//legend[normalize-space()='Overview']"));

        } catch (NoSuchElementException e) {
            System.out.println("Cannot find!");
            Assert.assertEquals(1, 2);
        }
        Assert.assertEquals(1, 1);

     }

    @Then("The fields should be uneditable")
    public void the_fields_should_be_uneditable() {
        WebElement descEditor = basicRunner.driver.findElement(By.xpath("//textarea[1]"));
        String state = descEditor.getAttribute("disabled");
        if (driver.findElement(By.xpath("//textarea[1]")).isEnabled()) {
            Assert.assertEquals(1, 2);
        } else {
            Assert.assertEquals(1, 1);
        }

     }


    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() throws InterruptedException {
        WebElement edit = basicRunner.driver.findElement(By.xpath("//button[contains(text(),'Edit')]"));
        Thread.sleep(500);
        edit.click();

    }

    @Then("The test case fields should be editable")
    public void the_test_case_fields_should_be_editable() {
        WebElement descEditor = basicRunner.driver.findElement(By.xpath("//textarea[1]"));
        String state = descEditor.getAttribute("disabled");
        if (driver.findElement(By.xpath("//textarea[1]")).isEnabled()) {
            Assert.assertEquals(1, 1);
        } else {
            Assert.assertEquals(1, 2);
        }
    }

    @When("The tester types in a new description into the description text area")
    public void the_tester_types_in_a_new_description_into_the_description_text_area() throws InterruptedException {
        WebElement descEditor = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/textarea[1] "));
        descEditor.sendKeys("xxx");
        Thread.sleep(500);
     }

    @When("The tester types in a new steps into the steps text area")
    public void the_tester_types_in_a_new_steps_into_the_steps_text_area() throws InterruptedException {
        WebElement stepsEditor = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/textarea[2]"));
        stepsEditor.sendKeys("xxx");
        Thread.sleep(500);
    }

    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() throws InterruptedException {
        WebElement automatedCheckmark = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[1]"));
        automatedCheckmark.click();
        Thread.sleep(500);

    }

    @When("The tester selects ryeGuy for performed from drop down")
    public void the_tester_selects_rye_guy_for_performed_from_drop_down() throws InterruptedException {
        Select dropdown = new Select(basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/select[1]")));
        dropdown.selectByVisibleText("ryeGuy");
        Thread.sleep(500);

    }

    @When("The tester selects FAIL for test result from drop down")
    public void the_tester_selects_fail_for_test_result_from_drop_down() throws InterruptedException {
       Select dropdown = new Select(basicRunner.driver.findElement(By.xpath(" //body/div[@id='root']/fieldset[2]/select[1]")));
        dropdown.selectByVisibleText("FAIL");
        Thread.sleep(500);
        System.out.println("6");

    }

    @When("The tester types in a new summary into the summary text area")
    public void the_tester_types_in_a_new_summary_into_the_summary_text_area() throws InterruptedException {
        WebElement summary = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[2]/textarea[1] "));
        summary.click();
        summary.sendKeys("xxx");

        Thread.sleep(500);
        System.out.println("10");
    }

    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() throws InterruptedException {
        WebElement save = basicRunner.driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
        save.click();
        Thread.sleep(500);
        System.out.println("8");

    }

    @Then("A confirmation prompt should appear, the tester clicks on Ok and the alert says the test case has been saved")
    public void a_confirmation_prompt_should_appear() throws InterruptedException {
            basicRunner.driver.switchTo().alert().accept();
            Assert.assertEquals(1, 1);
            Thread.sleep(500);
             basicRunner.driver.switchTo().alert().accept();
             Assert.assertEquals(1, 1);
            Thread.sleep(500);
            System.out.println("666");

        }



    @Given("the tester is on the test case editor for a specific test case")
    public void the_tester_is_on_the_test_case_editor_for_a_specific_test_case() throws InterruptedException {
        basicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=1");
        Thread.sleep(500);
        WebElement usernameInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[1]"));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys("ryeGuy");
        Thread.sleep(500);
        WebElement passwordInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[2]"));
        Thread.sleep(500);
        passwordInput.sendKeys("coolbeans");
        WebElement logInButton = basicRunner.driver.findElement(By.tagName("button"));
        Thread.sleep(500);
        logInButton.click();
        Thread.sleep(500);
        WebElement TestCases = basicRunner.driver.findElement(By.cssSelector("a[href='/testcases']"));
        TestCases.click();
        Thread.sleep(500);
        WebElement details = basicRunner.driver.findElement(By.xpath("(//button[contains(text(),'Details')])[1]"));
        details.click();
        Thread.sleep(500);
        System.out.println("7");
        WebElement edit = basicRunner.driver.findElement(By.xpath("//a[normalize-space()='Edit']"));
        edit.click();
        Thread.sleep(500);
     }

    @When("The Tester clicks on the edit button")
    public void the_Tester_clicks_on_the_edit_button() throws InterruptedException {
        WebElement edit = basicRunner.driver.findElement(By.xpath("(//button[normalize-space()='Edit'])[1]"));
        edit.click();
        Thread.sleep(1000);
    }

    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() throws InterruptedException {
        WebElement reset = basicRunner.driver.findElement(By.xpath("//button[1]"));
        reset.click();
        Thread.sleep(500);
    }

    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        WebElement detailsModalBefore = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/textarea[1]"));
        detailsModalBefore.getText();
        WebElement detailsModalAfter = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/textarea[1]"));
        detailsModalAfter.getText();
        WebElement stepsModalBefore = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/textarea[2]"));
        stepsModalBefore.getText();

        WebElement stepsModalAfter = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/textarea[2]"));
        stepsModalAfter.getText();
        if (stepsModalBefore.equals(stepsModalAfter) && detailsModalBefore.equals(detailsModalAfter)) {
            Assert.assertEquals(1, 1);
        } else {
            Assert.assertEquals(1, 2);
        }

    }


}