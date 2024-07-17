package prep_java.parking.lot;

public class Slot {
    private String vehicleType;
    private boolean isFull;
    private int slotNum;

    Slot(int num, String vehicleType){
        this.slotNum = num;
        this.isFull = false;
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public int getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(int slotNum) {
        this.slotNum = slotNum;
    }
}
