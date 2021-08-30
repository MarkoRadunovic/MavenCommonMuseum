package rs.ac.bg.student.marko.MavenCommonMuseum.transfer;

import java.io.Serializable;


public class Request implements Serializable{
    private Object podaci;
    private int operation;

    public Request() {
    }

    public Request(Object podaci, int operation) {
        this.podaci = podaci;
        this.operation = operation;
    }

    public int getOperation() {
        return operation;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }
    
    
}