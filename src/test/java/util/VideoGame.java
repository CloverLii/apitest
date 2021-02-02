package util;

public class VideoGame {
		
	private Integer id;
	private String name;
	private String releaseDate; // format: 2005-10-01T00:00:00+12:00
	private Integer reviewScore;
	private String category;
	private String rate;
	
	public VideoGame() {
		
	}
	
	public VideoGame(Integer id, String name, String releaseDate, Integer reviewScore, String category, String rate) {
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.reviewScore = reviewScore;
		this.category = category;
		this.rate = rate;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getReviewScore() {
		return reviewScore;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getRate() {
		return rate;
	}
	
	public void setID(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setReviewScore(Integer score) {
		this.reviewScore = score;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setRate(String rate) {
		this.rate = rate;
	}
	
}
