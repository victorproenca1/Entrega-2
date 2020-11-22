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
import javax.persistence.Lob;
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
@Table(name = "RASTREAMENTOROTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rastreamentorota.findAll", query = "SELECT r FROM Rastreamentorota r")
    , @NamedQuery(name = "Rastreamentorota.findById", query = "SELECT r FROM Rastreamentorota r WHERE r.id = :id")
    , @NamedQuery(name = "Rastreamentorota.findByNomerota", query = "SELECT r FROM Rastreamentorota r WHERE r.nomerota = :nomerota")})
public class Rota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "NOMEROTA")
    private String nomerota;
    @Lob
    @Size(max = 32700)
    @Column(name = "PONTO")
    private String ponto;

    public Rota() {
    }

    public Rota(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomerota() {
        return nomerota;
    }

    public void setNomerota(String nomerota) {
        this.nomerota = nomerota;
    }

    public String getPonto() {
        return ponto;
    }

    public void setPonto(String ponto) {
        this.ponto = ponto;
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
        if (!(object instanceof Rota)) {
            return false;
        }
        Rota other = (Rota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.Rastreamentorota[ id=" + id + " ]";
    }
    
}
