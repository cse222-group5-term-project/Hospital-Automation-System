package main.java.user;

public class Appointments implements Comparable<Appointments> {
    private Doctor doctor;
    private Date date;
    private Patient patient;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public Appointments(){
        this.patient = null;

    }

    public Appointments(Patient patient, Doctor doctor, Date date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public int compareTo(Appointments o) {

        return this.getDoctor().getUserID().compareTo(o.getDoctor().getUserID());
    }
}
