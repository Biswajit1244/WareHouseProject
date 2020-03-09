package com.biss.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biss.excel.PartExcelView;
import com.biss.excel.PartPdfView;
import com.biss.model.Part;
import com.biss.service.IOrderMethodService;
import com.biss.service.IPartService;
import com.biss.service.IUomTypeService;
import com.biss.utils.CommonUtil;

@Controller
@RequestMapping("/part")
public class PartController {
	@Autowired
	private IPartService ser;
	@Autowired
	private IUomTypeService uomSer;
	@Autowired
	private IOrderMethodService omSer;
	
    //commons ui code 
	private void commonsUi(Model model) {
		List<Object[]> uomList=uomSer.getUomIdAndUomModel();
		Map<Integer,String> uomMap=CommonUtil.convert(uomList);
		model.addAttribute("uomMap",uomMap);
		
		//orderMethod sale
		List<Object[]> omSaleList=omSer.getOmIdAndOmCode("Sale");
		Map<Integer,String> omSaleMap=CommonUtil.convert(omSaleList);
		model.addAttribute("omSaleMap",omSaleMap);
		
		//orderMethod purchase
		List<Object[]> omPurList=omSer.getOmIdAndOmCode("Purchase");
		Map<Integer,String> omPurMap=CommonUtil.convert(omPurList);
		model.addAttribute("omPurMap",omPurMap);
		}
	//1.Show Reg page
		@RequestMapping("/register")
		public String showRegPage(Model model) {
			model.addAttribute("part",new Part());
			commonsUi(model);
		return "PartRegPage";
		}
		//2.on click save Operation
		@RequestMapping(value = "/save",method =POST)
		public String saveOnePart(@ModelAttribute Part part,Model m) {
			Integer id=ser.savePart(part);
			String msg="Part "+id+" Saved";
			m.addAttribute("msg",msg);
			m.addAttribute("part",new Part());
			commonsUi(m);
		return "PartRegPage";
		}
		//3.show all data
		@RequestMapping("/all")
		public String getAllPart(Model model) {
			List<Part> list=ser.getAllPart();
			model.addAttribute("list",list);
		return "PartData";
		}
		//4.delete one order
		@RequestMapping("/delete")
		public String deletePart(@RequestParam("pid")Integer id,Model m) {
			ser.deletePart(id);
			String msg="Part "+id+" Deleted";
			m.addAttribute("msg", msg);
			
			List<Part> list=ser.getAllPart();
			m.addAttribute("list",list);
		return "PartData";
		}
		//5.show edit page
		@RequestMapping("/edit")
		public String showEditPage(@RequestParam("pid")Integer id,Model m) {
			Part Part=ser.getOnePart(id);
			m.addAttribute("part",Part);
			commonsUi(m);
			return "PartEditPage";
		}
		//6.on click update operation
		@RequestMapping(value="/update" ,method=POST)
		public String updatePart(@ModelAttribute Part part,Model m) {
			ser.updatePart(part);
			String msg="Part "+part.getPartId()+" Updated";
			m.addAttribute("msg",msg);
			
			List<Part> list=ser.getAllPart();
			m.addAttribute("list",list);
			return "PartData";
		}
		//7.view one Order
		@RequestMapping("/view")
		public String showViewPage(@RequestParam("pid")Integer id,Model m) {
			Part om=ser.getOnePart(id);
			m.addAttribute("ob",om);
			return "PartView";
		}
		//Excel Export
		@RequestMapping("/excel")
		public ModelAndView showExcel(@RequestParam(value="pid",required = false)Integer id) {
			ModelAndView mv=new ModelAndView();
			mv.setView(new PartExcelView());
			if(id==null) {
			//fetching all data 
			List<Part> list=ser.getAllPart();
			mv.addObject("list",list);
			}else {
				//fetch one data
			Part om=ser.getOnePart(id);
			mv.addObject("list",Arrays.asList(om));
			}
			return mv;
		}
		//Pdf Export
		@RequestMapping("/pdf")
		public ModelAndView showPDf(@RequestParam(value="pid",required = false)Integer id) {
			ModelAndView mv=new ModelAndView();
			mv.setView(new PartPdfView());
			if(id==null) {
			//fetching all data 
			List<Part> list=ser.getAllPart();
			mv.addObject("list",list);
			}else {
				//fetch one data
			Part om=ser.getOnePart(id);
			mv.addObject("list",Arrays.asList(om));
			}
			return mv;
		}
}
