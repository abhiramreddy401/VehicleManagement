package edu.abhi.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.abhi.springmvc.service.LoginService;
import edu.abhi.springmvc.service.PaymentService;
import edu.abhi.springmvc.service.VehicleRegisterService;
import edu.abhi.springmvc.service.ViolationService;
import edu.abhi.springmvc.vo.EntryVO;
import edu.abhi.springmvc.vo.UsersVO;
import edu.abhi.springmvc.vo.VehicleDetailsVO;
import edu.abhi.springmvc.vo.ViolationVO;


@Controller
public class AdminHomeController {
	
	private String userName="";
	private String status="";

	@Autowired
	private LoginService loginService;
    
	@Autowired
	private ViolationService violationService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private VehicleRegisterService vehicleRegisterService;
	

	@RequestMapping("/AdminHomePage")
    public ModelAndView adminHome() {
    	System.out.println("Admin Home Page......!!!");
        return new ModelAndView("AdminHomePage");
    }
	
	@RequestMapping("/AdminLogin")
    public ModelAndView adminLogin() {
    	System.out.println("Admin Login Page......!!!");
        return new ModelAndView("AdminLogin");
    }
	
	@RequestMapping("/RegisterVehicle")
    public ModelAndView registerVehicle() {
    	System.out.println("register a vehicle......!!!");
        return new ModelAndView("RegisterVehicle");
    }
    
    
    @RequestMapping(value="/AdminLoginPage",method=RequestMethod.GET)
    public @ResponseBody String adminloginvalidate(@RequestParam("userid") String userid,@RequestParam("password") String password,HttpSession session) {
    	String returnValue = "";
    	int userLevel;
    	try {
    		String where = "id='"+userid+"' and password = '"+password+"' and status='Y'";
    		List<UsersVO> usersVOList = loginService.findbyWhere(where);
    		if(usersVOList.size()>0)
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
    				returnValue = "Success";
    			}
    			else{
    			    returnValue = "Login Failed";
    			}
    		}
    	}catch (Exception e) {
    			e.printStackTrace();
		}
    	
    	System.out.println("RETURN VALUE:::"+returnValue);
    	return returnValue;	
    } 
   
	
	
	
	@RequestMapping(value="/AdminViolationDetails",method=RequestMethod.GET)
    public @ResponseBody String adminViolations(@RequestParam("userid") String userid,HttpSession session) throws Exception {
		
		System.out.println("Hello in the admin get violation");
		String vio_where = "vio_user_id='"+userid+"'";
		List<ViolationVO> violationVOList = violationService.findbyId(vio_where);
		System.out.println("violation size....."+violationVOList.size());
		Iterator<ViolationVO> iterator = violationVOList.iterator();
		
		String vehicleAndDate="";
		ViolationVO violationVO;
		if(violationVOList.size()>0 &&violationVOList!=null)
		{
			while(iterator.hasNext())
			{
				violationVO	 = 	 iterator.next();
				vehicleAndDate += violationVO.getVehicleNo()+"@"+violationVO.getViolationDate()+"#";
			}
			
		}
		System.out.println("vehicleAndDatevehicleAndDate"+vehicleAndDate);
		return vehicleAndDate;
	}
	
	//

	@RequestMapping(value="/adminViewStatus",method=RequestMethod.GET)
    public @ResponseBody String adminViewStatus(@RequestParam("userid") String userid,HttpSession session) throws Exception {
		System.out.println("Hello in the admin get violation");
		
		/*
		 *  i. User Name 
		 *  ii. Account Status
		 *  iii. No of Violations 
		 *  iv Amount Due
		 * 
		 */
		String where = "user_id='"+userid+"'";
		List<UsersVO> usersVOList = loginService.findbyWhere(where);
		if(usersVOList.size()>0)
		{
			// i.
    		userName = usersVOList.get(0).getName();
    		// ii.
    		status = usersVOList.get(0).getStatus();
    		
    		
    		System.out.println("UserName:::"+userName+":::Status::"+status);
		}
		
	 	   // iii.
		
		List<ViolationVO> violationVOList =  violationService.findViolationsCount(userid);
		
		 int violation_count_month = violationVOList.size();
		
		 System.out.println("Violation Count for 30 days::"+violation_count_month);
		
		 // iv.
		 
		 String dueAmount = paymentService.findDueAmount(userid);
		 
		 System.out.println(userName+"@@"+status+"@@"+violation_count_month+"@@"+dueAmount);
		 
		return userName+"@@"+status+"@@"+violation_count_month+"@@"+dueAmount;
	}

    // view parking entries
	
	@RequestMapping(value="/AdminViewEntries",method=RequestMethod.GET)
    public @ResponseBody String adminViewEntries(@RequestParam("data") String data,HttpSession session) throws Exception {
		
		
		System.out.println("::::::::::::::::::::Entry Date:::"+data);
        String date_s = data;
		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
	    Date date =dt.parse(date_s);

	    // *** same for the format String below
	    SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    String formatedDate = dt1.format(date);
	    System.out.println("FORMATTED DATE DUDE:::::"+formatedDate);	
	    		
		
		String where="Entry_Time='"+formatedDate+"'";
		List <EntryVO> entrylist = vehicleRegisterService.findByDate(where);
		Iterator iterator = entrylist.iterator();
		String entry = "";
		 if(entrylist.size()>0 || entrylist!=null)
				 {
			       while(iterator.hasNext())
			       {
			    	   EntryVO carsnikParkingEntryVO = (EntryVO)iterator.next(); 	
			    	   entry += carsnikParkingEntryVO.getUserName()+"@@"+carsnikParkingEntryVO.getVehicleNumber()+"@@"+carsnikParkingEntryVO.getEntryTime()+"#";
			       }
			 	 }
		
		return entry;
	}
	
	//update status of user
	@RequestMapping(value="/AdminUpdateStatus",method=RequestMethod.GET)
    public @ResponseBody String adminUpdateStatus(@RequestParam("data") String data,HttpSession session) throws Exception {
	   System.out.println("UPDATING THE STATUS in USERS TABLE");
	   
	    String [] arr = data.split("@@");
	    String status = arr[0];
	    String userId = arr[1];
	    String where1="user_id='"+userId+"'";
	    String where2="vio_user_id='"+userId+"'";
	    
	    
	    
	    List <UsersVO> usersVOList = loginService.findbyWhere(where1);
	    System.out.println(":::::::::CARSNIK PARKING USERS VO::::::"+usersVOList.size());
	    
	    List <ViolationVO> violationVOList = violationService.findbyId(where2);
//	    carsnikVehicleRegisterService
	    
	    if((usersVOList.size()>0 || usersVOList!=null) && (violationVOList.size()>0 || violationVOList!=null))
	    {
	    	usersVOList.get(0).setStatus(status);	
	        loginService.update(usersVOList.get(0));
	        
	        Iterator iterator = violationVOList.iterator();
	        
	        while(iterator.hasNext())
	        {
	        	ViolationVO violationVO = (ViolationVO)iterator.next();
	        	violationVO.setActiveOrInactive(status);
	        	
	        	violationService.updateVehicle(violationVO);
	        }
	        
	        System.out.println("UPDATED SUCCESSFULLY...");
	        return "Success";
	        
	    }
	    else
	    {
	    	System.out.println("NOT UPDATED SUCCESSFULLY");
	    	return "Not Updated";
	    }
	    
	}
	
	
	@RequestMapping(value="/sendMailStart",method=RequestMethod.GET)
    public @ResponseBody String sendMailStart(HttpSession ses) throws Exception {
		
		
		 String from = "ramabhi@yahoo.com";
	     String pass ="venianiabhi";
		    // Recipient's email ID needs to be mentioned.
		   //String to = "srinivas.rbs@gmail.com";
		     //String to = toAddress;
		   String host = "smtp.mail.yahoo.com";
  
		   
		   String returnValue = "";
		   // Get system properties
		   Properties properties = System.getProperties();
		   // Setup mail server
		   properties.put("mail.smtp.starttls.enable", "true");
		   properties.put("mail.smtp.host", host);
		   properties.put("mail.smtp.user", from);
		   properties.put("mail.smtp.password", pass);
		   properties.put("mail.smtp.port", "587");
		   properties.put("mail.smtp.auth", "true");

		   // Get the default Session object.
		   Session session = Session.getDefaultInstance(properties);

		   try{
		      		      
		      List<UsersVO> usersVOList = loginService.findAll();
				 if(usersVOList.size()>0 || usersVOList!=null)
				 {
					 Address[] cc;
					 Iterator iterator = usersVOList.iterator();
					 while(iterator.hasNext())
					 {
						// Create a default MimeMessage object.
					      MimeMessage message = new MimeMessage(session);

					      // Set From: header field of the header.
					      message.setFrom(new InternetAddress(from));

					      // Set To: header field of the header.

						 UsersVO usersVO = (UsersVO)iterator.next();
						 message.addRecipient(Message.RecipientType.TO,new InternetAddress(usersVO.getEmail()));
						 
					      // Set Subject: header field
					      message.setSubject("John Rentals Credentials!");

					      // Now set the actual message
					      message.setText("Hi"+ usersVO.getName()+","+'\n'+"This is to inform you that current months bill is generated"+'\n'+"and you are requested to pay the bill"+'\n'+'\n'+"Thanks & Regards"+'\n'+"John Rentals");

					      // Send message
					      Transport transport = session.getTransport("smtp");
					      transport.connect(host, from, pass);
					      transport.sendMessage(message, message.getAllRecipients());
					      transport.close();
					      returnValue = "Success"; 
						 return returnValue;
					 }
					 
				 }
				 else
				 {
					 returnValue = "There are no registered Mail-Id's !";
				 }
		        
		   }catch (MessagingException mex) {
		      mex.printStackTrace();
		   }
		   System.out.println("Start:::"+returnValue);
		return returnValue;
	}
	



@RequestMapping(value="/sendMailEnd",method=RequestMethod.GET)
public @ResponseBody String sendMailEnd(HttpSession ses) throws Exception {
	
	
	 String from = "ramabhi@yahoo.com";
     String pass ="venianiabhi";
	    // Recipient's email ID needs to be mentioned.
	   //String to = "srinivas.rbs@gmail.com";
	     //String to = toAddress;
	   String host = "smtp.mail.yahoo.com";

	   
	   String returnValue = "";
	   // Get system properties
	   Properties properties = System.getProperties();
	   // Setup mail server
	   properties.put("mail.smtp.starttls.enable", "true");
	   properties.put("mail.smtp.host", host);
	   properties.put("mail.smtp.user", from);
	   properties.put("mail.smtp.password", pass);
	   properties.put("mail.smtp.port", "587");
	   properties.put("mail.smtp.auth", "true");

	   // Get the default Session object.
	   Session session = Session.getDefaultInstance(properties);

	   try{
	      		      
	      List<UsersVO> usersVOList = loginService.findAll();
			 if(usersVOList.size()>0 || usersVOList!=null)
			 {
				 Address[] cc;
				 Iterator iterator = usersVOList.iterator();
				 while(iterator.hasNext())
				 {
					// Create a default MimeMessage object.
				      MimeMessage message = new MimeMessage(session);

				      // Set From: header field of the header.
				      message.setFrom(new InternetAddress(from));

				      // Set To: header field of the header.

					 UsersVO usersVO = (UsersVO)iterator.next();
					 message.addRecipient(Message.RecipientType.TO,new InternetAddress(usersVO.getEmail()));
					 
				      // Set Subject: header field
				      message.setSubject("John Rentals Credentials!");

				      // Now set the actual message
				      message.setText("Hi"+ usersVO.getName()+","+'\n'+"This is to inform you that the bill Amount is due"+'\n'+"and you are requested to pay the bill before 10th of next month"+'\n'+'\n'+"Note:Please Ignore this mail if you have already paid the bill amount."+'\n'+"Thanks & Regards"+'\n'+"John Rentals");

				      // Send message
				      Transport transport = session.getTransport("smtp");
				      transport.connect(host, from, pass);
				      transport.sendMessage(message, message.getAllRecipients());
				      transport.close();
				      returnValue = "Success"; 
					 return returnValue;
				 }
				 
			 }
			 else
			 {
				 returnValue = "There are no registered Mail-Id's !";
			 }
	      
	      
	   }catch (MessagingException mex) {
	      mex.printStackTrace();
	   }
	   System.out.println("Start:::"+returnValue);
	return returnValue;

}

/*
 * 
 * Below method is for insert the new vehicle details in the DB
 * 
 */

@RequestMapping(value="/vehicleregister",method=RequestMethod.GET)
public @ResponseBody String vehicleRegister(@RequestParam("data") String data,HttpSession session) throws Exception {
	try{
	String [] vehicleData = data.split("@");

	String make = vehicleData[0];
	String model = vehicleData[1];
	String year = vehicleData[2];
	String planeNo = vehicleData[3];
	String userId = session.getAttribute("userid").toString();
	 
	VehicleDetailsVO vehicleDetailsVO = new VehicleDetailsVO();
	vehicleDetailsVO.setMake(make);
	vehicleDetailsVO.setModel(model);
	vehicleDetailsVO.setUserId(userId);
	vehicleDetailsVO.setVehicleNumber(planeNo);
	vehicleDetailsVO.setYear(year);
	
	vehicleRegisterService.registerVehicle(vehicleDetailsVO);
	
	return "Success";
	}
	catch(Exception e)
	{
		return "Vehicle Not Registered";
	}
}


 /*
  * 
  * Below methos is for update the vehicle details in the DB
  * 
  */
@RequestMapping(value="/vehicleUpdate",method=RequestMethod.GET)
public @ResponseBody String vehicleUpdate(@RequestParam("data") String data,HttpSession session) throws Exception {
	try{
		
	String [] vehicleData = data.split("@");

	String make = vehicleData[0];
	String model = vehicleData[1];
	String year = vehicleData[2];
	String planeNo = vehicleData[3];
	
	System.out.println("::::::::::::::::::::"+planeNo);
	String vehicle_number = "vehicle_number='"+planeNo+"'";
	List<VehicleDetailsVO> vehicleDetailsVOList = vehicleRegisterService.findByWhere(vehicle_number);
	
	System.out.println("BEFORE UPDATE:::"+vehicleDetailsVOList.get(0).toString());
	
	VehicleDetailsVO vehicleDetailsVO = vehicleDetailsVOList.get(0);
	vehicleDetailsVO.setMake(make);
	vehicleDetailsVO.setModel(model);
	vehicleDetailsVO.setVehicleNumber(planeNo);
	vehicleDetailsVO.setYear(year);
	
	System.out.println(vehicleDetailsVO.toString());
	vehicleRegisterService.updateVehicle(vehicleDetailsVO);
	
	return "Success";
	}
	catch(Exception e)
	{
		
		/*carsnikSlotAssignService.delete(slotNo);
		
		String assigned="Y";
		carsnikSlotAssignService.update(assigned,assign_slot);*/
		return "Vehicle Not Updated Vehicle..!!";
	}
}
	

}


