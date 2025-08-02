package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class TodoPage {
    private final WebDriver driver;

    private final By todoInput = By.className("new-todo");
    private final By todoListItems = By.cssSelector(".todo-list li");
    private final By clearCompleted = By.className("clear-completed");
    private final By toggleAll = By.className("toggle-all");

    public TodoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addTodo(String todoText) {
        driver.findElement(todoInput).sendKeys(todoText + Keys.ENTER);
    }

    public boolean isTodoDisplayed(String todoText) {
        try {
            return driver.findElement(By.xpath("//label[text()='" + todoText + "']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void completeTodo(String todoText) {
        WebElement checkbox = driver.findElement(
                By.xpath("//label[text()='" + todoText + "']/preceding-sibling::input[@class='toggle']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isTodoCompleted(String todoText) {
        WebElement li = driver.findElement(By.xpath("//label[text()='" + todoText + "']/ancestor::li"));
        return li.getAttribute("class").contains("completed");
    }

    public void deleteTodo(String todoText) {
        WebElement todoItem = driver.findElement(By.xpath("//label[text()='" + todoText + "']/ancestor::li"));
        WebElement destroyBtn = todoItem.findElement(By.cssSelector("button.destroy"));
        Actions actions = new Actions(driver);
        actions.moveToElement(todoItem).perform(); // hover to reveal delete button
        destroyBtn.click();
    }

    public void editTodo(String oldText, String newText) {
        WebElement label = driver.findElement(By.xpath("//label[text()='" + oldText + "']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(label).perform();

        WebElement input = driver.findElement(By.xpath("//input[@id='todo-input']"));
        input.clear();
        input.sendKeys(newText + Keys.ENTER);
    }

    public void filterBy(String filterName) {
        driver.findElement(By.linkText(filterName)).click();
    }

    public void clearCompletedTodos() {
        try {
            WebElement clearBtn = driver.findElement(clearCompleted);
            if (clearBtn.isDisplayed()) {
                clearBtn.click();
            }
        } catch (NoSuchElementException e) {
            // No completed todos to clear
        }
    }

    public void toggleAllTodos() {
        driver.findElement(toggleAll).click();
    }

    public int getTodoCount() {
        List<WebElement> todos = driver.findElements(todoListItems);
        return todos.size();
    }
}
