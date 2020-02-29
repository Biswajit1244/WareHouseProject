package com.biss.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.biss.model.Sale;

public class SaleExcelView extends AbstractXlsxView{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//change file name
				response.addHeader("Content-Disposition", "attachment;filename=Sale.xlsx");
				Sheet s=workbook.createSheet("Sale");
				//construct row(0)
				setHead(s);
				//read model Data
				@SuppressWarnings("unchecked")
				List<Sale> list=(List<Sale>) model.get("list");
				setBody(list,s);
			}


			private void setHead(Sheet s) {
				Row r=s.createRow(0);
				r.createCell(0).setCellValue("ID");
				r.createCell(1).setCellValue("CODE");
				r.createCell(2).setCellValue("REF NUM");
				r.createCell(3).setCellValue("STOCK MODE");
				r.createCell(4).setCellValue("STOCK SOURCE");
				r.createCell(5).setCellValue("DEFAULT STATUS");
				r.createCell(6).setCellValue("DESCRIPTION");
			}
			private void setBody(List<Sale> list, Sheet s) {
				int count=1;
				for(Sale om:list) {
					Row r=s.createRow(count++);
					r.createCell(0).setCellValue(om.getSaleId());
					r.createCell(1).setCellValue(om.getSaleOrderCode());
					r.createCell(2).setCellValue(om.getSaleRefNo());
					r.createCell(3).setCellValue(om.getSaleStkMode());
					r.createCell(4).setCellValue(om.getSaleStkSource());
					r.createCell(5).setCellValue(om.getSaleDfltSts());
					r.createCell(6).setCellValue(om.getSaleDes());
				}
			}

}
