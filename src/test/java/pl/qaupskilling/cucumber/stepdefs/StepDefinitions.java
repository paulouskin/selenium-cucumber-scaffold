package pl.qaupskilling.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.qaupskilling.cucumber.model.OurColor;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StepDefinitions {

    String oneWordString;
    BigDecimal bigDecimalFromStep = BigDecimal.ZERO;
    BigInteger bigIntegerFromStep;

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

    @Given("{word} as a word step expression")
    public void asAWordStepExpression(String word) {
        oneWordString = word;
    }

    @Then("above word can not be split")
    public void aboveWordCanNotBeSplit() {
        Assertions.assertEquals(1, oneWordString.split(" ").length);
    }

    @Given("{bigdecimal} as a bigdecimal step expression")
    public void asABigdecimalStepExpression(BigDecimal bigNum) {
        bigDecimalFromStep = bigNum;
    }

    @Then("the variable value to which it assigned not equal to initial var value")
    public void aboveNumberIsABigDecimalClass() {
        Assertions.assertNotEquals(bigDecimalFromStep, BigDecimal.ZERO);
    }

    @Given("{biginteger} is a big integer")
    public void isABigInteger(BigInteger bigInt) {
        System.out.println("our big integer + 1 = " + bigInt.add(BigInteger.ONE));
    }

    @Given("{} as anonymous argument will be converted into enum")
    public void blueAsAnonymousArgumentWillBeConvertedIntoEnum(OurColor color) {
        System.out.println("Our color is " + color.toString());
    }
}
