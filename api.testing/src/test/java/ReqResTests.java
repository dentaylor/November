import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import models.User;
import models.UserData;
import models.UserDetail;
import models.UserPage;
import models.UserSupport;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ReqResTests  {
	private static final String JSON = "application/json";
	String baseUrl = "https://reqres.in/api/";

	@Test
	public void canGetResponseFromEmployees() {
		var endpoint = getEndpoint("users/2");

		var expectedCode = StatusCodes.Ok;
		var actualCode = get(endpoint).getStatusCode();

		Assert.assertEquals(actualCode, expectedCode);
	}

	@Test
	public void verifyEmailAddress() {

		var endpoint = getEndpoint("users/2");
		var email = "janet.weaver@reqres.in";

		when()
		.get(endpoint)
		.then()
		.assertThat()
		.statusCode(StatusCodes.Ok)
		.and()
		.body("data.email", equalTo(email));
	}
	
	@Test
	public void verifyPostTokenReturnValue() {
		var endpoint = getEndpoint("login");
		var token = "QpwL5tke4Pnpja7X4";

		var loginCredentials = new JsonObject();
		loginCredentials.addProperty("email", "eve.holt@reqres.in");
		loginCredentials.addProperty("password", "cityslicka");

		given()
		.contentType(JSON)
		.body(loginCredentials.toString())
		.post(endpoint)
		.then()
		.assertThat()
		.statusCode(StatusCodes.Ok)
		.and()
		.body("token", is(token));
	}
	
	@Test
	public void verifyDelete() {

		var endpoint = getEndpoint("users/2");

		given()
		.delete(endpoint)
		.then()
		.assertThat()
		.statusCode(StatusCodes.NoContent);
	}
	
	@Test
	public void canPatch() {

		var endpoint = getEndpoint("users/2");

		var user = new User();
		user.name = "morpheus2";
		user.job = "zion resident";

		given()
		.contentType(JSON)
		.body(user)
		.patch(endpoint)
		.then()
		.assertThat()
		.statusCode(StatusCodes.Ok)
		.and()
		.body("name", is(user.name))
		.body("job", is(user.job));
	}
	
	@Test
	public void canPut() {

		var endpoint = getEndpoint("users/2");

		var user = new User();
		user.name = "morpheus2";
		user.job = "zion resident";

		given()
		.contentType(JSON)
		.body(user)
		.patch(endpoint)
		.then()
		.assertThat()
		.statusCode(StatusCodes.Ok)
		.and()
		.body("name", is(user.name))
		.body("job", is(user.job));
	}
	
	@Test
	public void canDeserializeUserDetails() {

		String endpoint = getEndpoint("users/2");

		var expectedUserDataDetails = new UserData();
		expectedUserDataDetails.id = 2;
		expectedUserDataDetails.email = "janet.weaver@reqres.in";
		expectedUserDataDetails.first_name = "Janet";
		expectedUserDataDetails.last_name = "Weaver";
		expectedUserDataDetails.avatar = "https://reqres.in/img/faces/2-image.jpg";

		var expectedUserSupportDetails = new UserSupport();
		expectedUserSupportDetails.url = "https://reqres.in/#support-heading";
		expectedUserSupportDetails.text = "To keep ReqRes free, contributions towards server costs are appreciated!";

		var expectedUserDetails = new UserDetail();
		expectedUserDetails.data = expectedUserDataDetails;
		expectedUserDetails.support = expectedUserSupportDetails;

		var updatedUser = given()
				.get(endpoint)
				.getBody()
				.as(UserDetail.class);

		Assert.assertEquals(updatedUser.data.id, expectedUserDetails.data.id);
		Assert.assertEquals(updatedUser.data.email, expectedUserDetails.data.email);
		Assert.assertEquals(updatedUser.data.first_name, expectedUserDetails.data.first_name);
		Assert.assertEquals(updatedUser.data.last_name, expectedUserDetails.data.last_name);
		Assert.assertEquals(updatedUser.data.avatar, expectedUserDetails.data.avatar);

		Assert.assertEquals(updatedUser.support.url, expectedUserDetails.support.url);
		Assert.assertEquals(updatedUser.support.text, expectedUserDetails.support.text);
	}
	
	@Test
	public void canDeserializeUserDetailsList() {

		var endpoint = getEndpoint("users?page=2");

		var expectedPage = new UserPage();
		expectedPage.page = 2;
		expectedPage.per_page = 6;
		expectedPage.total = 12;
		expectedPage.total_pages = 2;

		expectedPage.data = new UserDetail[6];

		var expectedUserSupportDetails = new UserSupport();
		expectedUserSupportDetails.url = "https://reqres.in/#support-heading";
		expectedUserSupportDetails.text = "To keep ReqRes free, contributions towards server costs are appreciated!";

		expectedPage.support = expectedUserSupportDetails;

		UserPage userPage = given()
				.get(endpoint)
				.getBody()
				.as(UserPage.class);

		Assert.assertEquals(userPage.page, expectedPage.page);
		Assert.assertEquals(userPage.per_page, expectedPage.per_page);
		Assert.assertEquals(userPage.total, expectedPage.total);
		Assert.assertEquals(userPage.total_pages, expectedPage.total_pages);	
		Assert.assertEquals(userPage.support.text, expectedPage.support.text);
		Assert.assertEquals(userPage.data.length, expectedPage.data.length);	
	}

	private String getEndpoint(String endpoint) {
		return baseUrl + endpoint;
	}
}
