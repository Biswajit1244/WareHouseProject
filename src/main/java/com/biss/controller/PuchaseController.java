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

import com.biss.excel.PurchaseExcelView;
import com.biss.excel.PurchasePdfView;
import com.biss.model.Purchase;
import com.biss.service.IPurchaseService;
@Controller
@RequestMapping("purchase")
public class PuchaseController {
	@Autowired
	private IPurchaseService ser;
	
	//1.Show Reg page
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("purchase",new Purchase());
	return "PurchaseRegPage";
	}
	//2.on click save Operation
	@RequestMapping(value = "/save",method =POST)
	public String saveOnePurchase(@ModelAttribute Purchase purchase,Model m) {
		Integer id=ser.savePurchase(purchase);
		String msg="Purchase "+id+" Saved";
		m.addAttribute("msg",msg);
		m.addAttribute("purchase",new Purchase());
	return "PurchaseRegPage";
	}
	//3.show all data
	@RequestMapping("/all")
	public String getAllPurchase(Model model) {
		List<Purchase> list=ser.getAllPurchase();
		model.addAttribute("list",list);
	return "PurchaseData";
	}
	//4.delete one order
	@RequestMapping("/delete")
	public String deletePurchase(@RequestParam("pid")Integer id,Model m) {
		ser.deletePurchase(id);
		String msg="Order "+id+" Deleted";
		m.addAttribute("msg", msg);
		
		List<Purchase> list=ser.getAllPurchase();
		m.addAttribute("list",list);
	return "PurchaseData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("pid")Integer id,Model m) {
		Purchase Purchase=ser.getOnePurchase(id);
		m.addAttribute("purchase",Purchase);
		return "PurchaseEditPage";
	}
	//6.on click update operation
	@RequestMapping(value="/update" ,method=POST)
	public String updatePurchase(@ModelAttribute Purchase purchase,Model m) {
		ser.updatePurchase(purchase);
		String msg="Purchase "+purchase.getPurId()+" Updated";
		m.addAttribute("msg",msg);
		
		List<Purchase> list=ser.getAllPurchase();
		m.addAttribute("list",list);
		return "PurchaseData";
	}
	//7.view one Order
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("pid")Integer id,Model m) {
		Purchase om=ser.getOnePurchase(id);
		m.addAttribute("ob",om);
		return "PurchaseView";
	}
	//Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="oid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new PurchaseExcelView());
		if(id==null) {
		//fething all data 
		List<Purchase> list=ser.getAllPurchase();
		mv.addObject("list",list);
		}else {
			//fetch one data
		Purchase	om=ser.getOnePurchase(id);
		mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
	//Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView showPDf(@RequestParam(value="oid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new PurchasePdfView());
		if(id==null) {
		//fething all data 
		List<Purchase> list=ser.getAllPurchase();
		mv.addObject("list",list);
		}else {
			//fetch one data
		Purchase	om=ser.getOnePurchase(id);
		mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
}
