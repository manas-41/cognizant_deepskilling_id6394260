import React from 'react';
import './App.css';
import CohortDetails from './Components/CohortDetails';

function App() {
  return (
    <div className="App">
      <h2>Cohort Dashboard</h2>
      <CohortDetails name="React Bootcamp" status="ongoing" duration="6 weeks" />
      <CohortDetails name="Java Spring" status="completed" duration="8 weeks" />
    </div>
  );
}

export default App;
