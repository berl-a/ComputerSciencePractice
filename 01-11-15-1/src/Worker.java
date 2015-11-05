/**
 * Created by romanberla on 23.10.15.
 */
public class Worker extends Employer {

    private double salaryPerHour;
    private double workedHours;
    private double workingTimeLimit;

    Worker (String surname, double workTimeRate, double workedHours) {
        super(surname, workTimeRate);
        this.typeOfEmployer = TypeOfEmployer.WORKER;
        this.salaryPerHour = Constances.getSalaryPerHourForWorkTimeRates().get(workTimeRate);
        this.workedHours = workedHours;
        this.workingTimeLimit = Constances.getWorkTimeLimits().get(workTimeRate);
    }

    @Override
    public double getSalary() {
        return workedHours * salaryPerHour;
    }
}
