package com.frukas.warehouse.model;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class CreatedUpdateTime {

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
