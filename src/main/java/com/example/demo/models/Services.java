package com.example.demo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "services", schema = "zannabirgit.dk-db", catalog = "")
public class Services {
    private int serviceId;
    private String serviceName;
    private int servicePrice;
    private int serviceLength;
    private String serviceDescription;

    @Id
    @Column(name = "service_id")
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "service_name")
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Basic
    @Column(name = "service_price")
    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    @Basic
    @Column(name = "service_length")
    public int getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(int serviceLength) {
        this.serviceLength = serviceLength;
    }

    @Basic
    @Column(name = "service_description")
    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Services that = (Services) o;
        return serviceId == that.serviceId &&
                servicePrice == that.servicePrice &&
                serviceLength == that.serviceLength &&
                Objects.equals(serviceName, that.serviceName) &&
                Objects.equals(serviceDescription, that.serviceDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, serviceName, servicePrice, serviceLength, serviceDescription);
    }
}
