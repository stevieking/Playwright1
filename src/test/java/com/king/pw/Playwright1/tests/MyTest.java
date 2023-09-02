package com.king.pw.Playwright1.tests;

import org.junit.jupiter.api.*;

import com.king.pw.Playwright1.pages.HomePage;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

	private HomePage homePage;

	@BeforeEach
	public void setUp() {
		/** A new HomePage instance is created, which internally uses
		 * the Playwright factory to obtain a Page instance.
		 */
		homePage = new HomePage();
	}

	@AfterEach
	public void tearDown() {
		homePage.closePage();
	}

	@Test
	public void testHomePageTitle() {
		homePage.navigateTo("https://example.com");
		System.out.println("Home Page Title:= "+homePage.getPageTitle());
		assertEquals("Example Domain", homePage.getPageTitle());
	}
}
