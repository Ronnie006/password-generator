package generator.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import generator.service.PasswordGeneratorService;

@RestController
public class PasswordGeneratorController {
	
	private static final Logger logger = LoggerFactory.getLogger(PasswordGeneratorController.class);
	
	@Autowired
	PasswordGeneratorService passwordGeneratorService; 
	
	@RequestMapping(value="/password",method=RequestMethod.POST)
    public Map<String,Object> index(@RequestBody Map<String,Object> request) {
		
		boolean withSc = Boolean.parseBoolean(request.get("withSC").toString());
		String specialChar = "";
		if(!(request.get("specialCharacter")==null)){
			specialChar = request.get("specialCharacter").toString();
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		String password = passwordGeneratorService.getPassword(withSc,specialChar);
		map.put("password", password);
		
		logger.info(password);
		
        return map;
    }	
}



//@Controller
//public class PasswordGeneratorController {
//	
//	@Autowired
//	PasswordGeneratorService passwordGeneratorService; 
//	
//	@RequestMapping(value="/",method=RequestMethod.GET)
//    String index(Model model) {
//		String password = passwordGeneratorService.getPassword();
//		model.addAttribute("password",password);
//        return "index";
//    }
//	
//	@RequestMapping(value="/",method=RequestMethod.POST)
//    String submit(@ModelAttribute SpecialCharacter charac) {
//        return "index";
//    }
//	
//	
//	
//}
