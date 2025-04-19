package test1;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features/Amazon.feature",
		glue={"test1"},
		dryRun=false,
		plugin= {"pretty"}
		)
public class TestRunner {

}
