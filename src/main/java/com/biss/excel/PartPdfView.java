package com.biss.excel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.biss.model.Part;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PartPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download file
		response.addHeader("Content-Disposition", "attachment;filename=Part.pdf");
		//create element
		Paragraph p=new Paragraph("PART TYPE DATA");
		//add element to document
		document.add(p);
		//read data from list
		@SuppressWarnings("unchecked")
		List<Part> list=(List<Part>) model.get("list");
		//creating table element add no of column
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID"); t.addCell("WIDTH");
		t.addCell("LENGTH"); t.addCell("HEIGHT");
		t.addCell("CURRENCY"); t.addCell("DESCRIPTION");
		for(Part om:list) {
			t.addCell(om.getPartId().toString());
			t.addCell(om.getPartWidth().toString());
			t.addCell(om.getPartLength().toString());
			t.addCell(om.getPartHeight().toString());
			t.addCell(om.getPartCurrency());
			t.addCell(om.getPartDesc());
		}
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
		
	}
}