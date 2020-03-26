package Abdelhafid.pglp_4_2;

public class Quit implements GeneriqueCommand {

	
	@Override
	public void apply() {
		
		 System.exit(0);
		
	}

}
