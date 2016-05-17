package execlTest.jiandan;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSReader {
	
	
	public static List readExcelData(String url) throws IOException{
		//������һ��������
		FileInputStream fis = new FileInputStream(url);
		List hospitaList = new ArrayList();
		Workbook workbook = null;
		//xlsx ��2007���ϰ汾��xlx��2003�汾
 		if(url.toLowerCase().endsWith("xlsx")){
			workbook = new XSSFWorkbook(fis);
		}else if(url.toLowerCase().endsWith("xlx")){
			workbook = new HSSFWorkbook(fis);
		}
		//�õ�sheet������
		int numberOfSheets = workbook.getNumberOfSheets();
		//ȥѭ��numberOfSheets
		for(int sheetNum = 0; sheetNum < numberOfSheets; sheetNum++){
			// �õ� ������ �ĵ� N����  
			Sheet sheetAt = workbook.getSheetAt(sheetNum);
			Row row;
			String cell;
			// ���� ���еļ�¼�����ж�����¼��
			for(int i = sheetAt.getFirstRowNum();i<sheetAt.getPhysicalNumberOfRows();i++){
				//ѭ������
				row = sheetAt.getRow(i);
				//����ÿ����¼��ֵ����excel�У�ÿһ�еļ�¼���ж��ֵ������Ҳ��Ҫ���б�����
				for(int j = row.getFirstCellNum(); j<row.getPhysicalNumberOfCells();j++){
					//ѭ������
					cell = row.getCell(j).toString();
					hospitaList.add(cell);
				}
			}
		}
		return hospitaList;
	}

	public static void main(String[] args) throws IOException {
		List list = readExcelData("C:/Users/yutao/Desktop/test.xlsx");
		System.out.println(list);
	}

}
