package avs.pollsystem.dtos;

import java.util.List;

public record PollResponse(
    String currentPollId,
    String subject,
    List<PollOptionDto> options) {
}