package com.app.web.entidad;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "cars")

public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Marca",nullable = false,length = 50)
    private String Marca;

    @Column(name = "Modelo",nullable = false,length = 50)
    private String Modelo;

    @Column(name = "Descripcion",nullable = false,length = 50,unique = true)
    private String Descripcion;

    @Column(name = "Tipo_Combustible",nullable = false,length = 50)
    private String Tipo_Combustible;

    @Column(name = "Numero_de_Chasis",nullable = false,length = 50,unique = true)
    private String Numero_de_Chasis;

    @Column(name = "Numero_de_Placa",nullable = false,length = 50,unique = true)
    private String Numero_de_Placa;

    @Column(name = "Tipo_de_vehiculo",nullable = false,length = 50)
    private String Tipo_de_vehiculo;
    public Carros() {

    }

    public Carros(Long id, String Marca, String Modelo, String Descripcion, String tipo_Combustible, String numero_de_Chasis, String numero_de_Placa, String tipo_de_vehiculo) {
        super();
        this.id = id;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Descripcion = Descripcion;
        Tipo_Combustible = tipo_Combustible;
        Numero_de_Chasis = numero_de_Chasis;
        Numero_de_Placa = numero_de_Placa;
        Tipo_de_vehiculo = tipo_de_vehiculo;
    }

    public Carros( String Marca, String Modelo, String Descripcion, String tipo_Combustible, String numero_de_Chasis, String numero_de_Placa, String tipo_de_vehiculo) {
        super();
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Descripcion = Descripcion;
        Tipo_Combustible = tipo_Combustible;
        Numero_de_Chasis = numero_de_Chasis;
        Numero_de_Placa = numero_de_Placa;
        Tipo_de_vehiculo = tipo_de_vehiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }


    public String getTipo_Combustible() {
        return Tipo_Combustible;
    }

    public void setTipo_Combustible(String tipo_Combustible) {
        Tipo_Combustible = tipo_Combustible;
    }

    public String getNumero_de_Chasis() {
        return Numero_de_Chasis;
    }

    public void setNumero_de_Chasis(String numero_de_Chasis) {
        Numero_de_Chasis = numero_de_Chasis;
    }

    public String getNumero_de_Placa() {
        return Numero_de_Placa;
    }

    public void setNumero_de_Placa(String numero_de_Placa) {
        Numero_de_Placa = numero_de_Placa;
    }

    public String getTipo_de_vehiculo() {
        return Tipo_de_vehiculo;
    }

    public void setTipo_de_vehiculo(String tipo_de_vehiculo) {
        Tipo_de_vehiculo = tipo_de_vehiculo;
    }
    @Override
    public String toString() {
        return "Carros [id=" + id + ", Marca=" + Marca + ", Modelo=" + Modelo + ", Descripcion=" + Descripcion + ", Tipo_Combustible=" + Tipo_Combustible + ", Numero_de_Chasis=" + Numero_de_Chasis + ", Numero_de_Placa=" + Numero_de_Placa + ", Tipo_de_vehiculo=" + Tipo_de_vehiculo + "]";
    }


}
