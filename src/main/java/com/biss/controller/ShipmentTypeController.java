package com.biss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
}