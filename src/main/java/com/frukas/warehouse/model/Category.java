package com.frukas.warehouse.model;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String serialNumber;

    private boolean isActive = true;

    @Embedded
    private CreatedUpdateTime createdUpdateTime;

    public Category(){}

    public Category(Long id, String name, String serialNumber, boolean isActive, CreatedUpdateTime createdUpdateTime) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.isActive = isActive;
        this.createdUpdateTime = createdUpdateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public CreatedUpdateTime getCreatedUpdateTime() {
        return createdUpdateTime;
    }

    public void setCreatedUpdateTime(CreatedUpdateTime createdUpdateTime) {
        this.createdUpdateTime = createdUpdateTime;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", isActive=" + isActive +
                ", createdTime=" + createdUpdateTime.getCreateAt() +
                ", update =" + createdUpdateTime.getUpdateAt() +
                '}';
    }
}
