package co.misiontic.p53.planes_ms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Planes {
    @Id
    private String codigoPlan;
    private String plan_title; // Obviously a title 
    private String plan_region; // it's a important element of our marketing
    private String plan_city; // A city for filter the address
    private String plan_address; // it's necessary a specific place
    private String plan_category; // if it's a experience of coffee or photography
    private Integer valorPlan;
    private Date plan_start_date;
    private Date plan_end_date;
    private String plan_image_path;
    private String plan_image2_path;
    private String plan_description;
    private String plan_requirements;
    private Boolean plan_availability;

    public Planes(String codigoPlan, String plan_title, String plan_region, String plan_city, String plan_address,
            String plan_category, Integer valorPlan, Date plan_start_date, Date plan_end_date, String plan_image_path,
            String plan_image2_path, String plan_description, String plan_requirements, Boolean plan_availability) {
        this.codigoPlan = codigoPlan;
        this.plan_title = plan_title;
        this.plan_region = plan_region;
        this.plan_city = plan_city;
        this.plan_address = plan_address;
        this.plan_category = plan_category;
        this.valorPlan = valorPlan;
        this.plan_start_date = plan_start_date;
        this.plan_end_date = plan_end_date;
        this.plan_image_path = plan_image_path;
        this.plan_image2_path = plan_image2_path;
        this.plan_description = plan_description;
        this.plan_requirements = plan_requirements;
        this.plan_availability = plan_availability;
    }

    public String getCodigoPlan() {
        return codigoPlan;
    }

    public void setCodigoPlan(String codigoPlan) {
        this.codigoPlan = codigoPlan;
    }

    public String getPlan_title() {
        return plan_title;
    }

    public void setPlan_title(String plan_title) {
        this.plan_title = plan_title;
    }

    public String getPlan_region() {
        return plan_region;
    }

    public void setPlan_region(String plan_region) {
        this.plan_region = plan_region;
    }

    public String getPlan_city() {
        return plan_city;
    }

    public void setPlan_city(String plan_city) {
        this.plan_city = plan_city;
    }

    public String getPlan_address() {
        return plan_address;
    }

    public void setPlan_address(String plan_address) {
        this.plan_address = plan_address;
    }

    public String getPlan_category() {
        return plan_category;
    }

    public void setPlan_category(String plan_category) {
        this.plan_category = plan_category;
    }

    public Integer getValorPlan() {
        return valorPlan;
    }

    public void setValorPlan(Integer valorPlan) {
        this.valorPlan = valorPlan;
    }

    public Date getPlan_start_date() {
        return plan_start_date;
    }

    public void setPlan_start_date(Date plan_start_date) {
        this.plan_start_date = plan_start_date;
    }

    public Date getPlan_end_date() {
        return plan_end_date;
    }

    public void setPlan_end_date(Date plan_end_date) {
        this.plan_end_date = plan_end_date;
    }

    public String getPlan_image_path() {
        return plan_image_path;
    }

    public void setPlan_image_path(String plan_image_path) {
        this.plan_image_path = plan_image_path;
    }

    public String getPlan_image2_path() {
        return plan_image2_path;
    }

    public void setPlan_image2_path(String plan_image2_path) {
        this.plan_image2_path = plan_image2_path;
    }

    public String getPlan_description() {
        return plan_description;
    }

    public void setPlan_description(String plan_description) {
        this.plan_description = plan_description;
    }

    public String getPlan_requirements() {
        return plan_requirements;
    }

    public void setPlan_requirements(String plan_requirements) {
        this.plan_requirements = plan_requirements;
    }

    public Boolean getPlan_availability() {
        return plan_availability;
    }

    public void setPlan_availability(Boolean plan_availability) {
        this.plan_availability = plan_availability;
    }    
}