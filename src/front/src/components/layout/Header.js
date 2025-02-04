import React from 'react';
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import styles from './Header.module.css';

const Header = () => {
  return (
    <header className={styles.header}>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="container"> {/* Используем Bootstrap контейнер */}
          {/* Логотип и название */}
          <Link to="/" className="navbar-brand">
            <span className={styles.marketLink}>KIDS</span>
          </Link>
          
          {/* Кнопка для мобильного меню */}
          <button 
            className="navbar-toggler" 
            type="button" 
            data-bs-toggle="collapse" 
            data-bs-target="#navbarNav" 
            aria-controls="navbarNav" 
            aria-expanded="false" 
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>

          {/* Основное меню */}
          <div className="collapse navbar-collapse" id="navbarNav">
            <div className={`d-flex align-items-center me-auto ${styles.leftSection}`}>
              <button className={`${styles.catalogButton} btn btn-warning`}>
                <svg aria-hidden="true" width="24" height="24" viewBox="0 0 24 24">
                  <path d="M3 6h18v2H3z"></path>
                  <path d="M3 11h18v2H3z"></path>
                  <path d="M3 16h18v2H3z"></path>
                </svg>
                <span>Каталог</span>
              </button>

              {/* Поисковая строка */}
              <form className={`d-flex ms-3 ${styles.searchForm}`}>
                <input
                  type="text"
                  placeholder="Найти товары"
                  className={`form-control ${styles.searchInput}`}
                />
                <button type="submit" className={`btn btn-warning ${styles.searchButton}`}>
                  Найти
                </button>
              </form>
            </div>

            {/* Правая часть с иконками */}
            <div className={`d-flex align-items-center ${styles.rightSection}`}>
              <HeaderIcon
                icon="koleso"
                count={20}
                label="Колесо призов"
                href="/kolesoprizov"
              />
              <HeaderIcon
                icon="orders"
                label="Заказы"
                href="/my/orders"
              />
              <HeaderIcon
                icon="favorite"
                label="Избранное"
                href="/my/wishlist"
              />
              <HeaderIcon
                icon="cart"
                count={4}
                label="Корзина"
                href="/my/cart"
              />
              
              {/* Профиль пользователя */}
              <div className={styles.profile}>
                <Link to="/profile">
                  <button className={styles.profileButton}>
                    <img 
                      src="//avatars.mds.yandex.net/get-yapic/25358/XyJEAB5fSB3LaMG4yP8UR5I6gQ-1/islands-middle"
                      alt="Профиль"
                      className={styles.avatar}
                    />
                  </button>
                </Link>
              </div>
            </div>
          </div>
        </div> {/* Конец контейнера */}
      </nav>
    </header>
  );
};

const HeaderIcon = ({ icon, count, label, href }) => {
  const getIcon = () => {
    switch(icon) {
      case 'cart':
        return (
          <svg viewBox="0 0 24 24" width="24" height="24">
            {/* SVG path для корзины */}
          </svg>
        );
      // Добавить остальные иконки здесь
      default:
        return null;
    }
  };

  return (
    <Link to={href} className={styles.navItem}>
      <div className={styles.iconContainer}>
        {getIcon()}
        {count > 0 && <span className={styles.badge}>{count}</span>}
      </div>
      <span className={styles.iconLabel}>{label}</span>
    </Link>
  );
};

export default Header;
