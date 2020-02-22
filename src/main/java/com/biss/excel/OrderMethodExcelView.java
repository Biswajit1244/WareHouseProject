package com.biss.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.biss.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//change file name
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.xlsx");
		Sheet s=workbook.createSheet("OrderMethod");
		//construct row(0)
		setHead(s);
		//read model Data
		List<OrderMethod> list=(List<OrderMethod>) model.get("list");
		setBody(list,s);
	}


	private void setHead(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("MODE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("TYPE");
		r.createCell(4).setCellValue("ACCEPT");
		r.createCell(5).setCellValue("DESCRIPTION");
	}
	private void setBody(List<OrderMethod> list, Sheet s) {
		int count=1;
		for(OrderMethod om:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(om.getOrderId());
			r.createCell(1).setCellValue(om.getOrderMode());
			r.createCell(2).setCellValue(om.getOrderCode());
			r.createCell(3).setCellValue(om.getOrderType());
			r.createCell(4).setCellValue(om.getOrderAcpt().toString());
			r.createCell(5).setCellValue(om.getDecription());
		}
	}

}
