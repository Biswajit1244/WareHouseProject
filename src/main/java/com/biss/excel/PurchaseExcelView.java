package com.biss.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.biss.model.Purchase;

public class PurchaseExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//change file name
				response.addHeader("Content-Disposition", "attachment;filename=Purchase.xlsx");
				Sheet s=workbook.createSheet("Purchase");
				//construct row(0)
				setHead(s);
				//read model Data
				@SuppressWarnings("unchecked")
				List<Purchase> list=(List<Purchase>) model.get("list");
				setBody(list,s);
			}


			private void setHead(Sheet s) {
				Row r=s.createRow(0);
				r.createCell(0).setCellValue("OREDE ID");
				r.createCell(1).setCellValue("ORDER CODE");
				r.createCell(2).setCellValue("REF NUMBER");
				r.createCell(3).setCellValue("QTY CHECK");
				r.createCell(4).setCellValue("DEFAULT STATUS");
				r.createCell(5).setCellValue("DESCRIPTION");
			}
			private void setBody(List<Purchase> list, Sheet s) {
				int count=1;
				for(Purchase om:list) {
					Row r=s.createRow(count++);
					r.createCell(0).setCellValue(om.getPurId());
					r.createCell(1).setCellValue(om.getPurCode());
					r.createCell(2).setCellValue(om.getPurRefNum());
					r.createCell(3).setCellValue(om.getPurQtChck());
					r.createCell(4).setCellValue(om.getPurDfltSts());
					r.createCell(5).setCellValue(om.getPurDesc());
				}
			}


}
