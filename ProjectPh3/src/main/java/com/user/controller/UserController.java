package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.beans.User;
import com.user.dao.UserDao;

@Controller
public class UserController {
	@Autowired
	UserDao dao;

	@RequestMapping("/viewuser")
	public String viewuser(Model m) {
		List<User> userList = dao.getUserDetails();
		m.addAttribute("userList", userList);
		return "viewuser";
	}

	@RequestMapping(value = "/edituser/{uid}")
	public String edit(@PathVariable int uid, Model m) {
		User user = dao.getUserId(uid);
		m.addAttribute("user", user);
		return "editform";
	}
	
	
	
	@GetMapping("/userform")
    public String showUserForm() {
        return "usereditform";
    }

    @PostMapping("/getuser")
    public String getUser(@RequestParam("uid") int uid, Model model) {
        User user = dao.getUserId(uid);
        if (user == null) {
            model.addAttribute("error", "User not found for UID: " + uid);
        } else {
            model.addAttribute("user", user);
        }
        return "usereditform";
    }

    
    
    
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("user") User user) {
		System.out.println(user.getUid());
		dao.update(user);
		return "redirect:/viewuser";
	}

}
