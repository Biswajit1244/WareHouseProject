package com.biss.excel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.biss.model.Sale;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class SalePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download file
		response.addHeader("Content-Disposition", "attachment;filename=Sale.pdf");
		//create element
		Paragraph p=new Paragraph("SALE ORDER DATA:-");
		//add element to document
		document.add(p);
		//read data from list
		@SuppressWarnings("unchecked")
		List<Sale> list=(List<Sale>) model.get("list");
		//creating table element add no of column
		PdfPTable t=new PdfPTable(7);
		t.addCell("ID"); t.addCell("CODE");
		t.addCell("REF NUM"); t.addCell("STOCK MODE");
		t.addCell("STOCK SOURCE"); t.addCell("DEFAULT STATUS");
		t.addCell("DESCRIPTION");
		for(Sale om:list) {
			t.addCell(om.getSaleId().toString());
			t.addCell(om.getSaleOrderCode());
			t.addCell(om.getSaleRefNo());
			t.addCell(om.getSaleStkMode());
			t.addCell(om.getSaleStkSource());
			t.addCell(om.getSaleDfltSts());
			t.addCell(om.getSaleDes());
		}
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
	}
}


