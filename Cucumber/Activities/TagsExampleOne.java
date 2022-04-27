package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TagsExampleOne {

    @Given("^Users open page$")
    public void openPage(){
        System.out.println("Open the page");
    }
    @When("^User performs an action$")
    public void performAction(){
        System.out.println("Perform Actions");
    }
    @Then("^Do Action for first scenario$")
    public void doActionOne(){
        System.out.println("Do the Action for first Scenario");
    }
    @Then("^Do Action for second scenario$")
    public void doActionTwo(){
        System.out.println("Do the Action for second Scenario");
    }
}
