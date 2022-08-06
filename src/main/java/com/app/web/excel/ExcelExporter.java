
package com.app.web.excel;

import com.app.web.entidad.Carros;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.apache.poi.ss.util.CellUtil.createCell;

public class ExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Carros> listCarro;

    public ExcelExporter(List<Carros> listCarro){
        this.listCarro= listCarro;
        workbook= new XSSFWorkbook();
    }
    private void writeHeaderLine(){
        sheet= workbook.createSheet("Carross");

        Row row= sheet.createRow(0);

        CellStyle style= workbook.createCellStyle();
        XSSFFont font= workbook.createFont();
        font.setBold(true);
        font.setFontHeight(18);
        style.setFont(font);

        createCell (row,0, "Marca", style);
        createCell (row,1, "Modelo", style);
        createCell (row, 2, "Descripción", style);
        createCell(row, 3, "Tipo de combustible", style);
        createCell(row, 4, "Número de chasis", style);
        createCell(row, 5, "Número de placa", style);
        createCell(row, 6, "Tipo de vehículo", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell= row.createCell(columnCount);
        if(value instanceof  Integer){
            cell.setCellValue((Integer) value);
        }
        else if(value instanceof  Boolean){
            cell.setCellValue((Boolean) value);
        }
        else{
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    private void writeDataLines(){
        int rowCount= 1;

        CellStyle style= workbook.createCellStyle();
        XSSFFont font= workbook.createFont();
        font.setFontHeight(16);
        style.setFont(font);

        for(Carros Carro: listCarro){
            Row row= sheet.createRow(rowCount++);
            int columnCount=0;

            createCell(row, columnCount++, Carro.getMarca(), style);
            createCell(row, columnCount++, Carro.getModelo(), style);
            createCell(row, columnCount++, Carro.getDescripcion(), style);
            createCell(row, columnCount++, Carro.getTipo_Combustible(), style);
            createCell(row, columnCount++, Carro.getNumero_de_Chasis(), style);
            createCell(row, columnCount++, Carro.getNumero_de_Placa(), style);
            createCell(row, columnCount++, Carro.getTipo_de_vehiculo(), style);

        }
    }

    public void export(HttpServletResponse response)  throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream= response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }

}
