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

    public WorkerEntity(String firstname, String lastname, String type) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.type = type;
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

    /*
    public long getTotalWage() {
        this.hours = hours;
        this.weekNumber = weekNumber;

        long totalWage = 0;

        switch (this.type) {
            case "lazyWorker":
                totalWage = weekNumber * 23 * 20;
                hours= 20L;
                break;
            case "childWorker":
                totalWage = weekNumber * 10 * 30 ;
                hours= 30L;
                break;
            case "goodWorker":
                totalWage = weekNumber * 160;
                hours= 40L;
                break;
            case "disabledWorker":
                totalWage = weekNumber * 100;
                hours= 10L;
                break;
        }
        return totalWage;
    }

 */


}

