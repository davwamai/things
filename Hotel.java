package things;
import java.util.*;

public class Hotel {
    private UUID id;
    private String name;
    private String location;
    private boolean vacancy;

    public Hotel(String name, String location, boolean vacancy){
        this.id = UUID.randomUUID();
        this.name = name;
        this.location = location;
        this.vacancy = vacancy;
    }

    public Hotel(UUID id, String name, String location, boolean vacancy){
        this.id = id;
        this.name = name;
        this.location = location;
        this.vacancy = vacancy;
    }

    public String getHotelName(){
        return this.name;
    }

    public UUID getId(){
        return this.id;
    }

}
