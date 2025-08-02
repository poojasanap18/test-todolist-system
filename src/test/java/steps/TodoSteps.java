package steps;

import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.TodoPage;
import utils.DriverFactory;

public class TodoSteps {
    private static final Logger log = LoggerFactory.getLogger(TodoSteps.class);
    private final TodoPage todoPage = new TodoPage(DriverFactory.getDriver());

    @Given("I open the TodoMVC app")
    public void iOpenTheApp() {
        log.info("App is already launched in @Before");
    }

    @When("I add a new todo {string}")
    public void iAddANewTodo(String todo) {
        log.info("Adding todo: {}", todo);
        todoPage.addTodo(todo);
    }

    @Then("I should see the todo {string} in the list")
    public void iShouldSeeTheTodo(String todo) {
        log.info("Verifying todo presence: {}", todo);
        Assert.assertTrue(todoPage.isTodoDisplayed(todo));
    }

    @Then("I should not see the todo {string} in the list")
    public void iShouldNotSeeTheTodo(String todo) {
        log.info("Verifying todo absence: {}", todo);
        Assert.assertFalse(todoPage.isTodoDisplayed(todo));
    }

    @When("I mark {string} as completed")
    public void iMarkAsCompleted(String todo) {
        log.info("Marking todo as completed: {}", todo);
        todoPage.completeTodo(todo);
    }

    @Then("{string} should be marked as completed")
    public void shouldBeMarkedAsCompleted(String todo) {
        log.info("Verifying todo marked completed: {}", todo);
        Assert.assertTrue(todoPage.isTodoCompleted(todo));
    }

    @When("I delete the todo {string}")
    public void iDeleteTodo(String todo) {
        log.info("Deleting todo: {}", todo);
        todoPage.deleteTodo(todo);
    }

    @When("I edit the todo {string} to {string}")
    public void iEditTodo(String oldText, String newText) {
        log.info("Editing todo from '{}' to '{}'", oldText, newText);
        todoPage.editTodo(oldText, newText);
    }

    @When("I filter todos by {string}")
    public void iFilterBy(String filter) {
        log.info("Filtering todos by: {}", filter);
        todoPage.filterBy(filter);
    }

    @When("I clear completed todos")
    public void iClearCompletedTodos() {
        log.info("Clearing completed todos");
        todoPage.clearCompletedTodos();
    }

    @When("I toggle all todos as completed")
    public void iToggleAllTodos() {
        log.info("Toggling all todos as completed");
        todoPage.toggleAllTodos();
    }
}
