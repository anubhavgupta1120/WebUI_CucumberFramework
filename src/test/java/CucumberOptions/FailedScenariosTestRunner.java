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
@CucumberOptions(features = "@target/failed_scenarios.txt", glue = "StepDefinitions", monochrome = true, plugin = {
		"html:Reports/HTML_Reports/cucumber.html", "json:Reports/HTML_Reports/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedScenariosTestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
