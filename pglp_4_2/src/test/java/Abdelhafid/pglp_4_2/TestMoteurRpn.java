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
	
	/* tester la Division*/
	@Test
	public void testDivision() throws Exception {
		
		Stack<Integer> pile = new Stack<Integer>();
		Undo undo = new Undo(pile);
		
		MoteurRPN moteur= MoteurRPN.initialiser(pile, undo);
		
		moteur.enregistrer_op(4);
		moteur.enregistrer_op(8);
		
		/* exécuter la division*/
		
		  moteur.execComd("/");
		
		/* tester le resultat*/
		Stack<Integer> resultat = new Stack<Integer>();
		
		resultat.push(2);
		assertEquals(pile,resultat);
			
	}
	
	
	/* tester l'addition*/
	@Test
	public void testAddition() throws Exception {
		
		Stack<Integer> pile = new Stack<Integer>();
		Undo undo = new Undo(pile);
		
		MoteurRPN moteur= MoteurRPN.initialiser(pile, undo);
		
		moteur.enregistrer_op(5);
		moteur.enregistrer_op(4);
		
		/* exécuter l'addition*/
		
		  moteur.execComd("+");
		
		/* tester le resultat*/
		Stack<Integer> resultat = new Stack<Integer>();
		
		resultat.push(9);
		assertEquals(pile,resultat);
		
		
		
	}
	
	/* tester la Soustraction*/
	@Test
	public void testSoustraction() throws Exception {
		
		Stack<Integer> pile = new Stack<Integer>();
		Undo undo = new Undo(pile);
		
		MoteurRPN moteur= MoteurRPN.initialiser(pile, undo);
		
		moteur.enregistrer_op(5);
		moteur.enregistrer_op(4);
		
		/* exécuter la Soustraction*/
		
		  moteur.execComd("-");
		
		/* tester le resultat*/
		Stack<Integer> resultat = new Stack<Integer>();
		
		resultat.push(-1);
		assertEquals(pile,resultat);
			
	}
	
	
	/* tester une operation qui n'existe pas, le test échoue*/
	@Test (expected=Exception.class)
	public void test() throws Exception {
		
		Stack<Integer> pile = new Stack<Integer>();
		Undo undo = new Undo(pile);
		
		MoteurRPN moteur= MoteurRPN.initialiser(pile, undo);
		
		moteur.enregistrer_op(3);
		moteur.enregistrer_op(2);
		  moteur.execComd("(");
		
		
	}
	
	/* tester avec une seule operande , le test echoue*/
	@Test (expected=Exception.class)
	public void test2() throws Exception {
		
		Stack<Integer> pile = new Stack<Integer>();
		Undo undo = new Undo(pile);
		MoteurRPN moteur= MoteurRPN.initialiser(pile, undo);
		  moteur.enregistrer_op(2);
		  moteur.execComd("+");
		
	}
	

}
