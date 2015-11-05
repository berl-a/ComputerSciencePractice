import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * Created by romanberla on 24.10.15.
 */
public class Business {

    public static final int MAX_SURNAME_LENGTH = 18;
    public static final int MAX_TYPE_LENGTH = 10;
    public static final int MAX_WORK_TIME_RATE_LENGTH = 4;
    public static final int MAX_SALARY_LENGTH = 10;
    HashMap<String, Employer> employers = new HashMap<String, Employer>();

    Business(HashMap<Double, Double> salaryForWorkTimeRates, HashMap<Double, Double> salaryPerHourForWorkTimeRates, HashMap<Double, Double> workTimeLimits) {
        new Constances(salaryForWorkTimeRates, salaryPerHourForWorkTimeRates, workTimeLimits);

        System.out.println(Constances.getSalaryForWorkTimeRates().get(0.5));
    }

    public Employer findEmployer (String surname) {
        Employer e = null;
        for(int i = 0; i < employers.keySet().toArray().length && e == null; i ++)
            if(employers.keySet().toArray()[i].equals(surname))
                e = employers.get(employers.keySet().toArray()[i]);
        return e;
    }

    public TypeOfEmployer getTypeOfEmployer (String surname) {
        TypeOfEmployer type = null;
        for(int i = 0; i < employers.keySet().toArray().length && type == null; i ++)
            if(employers.keySet().toArray()[i].equals(surname))
                type = employers.get(employers.keySet().toArray()[i]).getTypeOfEmployer();
        return type;
    }

    public boolean addEmployer (TypeOfEmployer typeOfEmployer, String surname, double workTimeRate) {
        if(findEmployer(surname) == null) {
            if(typeOfEmployer.equals(TypeOfEmployer.WORKER))
                employers.put(surname, new Worker(surname, workTimeRate, 0));
            else if (typeOfEmployer.equals(TypeOfEmployer.MANAGER))
                employers.put(surname, new Manager(surname, workTimeRate, 0));
            else
                return false;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeEmployer (String surname) {
        boolean found = false;
        for(int i = 0; i < employers.keySet().toArray().length && !found; i ++)
            if(employers.keySet().toArray()[i].equals(surname)) {
                found = true;
                employers.remove(employers.keySet().toArray()[i]);
            }
        return found;
    }

    public int numberOfEmployersOfType (TypeOfEmployer typeOfEmployer) {
        int n = 0;
        for(String surname : employers.keySet()) {
            if(employers.get(surname).getTypeOfEmployer().equals(typeOfEmployer))
                n ++;
        }
        return n;
    }

    public double getSumOfSalarysOfEmployerOfType (TypeOfEmployer typeOfEmployer) {
        int s = 0;
        for(String surname : employers.keySet()) {
            if(employers.get(surname).getTypeOfEmployer().equals(typeOfEmployer))
                s += employers.get(surname).getSalary();
        }
        return s;
    }

    public void printEmployers () {
        System.out.println();
        System.out.println("All the employers of \"The Corp\" Corporation");
        System.out.println();

        System.out.println(getFillingDashes(MAX_SURNAME_LENGTH + MAX_TYPE_LENGTH + MAX_WORK_TIME_RATE_LENGTH + 4));
        for(String surname : employers.keySet()) {
            Employer e = employers.get(surname);
            DecimalFormat format = new DecimalFormat("#.##");
            System.out.println("|" + surname + getFillingSpaces(surname.length(), MAX_SURNAME_LENGTH) + "|" + e.typeOfEmployer + getFillingSpaces(e.getTypeOfEmployer().toString().length(), MAX_TYPE_LENGTH) + "|" + format.format(e.workTimeRate) + getFillingSpaces(format.format(e.workTimeRate).toString().length(), MAX_WORK_TIME_RATE_LENGTH) + "|");
        }
        System.out.println(getFillingDashes(MAX_SURNAME_LENGTH + MAX_TYPE_LENGTH + MAX_WORK_TIME_RATE_LENGTH + 4));
    }

    public void printEmployersOfEmployerType (TypeOfEmployer typeOfEmployer) {
        System.out.println();
        System.out.println("All the " + typeOfEmployer.toString() + "s of \"The Corp\" Corporation");
        System.out.println();

        System.out.println(getFillingDashes(MAX_SURNAME_LENGTH + MAX_WORK_TIME_RATE_LENGTH + 3));
        for(String surname : employers.keySet()) {
            Employer e = employers.get(surname);
            if(e.getTypeOfEmployer().equals(typeOfEmployer)) {
                DecimalFormat format = new DecimalFormat("#.##");
                System.out.println("|" + surname + getFillingSpaces(surname.length(), MAX_SURNAME_LENGTH) + "|" + format.format(e.workTimeRate) + getFillingSpaces(format.format(e.workTimeRate).toString().length(), MAX_WORK_TIME_RATE_LENGTH) + "|");
            }
        }
        System.out.println(getFillingDashes(MAX_SURNAME_LENGTH + MAX_WORK_TIME_RATE_LENGTH + 3));
    }

    public void printSalaries () {
        System.out.println();
        System.out.println("All the employers of \"The Corp\" Corporation");
        System.out.println();

        System.out.println(getFillingDashes(MAX_SURNAME_LENGTH + MAX_TYPE_LENGTH + MAX_WORK_TIME_RATE_LENGTH + MAX_SALARY_LENGTH + 5));
        for(String surname : employers.keySet()) {
            Employer e = employers.get(surname);
            DecimalFormat format = new DecimalFormat("#.##");
            System.out.println("|" + surname + getFillingSpaces(surname.length(), MAX_SURNAME_LENGTH) + "|" + e.typeOfEmployer + getFillingSpaces(e.getTypeOfEmployer().toString().length(), MAX_TYPE_LENGTH) + "|" + format.format(e.workTimeRate) + getFillingSpaces(format.format(e.workTimeRate).toString().length(), MAX_WORK_TIME_RATE_LENGTH) + "|" + format.format(e.getSalary()) + getFillingSpaces(format.format(e.getSalary()).length(), MAX_SALARY_LENGTH) + "|");
        }
        System.out.println(getFillingDashes(MAX_SURNAME_LENGTH + MAX_TYPE_LENGTH + MAX_WORK_TIME_RATE_LENGTH + MAX_SALARY_LENGTH + 5));
    }

    private String getFillingSpaces(int filledLength, int fullLength) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < fullLength - filledLength; i ++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String getFillingDashes (int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i ++) {
            sb.append("-");
        }
        return sb.toString();
    }


}