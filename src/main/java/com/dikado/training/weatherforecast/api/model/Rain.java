
package com.dikado.training.weatherforecast.api.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Rain implements Serializable
{

    private Double _3h;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1537786776111177436L;

    public Double get3h() {
        return _3h;
    }

    public void set3h(Double _3h) {
        this._3h = _3h;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
