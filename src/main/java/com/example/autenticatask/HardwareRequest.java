package com.example.autenticatask;
import javax.persistence.*;

                                                            //Spring frameworks automātiski izveido datubāzē tabulu no tās klases mainīgajiem,
                                                            //kura norādīta tieši pēc @Entity anotācijas
@Entity
public class HardwareRequest {
    @Id                                                     //Tiek definēts, ka nākošais mainīgais aiz @Id būs primary key izveidotajā tabulā.
    @GeneratedValue(strategy = GenerationType.AUTO)         //Tiek definēts, ka id mainīgais būs automātiski ģenerēta vērtība
    private Integer id = 1;
    private String hardware;
    private String parameters;
    private String comment;
    private String date;

    public Integer getId() { return id; }                   //Tiek definēti seteri un geteri, lai varētu dabūt vai mainīt šīs klases mainīgo vērtības

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
