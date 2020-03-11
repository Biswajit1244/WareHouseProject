package com.biss.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.biss.model.UomType;

public class UomTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//change file name
		response.addHeader("Content-Disposition", "attachment;filename=Uom.xlsx");
		Sheet s=workbook.createSheet("UOM");
		//construct row(0)
		setHead(s);
		//read model Data
		@SuppressWarnings("unchecked")
		List<UomType> list=(List<UomType>) model.get("list");
		setBody(list,s);
	}


	private void setHead(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("MODEL");
		r.createCell(3).setCellValue("DESCRIPTION");
	}
	private void setBody(List<UomType> list, Sheet s) {
		int count=1;
		for(UomType um:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(um.getUomId());
			r.createCell(1).setCellValue(um.getUomTp());
			r.createCell(2).setCellValue(um.getUomModel());
			r.createCell(3).setCellValue(um.getUomDesc());
		}
	}

}
