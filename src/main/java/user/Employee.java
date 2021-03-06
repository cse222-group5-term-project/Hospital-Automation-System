package main.java.user;
import main.java.database.Database;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Employee class is the class for all employees.
 *
 */
public class Employee extends User {
    private String proficiency;
    private ArrayList<Boolean> workingDays;
    private ArrayList<Boolean> nightShifts;
    private ArrayList<String> forensicCases;
    private final int WEEKDAY_CAPACITY = 7;

    public final static String proAdmin = "Admin";
    public final static String proRadiolog = "Radiolog";
    public final static String proInternist = "Internist";
    public final static String proNeorolog = "Neurolog";
    public final static String proSurgeon = "Surgeon";

    public Employee() {
        super();
        workingDays = new ArrayList<Boolean>(WEEKDAY_CAPACITY);
        nightShifts = new ArrayList<Boolean>(WEEKDAY_CAPACITY);
        forensicCases = new ArrayList<>();

        for (int i = 0; i < WEEKDAY_CAPACITY; i++){
            workingDays.add(true);
            nightShifts.add(true);
        }
    }

    public Employee(String ID, String pass, String name, String userType, String proficiency) {
        super(ID, pass, name, userType);

        this.proficiency = proficiency;
        workingDays = new ArrayList<Boolean>(WEEKDAY_CAPACITY);
        nightShifts = new ArrayList<Boolean>(WEEKDAY_CAPACITY);
        forensicCases = new ArrayList<>();
        for (int i = 0; i < WEEKDAY_CAPACITY; i++){
            workingDays.add(false);
            nightShifts.add(false);
        }
    }

    public Employee(String ID, String pass, String name, String userType, ArrayList<Boolean> _workingDays,
                    ArrayList<Boolean> _nightShifts,
                    ArrayList<String> _forensicCases) {
        super(ID, pass, name, userType);

        workingDays = _workingDays;
        nightShifts = _nightShifts;
        forensicCases = _forensicCases;
    }

    /**
     * Returns proficiency of the employee.
     * @return Proficiency of the employee.
     */    
    public String getProficiency() {
        return proficiency;
    }

    // A method that prints the night shifts of the employee.
    public void viewNightShifts()
    {
        System.out.println("\nDay \t\t nightShift\n");

        Iterator<Boolean> iter = nightShifts.iterator();
        int _day = 1;
        while(iter.hasNext()){
            Boolean nextEl = iter.next();
            if(nextEl)
                System.out.printf("%d \t\t YES\n", _day++);
            else
                System.out.printf("%d \t\t NO\n", _day++);
        }
    }

    // Printing the working days of the employee.
    public void viewWorkingDays()
    {
        System.out.println("\nDay \t\t Working Day\n");

        Iterator<Boolean> iter = workingDays.iterator();
        int _day = 1;
        while(iter.hasNext()){
            Boolean nextEl = iter.next();
            if(nextEl)
                System.out.printf("%d \t\t YES\n", _day++);
            else
                System.out.printf("%d \t\t NO\n", _day++);
        }
    }

    /**
     * This method iterates through the forensicCases ArrayList and prints out each element
     */
    public void viewForensicCases()
    {
        Iterator<String> iter = forensicCases.iterator();

        System.out.println("\nForensic cases:\n");

        while(iter.hasNext()){
            String nextEl = iter.next();
            System.out.printf("+%s\n", nextEl);
        }
    }

    /**
     * Sets the working days of this {@code Employee} for one week.
     *
     * @param _workingDays list of working days for one week.
     */
    public void setWorkingDays(ArrayList<Boolean> _workingDays) {
        workingDays = _workingDays;
    }

    /**
     * Returns the working days of this {@code Employee} for one week.
     *
     * @return working days of this {@code Employee}
     *         for one week.
     */
    public ArrayList<Boolean> getWorkingDays() {
        return workingDays;
    }

    /**
     * Changes the working situation of this {@code Employee} for the specified
     * {@code day}.
     *
     * @param bool true or false (true means work day, false means rest day).
     * @param day  day of the week (0 to 6, Monday is 0).
     */
    public void setWorkingDay(boolean bool, int day) {
        workingDays.set(day, bool);
        if (this.getUserType().equals("Doctor")){
            for(int i = 0; i <10; i++){
                Appointments newAppoint = new Appointments();
                Patient newPatient = new Patient();
                newAppoint.setPatient(newPatient);
                newAppoint.setDoctor((Doctor) this);
                Date newDate = new Date (day, i);
                newAppoint.setDate(newDate);
                Database.db.addAppointment(newAppoint);
            }
        }


    }

    /**
     * Returns the working situation of this {@code Employee} for the specified
     * {@code day}.
     *
     * @param day day of the week (0 to 6, Monday is 0).
     * @return the working situation of this {@code Employee} for the specified
     *         {@code day}
     *         (True or false, true means work day, false means rest day)
     */
    public boolean isWorkingDay(int day) {
        return workingDays.get(day);
    }

    /**
     * Sets the night shifts of this {@code Employee} for one week
     *
     * @param _nightShifts list of nightShifts for one week
     */
    public void setNightShifts(ArrayList<Boolean> _nightShifts) {
        nightShifts = _nightShifts;
    }

    /**
     * Returns the nights shifts of this {@code Employee} for one week.
     *
     * @return night shifts of this {@code Employee}
     *         for one week.
     */
    public ArrayList<Boolean> getNightShifts() {
        return nightShifts;
    }

    /**
     * Changes the night shift situation of this {@code Employee} for the specified
     * {@code day}.
     *
     * @param bool true or false (false means no nightshift, true means there is a
     *             night shift on that night).
     * @param day  day of the week (0 to 6, Monday is 0).
     */
    public void setNightShift(boolean bool, int day) {
        nightShifts.set(day, bool);
        if (this.getUserType().equals("Doctor")){
            for(int i = 20; i <24; i++){
                Appointments newAppoint = new Appointments();
                Patient newPatient = new Patient();
                newAppoint.setPatient(newPatient);
                newAppoint.setDoctor((Doctor) this);
                Date newDate = new Date (day, i);
                newAppoint.setDate(newDate);
                Database.db.addAppointment(newAppoint);
            }
        }
    }

    /**
     * Returns the night shift situation of this (@code Employee) for the specified
     * {@code day}.
     *
     * @param day day of the week (0 to 6, Monday is 0).
     * @return the night shift situation of this {@code Employee} for the specified
     *         {@code day}
     *         (false means no nightshift, true means there is a night shift on that
     *         night).
     */
    public boolean hasNightShift(int day) {
        return nightShifts.get(day);
    }

    /**
     * Returns forensic cases of this {@code Employee}.
     *
     * @return forensic cases of this {@code Employee}.
     */
    public ArrayList<String> getForensicCases() {
        return forensicCases;
    }

    /**
     * Changes forensic cases of this {@code Employee}.
     *
     * @param _forensicCases forensic cases
     */
    public void setForensicCases(ArrayList<String> _forensicCases) {
        forensicCases = _forensicCases;
    }

    /**
     * Adds a new forensic case to this {@code Employee}.
     *
     * @param fCase forensic case.
     */
    public void addForensicCase(String fCase) {
        forensicCases.add(fCase);
    }


    /**
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        Employee emp;
        emp = (Employee) obj;
        return super.equals(obj)
                && this.workingDays.equals(emp.workingDays)
                && this.nightShifts.equals(emp.nightShifts)
                && this.forensicCases.equals(emp.forensicCases);
    }

    /**
     * It returns a formatted string:
     * @column		 	day
     * @column			Work
     * @column 			Night Shift
     * @return String
     */
    @Override
    public String toString() {
        String str = "\n";
        str += super.toString();
        str += String.format("\n\n\t\t\t%-10s %-10s\n\n","Work", "Night Shift");
        String[] weekdays = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        for (int i = 0; i < WEEKDAY_CAPACITY; i++) {
            str += String.format("%-10s",weekdays[i]);
            str += "\t\t";
            if (workingDays.get(i))
                str += "Yes";
            else
                str += "No";

            str += "\t\t";

            if (nightShifts.get(i))
                str += "Yes";
            else
                str += "No";

            str += "\n";
        }

        str += "\nForensic cases of the employee:\n";
        if(forensicCases.size() == 0){
            str += "Nothing Found!";
        }

        for (int i = 0; i < forensicCases.size(); i++) {
            str += "-" + forensicCases.get(i);
            str += "\n";
        }
        return str;
    }
}
