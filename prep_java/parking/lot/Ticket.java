package prep_java.parking.lot;

public class Ticket {
    private String id;
    private int floorNum;
    private int slotNum;

    Ticket(String id, int floorNum, int slotNum, Vehicle vehicle){
        this.id = id+"_"+vehicle.getRegNum();
        this.floorNum = floorNum;
        this.slotNum = slotNum;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public int getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(int slotNum) {
        this.slotNum = slotNum;
    }
}
