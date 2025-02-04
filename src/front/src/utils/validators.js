// Валидация форм

export const validateEmail = (email) => /\S+@\S+\.\S+/.test(email);
export const validatePasswordStrength = (password) =>
    password.length >= 6; // Пример простой валидации пароля
