package things;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class HotelWriter extends HotelConstants{
    
    public static void saveHotels(){
        HotelSingleton hotels = HotelSingleton.getInstance();
        ArrayList<Hotel> hotelList = hotels.getHotels();
        JSONArray jsonHotels = new JSONArray();

        //creating all the json objects
        for(int i=0; i < hotelList.size();i++){
            jsonHotels.add(getHotelJSON(hotelList.get(i)));
        }

        //write JSON file
        try(FileWriter file = new FileWriter(HOTEL_FILE_NAME)){
            file.write(jsonHotels.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getHotelJSON(Hotel hotel){
        JSONObject hotelDetails = new JSONObject();
        hotelDetails.put(HOTEL_ID, hotel.getId().toString());
        hotelDetails.put(HOTEL_NAME, hotel.getHotelName());
  

        return hotelDetails;
    }
}
