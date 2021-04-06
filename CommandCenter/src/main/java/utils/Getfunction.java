package utils;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONObject;
import org.junit.Assert;

import com.relevantcodes.extentreports.LogStatus;

import extentreports.ExtentTestManager;
import restassuredtest.sample;

public class Getfunction extends sample {

	public void serverdetails(String basepath, String data, String keyvalue) throws FileNotFoundException, IOException {

		useRelaxedHTTPSValidation();

		systemproperty x = new systemproperty();

		String geturl = x.getdetails("URL");
		String getauthval = x.getdetails("Authorizationval");

		System.out.println(geturl + basepath);

		try {
			given().header("Authorization", "Token " + getauthval).when().get(geturl + basepath).then().assertThat()
					.statusCode(200);
			ExtentTestManager.getTest().log(LogStatus.PASS, "verify status code");
		} catch (Error e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed" + e);
			System.out.println(e);
		}

		try {
			String body = given().header("Authorization", "Token " + getauthval).when().get(geturl + basepath)
					.thenReturn().body().jsonPath().getString(keyvalue);

			System.out.println(body);
			Assert.assertTrue(body.contains(data));
			System.out.println(body);
			ExtentTestManager.getTest().log(LogStatus.PASS, "verify the list");
		} catch (Error e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed" + e);
			System.out.println(e);
		}

	}

	public void createRecord(String basepath, JSONObject data)
			throws FileNotFoundException, IOException, InterruptedException {

		useRelaxedHTTPSValidation();

		systemproperty x = new systemproperty();

		String geturl = x.getdetails("URL");
		String getauthval = x.getdetails("Authorizationval");

		System.out.println(geturl + basepath);

		Thread.sleep(2000);

		try {
			given().header("Authorization", "Token " + getauthval).and().body(data).when().post(geturl + basepath)
					.then().extract().response().then().assertThat().statusCode(201);
			ExtentTestManager.getTest().log(LogStatus.PASS, "verify status code");
		} catch (Error e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed" + e);
			System.out.println(e);
		}

	}

	public void deleteRecord(String basepath) throws FileNotFoundException, IOException {

		useRelaxedHTTPSValidation();

		systemproperty x = new systemproperty();

		String geturl = x.getdetails("URL");
		String getauthval = x.getdetails("Authorizationval");

		System.out.println(geturl + basepath);

		try {
			given().header("Authorization", "Token " + getauthval).when().delete(geturl + basepath).then().extract()
					.response().then().assertThat().statusCode(204);
			ExtentTestManager.getTest().log(LogStatus.PASS, "verify status code");
		} catch (Error e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed" + e);
			System.out.println(e);
		}

	}

}
