# apitest
This is an ongoing project for Restful API automation, using: 

- TestNG: for tests execution
- Rest Assured: for creating API tests using BDD style
- Junit5: for group assertion
- Maven: for dependencies management
- Slf4j & log4j: for logging
- Allure: for report
- API Server: @james-willett/VideoGameDB

**Project Structure:**

src/test/java:

- listener
- testcases
- util

src/test/resources:
- config/config.properties
- data/
- allure.properties
- log4j.properties

output:
- logs
- screenshots

target:
- allure-report
- allure-results

pom.xml

testng.xml
