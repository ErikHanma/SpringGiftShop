import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL + '/api/cart';

export const fetchCart = async () => {
    const response = await axios.get(API_URL);
    return response.data;
};

export const addToCart = async (item) => {
    const response = await axios.post(`${API_URL}/add`, item);
    return response.data;
};
