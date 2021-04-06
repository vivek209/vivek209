package restassuredtest;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import extentreports.ExtentTestManager;

public class sample extends ExtentTestManager {

	@BeforeMethod()

	public void beforeTest(Method method) {

		Test test = method.getAnnotation(Test.class);

		System.out.println("Test description is " + test.description());

		ExtentTestManager.startTest(method.getName(), test.description());

	}

	@AfterMethod(alwaysRun = true)

	protected void afterMethod(ITestResult result) {

		System.out.println(result);

		if (result.getStatus() == ITestResult.FAILURE) {

			ExtentTestManager.getTest().log(LogStatus.FAIL, "faile " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP)

		{
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			ExtentTestManager.getTest();

		}

	}

}
