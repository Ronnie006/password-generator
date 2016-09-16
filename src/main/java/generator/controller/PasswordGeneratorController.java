package generator.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import generator.service.PasswordGeneratorService;

@RestController
public class PasswordGeneratorController {
	
	@Autowired
	PasswordGeneratorService passwordGeneratorService; 
	
	@RequestMapping("/")
    String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "index";
    }
	
	@RequestMapping(value="/password", method=RequestMethod.POST)
	public String getPassword(@RequestBody Map<String, Object> request){
		
		boolean withSpecialCharacters = Boolean.parseBoolean(request.get("withSpecialCharacters").toString());
		String specialCharacters = request.get("specialCharacters").toString();
		
		return passwordGeneratorService.generatePassword(withSpecialCharacters,specialCharacters);
	}
	
}
