package rs.ac.bg.student.marko.MavenCommonMuseum.transfer;

import java.io.Serializable;

public class Response implements Serializable{
    private Object podaci;
    private Exception greska;

    public Response() {
    }

    public Response(Object podaci, Exception greska) {
        this.podaci = podaci;
        this.greska = greska;
    }

    public Exception getGreska() {
        return greska;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setGreska(Exception greska) {
        this.greska = greska;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }
    
    
}

