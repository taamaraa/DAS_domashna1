import React, { useState, useEffect } from 'react';
// src/App.js
import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home';  // Импортирање на Home компонента
import List from './components/List';  // Импортирање на List компонента

function ActivityList() {
    // Декларација на state за чување на податоците
    const [state, setState] = useState([]);

    // Користење на useEffect за да се преземат податоци при вчитување на компонентата
    useEffect(() => {
        // Повик до API-то за да ги преземете активностите
        fetch('http://localhost:8080/api/activities')  // Патека до вашиот API
            .then(response => response.json())  // Парсирање на JSON одговорот
            .then(data => {
                setState(data);  // Поставување на податоците во state
            })
            .catch(error => console.error('Error fetching data:', error));  // Управување со грешки
    }, []);  // Празниот масив [] значи дека useEffect ќе се изврши само при првото вчитување на компонентата

    return (
        <div>
            <h2>Activities</h2>
            {/* Прелистување на state и прикажување на активностите */}
            {state.length === 0 ? (
                <p>Loading activities...</p>
                {/ Текст кога нема податоци /}
                ) : (
                <div>
            {state.map(obj => (
                <div key={obj.id} style={{ marginBottom: '10px' }}>
            {/* Прикажување на податоците */}
                <h3>{obj.type}</h3>
                <p>Carbon Impact: {obj.carbonImpact} kg CO2</p>
                </div>
                ))}
                </div>
                )}
        </div>
    );
}

export default ActivityList;


function App() {
    return (
        <Router>
            <Routes>
                {/* Почетна компонента */}
                <Route exact path="/" element={<Home />} />

                {/* Страница со список на активности */}
                <Route path="/list" element={<List />} />
            </Routes>
        </Router>
    );
}

export default App;