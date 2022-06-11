 package main.java.user;

import main.java.HelperClass.Examination;
import main.java.HelperClass.PatientRoom;

import java.util.ArrayList;
import java.util.Queue;

 public class Patient extends User{
    private PatientRoom room;
    private int age;
    private int weight;
    private int height;
    private String bloodType;
    protected Queue<Appointments> appointments;
    protected Queue<String> symptoms;
    protected ArrayList<String> prescriptions = new ArrayList<>();
    protected ArrayList<Examination> testResults = new ArrayList<>();
    protected ArrayList<String> medicineRequirements = new ArrayList<>();
    protected ArrayList<String> allergies = new ArrayList<>();
    protected ArrayList<String> illnesses = new ArrayList<>();

    public Patient(String id, String password, String name, int age, int weight, int height, String bloodType) {
        super(id, password, name, User.userTypePatient);
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.bloodType = bloodType;
    }

    /**
     * this method assign a hospital room for patient
     * only a doctor could be assign a room for patient
     * @param room
     */
    public void setRoom(PatientRoom room) {
        this.room = room;
    }

     public Queue<String> getSymptoms() {
         return symptoms;
     }

     public void putAge(int theAge) {
        age = theAge;
    }

    public int getAge() {
        return age;
    }

    public void putWeight(int theWeight) {
        weight = theWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void putHeight(int theHeight) {
        height = theHeight;
    }

    public int getHeight() {
        return height;
    }

    public void putBloodType(String theBloodType) {
        bloodType = theBloodType;
    }

    public String getBloodType() {
        return bloodType;
    }

     /**
      * method to get medical history of patient
      * @return patient's informations as a string
      */
    public String getMedicalHistory(){
        String history = new String();
        history = history + "age: " + getAge();
        history = history + "\nweight: " + getWeight();
        history = history + "\nheight: " + getHeight();
        history = history + "\nblood type: " + getBloodType();

        return history;
    }
/*
    public boolean addAppointment(Appointments newAppointment) {
       // Date selectedDate = newAppointment.getDate();
        Doctor selectedDoctor = newAppointment.getDoctor();
        Appointments selectedAppointment = findFreeAppointment(selectedDate, selectedDoctor);
        if (selectedAppointment.getPatient() == null) {
            return true;
        } else {
            return false;
        }
    }
    /*
    public Appointments findFreeAppointment(Date selectedDate, Doctor selectedDoctor) {
        return (HospitalSystem.appointmentData[0]);
    }
*/

    public boolean deleteAppointment(Appointments selectedAppointment) {
        if (selectedAppointment.getPatient() == this) {
            selectedAppointment.putPatient(null);
            return true;
        } else {
            return false;
        }
    }

    public String listDoctorsAppointment() {
        String str = "";

        //  Empty Method

        return str;
    }

    public Date selectDate() {
        Date theSelectedDate = new Date();

        //  Empty Method

        return theSelectedDate;
    }

    public Doctor selectDoctor() {
        Doctor theSelectDoctor = new Doctor();

        //  Empty Method

        return theSelectDoctor;
    }

    public String listMyAppoinments() {
        String str = "";

        //  Empty Method

        return str;
    }

    public String listAppointments() {
        String str = "";

        //  Empty Method

        return str;
    }

    public String getPrescriptions() {
        String str = "";

        // prescriptions[];
        // Empty Method
        return str;
    }

    public String getTestResult() {
        String str = "";

        // testResults[];
        // Empty Method

        return str;
    }

    public String getMedicineRequirements() {
        String str = "";

        // medicineRequirements;
        //  Empty Method

        return str;
    }

    public String getAllergies() {
        String str = "";

        // allergies[];
        //  Empty Method

        return str;
    }

    public ArrayList<String> getIllness() {
        String str = "";

        // illnesses[];
        //  Empty Method

        return illnesses;
    }
    public void addIllness(String illness) {
        illnesses.add(illness);
    }

    public void addSymptom(String symptom) {
    }

     /**
      * doctor could add new appointment via this method
      * @param creation an appointment
      */
    public void addAppointment(Appointments creation) {
        appointments.offer(creation);
    }
}