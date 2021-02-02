package testcases;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestGetVideoGame extends BaseTest {

	
	@Test(description = "get a list of all Video Games", priority = 1)
	public void testGetAllVideoGames() {
		
		RestAssured.basePath = BaseTest.getAllVideoGames();	
		
			given()
				.contentType("application/json")
			.when()
				.get()
			.then()
				.statusCode(200)
				.header("Content-Type", "application/xml");
	}
		
	
	@Test(description = "get one Video Game by id", priority = 2)
	public void testSearchByID(){
		
		RestAssured.basePath = BaseTest.getVideoGameByID(2);
		
		given()
			.contentType("application/json")
		.when()
			.get()
		.then()
			.statusCode(200)
			.contentType(ContentType.XML)
			.assertThat()
			.body("videoGame.id", equalTo("2"))
			.body("videoGame.name", equalTo("Gran Turismo 3"))
			.body("videoGame.reviewScore", equalTo("91"))
			.body("videoGame.@category", equalTo("Driving"))
			.body("videoGame.@rating", equalTo("Universal"));
	}	
}
