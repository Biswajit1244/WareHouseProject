package com.biss.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biss.excel.OrderMethodExcelView;
import com.biss.excel.WhUserTypeExcelView;
import com.biss.model.OrderMethod;
import com.biss.model.WhUserType;
import com.biss.service.IWhUserTypeService;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService ser;

	@RequestMapping("/register")
	public String registerWhUser(Model model) {
		model.addAttribute("whUserType",new WhUserType());
		return "WhUserRegister";
	}
	@RequestMapping(value = "/save",method =POST)
	public String saveWhUser(@ModelAttribute WhUserType whUserType,Model m) {
		Integer id=ser.saveWhUser(whUserType);
		
		String msg="WhUser "+id+" Saved";
		m.addAttribute("msg",msg);
		m.addAttribute("whUserType",new WhUserType());
		return "WhUserRegister";
	}
	
	@RequestMapping("/all")
	public String ShowUserData(Model m) {
		List<WhUserType> list=ser.getAllWhUser();
		m.addAttribute("list",list);
		return "WhUserData";
	}
	
	@RequestMapping("/delete")
	public String deleteWhUser(@RequestParam("userid")Integer id,Model m) {
		ser.deleteWhUser(id);
		
		List<WhUserType> list=ser.getAllWhUser();
		m.addAttribute("list",list);
		return "WhUserData";
	}
	//Excel Export
		@RequestMapping("/excel")
		public ModelAndView showExcel() {
			ModelAndView mv=new ModelAndView();
			mv.setView(new WhUserTypeExcelView());
			//fething data 
			List<WhUserType> list=ser.getAllWhUser();
			mv.addObject("list",list);
			return mv;
		}

}
