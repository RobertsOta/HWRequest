package com.example.autenticatask;

import javax.persistence.*;


@Entity
public class HardwareRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = 1;
    private String hardware;
    private String parameters;
    private String comment;
    private String date;

//    @Basic
//    private java.sql.Timestamp sqlTimestamp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
