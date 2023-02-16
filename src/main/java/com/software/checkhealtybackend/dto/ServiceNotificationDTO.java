package com.software.checkhealtybackend.dto;

public class ServiceNotificationDTO {

    private Notification notification;
    private String to;

    public ServiceNotificationDTO(Notification notification, String to) {
        this.notification = notification;
        this.to = to;
    }

    public ServiceNotificationDTO() {
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
