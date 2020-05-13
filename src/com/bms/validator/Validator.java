package com.bms.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	//Works
	public boolean isName(String name) {
		boolean flag = true;
		String nameRegex = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
		Pattern p = Pattern.compile(nameRegex);

		if(name == null) {
			flag = false;

		}
		else {
			if(name.length() == 0) {
				flag = false;	
			}
			else {
				Matcher m = p.matcher(name);
				flag = m.matches();
			}
		}
		return true;
	}
	
	//Works
	public boolean isEmail(String email) {
		boolean flag = true;
		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(emailPattern);

		if(email == null) {
			flag = false;

		}
		else {
			if(email.length() == 0) {
				flag = false;	
			}
			else {
				Matcher m = p.matcher(email);
				flag = m.matches();
			}
		}
		return true;
	}
	
	//Works
	public boolean isUSN(String USN) {

		boolean flag = true;
		String emailPattern = "[1-4][A-Z][A-Z][0-9][0-9][A-Z][A-Z][0-9][0-9][1-9]";
		Pattern p = Pattern.compile(emailPattern);

		if(USN == null) {
			flag = false;

		}
		else {
			if(USN.length() == 0) {
				flag = false;	
			}
			else {
				Matcher m = p.matcher(USN);
				flag = m.matches();
			}
		}
		return true;
	}
	
	//Works
	public boolean isMOB(String mob) {
		
		boolean flag = true;
		
		String mobPattern = "[1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
		Pattern p = Pattern.compile(mobPattern);

		if(mob == null) {
			flag = false;

		}
		else {
			if(mob.length() == 0) {
				flag = false;	
			}
			else {
				Matcher m = p.matcher(mob);
				flag = m.matches();
			}
		}
		
		return true;
	}
}
