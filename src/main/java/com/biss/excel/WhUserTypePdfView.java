package com.biss.excel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.biss.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download file
				response.addHeader("Content-Disposition", "attachment;filename=WhUser.pdf");
				//create element
				Paragraph p=new Paragraph("WHUSER DATA:-");
				//add element to document
				document.add(p);
				//read data from list
				@SuppressWarnings("unchecked")
				List<WhUserType> list=(List<WhUserType>) model.get("list");
				//creating table element add no of column
				PdfPTable t=new PdfPTable(9);
				t.addCell("ID"); t.addCell("TYPE");
				t.addCell("CODE"); t.addCell("USER FOR");
				t.addCell("EMAIL"); t.addCell("CONTACT");
				t.addCell("ID TYPE");t.addCell("OTHER ID TYPE");
				t.addCell("ID NUMBER");
				for(WhUserType om:list) {
					t.addCell(om.getUserId().toString());
					t.addCell(om.getWhUserType());
					t.addCell(om.getWhUserCode());
					t.addCell(om.getWhUserFor());
					t.addCell(om.getWhUserEmail());
					t.addCell(om.getWhUserCont());
					t.addCell(om.getWhUserIdType());
					t.addCell(om.getWhUserIdOther());
					t.addCell(om.getWhUserIdNum());
				}
				document.add(t);
				//print date and time
				document.add(new Paragraph(new Date().toString()));
	}

}
