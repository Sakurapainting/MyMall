import com.google.gson.*;
import java.lang.reflect.Type;

public class CommodityTypeAdapter implements JsonSerializer<Commodity>, JsonDeserializer<Commodity> {
    @Override
    public JsonElement serialize(Commodity src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", src.getClass().getSimpleName());
        jsonObject.add("properties", context.serialize(src, src.getClass()));
        return jsonObject;
    }

    @Override
    public Commodity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            return context.deserialize(element, Class.forName(type));
        } catch (ClassNotFoundException e) {
            throw new JsonParseException("Unknown element type: " + type, e);
        }
    }
}
