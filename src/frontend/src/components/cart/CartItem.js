import React from 'react';

const CartItem = ({ item, onRemove }) => {
    return (
        <div className="cart-item">
            <h4>{item.productName}</h4>
            <p>Quantity: {item.quantity}</p>
            <button onClick={() => onRemove(item.id)}>Remove</button>
        </div>
    );
};

export default CartItem;
