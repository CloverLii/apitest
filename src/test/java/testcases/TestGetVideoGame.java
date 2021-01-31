package testcases;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.ArrayList;

public class TestGetVideoGame extends BaseTest {

	private Response response;
	private ArrayList<Integer> idList;
	
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
	
	@Test (description = "get all ids for possilbe use")
	private void getVideoGamesCount() {
		
		RestAssured.basePath = BaseTest.getAllVideoGames();	
		
		String responseStr = given()
								.get()
							.then()
								.extract()
								.response()
								.asString();
		
		System.out.println("...the content of 'responseStr' is : " + responseStr);			
	}
	
	@Test(description = "get one Video Game by id", priority = 2)
	public void testSearchByOne() {
		
		RestAssured.basePath = BaseTest.getVideoGameByID(2);
		System.out.println();
		
		given()
			.contentType("application/json")
		.when()
			.get()
		.then()
			.statusCode(200)
			.contentType(ContentType.XML)
			.assertThat()
			//.body("videoGame.id", equalTo(2))
			.body("videoGame.name", equalTo("Gran Turismo 3"))
			//.body("videoGame.reviewScore", equalTo(91))
			.body("videoGame.@category", equalTo("Driving"))
			.body("videoGame.@rating", equalTo("Universal"));
	}	
}
