package testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.FormatConverterUtil;
import util.VideoGame;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestUpdateVideoGame extends BaseTest {
	
	private VideoGame videoGame;
	
	@BeforeTest(alwaysRun= true, description = " generate random video game info for adding")
	public void prepareDate() {
		
		videoGame = BaseTest.newVideoGame();
		BaseTest.printVGInfo(videoGame);
	}
	
	
	@Test(description = "API: add a new video game", priority = 3)	
	public void testAddVideoGames() throws JsonProcessingException {
		
		RestAssured.basePath = BaseTest.addNewVideoGame();
		given()
			.contentType("application/json")
			.body(FormatConverterUtil.obj2Json(videoGame))
		.when()
			.post()
		.then()
			.statusCode(200)
			.contentType(ContentType.XML)
			.assertThat()
			.body("status", equalTo("Record Added Successfully"))
			.log().all();
	}
	
	
	@Test(description = "API: update a video game by id", priority = 4)
	public void testPutVideoGame() {
		
		RestAssured.basePath = BaseTest.updateVideoGame(videoGame.getId());
		System.out.println("...the name of video game before updating: " + videoGame.getName());
		
		videoGame.setName("name_updated");
		
		given()	
			.contentType("application/json")
			.body(videoGame)
		.when()
			.delete()
		.then()
			.statusCode(200)
			.contentType(ContentType.XML)
			.assertThat()
			.body("name", equalTo("name_updated"));
		
		System.out.println("...the name of video game after updating: " + videoGame.getName());
	}
	
	
	//@Test (description = "API: delete a video game by id", priority = 5)
	public void testDeleteVideoGame() {
			
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
