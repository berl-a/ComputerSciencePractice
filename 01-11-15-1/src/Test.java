import java.util.HashMap;

/**
 * Created by romanberla on 23.10.15.
 */
public class Test {
    public static void main(String[] args) {


        HashMap<Double, Double> a0 = new HashMap<>();
        a0.put(0.5, 100d);
        a0.put(0.65, 120d);
        Business b = new Business(a0, a0, a0);

        for(int i = 0; i < 10; i++) {
            b.addEmployer(TypeOfEmployer.MANAGER, "Employer #" + i, 0.65);
        }
        for(int i = 0; i < 10; i++) {
            b.addEmployer(TypeOfEmployer.WORKER, "Employer #" + (i + 10), 0.5);
        }
        b.printEmployers();
        b.removeEmployer("Employer #6");
        b.printEmployers();


    }
}
