package CucumberOptions;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//html, xml, json, junit, extent reports
//For extent report add plugin ""
// and also add these key value pairs in newly created extent.properties file
//basefolder.name = Reports/ExtentReports
//basefolder.datetimepattern = d-MMM-YY HH-mm-ss
//extent.reporter.spark.start = true
//extent.reporter.spark.out = TestReports/spark.html
///Users/anubhavgupta/Documents/eclipse-workspace(Java)/UI_CucumberFramework/src/test/resources/extent.properties -> properties file location should be this only
@CucumberOptions(features = "FeatureFiles", glue = "StepDefinitions", monochrome = true, plugin = {
		"html:Reports/HTML_Reports/cucumber.html", "json:Reports/HTML_Reports/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"})
public class TestRunner_TestNg extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

//we can override cucumber option through terminal using these commands

//cucumber.ansi-colors.disabled=  # true or false. default: false
//cucumber.execution.dry-run=     # true or false. default: false
//cucumber.execution.limit=       # number of scenarios to execute (CLI only).
//cucumber.execution.order=       # lexical, reverse, random or random:[seed] (CLI only). default: lexical
//cucumber.execution.wip=         # true or false. default: false.
//cucumber.features=              # comma separated paths to feature files. example: path/to/example.feature, path/to/other.feature
//cucumber.filter.name=           # regex. example: .*Hello.*
//cucumber.filter.tags=           # tag expression. example: @smoke and not @slow
//cucumber.glue=                  # comma separated package names. example: com.example.glue
//cucumber.plugin=                # comma separated plugin strings. example: pretty, json:path/to/report.json
//cucumber.object-factory=        # object factory class name. example: com.example.MyObjectFactory
//cucumber.snippet-type=          # underscore or camelcase. default: underscore