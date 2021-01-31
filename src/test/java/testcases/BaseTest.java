package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.restassured.RestAssured;
import util.BasePath;
import util.PropertiesReader;
import util.VideoGame;

public class BaseTest {
	
	@BeforeSuite(alwaysRun = true, description = "read properties files")
	@Parameters({"propertiesPath"})
	public void getProperties(@Optional("src/test/resources/config/config.properties") String propertiesPath) throws IOException {
		
		// TODO: read maybe more than one properties files
		PropertiesReader.readProperties(propertiesPath);
		// get RestAssured baseURI
		RestAssured.baseURI = PropertiesReader.getKey("conf.baseURI");
	}
	
	public static String getAllVideoGames() {
		return BasePath.GET_ALL_VIDEO_GAMES;
	}
	
	public  static String getVideoGameByID(Integer id) {
		return BasePath.GET_VIDEO_GAME_BY_ID + id;
	}
	
	public  static String deleteVideoGameByID(Integer id) {
		return BasePath.DELETE_VIDEO_GAME + id;
	}
	
	public  static String addNewVideoGame() {
		return BasePath.ADD_VIDEO_GAME;
	}
	
	public  static String updateVideoGame(Integer id, VideoGame videogame) {
		return BasePath.UPDATE_VIDEO_GAME + id;
	}
}
