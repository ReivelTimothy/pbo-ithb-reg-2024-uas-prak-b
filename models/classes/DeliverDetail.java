package models.classes;

import java.sql.Date;
import models.enumeration.DeliverStatus;

public class DeliverDetail {
    private int id, Transaction_id;
    private DeliverStatus status;
    private String currentPosition, evidence, update_By;
    private Date date;

    public DeliverDetail(int id, int Transaction_id, DeliverStatus status, String currentPosition, String evidence,
            String update_By, Date date) { // buat ngambil datanya 
        this.id = id;
        this.Transaction_id = Transaction_id;
        this.status = status;
        this.currentPosition = currentPosition;
        this.evidence = evidence;
        this.update_By = update_By;
        this.date = date;
    }
    public DeliverDetail(int Transaction_id, DeliverStatus status, String currentPosition, String evidence,
            String update_By, Date date) { // buat masukin data khusus arrived
        this.Transaction_id = Transaction_id;
        this.status = status;
        this.currentPosition = currentPosition;
        this.evidence = evidence;
        this.update_By = update_By;
        this.date = date;
    }

    public DeliverDetail(int Transaction_id, DeliverStatus status, String currentPosition,
            String update_By, Date date) { // buat masukin data selain status arrived
        this.Transaction_id = Transaction_id;
        this.status = status;
        this.currentPosition = currentPosition;
        this.update_By = update_By;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransaction_id() {
        return Transaction_id;
    }

    public void Transaction_id(int Transaction_id) {
        this.Transaction_id = Transaction_id;
    }

    public DeliverStatus getStatus() {
        return status;
    }

    public void setStatus(DeliverStatus status) {
        this.status = status;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getUpdate_By() {
        return update_By;
    }

    public void setUpdate_By(String update_By) {
        this.update_By = update_By;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
