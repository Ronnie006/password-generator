package generator.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class PasswordGeneratorService {

	public String generatePassword(boolean withSpecialCharacters, String specialCharacters) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		if(withSpecialCharacters){
			characters = characters + specialCharacters;
		}
		
		String pwd = RandomStringUtils.random(8,characters);
		return pwd;
	}
}
