package prep_java.parking.lot;

public class Floor {
    private Slot[] slots;
    private int floorNum;
    private int availableCarSlots;
    private int availableBikeSlots;

    Floor(int floorNum, int slotsNum){
        this.floorNum = floorNum;
        slots = new Slot[slotsNum];
        slots[0] = new Slot(1, "TRUCK");
        slots[1] = new Slot(2, "BIKE");
        slots[2] = new Slot(3, "BIKE");
        for(int i = 3;i<slotsNum;i++) {
            slots[i] = new Slot(i+1, "CAR");
        }
        this.availableBikeSlots = 2;
        this.availableCarSlots = slotsNum - 3;
    }

     int getFirstFreeSlot(String vehicleType){
        if(vehicleType.equals("TRUCK")){
            if(slots[0].isFull()){
                return -1;
            }
            return 1;
        }

        if(vehicleType.equals("BIKE")){
            if(this.availableBikeSlots == 0){
                return -1;
            }
            if(slots[0].isFull()){
                return 2;
            }
            return 1;
        }

        for(int i = 2;i<slots.length;i++){
            if(!slots[i].isFull()){
                return i+1;
            }
        }

        return -1;
     }

     void parkVehicle(int n){
        if(n>this.slots.length || n<=0 || this.slots[n-1].isFull()){
            System.out.println("Slot not available!");
            return;
        }

        this.slots[n-1].setFull(true);
     }

     void unParkVehicle(int slotNum){
        slotNum-=1;
        if(slotNum >= this.slots.length || slotNum < 0){
            System.out.println("No such slot!");
        }else{
            if(slotNum>1 && slotNum<4 && this.slots[slotNum].isFull()){
                this.availableBikeSlots += 1;
                this.slots[slotNum].setFull(false);
            } else if (slotNum>1 && this.slots[slotNum].isFull()) {
                this.availableCarSlots += 1;
                this.slots[slotNum].setFull(false);
            }else if(slotNum == 1 && this.slots[slotNum].isFull()){
                this.slots[slotNum].setFull(false);
            }
        }
     }

    public Slot[] getSlots() {
        return slots;
    }

    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public int getAvailableCarSlots() {
        return availableCarSlots;
    }

    public void setAvailableCarSlots(int availableCarSlots) {
        this.availableCarSlots = availableCarSlots;
    }

    public int getAvailableBikeSlots() {
        return availableBikeSlots;
    }

    public void setAvailableBikeSlots(int availableBikeSlots) {
        this.availableBikeSlots = availableBikeSlots;
    }

}
