package com.biss.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biss.model.ShipmentType;
import com.biss.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService ser;
	
	@RequestMapping("/register")
	public String showRegister() {
		return "ShipmentRegPage";
	}
	@RequestMapping(value = "/save", method=POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType,
									Model model) {
		Integer id=ser.saveShipmentType(shipmentType);
		String msg="ShipmentType of id "+id+" Saved";
		model.addAttribute("msg",msg);
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
}
