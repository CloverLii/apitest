package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import util.DataBuilder;
import util.FormatConverterUtil;
import util.VideoGame;

public class TestUpdateVideoGame extends BaseTest {
	
	private VideoGame videoGame;
	
	@BeforeTest(alwaysRun= true, description = " generate random video game info for adding")
	public void prepareDate() {
		
		String name = DataBuilder.getName();
		String releaseDate = DataBuilder.getReleaseDate();
		String category = DataBuilder.getCategoryName();
		String rate = DataBuilder.getRating();
		Integer reviewScore = DataBuilder.getReviewScore();
		Integer id = DataBuilder.getId(14);
		
		System.out.println("...new video game obj: " + id + ", " + name + ", "  + releaseDate + ", "  + reviewScore + ", "  + category + ", "  + rate);
		
		videoGame = new VideoGame(id, name, releaseDate, reviewScore, category, rate);
	}

	@Test(description = "add a new video game", priority = 3)	
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
	
	@Test (description = "delete a video game by id")
	public void testDeleteVideoGame() {
		
		RestAssured.basePath = BaseTest.deleteVideoGameByID(15);
		
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
