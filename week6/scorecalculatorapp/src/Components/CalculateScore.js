import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {
  const { name, school, total, goal } = props;
  const average = total / goal;

  return (
    <div className="score-container">
      <h2>Student Score Report</h2>
      <p>Name: {name}</p>
      <p>School: {school}</p>
      <p>Total Marks: {total}</p>
      <p>Goal: {goal}</p>
      <p>Average Score: {average}</p>
    </div>
  );
}

export default CalculateScore;
