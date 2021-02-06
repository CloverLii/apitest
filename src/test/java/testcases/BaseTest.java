package testcases;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.path.xml.element.Node;
import util.BasePath;
import util.DataBuilder;
import util.PropertiesReader;
import util.VideoGame;


/**
 * 
 * Define regularly used methods in other test classes
 * @author cloverli
 * @date 03/02/2021
 *
 */
public class BaseTest {
	
	private static Logger log = LoggerFactory.getLogger(BaseTest.class);
	
	@BeforeSuite(alwaysRun = true, description = "read configurations from properties files")
	@Parameters({"propertiesPath", "log4jConPath"})
	public void getProperties(@Optional("src/test/resources/config/config.properties") String propertiesPath, 
							  @Optional("src/test/resources/log4j.properties")String log4jConPath) throws IOException {
		
		// TODO: read maybe more than one properties files
		PropertiesReader.readProperties(propertiesPath);
		// get value RestAssured baseURI
		RestAssured.baseURI = PropertiesReader.getKey("conf.baseURI");
		log.info(String.format("====RestAssured baseURI = %s ====", PropertiesReader.getKey("conf.baseURI")));
		// read configuration file of log4j
		PropertyConfigurator.configure(log4jConPath);
	}
	
	public static String getAllVideoGames() {
		return BasePath.GET_ALL_VIDEO_GAMES;
	}
	
	public static String getVideoGameByID(Integer id) {
		return BasePath.GET_VIDEO_GAME_BY_ID + id;
	}
	
	public static String deleteVideoGameByID(Integer id) {
		return BasePath.DELETE_VIDEO_GAME + id;
	}
	
	public static String addNewVideoGame() {
		return BasePath.ADD_VIDEO_GAME;
	}
	
	public static String updateVideoGame(Integer id) {
		return BasePath.UPDATE_VIDEO_GAME + id;
	}
	
	// create new VideoGame object using (partial) predefined random values
	public static VideoGame newVideoGame() {
		
		VideoGame newVG = new VideoGame();
		// unique id for each video game
		newVG.setID(getLastID() + 1);
		newVG.setName(DataBuilder.getName());
		newVG.setReleaseDate(DataBuilder.getReleaseDate());
		newVG.setRating(DataBuilder.getRating());
		newVG.setReviewScore(DataBuilder.getReviewScore());
		newVG.setCategory(DataBuilder.getCategoryName());
		
		return newVG;
	}
	
	// print values of video game object for debugging
	public static void printVGInfo(VideoGame vg) {
		String vgInfo = 
		"...new video game obj: " + vg.getId() + ", " 
				+ vg.getName() + ", "  
				+ vg.getReleaseDate() + ", "  
				+ vg.getReviewScore() + ", "  
				+ vg.getCategory() + ", " 
				+ vg.getRating();	
		
		log.info(String.format("====video game values : %s ====", vgInfo));
	}
	
	// get a list of video game id
	private static List<Node> getAllVideoGamesIDs() {	
		
		RestAssured.basePath = getAllVideoGames();		
		NodeChildrenImpl idNodes = given().when().get().then().extract().path("videoGames.videoGame.id");	
		List<Node> idNodeList = idNodes.list();
		
		System.out.println("...idNodeList[" + idNodeList.size() + "]: " + idNodeList);
		log.info(String.format("====idNodeList[%d]:  %s ====", idNodeList.size(), idNodeList.toString()));
		
		return idNodeList;
	}	
	
	// get the id of last video game
	private static int getLastID() {
		List<Node> idList = getAllVideoGamesIDs();
		int lastID = Integer.parseInt(idList.get(idList.size()-1).value());
		System.out.println("...id of last video game is: " + lastID);
		log.info(String.format("====id of last video game is: %d ====", lastID));
		return lastID;
	}
}
