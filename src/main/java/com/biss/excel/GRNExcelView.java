package com.biss.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.biss.model.GRN;

public class GRNExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			//change file name
			response.addHeader("Content-Disposition", "attachment;filename=GRN.xlsx");
			Sheet s=workbook.createSheet("GRN");
			//construct row(0)
			setHead(s);
			//read model Data
			@SuppressWarnings("unchecked")
			List<GRN> list=(List<GRN>) model.get("list");
			setBody(list,s);
		}


		private void setHead(Sheet s) {
			Row r=s.createRow(0);
			r.createCell(0).setCellValue("ID");
			r.createCell(1).setCellValue("CODE");
			r.createCell(2).setCellValue("TYPE");
			r.createCell(4).setCellValue("DESCRIPTION");
		}
		private void setBody(List<GRN> list, Sheet s) {
			int count=1;
			for(GRN om:list) {
				Row r=s.createRow(count++);
				r.createCell(0).setCellValue(om.getGrnId());
				r.createCell(1).setCellValue(om.getGrnCode());
				r.createCell(2).setCellValue(om.getGrnType());
				r.createCell(3).setCellValue(om.getGrnDesc());
			}
		}

}
