/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "RASTREAMENTOONIBUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rastreamentoonibus.findAll", query = "SELECT r FROM Rastreamentoonibus r")
    , @NamedQuery(name = "Rastreamentoonibus.findById", query = "SELECT r FROM Rastreamentoonibus r WHERE r.id = :id")
    , @NamedQuery(name = "Rastreamentoonibus.findByMarca", query = "SELECT r FROM Rastreamentoonibus r WHERE r.marca = :marca")
    , @NamedQuery(name = "Rastreamentoonibus.findByPlaca", query = "SELECT r FROM Rastreamentoonibus r WHERE r.placa = :placa")
    , @NamedQuery(name = "Rastreamentoonibus.findByModelo", query = "SELECT r FROM Rastreamentoonibus r WHERE r.modelo = :modelo")})
public class Onibus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "MARCA")
    private String marca;
    @Size(max = 100)
    @Column(name = "PLACA")
    private String placa;
    @Size(max = 100)
    @Column(name = "MODELO")
    private String modelo;

    public Onibus() {
    }

    public Onibus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onibus)) {
            return false;
        }
        Onibus other = (Onibus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.Rastreamentoonibus[ id=" + id + " ]";
    }
    
}
