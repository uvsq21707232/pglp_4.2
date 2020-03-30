package Abdelhafid.pglp_4_2;

import java.util.Stack;

import org.junit.Test;

public class TestQuit {

	@Test
	public void testquit() throws Exception {
		Stack<Integer> pile = new Stack<Integer>();
		Undo undo = new Undo(pile);
		Interpreteur interpret = Interpreteur.initialiser(undo);

		interpret.executer_cmd("quit");
	}

}
