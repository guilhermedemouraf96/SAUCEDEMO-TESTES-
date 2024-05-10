package runner;

import org.junit.runner.RunWith;

import drivers.Drivers;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "steps",
		tags = "@regressivos",
		dryRun = false,
		monochrome = false,
		plugin = {"pretty", "html:target/cucumber-report.html" },
		snippets = SnippetType.CAMELCASE
	
		)
		public class Executa{
	
	
	


}
