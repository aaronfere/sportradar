package sportradar;

import java.util.List;

public class LiveScoreController {

	List<Match> matches;

	public void startMatch(String home, String away) {
		Match match = new Match(home, away);
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
		summary = summary.substring(0, summary.length()-2);
		return summary;
	}
	
}
