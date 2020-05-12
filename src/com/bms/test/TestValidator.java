package com.bms.test;

import com.bms.validator.Validator;

public class TestValidator {

	public static void main(String[] args) {
		
		Validator va = new Validator();
		String name = "Sumanth vam veer";
		String email = "vs.sumanth2k@bmsce.ac.in";
		String usn = "1BM18CS113";
		String mob = "9480707109";
		
		
		
		//TESTERS
		System.out.println("isName for "+name+" = "+va.isName(name));
		System.out.println("isEamil for "+email+" = "+va.isEmail(email));
		System.out.println("isUSN for "+usn+" = "+va.isUSN(usn));
		System.out.println("isMOB for "+mob+" = "+va.isMOB(mob));
	}

}
