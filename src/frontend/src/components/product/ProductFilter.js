import React from 'react';

const ProductFilter = ({ onFilterChange }) => {
    return (
        <div className="product-filter">
            <input type="text" placeholder="Search..." onChange={e => onFilterChange(e.target.value)} />
        </div>
    );
};

export default ProductFilter;
