# ToDOList Test Automation Framework

A scalable and parallel Selenium test automation framework using **Java**, **Cucumber**, **TestNG**, and **Log4j2** 

---

## 📦 Tech Stack

- **Language:** Java 11+
- **Build Tool:** Maven
- **Test Framework:** Cucumber + TestNG
- **Browser Automation:** Selenium WebDriver
- **Reporting:** Cucumber HTML, JSON, ExtentReports
- **Logging:** Log4j2
- **Parallel Execution:** TestNG + Thread-safe WebDriver(Faster execution used 4 Threads)

---

## ✅ Features Covered

- Add new todo items
- Edit existing todos
- Delete a todo
- Mark todo as completed
- Filter by: All, Active, Completed
- Clear completed todos
- Toggle all todos
- Full BDD scenario coverage using Cucumber

---

## 🗂 Project Structure

src/
- main/java/pages/
- test/java/hooks/
- test/java/steps/
- test/java/runner/
- test/java/utils/
- test/resources/features/

## How to Run

mvn clean test

## Reports

To generate report use : mvn verify
target/cucumber-reports/cucumber.html
target/cucumber-reports/cucumber.json
target/extent-report/ (if configured)

## Scenarios Included

- Add/Edit/Delete todo List
- Mark as completed
- Filter todos (All/Active/Completed)
- Clear completed
- Toggle all
