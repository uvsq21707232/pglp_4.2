package Abdelhafid.pglp_4_2;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class TestMoteurRpn {
	
	/* tester la multiplication*/
	@Test
	public void testMultiplication() throws Exception {
		
		Stack<Integer> pile = new Stack<Integer>();
		Undo undo = new Undo(pile);
		
		MoteurRPN moteur= MoteurRPN.initialiser(pile, undo);
		
		moteur.enregistrer_op(5);
		moteur.enregistrer_op(4);
		
		/* exécuter la multiplication*/
		
		  moteur.execComd("*");
		
		/* tester le resultat*/
		Stack<Integer> resultat = new Stack<Integer>();
		
		resultat.push(20);
		assertEquals(pile,resultat);
		
		
		
	}
}
