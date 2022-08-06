package com.app.web.excel;


        import java.awt.Color;
        import java.io.IOException;
        import java.util.List;

        import javax.servlet.http.HttpServletResponse;
        import com.app.web.entidad.Carros;
        import com.lowagie.text.*;
        import com.lowagie.text.pdf.*;


public class PdfExporter {
    private List<Carros> listaCarros;

    public PdfExporter(List<Carros> listaCarros) {
        this.listaCarros = listaCarros;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Marca", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Modelo", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Descripción", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Tipo de combustible", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Número de chasis", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Número de placa", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Tipo de vehículo", font));
        table.addCell(cell);
    }
    private void writeTableData(PdfPTable table) {
        for (Carros carros : listaCarros) {
            table.addCell(carros.getMarca());
            table.addCell(carros.getModelo());
            table.addCell(carros.getDescripcion());
            table.addCell(carros.getNumero_de_Chasis());
            table.addCell(carros.getTipo_Combustible());
            table.addCell(carros.getNumero_de_Placa());
            table.addCell(carros.getTipo_de_vehiculo());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Lista de carros", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}