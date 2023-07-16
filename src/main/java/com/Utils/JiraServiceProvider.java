package com.Utils;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public final class JiraServiceProvider {
	
	public JiraClient jira;
	public String project;
	
	public JiraServiceProvider(String juraURL, String username, String pasword, String project) {
		BasicCredentials creds=new BasicCredentials(username, pasword);
		jira=new JiraClient(juraURL,creds);
		this.project=project;
	}
	
	public void createJiraTicket(String issueType, String summary, String descriptioin, String reporterName) {
		try {
			FluentCreate fluent=jira.createIssue(project, issueType);
			fluent.field(Field.SUMMARY, summary);
			fluent.field(Field.DESCRIPTION, descriptioin);
			Issue newIssue =fluent.execute();
		} catch (JiraException e) {
			e.printStackTrace();
		}
	}
}
