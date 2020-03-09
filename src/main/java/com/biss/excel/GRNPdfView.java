package com.biss.excel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.biss.model.GRN;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class GRNPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download file
		response.addHeader("Content-Disposition", "attachment;filename=GRN.pdf");
		//create element
		Paragraph p=new Paragraph("GRN DATA");
		//add element to document
		document.add(p);
		//read data from list
		@SuppressWarnings("unchecked")
		List<GRN> list=(List<GRN>) model.get("list");
		//creating table element add no of column
		PdfPTable t=new PdfPTable(4);
		t.addCell("ID");
		t.addCell("CODE"); t.addCell("TYPE");
	    t.addCell("DESCRIPTION");
		for(GRN om:list) {
			t.addCell(om.getGrnId().toString());
			t.addCell(om.getGrnCode());
			t.addCell(om.getGrnType());
			t.addCell(om.getGrnDesc());
		}
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
	}


}
