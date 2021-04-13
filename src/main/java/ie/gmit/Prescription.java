package ie.gmit;

public class Prescription extends Item implements Printable {
    private String prescriptionID;
    private boolean prescription;

    public Prescription(){
    }

    public Prescription(String name, double price, int quantity, String prescriptionID, boolean prescription) {
        super(name, price, quantity);
        setPrescriptionID(prescriptionID);
        setPrescription(prescription);
    }

    public String getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(String prescriptionID) {
        this.prescriptionID = prescriptionID;

        if(prescriptionID.charAt(0)=='D') {
            this.prescriptionID = prescriptionID;
        }
        else{
            throw new IllegalArgumentException("Invalid Prescription ID");
        }
    }

    public boolean isPrescription() {
        return prescription;
    }

    public void setPrescription(boolean prescription) {
        if(prescription) {
            this.prescription = prescription;
        }
        else{
            throw new IllegalArgumentException("Invalid Prescription");
        }
    }

    @Override
    public String toString() {
        return "Item ID:" + prescriptionID + " " + super.toString() + " please pick up at counter";
    }
}
