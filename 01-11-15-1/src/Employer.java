/**
 * Created by romanberla on 23.10.15.
 */
public class Employer {

    protected TypeOfEmployer typeOfEmployer;

    protected String surname;
    protected double workTimeRate;

    Employer (String surname, double workTimeRate) {
        this.surname = surname;
        this.workTimeRate = workTimeRate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary () {
        return 0;
    }

    public TypeOfEmployer getTypeOfEmployer() {
        return typeOfEmployer;
    }

    public void setTypeOfEmployer(TypeOfEmployer typeOfEmployer) {
        this.typeOfEmployer = typeOfEmployer;
    }

    public double getWorkTimeRate() {
        return workTimeRate;
    }

    public void setWorkTimeRate(double workTimeRate) {
        this.workTimeRate = workTimeRate;
    }
}
