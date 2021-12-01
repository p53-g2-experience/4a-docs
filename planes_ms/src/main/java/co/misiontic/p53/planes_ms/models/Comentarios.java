package co.misiontic.p53.planes_ms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Comentarios {
    @Id
    private String username;
    private String codigoPlan;
    private Integer calificacion;
    private String opinion;

    public Comentarios(String username, String codigoPlan, Integer calificacion, String opinion) {
        this.username = username;
        this.codigoPlan = codigoPlan;
        this.calificacion = calificacion;
        this.opinion = opinion;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCodigoPlan(String codigoPlan) {
        this.codigoPlan = codigoPlan;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getUsername() {
        return username;
    }

    public String getCodigoPlan() {
        return codigoPlan;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public String getOpinion() {
        return opinion;
    }


}
