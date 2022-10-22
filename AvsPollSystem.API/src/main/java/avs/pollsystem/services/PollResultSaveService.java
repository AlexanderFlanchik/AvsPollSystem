package avs.pollsystem.services;

import avs.pollsystem.domain.PollResult;
import avs.pollsystem.repositories.PollResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PollResultSaveService {
    @Autowired
    private final PollResultRepository pollResultRepository;

    public Mono<Void> savePollResult(String pollOptionId) {
        PollResult result = new PollResult();
        result.setPollOptionId(pollOptionId);

        return pollResultRepository.insert(result).then();
    }
}
