package exercise;

public final class EmployeeCSVAdapter implements Employee {
    private final EmployeeCSV csv;

    public EmployeeCSVAdapter(EmployeeCSV csv) { this.csv = java.util.Objects.requireNonNull(csv); }

    @Override
    public String getId() {
        String[] t = csv.tokens();
        return t.length > 0 ? t[0] : "";
    }

    @Override
    public String getFirstName() {
        String[] t = csv.tokens();
        return t.length > 1 ? t[1] : "";
    }

    @Override
    public String getLastName() {
        String[] t = csv.tokens();
        return t.length > 2 ? t[2] : "";
    }

    @Override
    public String getEmail() {
        String[] t = csv.tokens();
        return t.length > 3 ? t[3] : "";
    }
}