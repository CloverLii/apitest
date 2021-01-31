package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import util.BasePath;
import util.PropertiesReader;
import util.VideoGame;

public class BaseTest {
		
	private String baseURL;
	
	
	@BeforeTest(alwaysRun = true, description = "read properties file")
	@Parameters({"propertiesPath"})
	public void getProperties(@Optional("src/test/resources/config/config.properties") String propertiesPath) throws IOException {
		
		System.out.println("...BaseTest beforeTest: read properties file");
		
		// TODO: read maybe more than one properties files
		PropertiesReader.readProperties(propertiesPath);
		baseURL = PropertiesReader.getKey(baseURL);
	}
	
	public String getAllVideoGames() {
		return baseURL + BasePath.GET_ALL_VIDEO_GAMES;
	}
	
	public String getVideoGameByID() {
		return baseURL + BasePath.GET_VIDEO_GAME_BY_ID;
	}
	
	public String deleteVideoGameByID(Integer id) {
		return baseURL + BasePath.DELETE_VIDEO_GAME;
	}
	
	public String addNewVideoGame(VideoGame videogame) {
		return baseURL + BasePath.ADD_VIDEO_GAME;
	}
	
	public String updateVideoGame(VideoGame videogame) {
		return baseURL + BasePath.UPDATE_VIDEO_GAME;
	}
}
