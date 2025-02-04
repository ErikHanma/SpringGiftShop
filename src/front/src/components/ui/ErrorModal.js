import React from 'react';

const ErrorModal = ({ message, onClose }) => {
    return (
        <div className="error-modal">
            <p>{message}</p>
            <button onClick={onClose}>Close</button>
        </div>
    );
};

export default ErrorModal;
