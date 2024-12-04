// src/components/List.js
import React, { useState, useEffect } from 'react';

const List = () => {
    const [state, setState] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/activities')  // Патека до вашиот API
            .then(response => response.json())
            .then(data => {
                setState(data);
            })
            .catch(error => console.error('Error fetching data:', error));
    }, []);

    return (
        <div>
            <h2>Activities List</h2>
            {state.length === 0 ? (
                <p>Loading activities...</p>
            ) : (
                state.map(obj => (
                    <div key={obj.id} style={{ marginBottom: '10px' }}>
                        <h3>{obj.type}</h3>
                        <p>Carbon Impact: {obj.carbonImpact} kg CO2</p>
                    </div>
                ))
            )}
        </div>
    );
};

export default List;