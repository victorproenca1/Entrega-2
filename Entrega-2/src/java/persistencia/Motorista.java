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
@Table(name = "RASTREAMENTOMOTORISTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rastreamentomotorista.findAll", query = "SELECT r FROM Rastreamentomotorista r")
    , @NamedQuery(name = "Rastreamentomotorista.findById", query = "SELECT r FROM Rastreamentomotorista r WHERE r.id = :id")
    , @NamedQuery(name = "Rastreamentomotorista.findByNomemotorista", query = "SELECT r FROM Rastreamentomotorista r WHERE r.nomemotorista = :nomemotorista")
    , @NamedQuery(name = "Rastreamentomotorista.findByEmailmotorista", query = "SELECT r FROM Rastreamentomotorista r WHERE r.emailmotorista = :emailmotorista")
    , @NamedQuery(name = "Rastreamentomotorista.findBySenhamotorista", query = "SELECT r FROM Rastreamentomotorista r WHERE r.senhamotorista = :senhamotorista")
    , @NamedQuery(name = "Rastreamentomotorista.findByAvaliacoespositivas", query = "SELECT r FROM Rastreamentomotorista r WHERE r.avaliacoespositivas = :avaliacoespositivas")
    , @NamedQuery(name = "Rastreamentomotorista.findByAvaliacoesnegativas", query = "SELECT r FROM Rastreamentomotorista r WHERE r.avaliacoesnegativas = :avaliacoesnegativas")})
public class Motorista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "NOMEMOTORISTA")
    private String nomemotorista;
    @Size(max = 100)
    @Column(name = "EMAILMOTORISTA")
    private String emailmotorista;
    @Size(max = 100)
    @Column(name = "SENHAMOTORISTA")
    private String senhamotorista;
    @Column(name = "AVALIACOESPOSITIVAS")
    private Integer avaliacoespositivas;
    @Column(name = "AVALIACOESNEGATIVAS")
    private Integer avaliacoesnegativas;

    public Motorista() {
    }

    public Motorista(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomemotorista() {
        return nomemotorista;
    }

    public void setNomemotorista(String nomemotorista) {
        this.nomemotorista = nomemotorista;
    }

    public String getEmailmotorista() {
        return emailmotorista;
    }

    public void setEmailmotorista(String emailmotorista) {
        this.emailmotorista = emailmotorista;
    }

    public String getSenhamotorista() {
        return senhamotorista;
    }

    public void setSenhamotorista(String senhamotorista) {
        this.senhamotorista = senhamotorista;
    }

    public Integer getAvaliacoespositivas() {
        return avaliacoespositivas;
    }

    public void setAvaliacoespositivas(Integer avaliacoespositivas) {
        this.avaliacoespositivas = avaliacoespositivas;
    }

    public Integer getAvaliacoesnegativas() {
        return avaliacoesnegativas;
    }

    public void setAvaliacoesnegativas(Integer avaliacoesnegativas) {
        this.avaliacoesnegativas = avaliacoesnegativas;
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
        if (!(object instanceof Motorista)) {
            return false;
        }
        Motorista other = (Motorista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.Rastreamentomotorista[ id=" + id + " ]";
    }
    
}
