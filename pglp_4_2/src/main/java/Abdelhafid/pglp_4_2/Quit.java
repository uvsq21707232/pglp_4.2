package Abdelhafid.pglp_4_2;

public class Quit implements GeneriqueCommand {

	
	@Override
	public void apply() {
		 System.out.println("Vous venez de quitté le programme.");
		 System.exit(0);
		
	}

}
