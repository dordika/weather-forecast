
package com.dikado.training.weatherforecast.api.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FutureWeatherForecast implements Serializable
{

    private String cod;
    private Double message;
    private Integer cnt;
    private java.util.List<com.dikado.training.weatherforecast.api.model.List> list = null;
    private City city;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7581866029838092396L;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<com.dikado.training.weatherforecast.api.model.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.dikado.training.weatherforecast.api.model.List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
