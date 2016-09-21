package execlTest.jiandan;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSQWriter {

	public static void main(String[] args) throws IOException {
		//����������
		XSSFWorkbook workbook = new XSSFWorkbook();
		//�ڹ������д���һ������
		XSSFSheet sheet = workbook.createSheet("��1");
		//workbook.setSheetName(0, "sheet1"); ��仰Ҫ�ȴ�����sheet��������
		//��ָ��������������һ��
		XSSFRow row = sheet.createRow(2);
		// ��ָ��������������һ�У���Ԫ��
		XSSFCell cell = row.createCell(1);
		// ���嵥Ԫ��Ϊ�ַ������� 
		cell.setCellType(XSSFCell.CELL_TYPE_STRING);
		// �ڵ�Ԫ���������� 
		XSSFRichTextString cellContent = new XSSFRichTextString("ҽԺ���");
		cell.setCellValue(cellContent);
		//��Ȼ������Ԫ��
		XSSFCell city = row.createCell(2);
		city.setCellType(Cell.CELL_TYPE_STRING);
		XSSFRichTextString cityContent = new XSSFRichTextString("����");
		city.setCellValue(cityContent);
		OutputStream fos = new FileOutputStream("C:/Users/yutao/Desktop/test3.xlsx");
		workbook.write(fos);
		fos.flush();
		System.out.println("�ļ�����");
		
		
	}

}
