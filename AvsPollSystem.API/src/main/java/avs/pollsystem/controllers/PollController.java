package avs.pollsystem.controllers;

import avs.pollsystem.dtos.PollResponse;
import avs.pollsystem.services.PollService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/poll")
@AllArgsConstructor
@CrossOrigin
public class PollController {

    @Autowired
    private final PollService pollService;

    @GetMapping
    public Mono<ResponseEntity<PollResponse>> getPoll() {
        return pollService.getActivePoll()
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}
