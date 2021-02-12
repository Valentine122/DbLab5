package ua.lviv.iot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Child")
@Table(name = "child")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 500)
    private String name;
    @Column(name = "surname", length = 500)
    private String surname;
    @Column(name = "certificate_of_birth")
    private Integer certificateOfBirth;
    @Column(name = "date_of_entry")
    private Date dateOfEntry;
    @Column(name = "child_group_id")
    private Integer childGroupId;
    @Column(name = "child_group_kindergarten_id")
    private Integer childGroupKindergartenId;
    @Column(name = "status", length = 20)
    private String status;

    public Child() {}

    public Child(String name, String surname, Integer certificateOfBirth, Date dateOfEntry, Integer childGroupId, Integer childGroupKindergartenId, String status) {
        this(-1, name, surname, certificateOfBirth, dateOfEntry, childGroupId, childGroupKindergartenId, status);
    }

    public Child(Integer id, String name, String surname, Integer certificateOfBirth, Date dateOfEntry, Integer childGroupId, Integer childGroupKindergartenId, String status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.certificateOfBirth = certificateOfBirth;
        this.dateOfEntry = dateOfEntry;
        this.childGroupId = childGroupId;
        this.childGroupKindergartenId = childGroupKindergartenId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getCertificateOfBirth() {
        return certificateOfBirth;
    }

    public void setCertificateOfBirth(Integer certificateOfBirth) {
        this.certificateOfBirth = certificateOfBirth;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public Integer getChildGroupId() {
        return childGroupId;
    }

    public void setChildGroupId(Integer childGroupId) {
        this.childGroupId = childGroupId;
    }

    public Integer getChildGroupKindergartenId() {
        return childGroupKindergartenId;
    }

    public void setChildGroupKindergartenId(Integer childGroupKindergartenId) {
        this.childGroupKindergartenId = childGroupKindergartenId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", certificateOfBirth=" + certificateOfBirth +
                ", dateOfEntry=" + dateOfEntry +
                ", childGroupId=" + childGroupId +
                ", childGroupKindergartenId=" + childGroupKindergartenId +
                ", status='" + status + '\'';
    }
}
