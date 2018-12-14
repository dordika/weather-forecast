
package com.dikado.training.weatherforecast.api.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Sys implements Serializable
{

    private String pod;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3990093391386476710L;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
