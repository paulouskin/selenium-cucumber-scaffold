package pl.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.qaupskilling.reqres.entity.UserData;

import java.io.File;
import java.io.IOException;

public class SerializationDeserializationTest {

    @Test
    public void shouldSerializeAndDeserializeObject() throws IOException {
        UserData user = new UserData("Jake Show", "Project Manager");
        ObjectMapper mapper = new ObjectMapper();
        File resultFile = new File("src/test/resources/data.json");
        //mapper.writeValue(System.out, user);
        mapper.writeValue(resultFile, user);
        UserData userFromJson = mapper.readValue(resultFile, UserData.class);
        Assertions.assertEquals(user.getName(), userFromJson.getName());
    }
}
