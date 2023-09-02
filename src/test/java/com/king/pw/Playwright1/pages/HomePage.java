package com.king.pw.Playwright1.pages;

import com.king.pw.Playwright1.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;

/**
 * Playwright page object that uses the factory to interact with a web page
 * 
 */
public class HomePage {

	private Page page;

	/** Constructor initializes the page 
	 * using the PlaywrightFactory.getPageInstance() method.
	 */
	public HomePage() {
		this.page = PlaywrightFactory.getPageInstance();
	}

	public void navigateTo(String url) {
		page.navigate(url);
	}

	public String getPageTitle() {
		return page.title();
	}

	public void closePage() {
		page.close();
	}
}
