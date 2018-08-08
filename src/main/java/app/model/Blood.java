package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "completebloodcount")
public class Blood implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "measuredate")
    Date measuredate;
    @Column(name = "hemoglobin")
    Double hemoglobin;
    @Column(name = "redbloodcell")
    Double redbloodcell;
    @Column(name = "avgrbc")
    Double avgrbc;
    @Column(name = "HGB")
    Double HGB;
    @ManyToOne
    @JoinColumn(name = "patient_SNILS", referencedColumnName = "SNILS")
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }


    public Blood(Date measuredate, Double hemoglobin, Double redbloodcell,
                 Double avgrbc, Double HGB) {
        this.measuredate = measuredate;
        this.hemoglobin = hemoglobin;
        this.redbloodcell = redbloodcell;
        this.avgrbc = avgrbc;
        this.HGB = HGB;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMeasuredate() {
        return measuredate;
    }

    public void setMeasuredate(Date measuredate) {
        this.measuredate = measuredate;
    }

    public Double getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(Double hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public Double getRedbloodcell() {
        return redbloodcell;
    }

    public void setRedbloodcell(Double redbloodcell) {
        this.redbloodcell = redbloodcell;
    }

    public Double getAvgrbc() {
        return avgrbc;
    }

    public void setAvgrbc(Double avgrbc) {
        this.avgrbc = avgrbc;
    }

    public Double getHGB() {
        return HGB;
    }

    public void setHGB(Double HGB) {
        this.HGB = HGB;
    }

    public Blood() {
    }

    @Override
    public String toString() {
        return "Blood{" +
                "id=" + id +
                ", measuredate=" + measuredate +
                ", hemoglobin=" + hemoglobin +
                ", redbloodcell=" + redbloodcell +
                ", avgrbc=" + avgrbc +
                ", HGB=" + HGB +
                ", patient=" + patient +
                '}';
    }

}
