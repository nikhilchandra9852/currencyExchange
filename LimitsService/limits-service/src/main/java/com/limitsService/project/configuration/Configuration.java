package com.limitsService.project.configuration;


import org.springframework.beans.factory.annotation.Value;

@org.springframework.context.annotation.Configuration("limits-service")
public class Configuration {

    @Value("${limits-service.minimum}")
    private int minimum;

    public int getMinimum() {
        return minimum;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "minimum=" + minimum +
                ", maximum=" + maximum +
                '}';
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    @Value("${limits-service.maximum}")
    private int maximum;

    public Configuration(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Configuration() {
    }
}
