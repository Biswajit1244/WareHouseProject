package com.biss.excel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.biss.model.UomType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download file
				response.addHeader("Content-Disposition", "attachment;filename=UomType.pdf");
				//create element
				Paragraph p=new Paragraph("UOMTYPE DATA");
				//add element to document
				document.add(p);
				//read data from list
				@SuppressWarnings("unchecked")
				List<UomType> list=(List<UomType>) model.get("list");
				//creating table element add no of column
				PdfPTable t=new PdfPTable(4);
				t.addCell("ID"); t.addCell("TYPE");
				t.addCell("MODEL"); 
				t.addCell("DESCRIPTION");
				for(UomType om:list) {
					t.addCell(om.getUomId().toString());
					t.addCell(om.getUomTp());
					t.addCell(om.getUomModel());
					t.addCell(om.getUomDesc());
				}
				document.add(t);
				//print date and time
				document.add(new Paragraph(new Date().toString()));
	}

}
