package com.cfprac.service;

import com.cfprac.client.SourceClient;
import com.cfprac.dto.ReconResultDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class FileService {

    private final SourceClient sourceClient;

    public FileService(SourceClient sourceClient) {
        this.sourceClient = sourceClient;
    }

    public File getReconResultsInExcel() throws IOException {

        try{
            List<ReconResultDto> results = sourceClient.fetchReconResult();

            List<String> headers = Arrays.asList("Business Date","Account","Source1 Qty","Source2 Qty","Status","Break Explanation");

            XSSFWorkbook wb = new XSSFWorkbook();

            XSSFSheet sheet = wb.createSheet("Breaks");

            Row row = sheet.createRow(0);

            int colNum = 0;

            for(String header: headers){
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(header);
            }

            int rowNum = 1;
            colNum = 0;
            int i = 0;

            for(ReconResultDto result: results){

                Row bodyRow = sheet.createRow(rowNum++);

                Cell businessDateCell = bodyRow.createCell(colNum++);
                Cell accountCell = bodyRow.createCell(colNum++);
                Cell source1QtyCell = bodyRow.createCell(colNum++);
                Cell source2QtyCell = bodyRow.createCell(colNum++);
                Cell statusCell = bodyRow.createCell(colNum++);
                Cell breakExplanationCell = bodyRow.createCell(colNum++);

                businessDateCell.setCellValue(result.getBusinessDate().toString()!=null ? result.getBusinessDate().toString() : null);
                accountCell.setCellValue(result.getAccount()!=null ? result.getAccount() : null );
                source1QtyCell.setCellValue(result.getSource1Qty()!=null ? result.getSource1Qty() : null);
                source2QtyCell.setCellValue(result.getSource2Qty()!=null ? result.getSource2Qty() : null);
                statusCell.setCellValue(result.getStatus()!=null ? result.getStatus() : null);
                breakExplanationCell.setCellValue(result.getBreakExplanation()!=null ? result.getBreakExplanation() : null);

                colNum=0;

            }

            String fileName ="Recon_Breaks.xlsx";
            File excelFile = new File(System.getProperty("java.io.tmpdir"), fileName);
            FileOutputStream outputStream = new FileOutputStream(excelFile);
            wb.write(outputStream);
            wb.close();
            return excelFile;

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }

}
