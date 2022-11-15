package sportradar;

public class Team {
	
	private String home;
	private String away;
	private int score_Home;
	private int score_Away;
	
	public Team(String home, String away, int score_Home, int score_Away) {
		super();
		this.home = home;
		this.away = away;
		this.score_Home = score_Home;
		this.score_Away = score_Away;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getAway() {
		return away;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public int getScore_Home() {
		return score_Home;
	}

	public void setScore_Home(int score_Home) {
		this.score_Home = score_Home;
	}

	public int getScore_Away() {
		return score_Away;
	}

	public void setScore_Away(int score_Away) {
		this.score_Away = score_Away;
	}

	@Override
	public String toString() {
		return home + " " + score_Home + " - " + score_Away + " " + away;
	}
}
