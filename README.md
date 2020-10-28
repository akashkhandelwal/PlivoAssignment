# PlivoAssignment

Project Overview:
 - Project directory is divided broadly into main and test directories.
 - main directory contains helper and util classes
   - There are two helper classes. PlivoActions class contains methods to perform various actions by call Plivo APIs. CommonActions class contains methods to parse data from test.properties files.
   - APICallUtil class contains methods to create the API request and return responses.
 - test directory contains below two test classes:
   - PlivoTest: Contains actual tests
   - BaseTest: Contains methods to be run before suite execution and before execution of test class. BeforeClass method calls Plivo APIs to fetch and store common test data required for validations.
 - Host and auth data is passed from test.properties file.

Pre-requisites to execute tests:
 - Install Java: 
 - Install Maven. Refer https://www.tutorialspoint.com/maven/maven_environment_setup.htm
 
Steps to execute the test from command line/terminal:
 - Clone this Github project
 - Navigate to Project's root folder(where pom.xml is present).
 - Execute command: mvn test.
 
 Step to execute the test from Eclipse:
  - Ensure to have TestNG installed on Eclipse. For installation, refer, https://www.guru99.com/install-testng-in-eclipse.html
  - Import project into Eclipse. Refer https://www.tutorialspoint.com/maven/maven_eclispe_ide.htm to import the project.
  - Open PlivoTest.java file.
  - Right click on the code window. Click on Run As > TestNG Test.
