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
		//Setting id for later sorting.
		match.setId(matches.size()+1);
		matches.add(match);
	}

	public void finishMatchByTeam(String team) {
		for (Match match : matches) {
			//Searching match by team name and them removing from list.
			if (team.equals(match.getAway()) || team.equals(match.getHome())) {
				matches.remove(match);
				break;
			}
		}
	}

	public void finishMatchByIndex(int index) {
		matches.remove(index);
	}
	
	public void updateMatchByTeam(String team, int score_Home, int score_Away) {
		for (Match match : matches) {
			//Searching match by team name and them updating from list.
			if (team.equals(match.getAway()) || team.equals(match.getHome())) {
				match.updateMatch(score_Home, score_Away);
				break;
			}
		}
	}

	public void updateMatchByIndex(int index, int score_Home, int score_Away) {
		matches.get(index).updateMatch(score_Home, score_Away);
	}
	
	public String getSummary() {
		String summary = "";
		//Calling class MatchComparator for sorting.
		matches.sort(new MatchComparator());
		for (Match match : matches) {
			//Generating summary string.
			summary += match.toString() + "\n";
		}
		//Deleting last line break.
		summary = summary.substring(0, summary.length()-1);
		return summary;
	}
	
}
