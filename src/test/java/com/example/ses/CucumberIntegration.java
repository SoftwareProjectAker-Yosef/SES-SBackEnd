package com.example.ses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/mohammadaker/Desktop/SES/src/test/resources/features/", glue = {"com.example.ses.cucumberGlue"})
public class CucumberIntegration {
}