import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/layout/Header';
import Footer from './components/layout/Footer';
import CatalogPage from './pages/Catalog/CatalogPage';
import CartPage from './pages/Cart/CartPage';
import CheckoutPage from './pages/Checkout/CheckoutPage';
import LoginPage from './pages/Auth/Login';
import RegisterPage from './pages/Auth/Register';
import OrderHistoryPage from './pages/Profile/OrderHistory';
import ProductList from './components/product/ProductList'; // Импортируем ваш компонент

const App = () => {
    return (
        <Router>
            <Header />
            <Routes>
                <Route path="/" element={<CatalogPage />} />
                <Route path="/cart" element={<CartPage />} />
                <Route path="/checkout" element={<CheckoutPage />} />
                <Route path="/login" element={<LoginPage />} />
                <Route path="/register" element={<RegisterPage />} />
                <Route path="/profile/orders" element={<OrderHistoryPage />} />
                <Route path="/products" element={<ProductList />} />
            </Routes>
            <Footer />
        </Router>
    );
};

export default App;
