package com.biss.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biss.excel.GRNExcelView;
import com.biss.excel.GRNPdfView;
import com.biss.model.GRN;
import com.biss.service.IGRNService;

@Controller
@RequestMapping("/grn")
public class GRNController {
	@Autowired
	private IGRNService ser;
	
	
	//1.Show Reg page
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("gRN",new GRN());
	return "GRNRegPage";
	}
	//2.on click save Operation
	@RequestMapping(value = "/save",method =POST)
	public String saveOneGRN(@ModelAttribute GRN gRN,Model m) {
		Integer id=ser.saveGRN(gRN);
		String msg="GRN "+id+" Saved";
		m.addAttribute("msg",msg);
		m.addAttribute("gRN",new GRN());
	return "GRNRegPage";
	}
	//3.show all data
	@RequestMapping("/all")
	public String getAllGRN(Model model) {
		List<GRN> list=ser.getAllGRN();
		model.addAttribute("list",list);
	return "GRNData";
	}
	//4.delete one order
	@RequestMapping("/delete")
	public String deleteGRN(@RequestParam("gid")Integer id,Model m) {
		ser.deleteGRN(id);
		String msg="GRNOrder "+id+" Deleted";
		m.addAttribute("msg", msg);
		
		List<GRN> list=ser.getAllGRN();
		m.addAttribute("list",list);
	return "GRNData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("gid")Integer id,Model m) {
		GRN GRN=ser.getOneGRN(id);
		m.addAttribute("gRN",GRN);
		return "GRNEditPage";
	}
	//6.on click update operation
	@RequestMapping(value="/update" ,method=POST)
	public String updateGRN(@ModelAttribute GRN gRN,Model m) {
		ser.updateGRN(gRN);
		String msg="GRN Order "+gRN.getGrnId()+" Updated";
		m.addAttribute("msg",msg);
		
		List<GRN> list=ser.getAllGRN();
		m.addAttribute("list",list);
		return "GRNData";
	}
	//7.view one Order
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("gid")Integer id,Model m) {
		GRN om=ser.getOneGRN(id);
		System.out.println(om);
		m.addAttribute("ob",om);
		return "GRNView";
	}
	//Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="gid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new GRNExcelView());
		if(id==null) {
		//fething all data 
		List<GRN> list=ser.getAllGRN();
		mv.addObject("list",list);
		}else {
			//fetch one data
		GRN	om=ser.getOneGRN(id);
		mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
	//Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView showPDf(@RequestParam(value="gid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new GRNPdfView());
		if(id==null) {
		//fething all data 
		List<GRN> list=ser.getAllGRN();
		mv.addObject("list",list);
		}else {
			//fetch one data
		GRN	om=ser.getOneGRN(id);
		mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
}
