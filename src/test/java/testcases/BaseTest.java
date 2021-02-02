package testcases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;
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
	
	public static String getVideoGameByID(Integer id) {
		return BasePath.GET_VIDEO_GAME_BY_ID + id;
	}
	
	public static String deleteVideoGameByID(Integer id) {
		return BasePath.DELETE_VIDEO_GAME + id;
	}
	
	public static String addNewVideoGame() {
		return BasePath.ADD_VIDEO_GAME;
	}
	
	public static String updateVideoGame(Integer id, VideoGame videogame) {
		return BasePath.UPDATE_VIDEO_GAME + id;
	}
	
	// get a list of video game id
	public static void getAllVideoGamesIDs() {	
		
		RestAssured.basePath = getAllVideoGames();		
		NodeChildrenImpl idNodes = given().when().get().then().extract().path("videoGames.videoGame.id");	
		List<Node> idNodeList = idNodes.list();
		
		System.out.println("...idNodeList[" + idNodeList.size() + "]: " + idNodeList);
	}	
}
