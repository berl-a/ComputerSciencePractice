/**
 * Created by romanberla on 23.10.15.
 */
public class Manager extends Employer {


    private double extraSalaryPercent;

    Manager (String surname, double workTimeRate, double extraSalaryPercent) {
        super(surname, workTimeRate);
        this.typeOfEmployer = "Manager";
        this.extraSalaryPercent = extraSalaryPercent;
    }

    @Override
    public double getSalary() {
        return Constances.getSalaryForWorkTimeRates().get(workTimeRate) * (1 + extraSalaryPercent);
    }

}
