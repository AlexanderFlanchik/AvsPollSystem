import { configureStore } from '@reduxjs/toolkit';
import pollReducer from './../reducers/pollSlice';

export const store = configureStore({
    reducer: pollReducer
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch

export default store
