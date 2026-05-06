package de.cyzetlc.hsbi.msi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;

import java.io.*;

@Getter @Setter
public class JsonFile {
    private final String path;

    private Gson gson;

    public JsonFile(String path) {
        this.path = path;
        gson = new Gson();
    }

    public JsonObject getObject() {
        return loadFromFile(this.path, JsonObject.class);
    }

    public void save(Object obj) {
        File file = new File(this.path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (Writer writer = new FileWriter(path)) {
            gson.toJson(obj, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T loadFromElement(JsonElement jsonElement, Class<T> clazz) {
        return new Gson().fromJson(jsonElement, clazz);
    }

    public static <T> T loadFromFile(String path, Class<T> clazz) {
        try (Reader reader = new FileReader(path)) {
            return new Gson().fromJson(reader, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
