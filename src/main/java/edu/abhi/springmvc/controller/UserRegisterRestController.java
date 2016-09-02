package edu.abhi.springmvc.controller;
 
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.abhi.springmvc.service.UserRegisterService;
import edu.abhi.springmvc.vo.UsersVO;
 
@RestController
public class UserRegisterRestController {
 
    @Autowired
    UserRegisterService userRegisterService;  //Service which will do all data retrieval/manipulation work
 
    
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersVO> getUser(@PathVariable("id") String id) {
        //System.out.println("Fetching User with id " + id);
        UsersVO user = userRegisterService.findById(id);
        
        
        return new ResponseEntity<UsersVO>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody UsersVO user,    UriComponentsBuilder ucBuilder) throws Exception {
 
    	Date date = new Date();
		java.sql.Date regDate = new java.sql.Date( date.getTime()); 
		
    	user.setRegDate(regDate);
    	user.setStatus("Y");
    	userRegisterService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
}