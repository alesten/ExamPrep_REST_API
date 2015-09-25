package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Country;
import java.util.List;

public class JSONConverter {
    public static String getJSONFromContries(List<Country> countries){

        String json = "";
        
        for (Country country : countries) {
            json += "," + getJSONFromCountry(country);
        }
        
        return "[" + json.substring(1) + "]";
    }
    
    public static String getJSONFromCountry(Country country){
        JsonObject jsonOut = new JsonObject();
        
        jsonOut.addProperty("code", country.getCode());
        jsonOut.addProperty("name", country.getName());
        jsonOut.addProperty("continent", country.getContinent());
        if(country.getCapital() != null){
            jsonOut.addProperty("capital", country.getCapital().getName());
        }else{
            jsonOut.addProperty("capital", "");
        }
    
        String jsonResponse = new Gson().toJson(jsonOut);

        return jsonResponse;
    }
}
