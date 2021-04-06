
package restassuredtest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONObject;
import org.testng.annotations.Test;

import utils.Getfunction;

public class Getvalues extends sample {

	Getfunction get = new Getfunction();

	@Test(priority = 1, description = "Verifying the users list")

	public void GetList1() throws FileNotFoundException, IOException {

		get.serverdetails("api/users",
				"george.bluth@reqres.in, janet.weaver@reqres.in, emma.wong@reqres.in, eve.holt@reqres.in, charles.morris@reqres.in, tracey.ramos@reqres.in",
				"data.email");

	}

	@Test(priority = 2, description = "Verifying the single user")

	public void GetList2() throws FileNotFoundException, IOException {

		get.serverdetails("api/users/2", "janet.weaver@reqres.in", "data.email");

	}

	@Test(priority = 3, description = "Verifying the valid API")

	public void GetList3() throws FileNotFoundException, IOException {

		get.serverdetails("api/users/23", "janet.weaver@reqres.in", "data.email");

	}

	@Test(priority = 4, description = "Verifying the list resource")

	public void GetList4() throws FileNotFoundException, IOException {

		get.serverdetails("api/unknown", "cerulean, fuchsia rose, true red, aqua sky, tigerlily, blue turquoise",
				"data.name");
	}

	@Test(priority = 5, description = "Verifying the single resource")

	public void GetList5() throws FileNotFoundException, IOException {

		get.serverdetails("api/unknown/2", "fuchsia rose", "data.name");
	}

	@Test(priority = 6, description = "Verifying the single resource not found")

	public void GetList6() throws FileNotFoundException, IOException {

		get.serverdetails("api/unknown/23", "fuchsia rose", "data.name");
	}

	@Test(priority = 7, description = "Delayed response")

	public void GetList7() throws FileNotFoundException, IOException {

		get.serverdetails("api/users?delay=3",
				"george.bluth@reqres.in, janet.weaver@reqres.in, emma.wong@reqres.in, eve.holt@reqres.in, charles.morris@reqres.in, tracey.ramos@reqres.in",
				"data.email");
	}

	@Test(priority = 8, description = "Create record")

	public void GetList8() throws FileNotFoundException, IOException, InterruptedException {

		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "leader");

		get.createRecord("api/users", request);

	}

	@Test(priority = 9, description = "Update record")

	public void GetList9() throws FileNotFoundException, IOException, InterruptedException {

		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");

		get.createRecord("api/users/2", request);

	}

	@Test(priority = 10, description = "patch update record")

	public void GetList10() throws FileNotFoundException, IOException, InterruptedException {

		JSONObject request = new JSONObject();
		request.put("name", "morpheus1");

		get.createRecord("api/users/2", request);

	}

	@Test(priority = 11, description = "Delete record")

	public void GetList11() throws FileNotFoundException, IOException {

		JSONObject request = new JSONObject();
		request.put("name", "morpheus1");

		get.deleteRecord("api/users/2");

	}

	@Test(priority = 12, description = "Create register success")

	public void GetList12() throws FileNotFoundException, IOException, InterruptedException {

		JSONObject request = new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "pistol");

		get.createRecord("api/register", request);

	}

	@Test(priority = 13, description = "Create register not success")
	public void GetList13() throws FileNotFoundException, IOException, InterruptedException {

		JSONObject request = new JSONObject();
		request.put("email", "sydney@fife");

		get.createRecord("api/register", request);

	}

	@Test(priority = 14, description = "Create login success")
	public void GetList14() throws FileNotFoundException, IOException, InterruptedException {

		JSONObject request = new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "cityslicka");
		request.put("token", "QpwL5tke4Pnpja7X4");

		get.createRecord("api/login", request);

	}

	@Test(priority = 15, description = "Create login not success")
	public void GetList15() throws FileNotFoundException, IOException, InterruptedException {

		JSONObject request = new JSONObject();
		request.put("email", "peter@klaven");

		get.createRecord("api/login", request);

	}

}
