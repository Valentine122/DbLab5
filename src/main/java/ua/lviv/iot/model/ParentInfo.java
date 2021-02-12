package ua.lviv.iot.model;

import javax.persistence.*;

@Entity(name = "ParentInfo")
@Table(name = "parent_info")
public class ParentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Integer childId;
    @Column(name = "father_surname")
    private String fatherSurname;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "father_patronymic")
    private String fatherPatronymic;
    @Column(name = "father_phone_number", length = 20)
    private String fatherPhoneNumber;
    @Column(name = "mother_surname")
    private String motherSurname;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "mother_patronymic")
    private String motherPatronymic;
    @Column(name = "mother_phone_number", length = 20)
    private String motherPhoneNumber;

    public ParentInfo() {}

    public ParentInfo(String fatherSurname, String fatherName, String fatherPatronymic, String fatherPhoneNumber, String motherSurname, String motherName, String motherPatronymic, String motherPhoneNumber) {
        this(-1, fatherSurname, fatherName, fatherPatronymic, fatherPhoneNumber, motherSurname, motherName, motherPatronymic, motherPhoneNumber);
    }

    public ParentInfo(Integer childId, String fatherSurname, String fatherName, String fatherPatronymic, String fatherPhoneNumber, String motherSurname, String motherName, String motherPatronymic, String motherPhoneNumber) {
        this.childId = childId;
        this.fatherSurname = fatherSurname;
        this.fatherName = fatherName;
        this.fatherPatronymic = fatherPatronymic;
        this.fatherPhoneNumber = fatherPhoneNumber;
        this.motherSurname = motherSurname;
        this.motherName = motherName;
        this.motherPatronymic = motherPatronymic;
        this.motherPhoneNumber = motherPhoneNumber;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getFatherSurname() {
        return fatherSurname;
    }

    public void setFatherSurname(String fatherSurname) {
        this.fatherSurname = fatherSurname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherPatronymic() {
        return fatherPatronymic;
    }

    public void setFatherPatronymic(String fatherPatronymic) {
        this.fatherPatronymic = fatherPatronymic;
    }

    public String getFatherPhoneNumber() {
        return fatherPhoneNumber;
    }

    public void setFatherPhoneNumber(String fatherPhoneNumber) {
        this.fatherPhoneNumber = fatherPhoneNumber;
    }

    public String getMotherSurname() {
        return motherSurname;
    }

    public void setMotherSurname(String motherSurname) {
        this.motherSurname = motherSurname;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherPatronymic() {
        return motherPatronymic;
    }

    public void setMotherPatronymic(String motherPatronymic) {
        this.motherPatronymic = motherPatronymic;
    }

    public String getMotherPhoneNumber() {
        return motherPhoneNumber;
    }

    public void setMotherPhoneNumber(String motherPhoneNumber) {
        this.motherPhoneNumber = motherPhoneNumber;
    }

    @Override
    public String toString() {
        return "\n" +
                "childId=" + childId +
                ", fatherSurname='" + fatherSurname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", fatherPatronymic='" + fatherPatronymic + '\'' +
                ", fatherPhoneNumber='" + fatherPhoneNumber + '\'' +
                ", motherSurname='" + motherSurname + '\'' +
                ", motherName='" + motherName + '\'' +
                ", motherPatronymic='" + motherPatronymic + '\'' +
                ", motherPhoneNumber='" + motherPhoneNumber + '\'';
    }
}
