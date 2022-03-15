package things;

import java.util.ArrayList;
import java.util.UUID;

public class HotelSingleton {
    private static HotelSingleton hotels;
    private ArrayList<Hotel> hotelList;

    private HotelSingleton() {
        hotelList = HotelLoader.getHotels();
    }

    public static HotelSingleton getInstance() {
        if(hotels == null) {
            hotels = new HotelSingleton();
        }

        return hotels;
    }

    public boolean haveHotel(String hotelName){
        for(Hotel hotel: hotelList){
            if(hotel.getHotelName().equals(hotelName)){
                return true;
            }
        }
        return false;
    }

    public Hotel getHotel(String hotelName){
        for(Hotel hotel: hotelList){
            if(hotel.getHotelName().equals(hotelName)){
                return hotel;
            }
        }
        return null;
    }

    public ArrayList<Hotel> getHotels(){
        return hotelList;
    }

    public boolean addHotel(String hotelName, UUID id, String location, boolean vacancy){
        if(haveHotel(hotelName)){
            return false;
        }

        hotelList.add(new Hotel(hotelName, location, vacancy));
        return true;
    }

    public void saveHotels() {
        HotelWriter.saveHotels();
    }
}
