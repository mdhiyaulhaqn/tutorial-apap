package apap.tutorial.gopud.rest;

import apap.tutorial.gopud.model.MenuModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuDetail {
    @JsonProperty("nama")
    private String nama;

    @JsonProperty("spesialis")
    private String spesialis;

    @JsonProperty("experience_in_years")
    private String experience_in_years;

    @JsonProperty("menus")
    private List<MenuModel> menus;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getExperience_in_years() {
        return experience_in_years;
    }

    public void setExperience_in_years(String experience_in_years) {
        this.experience_in_years = experience_in_years;
    }

    public List<MenuModel> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuModel> menus) {
        this.menus = menus;
    }
}
