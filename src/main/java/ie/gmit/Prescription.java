package ie.gmit;

public class Prescription extends Item {
    private String prescriptionID;
    private boolean prescription;
    private int prescriptionCount =0;

    public Prescription(String name){
        super(name);
    }

    public Prescription(String name, double price, int quantity, String prescriptionID, boolean prescription) {
        super(name, price, quantity);
        setPrescriptionID(prescriptionID);
        setPrescription(prescription);
        prescriptionCount++;
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
        if(prescription && (prescriptionCount<=3)) {
            this.prescription = prescription;
        }
        else{
            throw new IllegalArgumentException("Invalid Prescription");
        }
    }

    @Override
    public String toString() {
        return "Item ID:" + prescriptionID + " " + super.toString();
    }

    public int getPrescriptionCount(){return prescriptionCount;}
}
