package prep_java.parking.lot;

import java.util.Map;

public class ParkingLot {
    private final Floor[] floors;
    private String id;
    private Map<String, Ticket> ticketMap;


    ParkingLot(int floorNum, int slots){
        this.floors = new Floor[floorNum];
        for(int i = 0;i<floorNum;i++){
            floors[i] = new Floor(i+1, slots);
        }

    }

    public Ticket getTicket(Vehicle vehicle){
        String vehicleType = vehicle.getType();
        for(Floor f: floors){
            int freeSlot = f.getFirstFreeSlot(vehicleType);
            if(freeSlot != -1){
                f.parkVehicle(freeSlot);
                Ticket ticket = new Ticket(id, f.getFloorNum(), freeSlot, vehicle);
                ticketMap.put(ticket.getId(), ticket);
            }
        }

        return null;
    }

    public void unPark(String ticketId){
        if(!this.ticketMap.containsKey(ticketId)){
            System.out.println("No such ticket found!");
            return;
        }
        Ticket t = this.ticketMap.get(ticketId);
        Floor f = floors[t.getFloorNum()-1];
        f.unParkVehicle(t.getSlotNum());
        this.ticketMap.remove(ticketId);
    }
}
