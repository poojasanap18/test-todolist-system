package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DriverFactory;

public class TestHook {
    private static final Logger log = LoggerFactory.getLogger(TestHook.class);

    @Before
    public void beforeScenario() {
        log.info("Starting WebDriver session");
        DriverFactory.setDriver();
        DriverFactory.getDriver().get("https://todomvc.com/examples/react/dist/");
    }

    @After
    public void afterScenario() {
        log.info("Ending WebDriver session");
        DriverFactory.quitDriver();
    }
}
