package by.paulouskin.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefinitions {

    @Given("I create empty Maven Cucumber project")
    public void i_create_empty_Maven_Cucumber_project() {
        System.out.println("Given step");
    }

    @When("I run maven command clean verify")
    public void i_run_maven_command_clean_verify() {
        System.out.println("When step");
    }

    @Then("I see some reports generated in target folder")
    public void i_see_some_reports_generated_in_target_folder() {
        Logger logger = LoggerFactory.getLogger(StepDefinitions.class);
        logger.info("Tu tu tu ru tu");
        System.out.println("Then step");
        Assert.assertTrue(true);
    }

}
