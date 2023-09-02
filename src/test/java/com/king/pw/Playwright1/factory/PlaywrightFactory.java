package com.king.pw.Playwright1.factory;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

public class PlaywrightFactory {

	/** ThreadLocal is used to ensure that each thread has its own Playwright, Browser, and Page instances **/
	private static final ThreadLocal<Playwright> playwrightThreadLocal = ThreadLocal.withInitial(() -> Playwright.create());
	private static final ThreadLocal<Browser> browserThreadLocal = ThreadLocal.withInitial(() -> playwrightThreadLocal.get().chromium().launch());
	private static final ThreadLocal<Page> pageThreadLocal = ThreadLocal.withInitial(() -> browserThreadLocal.get().newPage());

	public static Playwright getPlaywrightInstance() {
		return playwrightThreadLocal.get();
	}

	public static synchronized Browser getBrowserInstance() {
		return browserThreadLocal.get();
	}

	public static Page getPageInstance() {
		return pageThreadLocal.get();
	}

	public static void close() {
		pageThreadLocal.get().close();
		browserThreadLocal.get().close();
		playwrightThreadLocal.get().close();
	}
}
