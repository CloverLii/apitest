package util;

public class BasePath {
	
	// GET: get a list of all video games
	public static String GET_ALL_VIDEO_GAMES = "/videogames";
	
	// GET: get a single video game by ID
	public static String GET_VIDEO_GAME_BY_ID = "videogames/{videoGameId}";
	
	// POST: add a new video game
	public static String ADD_VIDEO_GAME = "/videogames";
	
	// DELETE: delete a video game
	public static String DELETE_VIDEO_GAME = "/videogames/{videoGameId}";
	
	// PUT: update a video game
	public static String UPDATE_VIDEO_GAME = "/videogames/{videoGameId}";
		
}
