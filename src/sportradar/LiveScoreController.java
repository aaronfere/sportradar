package sportradar;

import java.util.ArrayList;
import java.util.List;

public class LiveScoreController {

	private List<Match> matches;
	
	public List<Match> getMatches() {
		return matches;
	}
	
	public LiveScoreController() {
		super();
		this.matches = new ArrayList<Match>();
	}

	public void startMatch(String home, String away) {
		Match match = new Match(home, away);
		match.setId(matches.size()+1);
		matches.add(match);
	}

	public void finishMatchByTeam(String team) {
		for (Match match : matches) {
			if (team.equals(match.getAway()) || team.equals(match.getHome())) {
				matches.remove(match);
				break;
			}
		}
	}

	public void finishMatchByIndex(int index) {
		matches.remove(index);
	}

	public void updateMatch(int index, int score_Home, int score_Away) {
		matches.get(index).updateMatch(score_Home, score_Away);
	}
	
	public String getSummary() {
		String summary = "";
		matches.sort(new MatchComparator());
		for (Match match : matches) {
			summary += match.toString() + "\n";
		}
		summary = summary.substring(0, summary.length()-1);
		return summary;
	}
	
}
