import React from 'react';
import ProductCard from '../../components/product/ProductCard';
import ProductFilter from '../../components/product/ProductFilter';

const CatalogPage = () => {
    // Логика получения продуктов

    return (
        <div className="catalog-page">
            <h2>Catalog</h2>
            <ProductFilter />
            {/* Отображение списка продуктов */}
            {/* products.map(product => (<ProductCard key={product.id} product={product} />)) */}
        </div>
    );
};

export default CatalogPage;
