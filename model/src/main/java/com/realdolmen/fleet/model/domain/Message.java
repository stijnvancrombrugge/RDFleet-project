package com.realdolmen.fleet.model.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by SDOAX36 on 12/11/2015.
 */
@Entity
public class Message extends AbstractEntity{

    private String from;
    private String message;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private Employee employee;

    private boolean read;

    public Message(String from, String message, Date date) {
        this.from = from;
        this.message = message;
        this.read = false;
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
