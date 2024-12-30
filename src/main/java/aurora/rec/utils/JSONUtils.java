package aurora.rec.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class helps converting Java objects into JSON data and viceversa
 */
public class JSONUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Convert an object to JSON string
    public static String toJSON(Object obj)  {
        String str = "";
        try{
            str=objectMapper.writeValueAsString(obj);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return str;
    }

    // Convert a JSON string to an object
    public static <T> T fromJSON(String json, Class<T> clazz) {
        T t = null;
        try{
        t = objectMapper.readValue(json, clazz);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return t;
    }
}