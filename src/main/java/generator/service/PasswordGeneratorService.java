package generator.service;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.primitives.Chars;

@Service
public class PasswordGeneratorService {
	
	
	
	public String getPassword(boolean withSpecialCharacters, String specialCharacters){	
		return generatePassword(withSpecialCharacters,specialCharacters);
	}

	public String generatePassword(boolean withSpecialCharacters, String specialCharacters) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String retString = "";
		String pwd = "";
		if(withSpecialCharacters){
			characters = characters + specialCharacters;
			pwd = RandomStringUtils.random(8,characters);
			List<Character> randomPwdCharList = Lists.newLinkedList(Chars.asList(pwd.toCharArray()));
			List<Character> scList = Lists.newLinkedList(Chars.asList(specialCharacters.toCharArray()));
			
			for(Character sc: scList){
				while(!randomPwdCharList.contains(sc)){
					pwd = RandomStringUtils.random(8,characters);
					randomPwdCharList = Lists.newLinkedList(Chars.asList(pwd.toCharArray()));
				}
			}
			
			for(Character passwordChar: randomPwdCharList){
				retString += passwordChar;
			}
		}else{
			retString = RandomStringUtils.random(8,characters);
		}
		
		return retString;
	}
}
