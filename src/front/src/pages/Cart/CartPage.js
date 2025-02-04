import React from 'react';
import CartItem from '../../components/cart/CartItem';

const CartPage = () => {
    // Логика получения данных корзины

    return (
        <div className="cart-page">
            <h2>Your Cart</h2>
            {/* cartItems.map(item => (<CartItem key={item.id} item={item} />)) */}
        </div>
    );
};

export default CartPage;
