package Employee;
public class PieceWorker extends Employee {
    private double wage; // wage per piece
    private int pieces;  // number of pieces produced

    // constructor
    public PieceWorker(String firstName, String lastName, String socialSecurityNumber,
                       double wage, int pieces) {
        super(firstName, lastName, socialSecurityNumber);
        
        if (wage < 0.0) {
            throw new IllegalArgumentException("Wage per piece must be >= 0.0");
        }
        if (pieces < 0) {
            throw new IllegalArgumentException("Number of pieces must be >= 0");
        }
        
        this.wage = wage;
        this.pieces = pieces;
    }

    // set wage per piece
    public void setWage(double wage) {
        if (wage < 0.0) {
            throw new IllegalArgumentException("Wage per piece must be >= 0.0");
        }
        this.wage = wage;
    }

    // return wage per piece
    public double getWage() {
        return wage;
    }

    // set number of pieces
    public void setPieces(int pieces) {
        if (pieces < 0) {
            throw new IllegalArgumentException("Number of pieces must be >= 0");
        }
        this.pieces = pieces;
    }

    // return number of pieces
    public int getPieces() {
        return pieces;
    }

    // calculate earnings; override abstract method earnings in Employee
    @Override
    public double earnings() {
        return getWage() * getPieces();
    }

    // return String representation of PieceWorker object
    @Override
    public String toString() {
        return String.format("piece worker: %s%n%s: $%,.2f; %s: %,d",
                super.toString(), "wage per piece", getWage(),
                "pieces produced", getPieces());
    }
}
