package testcases;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Test 'get video game' related APIs: get_all_video_games, get_video_game_by_id
 * @author cloverli
 * @date 03/02/2021
 *
 */

@Epic("Regression Tests")
@Feature("Get Video Game APIs")
public class TestGetVideoGame extends BaseTest {
	
	private static Logger log = LoggerFactory.getLogger(TestGetVideoGame.class);
	
	@Test(description = "API test: get all video games", groups = {"positive"}, priority = 1)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test description: GET, /videogames, get a list of all video games")
	@Story("Get all video games test")
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
		
	
	@Test(description = "API test: get one video game", groups = {"positive"}, priority = 2)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test description: GET, /videogames/videoGameId, get a video game by id")
	@Story("Get one video game by id")
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
	
	@Test(description="API test: get video game by invalid id", groups = {"negtive"}, priority = 3)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test description: GET, /videogames/videoGameId, try to get a video game by invalid id")
	@Story("Using invalid id when search one video game")
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
