package runnerPkg;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\featureFiles\\Github.feature",
				 plugin ={"html:target/cucumber-reports.html"},
				 glue= {"stepDef", "resources"},
				 tags = "@github")
public class TestRunner {

}
