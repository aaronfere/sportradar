package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sportradar.LiveScoreController;

class ScoreTest {

	LiveScoreController controller;

	@BeforeEach
	void setUp() {
		controller = new LiveScoreController();
	}

	@Test
	void testStartMatch() {
		controller.startMatch("Morocco", "Croatia");
		assertEquals(1, controller.getMatches().size());
	}

	@Test
	void testFinishMatchByTeam() {
		controller.startMatch("Morocco", "Croatia");
		controller.finishMatchByTeam("Morocco");
		assertEquals(0, controller.getMatches().size());
	}
	
	@Test
	void testFinishMatchByIndex() {
		controller.startMatch("Morocco", "Croatia");
		controller.finishMatchByIndex(0);
		assertEquals(0, controller.getMatches().size());
	}
	
	@Test
	void testUpdateMatchByTeam() {
		controller.startMatch("Morocco", "Croatia");
		controller.updateMatchByTeam("Morocco", 0, 1);
		assertEquals(1, controller.getMatches().get(0).getScore_Away());
	}

	@Test
	void testUpdateMatchByIndex() {
		controller.startMatch("Morocco", "Croatia");
		controller.updateMatchByIndex(0, 0, 1);
		assertEquals(1, controller.getMatches().get(0).getScore_Away());
	}

	@Test
	void testSummary() {
		String result = "Belgium 7 - Canada 0\n" + "Costa Rica 2 - Spain 4\n" + "Morocco 5 - Croatia 1";
		controller.startMatch("Morocco", "Croatia");
		controller.startMatch("Belgium", "Canada");
		controller.startMatch("Costa Rica", "Spain");
		// Updating results in bulk instead of goal by goal
		controller.updateMatchByIndex(0, 5, 1);
		controller.updateMatchByIndex(1, 7, 0);
		controller.updateMatchByIndex(2, 2, 4);
		String summary = controller.getSummary();
		assertEquals(result, summary);
	}

}
