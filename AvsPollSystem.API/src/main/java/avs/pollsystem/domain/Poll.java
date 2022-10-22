package avs.pollsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Polls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poll {
    @Id
    private String id;

    @Field(name = "subject")
    private String subject;

    @Field(name = "is_active")
    private Boolean isActive;

    private PollOption[] options;
}