import React from 'react';
import { Link } from 'react-router-dom';

const IntroPage = () => {
    return (
        <div>
            <div className="intro-title">
                Click <Link to="/poll"> here</Link>  to participate our polling…
            </div>
            <div className='poll-intro-container'>
                <img src={'/poll-intro.png'} />
            </div>
        </div>
    )
}

export default IntroPage