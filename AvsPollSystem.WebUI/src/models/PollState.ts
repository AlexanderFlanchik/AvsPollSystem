import { PollOption } from "./PollOption";
import { PollResult } from "./PollResult";

export interface PollState {
    currentPollId: string;
    optionSelected: string;
    subject: string;
    isPollCompleted: boolean;
    options: Array<PollOption>;
    results: Array<PollResult>;
}