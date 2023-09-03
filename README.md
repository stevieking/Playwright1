# Playwright1
Playwright factory to manage the Playwright browser instances and pages.

Playwright factory method utilizing ThreadLocal for managing Playwright objects including Playwright page object

In the Playwright factory  class, **ThreadLocal** is used to ensure that each thread has its own Playwright, Browser, and Page instances.

These methods provide access to these instances.
- getPlaywrightInstance()
- getBrowserInstance()
- getPageInstance() methods provide access to these instances.

For the page object:

The HomePage constructor initializes the page using the 'PlaywrightFactory.getPageInstance()` method.

Page methods are used to interact with the page.
- navigateTo()
- getPageTitle()
- closePage()


For the test class: 
- In the setUp method, a new HomePage instance is created, which internally uses the Playwright factory to obtain a Page instance.
- In the tearDown method, the page is closed to ensure proper resource cleanup.

This approach allows you to encapsulate Playwright-related logic within the page object, making your test code cleaner and more maintainable. 

It also ensures that Playwright resources are managed correctly.


## Run the Test
`mvn clean -Dtest=com.king.pw.Playwright1.tests.MyTest test`


<sub>
[INFO]

[INFO] -------------------------------------------------------

[INFO]  T E S T S

[INFO] -------------------------------------------------------

[INFO] Running com.king.pw.Playwright1.tests.MyTest

**Home Page Title:= Example Domain**

[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 42.077 s - in com.king.pw.Playwright1.tests.MyTest

[INFO]

[INFO] Results:

[INFO]

[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO]

[INFO] ------------------------------------------------------------------------

[INFO] BUILD SUCCESS

[INFO] ------------------------------------------------------------------------

[INFO] Total time:  01:05 min
</sub>

