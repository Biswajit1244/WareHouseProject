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

import com.biss.excel.SaleExcelView;
import com.biss.excel.SalePdfView;
import com.biss.model.Sale;
import com.biss.service.ISaleService;
@Controller
@RequestMapping("/sale")
public class SaleController {
	@Autowired
	private ISaleService ser;
	
	
	//1.Show Reg page
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("sale",new Sale());
	return "SaleRegPage";
	}
	//2.on click save Operation
	@RequestMapping(value = "/save",method =POST)
	public String saveOneSale(@ModelAttribute Sale sale,Model m) {
		Integer id=ser.saveSale(sale);
		String msg="Sale "+id+" Saved";
		m.addAttribute("msg",msg);
		m.addAttribute("sale",new Sale());
	return "SaleRegPage";
	}
	//3.show all data
	@RequestMapping("/all")
	public String getAllSale(Model model) {
		List<Sale> list=ser.getAllSale();
		model.addAttribute("list",list);
	return "SaleData";
	}
	//4.delete one order
	@RequestMapping("/delete")
	public String deleteSale(@RequestParam("sid")Integer id,Model m) {
		ser.deleteSale(id);
		String msg="SaleOrder "+id+" Deleted";
		m.addAttribute("msg", msg);
		
		List<Sale> list=ser.getAllSale();
		m.addAttribute("list",list);
	return "SaleData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid")Integer id,Model m) {
		Sale Sale=ser.getOneSale(id);
		m.addAttribute("sale",Sale);
		return "SaleEditPage";
	}
	//6.on click update operation
	@RequestMapping(value="/update" ,method=POST)
	public String updateSale(@ModelAttribute Sale sale,Model m) {
		ser.updateSale(sale);
		String msg="Sale Order "+sale.getSaleId()+" Updated";
		m.addAttribute("msg",msg);
		
		List<Sale> list=ser.getAllSale();
		m.addAttribute("list",list);
		return "SaleData";
	}
	//7.view one Order
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("sid")Integer id,Model m) {
		Sale om=ser.getOneSale(id);
		System.out.println(om);
		m.addAttribute("ob",om);
		return "SaleView";
	}
	//Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="oid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new SaleExcelView());
		if(id==null) {
		//fething all data 
		List<Sale> list=ser.getAllSale();
		mv.addObject("list",list);
		}else {
			//fetch one data
		Sale	om=ser.getOneSale(id);
		mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
	//Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView showPDf(@RequestParam(value="oid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new SalePdfView());
		if(id==null) {
		//fething all data 
		List<Sale> list=ser.getAllSale();
		mv.addObject("list",list);
		}else {
			//fetch one data
		Sale	om=ser.getOneSale(id);
		mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
}
