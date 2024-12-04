// src/components/Home.js
import React from 'react';
import { Link } from 'react-router-dom';  // Импортирање на Link од react-router-dom

const Home = () => {
    return (
        <div>
            <h1>Welcome to EcoTracker</h1>
            <p>Track your carbon footprint and take action to reduce it!</p>
            {/* Линк до страницата со список на активности */}
            <Link to="/list">See list of activities</Link>
        </div>
    );
};

export default Home;