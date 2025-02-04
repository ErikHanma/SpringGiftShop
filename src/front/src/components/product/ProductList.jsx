import React from 'react';
import styled from 'styled-components';

// Пример данных о продуктах (замените на ваши реальные данные)
const products = [
  {
    id: 1,
    imageUrl: 'https://i.ibb.co/6XJd201/product1.png',
    discount: '46% ДЛЯ ВАС',
    price: '3599 р',
    installment: '4×900 р в сплит',
    description: 'Радиоуправляемый гусеничный экскаватор Cubits Urbamax E500...',
    rating: '4.8 ★ 385 оценок',
    delivery: 'Послезавтра, ПВЗ · Курьер',
  },
  // Добавьте остальные продукты...
];

// Styled Components для стилизации
const ProductGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(4, 1fr); // 4 колонки
  gap: 16px;
  padding: 16px;
`;

const ProductCard = styled.div`
  border: 1px solid #eee;
  border-radius: 8px;
  overflow: hidden;
  background-color: #fff;
  position: relative;

  &:hover {
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }
`;

const ProductImage = styled.img`
  width: 100%;
  height: auto; /* Сохраняем соотношение сторон */
`;

const ProductDiscount = styled.div`
  position: absolute;
  top: 8px;
  left: 8px;
  background-color: #2ecc71; /* Цвет фона */
  color: white;
  padding: 4px 8px;
  border-radius: 4px;
`;

const ProductDetails = styled.div`
  padding: 12px;
`;

const ProductPrice = styled.div`
  font-size: 16px;
  font-weight: bold;
`;

const ProductInstallment = styled.div`
  font-size: 12px;
`;

const ProductDescription = styled.div`
  font-size: 14px;
`;

const ProductRating = styled.div`
  font-size: 12px;
`;

const ProductDelivery = styled.div`
  font-size: 10px;
`;

const Container = styled.div`
  max-width: 1200px;
  margin: auto; /* Центрируем контейнер */
`;

// Компонент списка продуктов
const ProductList = () => {
    return (
        <Container>
            <div className="_1DITN A7Gr3 _2jMpp">
                <div id="/content/page/fancyPage/searchSpellchecker" data-apiary-widget-name="@search/Spellchecker">
                    {/* Здесь может быть логика для Spellchecker */}
                    <div data-zone-name="SearchSpellchecker"></div>
                </div>

                <div id="/content/page/fancyPage/searchPromoHeader" data-apiary-widget-name="@promo/SearchPromoHeader">
                    {/* Логика для заголовка промо */}
                </div>

                <h1 className="ds-text ds-text_weight_med ds-text_typography_headline-2">Детские игрушки и игры в KIDS</h1>

                <ProductGrid>
                    {products.map((product) => (
                        <ProductCard key={product.id}>
                            <ProductImage src={product.imageUrl} alt={product.description} />
                            <ProductDiscount>{product.discount}</ProductDiscount>
                            <ProductDetails>
                                <ProductPrice>{product.price}</ProductPrice>
                                <ProductInstallment>{product.installment}</ProductInstallment>
                                <ProductDescription>{product.description}</ProductDescription>
                                <ProductRating>{product.rating}</ProductRating>
                                <ProductDelivery>{product.delivery}</ProductDelivery>
                            </ProductDetails>
                        </ProductCard>
                    ))}
                </ProductGrid>
            </div>
        </Container>
    );
};

export default ProductList;
