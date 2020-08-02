package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "D:/IntelliJWorkspace/Aparupa_Assignment_02/src/test/Features",
        glue = {"StepDefinitions"},
        tags = "@single"
)
public class runner extends AbstractTestNGCucumberTests {

    //Created : Sun Jul 12 12:31:02 IST 2020
    //Triggered By : Manjunath

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

//