import { useState, useEffect } from 'react';
import axios from 'axios';

const useApi = (apiFunc) => {
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);

    useEffect(() => {
        apiFunc()
            .then(response => setData(response))
            .catch(err => setError(err));
    }, [apiFunc]);

    return { data, error };
};

export default useApi;
