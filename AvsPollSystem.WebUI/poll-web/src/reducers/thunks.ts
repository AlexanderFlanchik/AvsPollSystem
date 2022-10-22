import { createAsyncThunk } from "@reduxjs/toolkit";
import { PollResult } from "../models/PollResult";
import { PollState } from "../models/PollState";
import { PollService } from "../services/pollService";

const pollService = new PollService();

export const loadPollDataAsync = createAsyncThunk<PollState, void>('poll/loadData', 
    async() => {
        return await pollService.getActivePoll();
    })

export const savePollResultAsync = createAsyncThunk<boolean, { selectedOptionId: string}>('poll/saveData',
    async ({ selectedOptionId }) => {
        return await pollService.votePoll(selectedOptionId);
    })
    
export const loadPollResultsAsync = createAsyncThunk<PollResult[], { pollId: string }>('poll/loadResults',
    async ({ pollId })  => {
        return await pollService.loadPollResults(pollId);
    })