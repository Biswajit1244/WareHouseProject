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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biss.excel.PurchaseExcelView;
import com.biss.excel.PurchasePdfView;
import com.biss.excel.VendorPdfViews;
import com.biss.model.Purchase;
import com.biss.model.PurchaseDtls;
import com.biss.service.IPartService;
import com.biss.service.IPurchaseService;
import com.biss.service.IShipmentTypeService;
import com.biss.service.IWhUserTypeService;
import com.biss.utils.CommonUtil;
@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private IPurchaseService ser;

	@Autowired
	private IPartService partSer;
	@Autowired
	private IShipmentTypeService shipSer;
	@Autowired
	private IWhUserTypeService whUserSer;

	//Common UI code
	private void commonUi(Model m) {
		List<Object[]> shipList=shipSer.getShipmentIdAndCode();
		Map<Integer,String> shipMap=CommonUtil.convert(shipList);
		m.addAttribute("shipMap",shipMap);

		List<Object[]> whUserList=whUserSer.getWhUserIdAndCode("Vendor");
		Map<Integer,String> whUserMap=CommonUtil.convert(whUserList);
		m.addAttribute("whUserMap",whUserMap);
	}

	//1.Show Reg page
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("purchase",new Purchase());
		commonUi(model);
		return "PurchaseRegPage";
	}
	//2.on click save Operation
	@RequestMapping(value = "/save",method =POST)
	public String saveOnePurchase(@ModelAttribute Purchase purchase,Model m) {
		Integer id=ser.savePurchase(purchase);
		String msg="Purchase "+id+" Saved";
		m.addAttribute("msg",msg);
		m.addAttribute("purchase",new Purchase());
		commonUi(m);
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
		commonUi(m);
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
		return "PurchaseViewPage";
	}
	//Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="pid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new PurchaseExcelView());
		if(id==null) {
			//fetching all data 
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
	public ModelAndView showPDf(@RequestParam(value="pid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new PurchasePdfView());
		if(id==null) {
			//fetching all data 
			List<Purchase> list=ser.getAllPurchase();
			mv.addObject("list",list);
		}else {
			//fetch one data
			Purchase	om=ser.getOnePurchase(id);
			mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
	//*********For Screen Two***********//
	@RequestMapping("/parts")
	public String showPart(@RequestParam("pid")Integer poId,
			Model model) {
		//add Purchase Details
		Purchase po =ser.getOnePurchase(poId);
		model.addAttribute("parent",po);

		//send form backing object
		model.addAttribute("purchaseDtls",new PurchaseDtls());

		//dropdown data
		List<Object[]> partCode=partSer.getPartIdAndCode();
		Map<Integer,String> partMap=CommonUtil.convert(partCode);
		model.addAttribute("partMap",partMap);

		//Display all Parts which are added for this PO
		List<PurchaseDtls> childs=po.getChilds();
		int i=1; //slno setting
		for(PurchaseDtls dtl:childs) {
			dtl.setSlNo(i++);
		}
		model.addAttribute("childs", childs);


		return "PurchaseParts";
	}
	@RequestMapping(value = "/addPart",method = RequestMethod.POST)
	public String addPart(@ModelAttribute PurchaseDtls purchaseDtls) {
			ser.savePurchaseDtls(purchaseDtls);
			Integer poId=purchaseDtls.getPur().getPurId();
			//TODO: PO Status change
			ser.updatePurchaseStatus(poId, "PICKING");
			return "redirect:parts?pid="+poId;
	}
	@RequestMapping("/removePart")
	public String removeParts(
			@RequestParam("dtlId")Integer dtlId,
			@RequestParam("poId")Integer poId
			) {
		ser.deletePurchaseDtls(dtlId);
		if(ser.getOnePurchase(poId).getChilds().isEmpty()) {
			ser.updatePurchaseStatus(poId, "OPEN");
		}
		return "redirect:parts?pid="+poId;
	}
	@RequestMapping("/placeOrder")
	public String placeOrderConfirm(
			@RequestParam("poId")Integer poId
			) 
	{
		ser.updatePurchaseStatus(poId, "ORDERED");
		return "redirect:parts?pid="+poId;
	}
	
	@RequestMapping("/invoceOrder")
	public String placeOrderForInvoice(
			@RequestParam("poId")Integer poId
			) 
	{
		ser.updatePurchaseStatus(poId, "INVOICED");
		return "redirect:all";
	}
	//------------Generate PDF--------------
		@RequestMapping("/downloadInvoce")
		public ModelAndView downloadInvoiceAsPdf(
				@RequestParam("poId")Integer id
				)
		{
			Purchase po=ser.getOnePurchase(id);
			ModelAndView m=new ModelAndView();
			m.setView(new VendorPdfViews());
			m.addObject("po", po);
			return m;
		}
}
