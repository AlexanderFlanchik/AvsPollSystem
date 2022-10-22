package avs.pollsystem.controllers;

import avs.pollsystem.dtos.PollResultDto;
import avs.pollsystem.services.PollResultSummaryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
@RequestMapping("api/poll/results")
@CrossOrigin
public class PollSummaryController {

    @Autowired
    private final PollResultSummaryService pollResultSummaryService;

    @GetMapping("/{pollId}")
    public Flux<PollResultDto> getPollResults(@PathVariable String pollId) {
        return pollResultSummaryService.getPollResults(pollId);
    }
}