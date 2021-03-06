package com.biss.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biss.excel.WhUserTypeExcelView;
import com.biss.excel.WhUserTypePdfView;
import com.biss.model.WhUserType;
import com.biss.service.IWhUserTypeService;
import com.biss.utils.EmailUtil;
import com.biss.utils.WhUserTypeUtil;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService ser;
	@Autowired
	private ServletContext context;
	@Autowired
	private WhUserTypeUtil util;
	@Autowired
	private EmailUtil emailUtil;
	
	@RequestMapping("/register")
	public String registerWhUser(Model model) {
		model.addAttribute("whUserType",new WhUserType());
		return "WhUserRegister";
	}
	@RequestMapping(value = "/save",method =POST)
	public String saveWhUser(@ModelAttribute WhUserType whUserType,Model m) {
		Integer id=ser.saveWhUser(whUserType);
		
		String msg="WhUser "+id+" Saved";
		if(id!=null) { //send email
			String text="Welcome to WhUser ="+whUserType.getWhUserCode()
			+", type="+whUserType.getWhUserType()
			+", All the best!!";
			
			boolean sent=emailUtil.sendEmail(
					whUserType.getWhUserEmail(), 
					"Welcome WhUser", 
					text);
			if(sent)
				msg+=",Email also sent!";
			else
				msg+=",Email Sending Fail!";
		}
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
		String msg="WhUser "+id+" deleted";
		m.addAttribute("msg",msg);
		List<WhUserType> list=ser.getAllWhUser();
		m.addAttribute("list",list);
		return "WhUserData";
	}
	//5.show edit page
		@RequestMapping("/edit")
		public String showEditPage(@RequestParam("userid")Integer id,Model m) {
			WhUserType WhUserType=ser.getOneWhUserType(id);
			m.addAttribute("whUserType",WhUserType);
			return "WhUserEditPage";
		}
		//6.on click update operation
		@RequestMapping(value="/update" ,method=POST)
		public String updateWhUserType(@ModelAttribute WhUserType whUserType,Model m) {
			ser.updateWhUserType(whUserType);
			String msg="WhUserType "+whUserType.getUserId()+" Updated";
			m.addAttribute("msg",msg);

			List<WhUserType> list=ser.getAllWhUser();
			m.addAttribute("list",list);
			return "WhUserData";
		}
		//7.view one Order
		@RequestMapping("/view")
		public String showViewPage(@RequestParam("userid")Integer id,Model m) {
			WhUserType om=ser.getOneWhUserType(id);
			m.addAttribute("ob",om);
			return "WhUserTypeView";
		}
	//Excel Export
		@RequestMapping("/excel")
		public ModelAndView showExcel(@RequestParam(value="userid",required = false)Integer id) {
			ModelAndView mv=new ModelAndView();
			mv.setView(new WhUserTypeExcelView());
			if(id==null) {
			//fething data 
			List<WhUserType> list=ser.getAllWhUser();
			mv.addObject("list",list);
			}else {
				WhUserType wt=ser.getOneWhUserType(id);
				mv.addObject("list",Arrays.asList(wt));
			}
			return mv;
		}
		//Pdf Export
		@RequestMapping("/pdf")
		public ModelAndView showPdf(@RequestParam(value="userid",required = false)Integer id) {
			ModelAndView mv=new ModelAndView();
			mv.setView(new WhUserTypePdfView());
			if(id==null) {
			//fething data 
			List<WhUserType> list=ser.getAllWhUser();
			mv.addObject("list",list);
			}else {
				WhUserType wt=ser.getOneWhUserType(id);
				mv.addObject("list",Arrays.asList(wt));
			}
			return mv;
		}
		//Show pie chart
		@RequestMapping("/charts")
		public String showCharts() {
			List<Object[]> list=ser.getWhuserIdCount();
			String path=context.getRealPath("/");
			util.generatePie(path, list);
			util.generateBar(path, list);
			return "WhUserCharts";
		}
}
