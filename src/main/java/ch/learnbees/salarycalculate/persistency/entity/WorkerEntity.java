package ch.learnbees.salarycalculate.persistency.entity;

import javax.persistence.*;

@Entity
@Table(name = "workers")
public class WorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;
    private String lastname;
    private String type;

    @OneToOne(mappedBy = "workerEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private WorkingHoursEntity workingHours;

    public WorkerEntity() {}

    public WorkerEntity(String firstname, String lastname, String type , WorkingHoursEntity workingHours) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.type = type;
        this.workingHours = workingHours;
    }

    public WorkingHoursEntity getWorkingHours() {
        return workingHours;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getType() {
        return type;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setType(String type) {
        this.type = type;
    }




}

