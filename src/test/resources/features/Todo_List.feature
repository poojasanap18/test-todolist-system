Feature: Manage Todo items

  Scenario: Add a new todo item
    Given I open the TodoMVC app
    When I add a new todo "Buy groceries"
    Then I should see the todo "Buy groceries" in the list

  Scenario: Mark a todo item as completed
    Given I open the TodoMVC app
    When I add a new todo "start exercise"
    And I mark "start exercise" as completed
    Then "start exercise" should be marked as completed

  Scenario: Add multiple todos
    Given I open the TodoMVC app
    When I add a new todo "Task 1"
    And I add a new todo "Task 2"
    Then I should see the todo "Task 1" in the list
    And I should see the todo "Task 2" in the list

  Scenario: Complete and verify multiple todos
    Given I open the TodoMVC app
    When I add a new todo "Call me babe"
    And I add a new todo "Build the house"
    And I mark "Call me babe" as completed
    And I mark "Build the house" as completed
    Then "Call me babe" should be marked as completed
    And "Build the house" should be marked as completed

  Scenario: Delete a todo item
    Given I open the TodoMVC app
    When I add a new todo "Buy groceries"
    And I delete the todo "Buy groceries"
    Then I should not see the todo "Buy groceries" in the list

  Scenario: Edit a todo item
    Given I open the TodoMVC app
    When I add a new todo "Read"
    And I edit the todo "Read" to "Read a book"
    Then I should see the todo "Read a book" in the list

  Scenario: Filter Active todos
    Given I open the TodoMVC app
    When I add a new todo "Active task"
    And I filter todos by "Active"
    Then I should see the todo "Active task" in the list

  Scenario: Filter Completed todos
    Given I open the TodoMVC app
    When I add a new todo "Completed task"
    And I mark "Completed task" as completed
    And I filter todos by "Completed"
    Then I should see the todo "Completed task" in the list

  Scenario: Clear completed todos
    Given I open the TodoMVC app
    When I add a new todo "Old Task"
    And I mark "Old Task" as completed
    And I clear completed todos
    Then I should not see the todo "Old Task" in the list

  Scenario: Toggle all todos completed
    Given I open the TodoMVC app
    When I add a new todo "Task A"
    And I add a new todo "Task B"
    And I toggle all todos as completed
    Then "Task A" should be marked as completed
    And "Task B" should be marked as completed
