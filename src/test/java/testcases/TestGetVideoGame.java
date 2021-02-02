package testcases;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Test 'get video game' related APIs: get_all_video_games, get_video_game_by_id
 * @author cloverli
 * @date 03/02/2021
 *
 */
public class TestGetVideoGame extends BaseTest {

	
	@Test(description = "API: get a list of all Video Games", priority = 1)
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
		
	
	@Test(description = "API: get one Video Game by id", priority = 2)
	public void testSearchByID(){
		
		// use certain video game for regression test
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
