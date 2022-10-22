import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { initialState } from '../store/initialState';
import { loadPollDataAsync, loadPollResultsAsync, savePollResultAsync } from './thunks';

export const pollSlice = createSlice({
    name: 'poll',
    initialState,
    reducers: {
        selectPollOption: (state, action: PayloadAction<string>) => {
            state.optionSelected = action.payload 
        }
    },
    extraReducers: (builder) => {
        builder.addCase(loadPollDataAsync.fulfilled, (state, action) => {
            state.currentPollId = action.payload.currentPollId;
            state.isPollCompleted = action.payload.isPollCompleted;
            state.subject = action.payload.subject;
            state.options = action.payload.options;
        }).addCase(savePollResultAsync.fulfilled, (state, action) => {
            state.isPollCompleted = action.payload;
        }).addCase(loadPollResultsAsync.fulfilled, (state, action) => {
            state.results = action.payload;
        })
    }
})

const pollReducer = pollSlice.reducer;

export const { selectPollOption } = pollSlice.actions
export default pollReducer