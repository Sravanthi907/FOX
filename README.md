This repository contains the automated functional test scripts for FOX project. It used Selenium webdriver (Java binding), Jbehave, Serenity and Maven to develop the scripts.

### Run the tests
From the project folder, run the command from project workspace- mvn clean verify -Dmaven.test.failure.ignore=true -DsystemPropertiesFile=config//serenity_chrome.properties

### Test results
The detailed test reports can be seen at-  project-folder/target/site/serenity/index.html

Automated Tested Cases:

1) Account Registration.
2) Login
3) Capture last 4 shows and keep those in Excel sheet.(please refer Sheet Results.xls).
4) Capture the duplicated results in excel sheet.(please refer showresults.xls)(Right now no duplicate options are showing).


