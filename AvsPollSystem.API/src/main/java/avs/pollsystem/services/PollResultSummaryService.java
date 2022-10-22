package avs.pollsystem.services;

import avs.pollsystem.dtos.PollResultDto;
import avs.pollsystem.repositories.PollOptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class PollResultSummaryService {
    @Autowired
    private final PollOptionRepository pollOptionRepository;

    public Flux<PollResultDto> getPollResults(String pollId) {
       return pollOptionRepository.findByPollId(pollId)
                .map(optionData -> {
                    var results = optionData.getResults().stream()
                            .map(v -> v.get("results"))
                            .findFirst()
                            .orElse(0);

                    return new PollResultDto(optionData.getValue(), results);
                });
    }
 }
