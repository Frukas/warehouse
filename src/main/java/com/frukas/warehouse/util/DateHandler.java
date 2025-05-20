package com.frukas.warehouse.util;

import com.frukas.warehouse.model.CreatedUpdateTime;

import java.time.LocalDateTime;

public class DateHandler {

    private DateHandler(){}

    public static void setCreatedUpdated(CreatedUpdateTime date){

        LocalDateTime now = LocalDateTime.now();

        if(date.getCreateAt() == null){
            date.setCreateAt(now);
        }

        date.setUpdateAt(now);
    }
}
