package com.bms.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public boolean isName(String name) {

		boolean flag = true;
		String nameRegex = "[a-z]* [A-Z]*";
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
		return flag;
	}
	
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
		return flag;
	}

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
		return flag;
	}
	
	public boolean isDOB(String DOB) {

		boolean flag = true;
		String emailPattern = "";
		Pattern p = Pattern.compile(emailPattern);

		if(DOB == null) {
			flag = false;

		}
		else {
			if(DOB.length() == 0) {
				flag = false;	
			}
			else {
				Matcher m = p.matcher(DOB);
				flag = m.matches();
			}
		}
		return true;
	}
}
