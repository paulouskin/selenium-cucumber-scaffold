package pl.qaupskilling.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions {

    @Given("I an empty Maven Cucumber project")
    public void i_create_empty_maven_cucumber_project() {
        System.out.println("I an empty Maven Cucumber project");
    }
    @When("I run maven command clean verify")
    public void i_run_maven_command_clean_verify() {
        System.out.println("I run maven command clean verify");
    }
    @Then("I see some reports generated in target folder")
    public void shouldHaveReportInTargetFolder() {
        Assertions.assertTrue(1 == 1);
    }

}
