package com.mathjazz.fractions.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id_stacji",
        "stacja",
        "data_pomiaru",
        "godzina_pomiaru",
        "temperatura",
        "predkosc_wiatru",
        "kierunek_wiatru",
        "wilgotnosc_wzgledna",
        "suma_opadu",
        "cisnienie"
})
public class Forecast {

    @JsonProperty("id_stacji")
    private String idStacji;
    @JsonProperty("stacja")
    private String stacja;
    @JsonProperty("data_pomiaru")
    private String dataPomiaru;
    @JsonProperty("godzina_pomiaru")
    private String godzinaPomiaru;
    @JsonProperty("temperatura")
    private String temperatura;
    @JsonProperty("predkosc_wiatru")
    private String predkoscWiatru;
    @JsonProperty("kierunek_wiatru")
    private String kierunekWiatru;
    @JsonProperty("wilgotnosc_wzgledna")
    private String wilgotnoscWzgledna;
    @JsonProperty("suma_opadu")
    private String sumaOpadu;
    @JsonProperty("cisnienie")
    private String cisnienie;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id_stacji")
    public String getIdStacji() {
        return idStacji;
    }

    @JsonProperty("id_stacji")
    public void setIdStacji(String idStacji) {
        this.idStacji = idStacji;
    }

    @JsonProperty("stacja")
    public String getStacja() {
        return stacja;
    }

    @JsonProperty("stacja")
    public void setStacja(String stacja) {
        this.stacja = stacja;
    }

    @JsonProperty("data_pomiaru")
    public String getDataPomiaru() {
        return dataPomiaru;
    }

    @JsonProperty("data_pomiaru")
    public void setDataPomiaru(String dataPomiaru) {
        this.dataPomiaru = dataPomiaru;
    }

    @JsonProperty("godzina_pomiaru")
    public String getGodzinaPomiaru() {
        return godzinaPomiaru;
    }

    @JsonProperty("godzina_pomiaru")
    public void setGodzinaPomiaru(String godzinaPomiaru) {
        this.godzinaPomiaru = godzinaPomiaru;
    }

    @JsonProperty("temperatura")
    public String getTemperatura() {
        return temperatura;
    }

    @JsonProperty("temperatura")
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    @JsonProperty("predkosc_wiatru")
    public String getPredkoscWiatru() {
        return predkoscWiatru;
    }

    @JsonProperty("predkosc_wiatru")
    public void setPredkoscWiatru(String predkoscWiatru) {
        this.predkoscWiatru = predkoscWiatru;
    }

    @JsonProperty("kierunek_wiatru")
    public String getKierunekWiatru() {
        return kierunekWiatru;
    }

    @JsonProperty("kierunek_wiatru")
    public void setKierunekWiatru(String kierunekWiatru) {
        this.kierunekWiatru = kierunekWiatru;
    }

    @JsonProperty("wilgotnosc_wzgledna")
    public String getWilgotnoscWzgledna() {
        return wilgotnoscWzgledna;
    }

    @JsonProperty("wilgotnosc_wzgledna")
    public void setWilgotnoscWzgledna(String wilgotnoscWzgledna) {
        this.wilgotnoscWzgledna = wilgotnoscWzgledna;
    }

    @JsonProperty("suma_opadu")
    public String getSumaOpadu() {
        return sumaOpadu;
    }

    @JsonProperty("suma_opadu")
    public void setSumaOpadu(String sumaOpadu) {
        this.sumaOpadu = sumaOpadu;
    }

    @JsonProperty("cisnienie")
    public String getCisnienie() {
        return cisnienie;
    }

    @JsonProperty("cisnienie")
    public void setCisnienie(String cisnienie) {
        this.cisnienie = cisnienie;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "idStacji='" + idStacji + '\'' +
                ", stacja='" + stacja + '\'' +
                ", dataPomiaru='" + dataPomiaru + '\'' +
                ", godzinaPomiaru='" + godzinaPomiaru + '\'' +
                ", temperatura='" + temperatura + '\'' +
                ", predkoscWiatru='" + predkoscWiatru + '\'' +
                ", kierunekWiatru='" + kierunekWiatru + '\'' +
                ", wilgotnoscWzgledna='" + wilgotnoscWzgledna + '\'' +
                ", sumaOpadu='" + sumaOpadu + '\'' +
                ", cisnienie='" + cisnienie + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}

