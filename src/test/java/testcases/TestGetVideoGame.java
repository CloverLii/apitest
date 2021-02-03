package testcases;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * 
 * Test 'get video game' related APIs: get_all_video_games, get_video_game_by_id
 * @author cloverli
 * @date 03/02/2021
 *
 */
public class TestGetVideoGame extends BaseTest {
	
	static Logger log = Logger.getLogger(TestGetVideoGame.class);
	
	@Test(description = "API: get a list of all Video Games", groups = {"positive"}, priority = 1)
	public void testGetAllVideoGames() {
		
		RestAssured.basePath = BaseTest.getAllVideoGames();	
		log.info(String.format("==== API:get all video games: %s ====", BaseTest.getAllVideoGames()));
		
			given()
				.contentType("application/json")
			.when()
				.get()
			.then()
				.statusCode(200)
				.header("Content-Type", "application/xml");
	}
		
	
	@Test(description = "API: get one Video Game by id", groups = {"positive"}, priority = 2)
	public void testSearchByID(){
		
		// use certain video game for regression test
		RestAssured.basePath = BaseTest.getVideoGameByID(2);
		log.info(String.format("==== API:get video game by id: %s ====", BaseTest.getVideoGameByID(2)));
		
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
	
	@Test(description="API: try to get video game by invalid id", groups = {"negtive"}, priority = 3)
	public void testSearchByInvalidID() {
		
		// use invalid video game for regression test
		RestAssured.basePath = BaseTest.getVideoGameByID(10000);
		log.info(String.format("==== API:get video game by id: %s ====", BaseTest.getVideoGameByID(10000)));
		
		given()
			.contentType("application/json")
		.when()
			.get()
		.then()
			.statusCode(500)
			.contentType(ContentType.XML)
			.assertThat()
			.body("Map.error", equalTo("Internal Server Error"));
	}
}
