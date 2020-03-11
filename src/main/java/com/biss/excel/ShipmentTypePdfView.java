package com.biss.excel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.biss.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download file
		response.addHeader("Content-Disposition", "attachment;filename=Shipment.pdf");
		//create element
		Paragraph p=new Paragraph("SHIPMENT DATA");
		//add element to document
		document.add(p);
		//read data from list
		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		//creating table element add no of column
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID"); t.addCell("MODE");
		t.addCell("CODE"); t.addCell("ENABLE");
		t.addCell("GRADE"); t.addCell("DESCRIPTION");
		for(ShipmentType om:list) {
			t.addCell(om.getShipId().toString());
			t.addCell(om.getShipMode());
			t.addCell(om.getShipCode());
			t.addCell(om.getEnbShip());
			t.addCell(om.getShipGrad());
			t.addCell(om.getShipDesc());
		}
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
	}

}
