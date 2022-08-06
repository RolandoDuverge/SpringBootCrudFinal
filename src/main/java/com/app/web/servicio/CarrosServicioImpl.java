package com.app.web.servicio;

import com.app.web.entidad.Carros;
import com.app.web.repositorio.CarrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class CarrosServicioImpl implements CarrosServicio{

    @Autowired
    private CarrosRepositorio repositorio;

    @RequestMapping
    public List<Carros> listarTodosLosCarros() {
        return repositorio.findAll();
    }

    @Override
    public Carros guardarCarro(Carros Carro) {
        return repositorio.save(Carro);
    }

    @Override
    public Carros obtenerCarroId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Carros actualizarCarro(Carros Carro) {
        return repositorio.save(Carro);
    }

    @Override
    public void eliminarCarro(Long id) {
        repositorio.deleteById(id);
    }

}
