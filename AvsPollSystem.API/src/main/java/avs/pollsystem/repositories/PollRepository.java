package avs.pollsystem.repositories;

import avs.pollsystem.domain.Poll;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PollRepository extends ReactiveMongoRepository<Poll, String> {
    @Query("""
            { "isActive": true }
            """)
    @Aggregation(pipeline = """
            {
                $lookup: {
                    from: "PollOptions",
                    localField: "_id",
                    foreignField: "poll_id",
                    as: "options"
                }
            }
            """)
    Mono<Poll> findActivePoll();
}
