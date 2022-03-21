package ch.learnbees.salarycalculate.controller.model;

public class WorkerViewModel {

    private String firstname;
    private String lastname;
    private String type;

    public WorkerViewModel(){}

    public WorkerViewModel(String firstname, String lastname, String type) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.type = type;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
