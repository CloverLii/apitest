package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import util.FormatConverterUtil;
import util.VideoGame;

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
	
	@Test (description = "API: delete a video game by id")
	public void testDeleteVideoGame() {
			
		RestAssured.basePath = BaseTest.deleteVideoGameByID(videoGame.getId());
		
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
