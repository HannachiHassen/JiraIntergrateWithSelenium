package com.Listeners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Utils.JiraPolicy;
import com.Utils.JiraServiceProvider;

public final class JiraListener implements ITestListener {
	

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
	
	}
	
	public void onTestFailure(ITestResult result) {
		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTicketReady = jiraPolicy.logTicketReady();
		if (isTicketReady) {
			// raise jira ticket:
			System.out.println("is ticket ready for JIRA: " + isTicketReady);
			JiraServiceProvider jiraSp = new JiraServiceProvider("https://qajiratesting.atlassian.net",
					"hannachihassen07@gmail.com", 
					"ATATT3xFfGF0HfjD36jHpeB9E_HJYmi4CHPfdSx5OQNBBreHsqrGIGs5BgAwbrNn1WZN4uLOYElUrVp9TSbj8GXK-rTmOL-7cgQ7NyXIaPnvPUVOKnMSlPwxkEPoeUMwHvFU_3BxyLul9BugcrrP704sfDQjguEXu9hXCW7ez2jWjcMW3bBlFrc=600DCF7E", 
					"NAV");
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()
					+ "got failed due to some assertion or exception";
			String issueDescription = result.getThrowable().getMessage() + "\n";
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));

			jiraSp.createJiraTicket("Bug", issueSummary, issueDescription, "Hassen");
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}
	
	public void onStart(ITestContext context) {
		
	}
	
	public void onFinish(ITestContext context) {
		
	}
}
