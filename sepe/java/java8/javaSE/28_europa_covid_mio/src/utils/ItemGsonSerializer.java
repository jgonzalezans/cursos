package utils;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import model.Item;

public class ItemGsonSerializer implements JsonSerializer<Item> {

	@Override
	public JsonElement serialize(Item src, Type typeOfSrc, JsonSerializationContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
