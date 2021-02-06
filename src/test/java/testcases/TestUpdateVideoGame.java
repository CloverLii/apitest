package testcases;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.FormatConverter;
import util.VideoGame;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 
 * Test 'update video game' related APIs: add_new_video_games, update_video_game_by_id, delete_video_game_by_id
 * @author cloverli
 * @date 03/02/2021
 *
 */
@Epic("Regression Tests")
@Feature("Handle Video Game APIs")
public class TestUpdateVideoGame extends BaseTest {
	
	private static Logger log = LoggerFactory.getLogger(TestUpdateVideoGame.class);
	
	private VideoGame videoGame;
	
	@BeforeTest(alwaysRun= true, description = "API test: generate a new video game object")
	public void prepareDate() {
		
		videoGame = BaseTest.newVideoGame();
		BaseTest.printVGInfo(videoGame);
	}
	
	//TODO: high lever modelization according to actual project 
	@Test(description = "API test: add a new video game", groups = {"positive"}, priority = 3)	
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test description: POST, /videogames, add a new video game")
	public void testAddVideoGames() throws JsonProcessingException {
		
		RestAssured.basePath = BaseTest.addNewVideoGame();
		given()
			.contentType("application/json")
			// convert VideoGame object to format Json
			.body(FormatConverter.obj2Json(videoGame))
		.when()
			.post()
		.then()
			.statusCode(200)
			.contentType(ContentType.XML)
			.assertThat()
			.body("status", equalTo("Record Added Successfully"))
			.log().all();
	}
	
	
	@Test(description = "API test: update a video game", groups = {"positive"},  priority = 4)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test description: PUT, /videogames/videoGameId, update an existing video game by id ")
	public void testPutVideoGame() throws JsonProcessingException {
		
		// update newly added video game as using a public mock server
		RestAssured.basePath = BaseTest.updateVideoGame(videoGame.getId());
		System.out.println("...the name of video game before updating: " + videoGame.getName());
		
		// use certain name for regression testing
		videoGame.setName("name_updated");
		
		given()	
			.contentType("application/json")
			.body(FormatConverter.obj2Json(videoGame))
		.when()
			.delete()
		.then()
			.statusCode(200)
			.contentType(ContentType.XML)
			.assertThat()
			.body("name", equalTo("name_updated"));
		
		System.out.println("...the name of video game after updating: " + videoGame.getName());
	}
	
	
	@Test (description = "API test: delete a video game", groups = {"positive"}, priority = 5)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test description: DELETE, /videogames/videoGameId, delete an existing video game by id")
	public void testDeleteVideoGame() {
		
		// delete newly added video game as using a public mock server
		RestAssured.basePath = BaseTest.deleteVideoGameByID(videoGame.getId());
		System.out.println("...the id of last video game before deleting: " + videoGame.getId());
		
		given()	
			.contentType("application/json")
		.when()
			.delete()
		.then()
			.statusCode(200)
			.contentType(ContentType.XML)
			.assertThat()
			.body("status", equalTo("Record Deleted Successfully"));
			
	}
}
