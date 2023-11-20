package package1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class TrelloBoard {
String id;
    
	@Test(enabled = true, priority = 1)
	public void createBoard() {
	    RestAssured.baseURI="https://trello.com/";
	            Response rep = given().queryParam("name", "shrey")
	            .queryParam("key", "bdc0cb35f9f04521a49ceaea67b971af")
	            .queryParam("token", "ATTA969741828c45e387b37d2b720a7c9aaf60ebf07ffd14b2d4a0865f8036a3a0380AAA063F")
	            .header("Content-Type","json/application")
	            .when().post("/1/boards/").then().statusCode(200).contentType(ContentType.JSON).extract().response();
	            JsonPath path=new JsonPath(rep.asString());//want response as string
	            System.out.println(path);
	            id = path.get("id");//getting id 
	            System.out.println(id);
	}
	@Test(enabled = false,priority = 2)
	public void deleteBoard() {
	    RestAssured.baseURI="https://trello.com/";
	         given().queryParam("name", "jas")
	        .queryParam("key", "bdc0cb35f9f04521a49ceaea67b971af")
	        .queryParam("token", "ATTA969741828c45e387b37d2b720a7c9aaf60ebf07ffd14b2d4a0865f8036a3a0380AAA063F")
	        .header("Content-Type","json/application")
	        .when().delete("/1/boards/"+id).then().statusCode(200).contentType(ContentType.JSON).log().all();
	}
}
