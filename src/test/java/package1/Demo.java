package package1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo {
	@Test(enabled = false)
	public void getAllUsers() {
		io.restassured.response.Response a=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(a.getBody()); //to get response body
		int act=a.getStatusCode(); //to get status code of the response
		Assert.assertEquals(act,200);
		System.out.println(a.time());//to get response time
		System.out.println(a.asString());//to get response body data in the form of string
	    }

	@Test(enabled = false)
	public void tc1() {
	   //given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
	   given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]",equalTo(7));
	   System.out.println(given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all());
	}
	@Test(enabled = false)
	public void getsingleUser() {
		given().get("https://reqres.in/api/users/7").then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void createUser() {
		JSONObject js=new JSONObject();
		js.put("name", "shreyansh");
		js.put("job", "tester");
		System.out.println(js.toJSONString());
		given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	}
	@Test(enabled = false)
	public void updateUser() {
		JSONObject js=new JSONObject();
		js.put("name", "jas");
		js.put("job", "developer");
		System.out.println(js.toJSONString());
		given().body(js.toJSONString()).when().put("https://reqres.in/api/users/7").then().statusCode(200).log().all();
	}
	@Test(enabled = true)
	public void deleteUser() {
		given().delete("https://reqres.in/api/users/7").then().statusCode(204).log().all();
	}
}