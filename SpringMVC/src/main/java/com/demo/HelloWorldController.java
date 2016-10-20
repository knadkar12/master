package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.UserDao;

@Controller
//@SessionAttributes("id")
public class HelloWorldController 
{
	@Autowired
	UserDao dao;
	
	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/hello")
	public ModelAndView showHello()
	{
		String message="Hello Spring MVC";
		return new ModelAndView("hellopage","message",message);
	}	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "Login";
    }
 
	@RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") UserBean loginBean) 
    {    	
    	UserBean bean = new UserBean();
    	
        if (loginBean != null && loginBean.getId()!= null & loginBean.getPassword() != null) 
        {
        	bean = dao.check(loginBean.getId());
        	
            if (loginBean.getId().equals(bean.getId()) && loginBean.getPassword().equals(bean.getPassword())) 
            {
                model.addAttribute("msg", "Welcome ");
                model.addAttribute("id",loginBean.getId());
                return "success";
            } 
            else
            {
                model.addAttribute("error", "Invalid Details");
                return "Login";
            }
        } 
        else
        {
            model.addAttribute("error", "Please enter Details");
            return "Login";
        }
	
	
/*    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
        if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
            if (loginBean.getUserName().equals("chandra") && loginBean.getPassword().equals("chandra123")) {
                model.addAttribute("msg", "Welcome " + loginBean.getUserName());
                return "success";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "Login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "Login";
        }*/
    }
	
	
	/*@RequestMapping(value="/login" , method = RequestMethod.GET)
	public ModelAndView login() 
	{
		ModelAndView model = new ModelAndView("Login");
        model.addObject("msg", "Please Enter Your Login Details");
        return model;
    }
	
	@RequestMapping(value="/submitForm", method=RequestMethod.GET)
	public ModelAndView submit(@ModelAttribute("loginBean") LoginBean loginBean)
	{
		ModelAndView model=null;
		
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) 
		{
            if (loginBean.getUserName().equals("chandra") && loginBean.getPassword().equals("chandra123")) 
            {
            	model=new ModelAndView("success");
            	model.addObject("msg","Welcome "+loginBean.getUserName());
               return model;
                
            } 
            else 
            {
            	model=new ModelAndView("Login");
            	model.addObject("msg","Sorry incorrect credentials");
                return model;
            }
        } 
		else 
        {
	        	model=new ModelAndView("Login");
	        	model.addObject("error","Values can not be blank ");
	        	return model;
        }
	}*/
	/*@RequestMapping(value="/submitForm",method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean)
	{
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
            if (loginBean.getUserName().equals("chandra") && loginBean.getPassword().equals("chandra123")) {
                model.addAttribute("msg", "welcome" + loginBean.getUserName());
                return "success";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }*/
}
	
