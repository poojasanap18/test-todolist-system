TodoList Selenium Cucumber Framework

***********************************
Tech Stack
***********************************
Java 11+
Maven
Selenium WebDriver
Cucumber BDD
TestNG
Log4j2 (SLF4J)
Extent Reports

**********************************
Project Structure
**********************************
src/
├── main/java/pages/
├── test/java/hooks/
├── test/java/steps/
├── test/java/runner/
├── test/java/utils/
├── test/resources/features/

*******************************
How to Run
*******************************
mvn clean test

********************************
Reports
********************************
To generate report use : mvn verify
target/cucumber-reports/cucumber.html
target/cucumber-reports/cucumber.json
target/extent-report/ (if configured)

*******************************
Scenarios Included
*******************************
Add/Edit/Delete todo List
Mark as completed
Filter todos (All/Active/Completed)
Clear completed
Toggle all