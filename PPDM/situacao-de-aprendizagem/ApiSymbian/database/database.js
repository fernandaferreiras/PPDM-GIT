const Sequelize = require('sequelize');

const connection = new Sequelize('Symbian', 'root', '12345678', {
    host: 'localhost',
    dialect: 'mysql',
    timezone: '-03:00'
});

module.exports = connection;