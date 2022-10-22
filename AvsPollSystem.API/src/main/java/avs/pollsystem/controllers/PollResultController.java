package avs.pollsystem.controllers;

import avs.pollsystem.dtos.SavePollResultRequest;
import avs.pollsystem.services.PollResultSaveService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/poll/result")
@AllArgsConstructor
@CrossOrigin
public class PollResultController {

    @Autowired
    private final PollResultSaveService pollResultSaveService;

    @PostMapping
    public Mono<ResponseEntity<Void>> savePollResult(@RequestBody SavePollResultRequest request) {
        return pollResultSaveService.savePollResult(request.pollOptionId())
                .map(ResponseEntity::ok);
    }
}