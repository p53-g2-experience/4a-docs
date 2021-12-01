package co.misiontic.p53.planes_ms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Planes {
    @Id
    private String codigoPlan;
    private String nombrePlan;
    private String descripcionPlan;
    private String rutaImagen;
    private Integer valorPlan;

    public Planes(String codigoPlan, String nombrePlan, String descripcionPlan, String rutaImagen, Integer valorPlan) {
        this.codigoPlan = codigoPlan;
        this.nombrePlan = nombrePlan;
        this.descripcionPlan = descripcionPlan;
        this.rutaImagen = rutaImagen;
        this.valorPlan = valorPlan;
    }

    public void setCodigoPlan(String codigoPlan) {
        this.codigoPlan = codigoPlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public void setDescripcionPlan(String descripcionPlan) {
        this.descripcionPlan = descripcionPlan;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void setValorPlan(Integer valorPlan) {
        this.valorPlan = valorPlan;
    }

    public String getCodigoPlan() {
        return codigoPlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public String getDescripcionPlan() {
        return descripcionPlan;
    }

    public String getRutaImagen() { return rutaImagen; }

    public Integer getValorPlan() {
        return valorPlan;
    }


}
