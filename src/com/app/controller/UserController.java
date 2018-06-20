package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;
@Controller
public class UserController {
	@Autowired
	private IUserService service;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	//1.show register page
	@RequestMapping("/userReg")
	public String showRegPage(){
		return "UserRegister";
	}
	
	
	/**2.This method will be
	 * executed on click submit from
	 * User Register page.
	 * i.  it reads model attribute
	 * ii. call codeUtil getPwd
	 * iii.set pwd to model attribute
	 * iv. call service layer saveuser
	 * v.  call sendEmail using commonUtil
	 * vi. send success msg back to UI
	*/
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user")User user,ModelMap map){
		String pwd=codeUtil.getPwd();
		user.setPassword(pwd);
		int userId=service.saveUser(user);
		String text="Hello :"+user.getUserName()+"/"+user.getEmailId()+",.."
				+" password is:"+user.getPassword();
		commonUtil.sendEmail(user.getEmailId(), "User Register...", text);
		map.addAttribute("msg", "Saved with id:"+userId);
		return "UserRegister";
	}
	//3.show Loging page
	@RequestMapping("/login")
	public String showLogin(){
		System.out.println("from login..");
		return "UserLogin";
	}
	/**
	 * on click login,
	 * this method  will be called
	 * for user name and pwd check
	 * and creates session 
	 * if it is valid
	 */
	@RequestMapping(value="/loginCheck",method=RequestMethod.POST)
	public String loginDetailsCheck(
		@RequestParam("userName")String email,
		@RequestParam("pwd")String pwd,ModelMap map,
		HttpServletRequest req){
		String pageName=null;
		User user=service.getUserByNameAndPwd(email, pwd);
		if(user==null){
			pageName="UserLogin";
			map.addAttribute("msg", "Invalid userName/password");
		}else{
			//create session
			HttpSession ses=req.getSession();
			//keep un in session
			ses.setAttribute("userName", user.getUserName());
			//goto home page
			pageName="LocationReg";
			map.addAttribute("msg", "Valid details");
		}
		return pageName;
	}
	
	
	
	/**
	 * Logout method
	 */
	@RequestMapping("/logout")
	public String doLogout(HttpServletRequest req,ModelMap map){
		HttpSession ses=req.getSession(false);
		ses.setAttribute("userName", null);
		ses.invalidate();
		map.addAttribute("msg","Successfully loggedout!!!");
		return "UserLogin";
	}
	
	
	
	
	
	
	
}