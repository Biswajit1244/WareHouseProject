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
import com.biss.excel.UomTypeExcelView;
import com.biss.model.OrderMethod;
import com.biss.model.UomType;
import com.biss.service.IUomTypeService;

@Controller
@RequestMapping("/uom")
public class UomTypeController {
	@Autowired
	private IUomTypeService ser;
	
	@RequestMapping("/register")
	public String regUom(Model m) {
		m.addAttribute("uomType", new UomType());
		return "UomTypeRegPage";
	}
	@RequestMapping(value = "/save",method =POST)
	public String saveUomType(@ModelAttribute UomType uomtype,Model m) {
		Integer id=ser.saveUomType(uomtype);
		String msg="Uom Type "+id+" Saved";
		m.addAttribute("msg",msg);
		m.addAttribute("uomType", new UomType());
		return "UomTypeRegPage";
	}
	@RequestMapping("/all")
	public String getAllUomData(Model m) {
		List<UomType> list=ser.getAllUomType();
		m.addAttribute("list", list);
		return "UomTypeData";
	}
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("uid")Integer id,Model m) {
		ser.deleteUomType(id);
		
		List<UomType> list=ser.getAllUomType();
		m.addAttribute("list", list);
		return "UomTypeData";
	}
	//Excel Export
		@RequestMapping("/excel")
		public ModelAndView showExcel() {
			ModelAndView mv=new ModelAndView();
			mv.setView(new UomTypeExcelView());
			//fething data 
			List<UomType> list=ser.getAllUomType();
			mv.addObject("list",list);
			return mv;
		}
	
	
	
	
}
