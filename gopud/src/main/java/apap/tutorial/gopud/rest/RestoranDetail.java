package apap.tutorial.gopud.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestoranDetail {
    private String status;

    @JsonProperty("restauran-license")
    private Integer restauranLicense;

    @JsonProperty("valid-until")
    private Date validUntil;

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public Integer getRestauranLicense() {
        return restauranLicense;
    }

    public void setRestauranLicense(Integer restauranLicense) {
        this.restauranLicense = restauranLicense;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
