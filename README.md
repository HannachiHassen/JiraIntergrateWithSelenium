# How to integrate Jira with Selenium

Selenium is the most popular automation testing framework. Selenium Webdriver is used for automation testing by testers across teams and organizations, and for good reason. 

Among its many advantages, one of Selenium’s unique features is its extensibility. That means testers can create their own frameworks as required, extend them and hook them up with multiple services. Because of its unique feature, Selenium stands out from all available modern frameworks.

Given that Jira is one of the most popular issue tracking and project management tools used by Agile development and testing teams, it is common for testers to integrate Selenium with Jira for greater efficiency and more accurate results.

## What is Jira?

Jira is a tool primarily used for bug and issue tracking. It also supports project management features for all kinds of use cases, from requirements and test case management to Agile software development. 

Jira is free to use for up to 20 users. However, if any organization requires additional features like support, storage, and a large user limit they must go for the commercial version. Since Jira is a bug/issue tracking tool, it enables the assignment, resolution, and implementation of bug life cycle management. 

Jira also provides Rest API endpoints with which testers can automate multiple actions such as Create Issue, Assign Issue, Search the Issue, etc. So, if QAs are utilizing Selenium test automation they can directly log an issue in Jira using Jira API endpoints without the need for manual interventions. 

The following sections will describe how to create API Tokens, how to use Jira API, and how to create issues with Selenium.

### How to Create API Token in Jira

Jira API tokens allow a user to authenticate with cloud apps and bypass two-step verification and SSO in order to retrieve data from the instance through REST APIs. Token controls allow admins to view and revoke the use of API tokens by their managed accounts.

Basically, using the access token and user name, testers can connect Selenium and Jira.
Steps to generate API token in Jira

 1. Navigate to your Organization Jira website (ex: https://example.atlassian.net/)
 2. Login with credentials
 3. Click on Profile and Settings
 4. Click on Account Settings
 5. Click on Security. Then, click on Create and manage API tokens
 6. In the API Tokens section Click on Create API token
 7. Enter the Label and click on Create
 8. Once the token is created, copy and save it in the desired location
 
Note: After creating the API token don’t forget to copy and save the token in the text editor. The token is not accessible once the pop-up disappears.

### How to connect Selenium with Jira and log defects in Jira using Selenium

Let’s start with the prerequisites

1. The Eclipse IDE, already installed.
2. The basic Maven Project Set up, already in place.

> **Note**: This example uses TestNG, Selenium, the Maven Automation Framework, and Java as programming languages.

Now, let’s explore how to integrate Jira with Selenium and then log defects in Jira.

- Problem Statement: The user has their Selenium tests. When they execute the tests, and any of them fail, a Jira ticket should be automatically created under the relevant Project. 

- Condition: If the same ticket has already been created in that particular project, ticket creation should be skipped.

> **Note**: Without this condition, projects end up with a lot of duplicate issues each time they re-run multiple tests.

#### Step 1: Add required dependencies in pom.xml

In order to Integrate Jira with Selenium, use rcarz Jira-client for simplicity. This is the wrapper built on top of the Jira Rest API Client.

Navigate to pom.xml in the project, and add the following dependency:

 ```xml
<dependency>
    <groupId>net.rcarz</groupId>
    <artifactId>Jira-client</artifactId>
    <version>0.5</version>
    <scope>compile</scope>
</dependency>
```

> **Note**: Take extra care when using the . notation as there could be many web elements on the HTML source with the same class attribute.


#### Step 2: Create a utility to handle Jira issue

Let’s create a package inside the main folder com.demo.utility, which will contain two classes

 1. JiraServiceProvider: This class will have a method to create a Jira issue.
 2. JiraCreateIssue: This contains custom annotation code.
 
 Important Points to remember when creating a JiraServiceProvider object:

 - JiraUrl: This should be a company Jira URL. If someone is using the Jira cloud it will be something like: https://xyz.atlassian.net 
 - username: This parameter is the login name (typically email) but depends on the configuration (ex: xyz@gmail.com)
 - password: If using the Jira cloud, one must pass the API Token as a password. Using one’s login password might not work (example API token: lorelimpusm12uijk)
 - project: This is the project Key, often named with two letters (ex: BS). Using the full project name like might not work, so always use the short version. 
 
 How to get project key In Jira

 1. Navigate to Jira URL (https://example.atlassian.net)
 2. Click on Projects Menu 
 3. Click on View All Projects
 4. Choose the Desired Project 
 5. On Project Page, Click on Project Settings
 6. Look for the field Key. This is the short project Key
 7. Just copy and use it as a project key
 
#### Step 3: Create Listener to notify test failures

Create a listener so that each time a test fails, it should automatically create the Jira issue method. This listener keeps track of test failures and executes specified code.

#### Step 4: Create basic tests using Selenium and Java

Let’s create some basic tests. This example creates There basic tests.

#### Step 5: Configure the testng.xml file

Once we have all the required set up, we need to have a testng.xml file configured to run our tests. Our sample xml file looks like below. (You can use your existing testng.xml file to run your tests).

#### Step 6: Execute your tests

Once setup is complete, execute the tests. Once tests are executed, any failures should automatically create a Jira ticket. After execution, view the result in the console.

If everything is correct then after all Selenium tests run, it will create a Jira Issue, and the console will return as output – Ticket ID/Issue ID. It will also offer the URL to navigate to that particular issue.

#### Step 7: Ensure ticket created in Jira

Let’s navigate to the Jira dashboard to check whether an issue has been created or not. In the Jira dashboard, click on the project dashboard to see if a new issue has been created

 