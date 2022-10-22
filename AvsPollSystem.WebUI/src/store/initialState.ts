import { PollState } from "../models/PollState";

export const initialState : PollState = {
    currentPollId: "",
    isPollCompleted: false,
    optionSelected: "",
    subject: "No active polls or it is still loading..",
    options: [],
    results: []
}