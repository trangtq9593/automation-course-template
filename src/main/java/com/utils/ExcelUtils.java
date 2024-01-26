package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils  {
    private static XSSFWorkbook wb;
    private static XSSFSheet sh;
    private static File f;
    private static FileInputStream stream;

    public ExcelUtils (String excelFilePath, String excelFileName) {

        try {
            
            f = new File(excelFilePath);
            stream = new FileInputStream(f);
            wb = new XSSFWorkbook(stream);
            sh = wb.getSheetAt(0);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    public String getData (int row, int column) {
        Cell cell = sh.getRow(row).getCell(column);
        return cell.getStringCellValue();
    }

    public int getRowCount() {
        return sh.getPhysicalNumberOfRows();
    }

    public int getRowByTCID(String TCID) {
        for (int i = 1; i <= getRowCount(); i++) {
            Cell cell = sh.getRow(i).getCell(0);
           if (cell.getStringCellValue().equals(TCID)) {
            return cell.getRowIndex();
           }
        }
        return 0;
    }

    public void setCellData(String result, String TCID, int column) {
        int row = getRowByTCID(TCID);
        Cell cell = sh.getRow(row).getCell(column);
        if (cell == null) {
            cell = sh.getRow(row).createCell(column);
        }
        cell.setCellValue(result);
    }

    
    public void saveNewFile(String excelFilePath, String excelFileName) throws Exception {
        
        String fileNameWithoutExt = FilenameUtils.removeExtension(excelFileName);
        String exportFilePath = excelFilePath + fileNameWithoutExt + "_export.xlsx";

        FileOutputStream file_out = new FileOutputStream(exportFilePath);
        wb.write(file_out);
        file_out.flush();
        file_out.close();
    }

}
