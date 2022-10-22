import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import IntroPage from './components/IntroPage';
import Poll from './components/Poll';

function App() {
  return (
    <div className="App">
      <div className="app-title">
        AVS Poll
      </div>
      <Router>
        <Routes>
          <Route path='/' element={<IntroPage/>}/>
          <Route path='/poll' element={<Poll/>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
