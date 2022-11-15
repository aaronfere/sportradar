package sportradar;

import java.util.Comparator;

public class MatchComparator implements Comparator<Match>{

	@Override
	public int compare(Match o1, Match o2) {
		if ( (o1.getScore_Away() + o1.getScore_Home()) != (o2.getScore_Away() + o2.getScore_Home()) ) {
			return (o1.getScore_Away() + o1.getScore_Home()) - (o2.getScore_Away() + o2.getScore_Home());
		}else {
			return o1.getHome().compareTo(o2.getHome());
		}
	}
}
