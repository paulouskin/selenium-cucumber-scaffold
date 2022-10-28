package pl.qaupskilling.cucumber.stepdefs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pl.qaupskilling.cucumber.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TransformersSteps {

    private LocalDate today;
    private LocalDate future;

    private List<Book> books;

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDate iso8601Date(String year, String month, String day) {
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    @DataTableType
    public Book bookDataTableEntryTransformer(Map<String, String> row) {
        return new Book(row.get("author"), row.get("title"), Integer.parseInt(row.get("publishYear")));
    }

    @Given("today is {iso8601Date}")
    public void today_is(LocalDate date) {
        today = date;
    }

    @When("we add {int} month to today's date")
    public void we_add_month_to_today_s_date(Integer monthCount) {
        future = today.plusMonths(monthCount);
    }

    @Then("result date will be in future")
    public void result_date_will_be_in_future() {
        Assertions.assertTrue(future.isAfter(today));
    }


    @Given("the following books")
    public void theFollowingBooks(List<Book> ourBooks) {
        books = ourBooks;
    }

    @Then("I want to output all above mentioned books on the console")
    public void iWantToOutputThisBooksOnTheConsole() {
        System.out.println("Listing all books which need to be read:");
        books.forEach(System.out::println);
    }


}
