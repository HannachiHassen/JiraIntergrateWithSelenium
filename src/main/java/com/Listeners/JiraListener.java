package com.Listeners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Utils.JiraPolicy;
import com.Utils.JiraServiceProvider;

public final class JiraListener implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	
	}
	@Override
	public void onTestFailure(ITestResult result) {
		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTicketReady = jiraPolicy.logTicketReady();
		if (isTicketReady) {
			// raise jira ticket:
			System.out.println("is ticket ready for JIRA: " + isTicketReady);
			JiraServiceProvider jiraSp = new JiraServiceProvider("https://qajiratesting.atlassian.net",
					"hassenhannachi07@gmail.com", 
					"ATATT3xFfGF058gtjaez6yDBfO_Vz5xoo4nK3VWRvkyTvH7OcMVfzjXYNmeyNGaMka21NeqnsNehraiBijeTXC1ARwsBV7xPRy2XE6blv_OG9GNnvMiUxpAcoNPT3H4hCSUcSo8N06vcQ7AGO_AVRLjqHO0tlQD92fw18d9rQR7uW9Evqug6Jto=D1AA01E3", 
					"NAV");
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()
					+ "got failed due to some assertion or exception";
			String issueDescription = result.getThrowable().getMessage() + "\n";
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));

			jiraSp.createJiraTicket("Bug", issueSummary, issueDescription, "Hassen");
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}
	@Override
	public void onStart(ITestContext context) {
		
	}
	@Override
	public void onFinish(ITestContext context) {
		
	}
}
