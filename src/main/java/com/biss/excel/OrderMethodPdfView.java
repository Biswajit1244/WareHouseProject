package com.biss.excel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.biss.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			//download file
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.pdf");
		//create element
		Paragraph p=new Paragraph("ORDER TYPE DATA");
		//add element to document
		document.add(p);
		//read data from list
		List<OrderMethod> list=(List<OrderMethod>) model.get("list");
		//creating table element add no of column
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID"); t.addCell("MODE");
		t.addCell("CODE"); t.addCell("ORDER TYPE");
		t.addCell("ACCEPT TYPE"); t.addCell("DESCRIPTION");
		for(OrderMethod om:list) {
			t.addCell(om.getOrderId().toString());
			t.addCell(om.getOrderMode());
			t.addCell(om.getOrderCode());
			t.addCell(om.getOrderType());
			t.addCell(om.getOrderAcpt().toString());
			t.addCell(om.getDecription());
		}
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
	}

}
