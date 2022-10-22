package avs.pollsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "PollResults")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollResult {
    @Id
    private String id;

    @Field(name = "poll_option_id", targetType = FieldType.OBJECT_ID)
    private String pollOptionId;
}