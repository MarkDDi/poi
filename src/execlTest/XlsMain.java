package execlTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class XlsMain {

	public static void main(String[] args) throws IOException {
		XlsMain xlsMain = new XlsMain();
		
//		XlsDto xls = null;
		List<XlsDto> list = xlsMain.readXls();
		System.out.println(list);
		
	}
	
	private List<XlsDto> readXls() throws IOException{
		InputStream in = new FileInputStream("test.xlsx");
		HSSFWorkbook hssfworkbook = new HSSFWorkbook(in);
		XlsDto xlsDto = null;
		List<XlsDto> list = new ArrayList<XlsDto>();
		// ѭ��������Sheet
		for(int num=0;num < hssfworkbook.getNumberOfSheets(); num++){
			// �õ� ������ �ĵ� N����  
			HSSFSheet sheetAt = hssfworkbook.getSheetAt(num);
			if(sheetAt == null){
				continue;
			}
			for(int rowNum=1; rowNum <= sheetAt.getLastRowNum(); rowNum++){
				HSSFRow row = sheetAt.getRow(rowNum); 
				if(row == null){
					continue;
				}
				xlsDto = new XlsDto();
				HSSFCell cell = row.getCell(0);
				if(cell == null){
					continue;
				}
				xlsDto.setXh(getValue(cell));
				list.add(xlsDto);
			}
			
		}
		
		
		
		return list;
	}
	
	/**
	 * 
	 * �õ�excel���е�ֵ
	 *
	 * @param cell
	 * @return
	 * 
	 * @author yutao
	 * @date 2016��5��16�� ����3:51:26
	 */
	private String getValue(HSSFCell cell){
		if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){
			return String.valueOf(cell.getBooleanCellValue());
		}else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
			return String.valueOf(cell.getNumericCellValue());
		}else{
			return cell.getStringCellValue();
		}
		
	}
}
