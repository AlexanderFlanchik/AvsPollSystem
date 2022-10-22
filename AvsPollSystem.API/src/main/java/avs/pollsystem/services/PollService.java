package avs.pollsystem.services;

import avs.pollsystem.dtos.PollOptionDto;
import avs.pollsystem.dtos.PollResponse;
import avs.pollsystem.repositories.PollRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PollService {
    @Autowired
    private final PollRepository pollRepository;

    public Mono<PollResponse> getActivePoll() {
            return pollRepository.findActivePoll()
                .map(poll -> new PollResponse(
                        poll.getId(),
                        poll.getSubject(),
                        Arrays.stream(poll.getOptions())
                                .map(o -> new PollOptionDto(o.getId(), o.getValue()))
                                .collect(Collectors.toList())
                        )
                );
    }
}