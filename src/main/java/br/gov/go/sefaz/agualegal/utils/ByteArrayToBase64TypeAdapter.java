package br.gov.go.sefaz.agualegal.utils;

import java.lang.reflect.Type;
import java.util.Base64;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ByteArrayToBase64TypeAdapter implements JsonSerializer<byte[]> {

	@Override
	public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(Base64.getEncoder().encodeToString(src));
	}
}
