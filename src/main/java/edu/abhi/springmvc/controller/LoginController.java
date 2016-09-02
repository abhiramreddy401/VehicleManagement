package edu.abhi.springmvc.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.abhi.springmvc.service.ForgetCredentialsService;
import edu.abhi.springmvc.service.LoginService;
import edu.abhi.springmvc.service.ViolationService;
import edu.abhi.springmvc.vo.ForgetCredentialsVO;
import edu.abhi.springmvc.vo.UsersVO;



@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

    @Autowired
	private ForgetCredentialsService forgetCredentialsService;
    

    @Autowired
	private ViolationService violationService;
    
    @RequestMapping("/UserLogin")
    
    public ModelAndView userLogin() {
    	System.out.println("User Login Page......!!!");
        return new ModelAndView("UserLogin");
    }
    
    
    
    
    @RequestMapping("/forget")
    public ModelAndView forget() {
    	System.out.println("FORGET FORGET");
        return new ModelAndView("Forget");
    }
    
    
   @RequestMapping(value="/forgetCredentials",method=RequestMethod.GET)
    public @ResponseBody String forgetCredentials(@RequestParam("data") String data,HttpSession session) throws Exception {
    	
    	String mailIdOrMobile = data;
    	Date date = new Date();
		java.sql.Date sentTime  = new java.sql.Date( date.getTime());
    	
    	// Get the user mail id based on the Email provided from the UI
		
		String where = "email='"+mailIdOrMobile+"'";
		
		List<UsersVO> usersVOList = loginService.findbyWhere(where);
		
		if(usersVOList.size()>0 || usersVOList!=null)
		{	
			ForgetCredentialsVO forgetCredentialsVO = new ForgetCredentialsVO();
			forgetCredentialsVO.setMailIdOrMobile(mailIdOrMobile);
			forgetCredentialsVO.setUserId(usersVOList.get(0).getUserId());
			forgetCredentialsVO.setSentTime(sentTime);
	    	
	    	return forgetCredentialsService.sendCredentials(forgetCredentialsVO,usersVOList.get(0).getEmail(),usersVOList.get(0).getPassword());
	    	
    	}
		else
		{
			return "Please provide the valid Email-Id";
		}
		
    	
    }
    //showSlots.htm
 /*   
    @RequestMapping(value="/showSlots",method=RequestMethod.GET)
    public @ResponseBody String showSlots(HttpSession session) throws Exception {
    	
    	System.out.println("the show slots methos......!!");
    	String userId = session.getAttribute("userid").toString();
    	String where = "user_id='"+userId+"'";
        
    	System.out.println("showSlots.htm comes here...");
    	carsnikParkingAssignList = carsnikSlotAssignService.findByWhere(where);
    	System.out.println(carsnikParkingAssignList.size());
    	Iterator iterator = carsnikParkingAssignList.iterator();
    	
    	String assignedSlots = "";
    	if(carsnikParkingAssignList.size()>0 || carsnikParkingAssignList!=null)
    	{
    		
    		while(iterator.hasNext())
    		{
    			carsnikParkingAssignVO = (CarsnikParkingAssignVO) iterator.next();
    			assignedSlots += carsnikParkingAssignVO.getSlotNo()+"#";
    			System.out.println(assignedSlots);
    		}
    		
    	}
    	System.out.println(assignedSlots);
    	return assignedSlots;
    }
      */
   
    @RequestMapping("/mainPage")
    public ModelAndView UserMainPage() {
    	return new ModelAndView("UserMainPage");
    }
    
   
    int ViolationCount=0 ;
    Date ViolationDate;
    String userName="";
	String status="";
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public @ResponseBody String loginvalidate(@RequestParam("userid") String userid,@RequestParam("password") String password,HttpSession session) {
    	
    	String returnValue = "";
    	int userLevel;
    	
    	try {
    		// status to be checked and then only allowed to login
    		String where = "id='"+userid+"' and password = '"+password+"' and status='Y'";
    		System.out.println(where);
    		List<UsersVO> usersVOList = loginService.findbyWhere(where);
    		
    		if(usersVOList.size()>0 || usersVOList!=null)
    		{
	    		userName = usersVOList.get(0).getName();
	    		status = usersVOList.get(0).getStatus();
	    		userLevel = usersVOList.get(0).getLevel();
	    		
	    		System.out.println(usersVOList.get(0).toString());
	    	
	    		session.setAttribute("userid",userid);
    			session.setAttribute("password", password);
    			session.setAttribute("username", userName);
    			session.setAttribute("status", status);
    			
    			if(userLevel>0)
    			{
    				returnValue = "Admin";
    			}
    			else{
    			    returnValue = "User";
    			}
    			
    			String vio_where = "vio_user_id='"+userid+"'";
        		List<Object[]> violationDetails = violationService.findbyWhere(vio_where);
        		
        		if(violationDetails.get(0)[0]!=null)
        		{
        			
        		ViolationCount = (Integer)violationDetails.get(0)[0];
        		ViolationDate = (Date)violationDetails.get(0)[1];
        		session.setAttribute("ViolationCount", ViolationCount);
    			session.setAttribute("ViolationDate", ViolationDate);
        		}
        		else
        		{
        		
        			System.out.println("here comes the null pointer exception");
        			session.setAttribute("ViolationCount", ViolationCount);
        			session.setAttribute("ViolationDate", ViolationDate);
        		}
        		
        		
     		}
    		else
    		{
    			returnValue = "login failed";
    		}
    		
    					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return returnValue;
}

    
    
};