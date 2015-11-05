/**
 * Created by romanberla on 05.11.15.
 */
public enum TypeOfEmployer {
    MANAGER {
        @Override
        public String toString() {
            return "Manager";
        }
    }, WORKER {
        @Override
        public String toString() {
            return "Worker";
        }
    };
}
