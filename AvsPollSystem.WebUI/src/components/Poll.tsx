import React, { useEffect } from 'react';
import { useAppDispatch, useAppSelector } from './../hooks';
import { loadPollDataAsync, loadPollResultsAsync, savePollResultAsync } from './../reducers/thunks';
import { selectPollOption } from '../reducers/pollSlice';

const Poll = () => {
    const poll = useAppSelector(state => state);
    const dispatch = useAppDispatch();
    
    useEffect(() => {
        if(!poll.currentPollId) {
            dispatch(loadPollDataAsync())
                .then((data) => {
                    console.log("Dispatched!");
                    console.log(data)
                })        
        }
    }, [])

    const voteClick = () => {
        dispatch(
            savePollResultAsync(
                {
                    selectedOptionId: poll.optionSelected
                })
        ).then(() => dispatch(loadPollResultsAsync({ pollId: poll.currentPollId })));
    }

    return (
        <>
            <div className="subject-container">
                {poll.subject}
            </div>
            {!poll.isPollCompleted && 
                <div className='options-bar'>
                   {poll.options.map(o => 
                        (<span key={o.optionId} className="poll-option">
                            <input key={o.optionId} type="radio" value={o.optionId} checked={poll.optionSelected===o.optionId} 
                            onChange={()=>dispatch(selectPollOption(o.optionId))}/> {o.value}
                        </span>))}
                        {poll.optionSelected &&
                        <div className="vote-button-bar">
                            <button onClick={voteClick}>Vote!</button>
                        </div>}    
                </div>
            }
            {poll.isPollCompleted &&
                <div className="results-container">
                    <div className="results-caption">Results:</div>
                    <div>
                        {poll.results.map(o => 
                            (<div key={o.value}><strong>{o.value}</strong> - <strong>{o.result}</strong> votes.</div>))}
                    </div>
                </div>
            }
        </>
    )
}

export default Poll