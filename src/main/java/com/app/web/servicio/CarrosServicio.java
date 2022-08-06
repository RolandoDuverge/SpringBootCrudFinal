package com.app.web.servicio;

import java.util.List;
import com.app.web.entidad.Carros;

public interface CarrosServicio {

    public List<Carros> listarTodosLosCarros();

    public Carros guardarCarro(Carros Carro);

    public Carros obtenerCarroId(Long id);

    public Carros actualizarCarro(Carros Carro);

    public void eliminarCarro(Long id);

}
