package com.julia;

import java.awt.*;

public enum Priority {
    HIGH,
    MEDIUM,
    LOW;

    public String getPriorityText(Priority priority){
        if(priority == HIGH){
            return "High";
        }else if(priority == MEDIUM){
            return "Medium";
        }else{
            return "Low";
        }
    }


}
