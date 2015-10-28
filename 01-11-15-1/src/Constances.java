import java.util.HashMap;

/**
 * Created by romanberla on 23.10.15.
 */
public class Constances {

    private static HashMap<Double, Double> salaryForWorkTimeRates;
    private static HashMap<Double, Double> salaryPerHourForWorkTimeRates;
    private static HashMap<Double, Double> workTimeLimits;

    Constances (HashMap<Double, Double> salaryForWorkTimeRates, HashMap<Double, Double> salaryPerHourForWorkTimeRates, HashMap<Double, Double> workTimeLimits) {
        this.salaryForWorkTimeRates = salaryForWorkTimeRates;
        this.salaryPerHourForWorkTimeRates = salaryPerHourForWorkTimeRates;
        this.workTimeLimits = workTimeLimits;
    }

    public static HashMap<Double, Double> getWorkTimeLimits() {
        return workTimeLimits;
    }

    public static void setTimeLimitsForWorkTimeRates(HashMap<Double, Double> timeLimitsForWorkTimeRates) {
        Constances.workTimeLimits = timeLimitsForWorkTimeRates;
    }

    public static HashMap<Double, Double> getSalaryForWorkTimeRates() {
        return salaryForWorkTimeRates;
    }

    public static void setSalaryForWorkTimeRates(HashMap<Double, Double> salaryForWorkTimeRates) {
        Constances.salaryForWorkTimeRates = salaryForWorkTimeRates;
    }

    public static HashMap<Double, Double> getSalaryPerHourForWorkTimeRates() {
        return salaryPerHourForWorkTimeRates;
    }

    public static void setSalaryPerHourForWorkTimeRates(HashMap<Double, Double> salaryPerHourForWorkTimeRates) {
        Constances.salaryPerHourForWorkTimeRates = salaryPerHourForWorkTimeRates;
    }

    public static void setWorkTimeLimits(HashMap<Double, Double> workTimeLimits) {
        Constances.workTimeLimits = workTimeLimits;
    }
}