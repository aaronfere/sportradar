package sportradar;

import java.util.Comparator;

public class MatchComparator implements Comparator<Match>{

	@Override
	public int compare(Match o1, Match o2) {
		if ( (o1.getScore_Away() + o1.getScore_Home()) != (o2.getScore_Away() + o2.getScore_Home()) ) {
			//Order by goals.
			return (o2.getScore_Away() + o2.getScore_Home()) - (o1.getScore_Away() + o1.getScore_Home());
		}else {
			//Order by the most recently added to our system.
			return o2.getId() - o1.getId();
		}
	}
}
