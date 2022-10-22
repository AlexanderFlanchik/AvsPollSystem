package avs.pollsystem.repositories;

import avs.pollsystem.domain.PollResult;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollResultRepository  extends ReactiveMongoRepository<PollResult, String> {
}
