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
@Table(name = "RASTREAMENTOALUNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rastreamentoaluno.findAll", query = "SELECT r FROM Rastreamentoaluno r")
    , @NamedQuery(name = "Rastreamentoaluno.findById", query = "SELECT r FROM Rastreamentoaluno r WHERE r.id = :id")
    , @NamedQuery(name = "Rastreamentoaluno.findByEmailaluno", query = "SELECT r FROM Rastreamentoaluno r WHERE r.emailaluno = :emailaluno")
    , @NamedQuery(name = "Rastreamentoaluno.findBySenhaaluno", query = "SELECT r FROM Rastreamentoaluno r WHERE r.senhaaluno = :senhaaluno")
    , @NamedQuery(name = "Rastreamentoaluno.findByNomealuno", query = "SELECT r FROM Rastreamentoaluno r WHERE r.nomealuno = :nomealuno")
    , @NamedQuery(name = "Rastreamentoaluno.findByCurso", query = "SELECT r FROM Rastreamentoaluno r WHERE r.curso = :curso")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "EMAILALUNO")
    private String emailaluno;
    @Size(max = 100)
    @Column(name = "SENHAALUNO")
    private String senhaaluno;
    @Size(max = 100)
    @Column(name = "NOMEALUNO")
    private String nomealuno;
    @Size(max = 100)
    @Column(name = "CURSO")
    private String curso;

    public Aluno() {
    }

    public Aluno(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailaluno() {
        return emailaluno;
    }

    public void setEmailaluno(String emailaluno) {
        this.emailaluno = emailaluno;
    }

    public String getSenhaaluno() {
        return senhaaluno;
    }

    public void setSenhaaluno(String senhaaluno) {
        this.senhaaluno = senhaaluno;
    }

    public String getNomealuno() {
        return nomealuno;
    }

    public void setNomealuno(String nomealuno) {
        this.nomealuno = nomealuno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClasses.Rastreamentoaluno[ id=" + id + " ]";
    }
    
}
