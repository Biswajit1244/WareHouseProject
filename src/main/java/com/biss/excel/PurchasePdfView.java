package com.biss.excel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.biss.model.Purchase;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PurchasePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download file
		response.addHeader("Content-Disposition", "attachment;filename=Purchase.pdf");
		//create element
		Paragraph p=new Paragraph("PURCHASE DATA:-\n");
		//add element to document
		document.add(p);
		//read data from list
		@SuppressWarnings("unchecked")
		List<Purchase> list=(List<Purchase>) model.get("list");
		//creating table element add no of column
		PdfPTable t=new PdfPTable(8);
		t.addCell("OREDE ID"); t.addCell("ORDER CODE");
		t.addCell("REF NUMBER"); t.addCell("QTY CHECK");
		t.addCell("DEFAULT STATUS"); t.addCell("SHIPMENT CODE");
		t.addCell("VENDOR"); t.addCell("DESCRIPTION");
		for(Purchase om:list) {
			t.addCell(om.getPurId().toString());
			t.addCell(om.getPurCode());
			t.addCell(om.getPurRefNum());
			t.addCell(om.getPurQtChck());
			t.addCell(om.getPurDfltSts());
			t.addCell(om.getShipOb().getShipCode());
			t.addCell(om.getWhUserOb().getWhUserCode());
			t.addCell(om.getPurDesc());
		}
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
	}

}

