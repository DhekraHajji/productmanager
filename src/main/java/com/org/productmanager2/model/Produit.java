package com.org.productmanager2.model;




import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (nullable=false, updatable=false)
    private Long id;
    private String name;
    private Integer Qte;
    private Timestamp Date_creation;
    private Timestamp Date_mmodif;
    public Produit (){
    }
    public Produit (String name, Integer Qte, Timestamp Date_creation, Timestamp Date_mmodif)
    {
        this.name = name;
        this.Qte = Qte;
        this.Date_creation = Date_creation;
        this.Date_mmodif = Date_mmodif;
    }

    public Long getId () {
        return id;
    }
    public String getName () {
        return name;
    }
    public Integer getQte () {
        return Qte;
    }
    public Timestamp getDate_creation () {
        return Date_creation;
    }
    public Timestamp getDate_mmodif () {
        return Date_mmodif;
    }

    public void setId (Long id) {
        this.id = id;
    }
    public void setName (String name) {
        this.name = name;
    }
    public void setQte (Integer Qte) {
        this.Qte = Qte;
    }
    public void setDate_creation (Timestamp Date_creation) {
        this.Date_creation = Date_creation;
    }
    public void setDate_mmodif (Timestamp Date_mmodif) {
        this.Date_mmodif = Date_mmodif;
    }
    public String toString()
    {
        return "Produit {" + "id=" + id +
                ", name='" + name + '\'' +
                ", Qte = '" + Qte + '\'' +
                ", Date_creation = '" + '\'' +
                ", Date_mmodif = '" + '\'' +
                '}';
    }


}


