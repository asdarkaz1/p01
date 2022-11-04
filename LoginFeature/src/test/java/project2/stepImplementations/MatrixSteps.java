package project2.stepImplementations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import project2.runners.basicRunner;

public class MatrixSteps {
    @Given("A manager is on their home page")
    public void a_manager_is_on_their_home_page() throws InterruptedException {
        basicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=1");
        Thread.sleep(500);
        WebElement usernameInput = basicRunner.driver.findElement(By.xpath("//input[@placeholder='gatorFan99']"));
        usernameInput.click();
        Thread.sleep(500);
        usernameInput.sendKeys("g8tor");
        WebElement passwordInput = basicRunner.driver.findElement(By.xpath("//input[@name='pass']"));
        passwordInput.sendKeys("chomp!");
        Thread.sleep(500);
        WebElement logInButton = basicRunner.driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(500);
    }
    @Then("A manager can pull up a form to make a new matrix")
    public void a_manager_can_pull_up_a_form_to_make_a_new_matrix() {
        WebElement newMatrix = basicRunner.driver.findElement(By.xpath("//button[normalize-space()='Create A new Requirements Matrix']"));
         newMatrix.click();
    }
    @When("A manager creates a title for a matrix")
    public void a_manager_creates_a_title_for_a_matrix() throws InterruptedException {
        WebElement title = basicRunner.driver.findElement(By.cssSelector("input[name='title']"));
        title.click();
        title.sendKeys("abcdef");
        Thread.sleep(500);

    }
    @When("A manager adds requirements to a matrix")
    public void a_manager_adds_requirements_to_a_matrix() throws InterruptedException {
        WebElement addReq = basicRunner.driver.findElement(By.xpath("//button[contains(text(),'Add Requirement')]"));
        addReq.click();
        addReq.click();
        addReq.click();
        Thread.sleep(500);
    }
    @When("A manager saves a matrix")
    public void a_manager_saves_a_matrix() throws InterruptedException {
        WebElement create = basicRunner.driver.findElement(By.xpath("//button[contains(text(),'Create Matrix')]"));
        create.click();
        Thread.sleep(500);
        basicRunner.driver.switchTo().alert().accept();
        WebElement matrices = basicRunner.driver.findElement(By.xpath("//a[contains(text(),'Matrices')]"));
        matrices.click();
        Thread.sleep(500);
    }


    @Then("The matrix should be visible for all testers and managers")
    public void the_matrix_should_be_visible_for_all_testers_and_managers() throws InterruptedException {
        basicRunner.driver.findElement(By.xpath("//a[normalize-space()='Matrices']"));
        Thread.sleep(500);
        basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/ul/li[contains(text(),'abcdef')]"));
    }


    @Given("A manager or tester has selected a matrix")
    public void a_manager_or_tester_has_selected_a_matrix() throws InterruptedException {
        basicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=1");
        Thread.sleep(500);
        WebElement usernameInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[1]"));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys("g8tor");
        WebElement passwordInput = basicRunner.driver.findElement(By.xpath("//body/div[@id='root']/fieldset[1]/input[2]"));
        passwordInput.sendKeys("chomp!");
        Thread.sleep(500);
        WebElement logInButton = basicRunner.driver.findElement(By.tagName("button"));
        logInButton.click();
        Thread.sleep(500); ;
        WebElement  matricesButton = basicRunner.driver.findElement(By.xpath("//a[contains(text(),'Matrices')]"));
        matricesButton.click();
        Thread.sleep(500);
        WebElement  showButton = basicRunner.driver.findElement(By.xpath("(//button[contains(text(),'Show')])[1]"));
        showButton.click();
        Thread.sleep(500);


    }

    @When("A manager or tester adds or removes defects")
    public void a_manager_or_tester_adds_or_removes_defects() throws InterruptedException {
        WebElement  editButton = basicRunner.driver.findElement(By.xpath("//body[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/button[1]"));
        editButton.click();
        Thread.sleep(500);
        WebElement  addDefect = basicRunner.driver.findElement(By.xpath("(//button[contains(text(),'Add')])[2]"));
        addDefect.click();
        addDefect.click();
        addDefect.click();
        Thread.sleep(500);




    }
    @When("A manager or tester adds or removes Test Cases")
    public void a_manager_or_tester_adds_or_removes_test_cases() throws InterruptedException {
        WebElement  editButton = basicRunner.driver.findElement(By.xpath("//body[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/button[1]"));
        editButton.click();
        Thread.sleep(500);
        WebElement  add = basicRunner.driver.findElement(By.xpath("(//button[contains(text(),'Add')])[1]"));
        add.click();
        add.click();
        add.click();
        Thread.sleep(500);

    }

    @When("A manager or tester confirms their changes")
    public void a_manager_or_tester_confirms_their_changes() throws InterruptedException {
        WebElement saveReq = basicRunner.driver.findElement(By.xpath("(//button[contains(text(),'Save Requirements')])[1]"));
        saveReq.click();
        Thread.sleep(500);

    }
    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {
        try {
            basicRunner.driver.switchTo().alert().accept();
        }catch
        (Exception e ){
            Assert.assertEquals(1, 2);
        }

        Assert.assertEquals(1, 1);
    }
}