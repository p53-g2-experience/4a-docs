package co.misiontic.p53.planes_ms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Reservas {
    @Id
    private String username;
    private String codigoPlan;
    private Integer cantidadIntegrantes;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer valorReserva;

    public Reservas(String username, String codigoPlan, Integer cantidadIntegrantes, Date fechaInicio, Date fechaFin, Integer valorReserva) {
        this.username = username;
        this.codigoPlan = codigoPlan;
        this.cantidadIntegrantes = cantidadIntegrantes;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valorReserva = valorReserva;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCodigoPlan(String codigoPlan) {
        this.codigoPlan = codigoPlan;
    }

    public void setCantidadIntegrantes(Integer cantidadIntegrantes) {
        this.cantidadIntegrantes = cantidadIntegrantes;
    }

    public void setValorReserva(Integer valorReserva) {
        this.valorReserva = valorReserva;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getUsername() {
        return username;
    }

    public String getCodigoPlan() {
        return codigoPlan;
    }

    public Integer getCantidadIntegrantes() {
        return cantidadIntegrantes;
    }

    public Integer getValorReserva() {
        return valorReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

}
