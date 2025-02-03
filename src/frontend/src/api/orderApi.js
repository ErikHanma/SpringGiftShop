import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL + '/api/orders';

export const createOrder = async (orderData) => {
    const response = await axios.post(API_URL, orderData);
    return response.data;
};
