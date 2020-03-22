/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
 * @author James Bristow <jmb1079@psu.edu>
 */
@Entity
@Table(name = "INDIVIDUAL", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Individual.findAll", query = "SELECT i FROM Individual i"),
    @NamedQuery(name = "Individual.findById", query = "SELECT i FROM Individual i WHERE i.id = :id"),
    @NamedQuery(name = "Individual.findByFname", query = "SELECT i FROM Individual i WHERE i.fname = :fname"),
    @NamedQuery(name = "Individual.findByLname", query = "SELECT i FROM Individual i WHERE i.lname = :lname"),
    @NamedQuery(name = "Individual.findByState", query = "SELECT i FROM Individual i WHERE i.state = :state"),
    @NamedQuery(name = "Individual.findByLatitude", query = "SELECT i FROM Individual i WHERE i.latitude = :latitude"),
    @NamedQuery(name = "Individual.findByLongitude", query = "SELECT i FROM Individual i WHERE i.longitude = :longitude")
})
public class Individual implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FNAME")
    private String fname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LNAME")
    private String lname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "LATITUDE")
    private String latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "LONGITUDE")
    private String longitude;

    public Individual()
    {
    }

    public Individual(Integer id)
    {
        this.id = id;
    }

    public Individual(Integer id, String fname, String lname, String state, String latitude, String longitude)
    {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Individual))
        {
            return false;
        }
        Individual other = (Individual) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Services.Individual[ id=" + id + " ]";
    }
    
}
