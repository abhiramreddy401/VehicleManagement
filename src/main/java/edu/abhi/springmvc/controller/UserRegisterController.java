package edu.abhi.springmvc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.abhi.springmvc.vo.UsersVO;


@Controller
public class UserRegisterController {
	
	public static final String VIEW_NAME="Register";
	
	@RequestMapping("/register")
    public ModelAndView register() {
    	
        return new ModelAndView(VIEW_NAME);
    }
	
}
