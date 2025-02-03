import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
    return (
        <header>
            <h1>Gift Store</h1>
            <nav>
                <Link to="/">Home</Link>
                <Link to="/catalog">Catalog</Link>
                <Link to="/cart">Cart</Link>
                <Link to="/profile">Profile</Link>
            </nav>
        </header>
    );
};

export default Header;
