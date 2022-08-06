package com.app.web.controlador;

import com.app.web.servicio.CarrosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import com.app.web.entidad.Carros;
import com.app.web.excel.ExcelExporter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.app.web.excel.PdfExporter;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.lowagie.text.DocumentException;


@Controller
public class CarrosControlador {

    @Autowired
    private CarrosServicio servicio;

        @GetMapping({ "/carros", "/" })
        public String listarCarros(Model modelo) {
            modelo.addAttribute("carros", servicio.listarTodosLosCarros());
            return "carros";
        }

        @GetMapping("/carros/nuevo")
        public String registrarCarro(Model modelo) {
            Carros carro = new Carros();
            modelo.addAttribute("carro", carro);
            return "crear_carro";
        }
        @PostMapping("/carros")
        public String guardarCarro(@ModelAttribute("Carro") Carros Carro) {
            servicio.guardarCarro(Carro);
            return "redirect:/carros";
        }
        @GetMapping("/carros/editar/{id}")
        public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
            modelo.addAttribute("carro", servicio.obtenerCarroId(id));
            return "editar_carro";
        }

        @PostMapping("/carros/{id}")
        public String actualizarCarro(@PathVariable Long id, @ModelAttribute("carro") Carros Carro,Model modelo) {
            Carros carrosExistente = servicio.obtenerCarroId(id);
            carrosExistente.setId(id);
            carrosExistente.setModelo(Carro.getModelo());
            carrosExistente.setMarca(Carro.getMarca());
            carrosExistente.setDescripcion(Carro.getDescripcion());
            carrosExistente.setNumero_de_Chasis(Carro.getNumero_de_Chasis());
            carrosExistente.setNumero_de_Placa(Carro.getNumero_de_Placa());
            carrosExistente.setTipo_Combustible(Carro.getTipo_Combustible());
            carrosExistente.setTipo_de_vehiculo(Carro.getTipo_de_vehiculo());

            servicio.actualizarCarro(carrosExistente);
            return "redirect:/carros";
        }

        @GetMapping("/carros/{id}")
        public String eliminarCarro(@PathVariable Long id) {
            servicio.eliminarCarro(id);
            return "redirect:/carros";
        }

    @GetMapping("/carros/export/excel")
    public void exportToExcel(HttpServletResponse response) throws  IOException{
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter= new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime= dateFormatter.format(new Date());

        String headerKey= "Content-Disposition";
        String headerValue= "attachment; filename=Carros" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Carros> listCarro= servicio.listarTodosLosCarros();
        ExcelExporter excelExporter= new ExcelExporter(listCarro);
        excelExporter.export(response);
    }

    @GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Carros> listaCarros = servicio.listarTodosLosCarros();

        PdfExporter exporter = new PdfExporter(listaCarros);
        exporter.export(response);

    }
}