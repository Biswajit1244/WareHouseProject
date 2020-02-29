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

import com.biss.excel.UomTypeExcelView;
import com.biss.excel.UomTypePdfView;
import com.biss.model.UomType;
import com.biss.service.IUomTypeService;
import com.biss.utils.UomTypeUtil;

@Controller
@RequestMapping("/uom")
public class UomTypeController {
	@Autowired
	private IUomTypeService ser;
	@Autowired
	private ServletContext context;
	@Autowired
	private UomTypeUtil util;
	
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
		String msg="UomType "+id+" deleted";
		m.addAttribute("msg",msg);
		List<UomType> list=ser.getAllUomType();
		m.addAttribute("list", list);
		return "UomTypeData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("uid")Integer id,Model m) {
		UomType uomType=ser.getOneUomType(id);
		m.addAttribute("uomType",uomType);
		return "UomTypeEditPage";
	}
	//6.on click update operation
	@RequestMapping(value="/update" ,method=POST)
	public String updateUomType(@ModelAttribute UomType uomType,Model m) {
		ser.updateUomType(uomType);
		String msg="UomType "+uomType.getUomId()+" Updated";
		m.addAttribute("msg",msg);

		List<UomType> list=ser.getAllUomType();
		m.addAttribute("list",list);
		return "UomTypeData";
	}
	//7.view one Order
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("uid")Integer id,Model m) {
		UomType om=ser.getOneUomType(id);
		m.addAttribute("ob",om);
		return "UomTypeView";
	}
	//Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="uid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new UomTypeExcelView());
		if(id==null) {
			//fetching data 
			List<UomType> list=ser.getAllUomType();
			mv.addObject("list",list);
		}else {
			UomType ut=ser.getOneUomType(id);
			mv.addObject("list",Arrays.asList(ut));
		}
		return mv;
	}
	//Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="uid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new UomTypePdfView());
		if(id==null) {
			//fetching data 
			List<UomType> list=ser.getAllUomType();
			mv.addObject("list",list);
		}else {
			UomType ut=ser.getOneUomType(id);
			mv.addObject("list",Arrays.asList(ut));
		}
		return mv;
	}
	//Show pie chart
		@RequestMapping("/charts")
		public String showCharts() {
			List<Object[]> list=ser.getUomTypeConunt();
			String path=context.getRealPath("/");
			util.generatePie(path, list);
			util.generateBar(path, list);
			return "UomTypeCharts";
		}
}
