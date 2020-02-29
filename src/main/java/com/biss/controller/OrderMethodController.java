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

import com.biss.excel.OrderMethodExcelView;
import com.biss.excel.OrderMethodPdfView;
import com.biss.model.OrderMethod;
import com.biss.service.IOrderMethodService;
import com.biss.utils.OrderMethodUtil;
@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService ser;
	@Autowired
	private ServletContext context;
	@Autowired
	private OrderMethodUtil util;
	
	//1.Show Reg page
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("orderMethod",new OrderMethod());
	return "OrderMethodRegPage";
	}
	//2.on click save Operation
	@RequestMapping(value = "/save",method =POST)
	public String saveOneOrderMethod(@ModelAttribute OrderMethod orderMethod,Model m) {
		Integer id=ser.saveOrderMethod(orderMethod);
		String msg="OrderMethod "+id+" Saved";
		m.addAttribute("msg",msg);
		m.addAttribute("orderMethod",new OrderMethod());
	return "OrderMethodRegPage";
	}
	//3.show all data
	@RequestMapping("/all")
	public String getAllOrderMethod(Model model) {
		List<OrderMethod> list=ser.getAllOrderMethod();
		model.addAttribute("list",list);
	return "OrderMethodData";
	}
	//4.delete one order
	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam("oid")Integer id,Model m) {
		ser.deleteOrderMethod(id);
		String msg="Order "+id+" Deleted";
		m.addAttribute("msg", msg);
		
		List<OrderMethod> list=ser.getAllOrderMethod();
		m.addAttribute("list",list);
	return "OrderMethodData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("oid")Integer id,Model m) {
		OrderMethod orderMethod=ser.getOneOrderMethod(id);
		m.addAttribute("orderMethod",orderMethod);
		return "OrderMethodEditPage";
	}
	//6.on click update operation
	@RequestMapping(value="/update" ,method=POST)
	public String updateOrderMethod(@ModelAttribute OrderMethod orderMethod,Model m) {
		ser.updateOrderMethod(orderMethod);
		String msg="OrderMethod "+orderMethod.getOrderId()+" Updated";
		m.addAttribute("msg",msg);
		
		List<OrderMethod> list=ser.getAllOrderMethod();
		m.addAttribute("list",list);
		return "OrderMethodData";
	}
	//7.view one Order
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("oid")Integer id,Model m) {
		OrderMethod om=ser.getOneOrderMethod(id);
		System.out.println(om);
		m.addAttribute("ob",om);
		return "OrderMethodView";
	}
	//Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="oid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new OrderMethodExcelView());
		if(id==null) {
		//fething all data 
		List<OrderMethod> list=ser.getAllOrderMethod();
		mv.addObject("list",list);
		}else {
			//fetch one data
		OrderMethod	om=ser.getOneOrderMethod(id);
		mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
	//Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView showPDf(@RequestParam(value="oid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new OrderMethodPdfView());
		if(id==null) {
		//fething all data 
		List<OrderMethod> list=ser.getAllOrderMethod();
		mv.addObject("list",list);
		}else {
			//fetch one data
		OrderMethod	om=ser.getOneOrderMethod(id);
		mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
	//Show pie chart
		@RequestMapping("/charts")
		public String showCharts() {
			List<Object[]> list=ser.getOrderTypeCount();
			String path=context.getRealPath("/");
			util.generatePie(path, list);
			util.generateBar(path, list);
			return "OrderMethodCharts";
		}
}
