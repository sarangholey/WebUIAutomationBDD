package com.qa.automation.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",//to tell cucumber where is ur feature file
        glue="com.qa.automation.stepdefs", // to tell cucumber where is ur step def code
        tags="@RegUserLogin", // to tell which tagged feature file to execute
        plugin = {"pretty", // to generate reports
            "html:target/html/web_ui_automation_report.html",
            "json:target/json/file.json",
            },
        monochrome = true,
        publish=true,
        dryRun=false // to tell whether to test run(true) or actual run(false)
        )
public class TestRunner {
	//Class will be Empty.
    //Nothing goes here@RegUserLogin
    //So do not get confused
}
