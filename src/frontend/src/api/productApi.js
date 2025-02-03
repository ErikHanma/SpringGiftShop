import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL + '/api/products';

export const fetchProducts = async () => {
    const response = await axios.get(API_URL);
    return response.data;
};

export const fetchProductById = async (id) => {
    const response = await axios.get(`${API_URL}/${id}`);
    return response.data;
};
