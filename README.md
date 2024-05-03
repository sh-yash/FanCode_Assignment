# Automated Fancode Assignment Scenario with RestAssured and TestNG

This project automates the scenario where users from the city FanCode are checked to have completed more than 50% of their todo tasks. The implementation is done using RestAssured library for making API requests, TestNG for test execution, and POJOs for data modeling.

## Setup Instructions
### Prerequisites

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
Java JDK installed on your machine
Maven installed on your machine
```

## Steps

```
1. Clone the repository to your local machine:
   git clone https://github.com/sh-yash/FanCode_Assignment.git

2. Navigate to the project directory:
   cd FanCode_Assignement

3. Build the project using Maven:
   mvn clean install

4. Run the test suite using TestNG XML file:
   mvn test -DsuiteXmlFile=FanCodeTest.xml
```
This will execute the automation script and print the users who have completed more than 50% of their tasks from the city FanCode.

## Dependencies
RestAssured: Version 4.3.3

TestNG: Version 7.4.0

lombok 1.18.32

jackson-databind : 2.17.0 
