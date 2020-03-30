package Abdelhafid.pglp_4_2;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class TestUndo {

	@Test
	public void test() {
		Stack<Integer> pile_test = new Stack<Integer>();
		Undo undo = new Undo(pile_test);

		pile_test.push(7);
		undo.addHist();
		pile_test.push(3);
		undo.addHist();
		pile_test.push(4);
		undo.addHist();
		undo.apply();

		Stack<Integer> resultat = new Stack<Integer>();
		resultat.push(7);
		resultat.push(3);
		assertEquals(pile_test, resultat);

	}
}