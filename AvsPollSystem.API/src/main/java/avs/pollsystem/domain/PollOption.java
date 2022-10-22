package avs.pollsystem.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@Document(collection = "PollOptions")
@Data
public class PollOption {
    @Id
    private String id;

    @Field(name = "poll_id", targetType = FieldType.OBJECT_ID)
    private String pollId;

    private String value;

    private ArrayList<LinkedHashMap<String, Integer>> results;
}
