package things;

import java.util.UUID;

public class GenUUID{

    public static void main(String[] args){
        final String uuid = UUID.randomUUID().toString();
        System.out.println("uuid = "+ uuid);
    }
}