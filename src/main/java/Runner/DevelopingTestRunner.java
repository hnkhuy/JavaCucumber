package Runner;

import Utilities.PropertiesFileReader;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

/**
 * Created by huy.huynh on 13/09/2018.
 */
@CucumberOptions(features = "src/main/resources/features/", glue = {"StepDefs"}, plugin = {"com.cucumber.listener" +
        ".ExtentCucumberFormatter:target/cucumber-reports/report.html"})
public class DevelopingTestRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    public void setupSomething() throws Exception {
        PropertiesFileReader.openFileProperty();
    }

    @AfterClass
    public static void writeExtentReport() throws Exception {
        Reporter.loadXMLConfig(new File(PropertiesFileReader.getPropertyOfConfigFile("reportConfigPath")));
    }

    @AfterTest
    public void tearDownTest() {
        //        WebDriverCenter.quitAllDriver();
        PropertiesFileReader.closePropertiesFileInputStream();
    }
}
