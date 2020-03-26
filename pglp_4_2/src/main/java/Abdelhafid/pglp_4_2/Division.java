package Abdelhafid.pglp_4_2;

import Exeptions.DivisionParZeroException;

public class Division implements SpecificCommand {

	@Override
	public int apply(final int a,final int b) {
		
		if(b == 0) {
			throw new DivisionParZeroException();
		}
		
		return a/b;
	}

}
