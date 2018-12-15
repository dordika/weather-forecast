
package com.dikado.training.weatherforecast.api.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Clouds implements Serializable
{

    private Integer all;
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -4763063369602461536L;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
