package com.biss.excel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.biss.model.Purchase;
import com.biss.model.PurchaseDtls;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfViews extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download File
				response.addHeader("Content-Disposition", "attachment;filename=VendorInvoice.pdf");

				//read Purchase Order
				Purchase po=(Purchase) model.get("po");
				//read all childs
				List<PurchaseDtls> parts=po.getChilds();
				
				//final cost calculation
				double finalCost=0.0;
				for(PurchaseDtls dtl:parts) {
					finalCost=finalCost+(dtl.getPart().getPartBCost()*dtl.getQty());
				}
				//--ends here--

				PdfPTable header=new PdfPTable(4);
				header.addCell("VENDOR CODE");	header.addCell(po.getWhUserOb().getWhUserCode());
				header.addCell("PO ORDER CODE");header.addCell(po.getPurCode());
				
				header.addCell("FINAL COST");	header.addCell(Double.toString(finalCost));
				header.addCell("SHIPMENT CODE");header.addCell(po.getShipOb().getShipCode());
				
				document.add(header);

				PdfPTable partsTable=new PdfPTable(4);
				partsTable.addCell("PART CODE");
				partsTable.addCell("BASE COST");
				partsTable.addCell("QUANTITY");
				partsTable.addCell("LINE TOTAL");


				for(PurchaseDtls dtl:parts) {
					partsTable.addCell(dtl.getPart().getPartCode());
					partsTable.addCell(dtl.getPart().getPartBCost().toString());
					partsTable.addCell(dtl.getQty().toString());
					partsTable.addCell(Double.toString(
							dtl.getPart().getPartBCost()*dtl.getQty()
							));
				}
				document.add(new Paragraph("--PARTS TABLE--"));
				document.add(partsTable);
				document.add(new Paragraph(new Date().toString()));
			}
}
