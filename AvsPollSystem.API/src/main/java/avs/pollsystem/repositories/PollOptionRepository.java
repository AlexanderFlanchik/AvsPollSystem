package avs.pollsystem.repositories;

import avs.pollsystem.domain.PollOption;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PollOptionRepository extends ReactiveMongoRepository<PollOption, String> {
    @Query(value = """
                {
                    "pollId" : ObjectId(?0)
                }
            """)
    @Aggregation(value = """
            {
                $lookup: {
                    from: "PollResults",
                    let: { option_id: "$_id"},
                    pipeline: [
                        {
                            $match: {
                                $expr: {
                                    $eq: ["$poll_option_id", "$$option_id"]
                                }
                            }
                        },
                        {
                            $group: {
                                _id: { poll_option_id: "$poll_option_id" },
                                results: { $sum: 1 }
                            }
                        },
                        {
                            $project: {
                                _id: 0
                            }
                        }
                    ],
                    as: "results"
                }
            }
            """)
    Flux<PollOption> findByPollId(String value);
}