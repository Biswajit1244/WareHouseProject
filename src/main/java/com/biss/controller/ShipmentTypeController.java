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

import com.biss.excel.ShipmentTypeExcelView;
import com.biss.excel.ShipmentTypePdfView;
import com.biss.model.ShipmentType;
import com.biss.service.IShipmentTypeService;
import com.biss.utils.ShipmentTypeUtil;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService ser;
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtil util;

	@RequestMapping("/register")
	public String showRegister(Model m) {
		m.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentRegPage";
	}
	@RequestMapping(value = "/save", method=POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType,
			Model model) {
		Integer id=ser.saveShipmentType(shipmentType);
		String msg="ShipmentType of id "+id+" Saved";
		model.addAttribute("msg",msg);
		model.addAttribute("shipmentType",new ShipmentType());
		return"ShipmentRegPage";
	}
	@RequestMapping("/all")
	public String getShipmentData(Model model) {
		List<ShipmentType> list=ser.getAllShipmentType();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	/***
	 * This method delete the shipment based on shipId
	 * comming by url Rewritting
	 */
	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("sid")Integer id,
			Model model) {
		ser.deleteShipmentType(id);
		String msg="Shipment "+id+" Deleted";
		model.addAttribute("msg",msg);

		List<ShipmentType> list=ser.getAllShipmentType();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid")Integer id,Model m) {
		ShipmentType s=ser.getOneShipment(id);
		m.addAttribute("shipmentType", s);
		return "ShipmentEditPage";
	}

	@RequestMapping(value = "/update",method=POST)
	public String upDateShipMent(@ModelAttribute ShipmentType shipmentType,Model m) {
		ser.updateShipmentType(shipmentType);
		String msg="ShipmentType "+shipmentType.getShipId()+" updated";
		m.addAttribute("msg",msg);

		List<ShipmentType> list=ser.getAllShipmentType();
		m.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	//view one ShipMent Details
	@RequestMapping("/view")
	public String showOneShipment(@RequestParam("sid")Integer id,Model m)
	{
		ShipmentType st=ser.getOneShipment(id);
		m.addAttribute("ob", st);
		return "ShipmentTypeView";
	}
	//Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="sid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new ShipmentTypeExcelView());
		if(id==null) {
			//fething data 
			List<ShipmentType> list=ser.getAllShipmentType();
			mv.addObject("list",list);
		}else{
			ShipmentType st=ser.getOneShipment(id);
			mv.addObject("list",Arrays.asList(st));
		}
		return mv;
	}
	//Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="sid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new ShipmentTypePdfView());
		if(id==null) {
			//fething data 
			List<ShipmentType> list=ser.getAllShipmentType();
			mv.addObject("list",list);
		}else{
			ShipmentType st=ser.getOneShipment(id);
			mv.addObject("list",Arrays.asList(st));
		}
		return mv;
	}
	//Show pie chart
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=ser.getShipmentModeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "ShipmentTypeCharts";
	}
}
