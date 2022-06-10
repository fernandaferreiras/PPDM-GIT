const Sequelize = require('sequelize');

const connection = require('../database/database');

const Usuario = connection.define(
    'tbl_usuario',
    {
        cod_usuario:{
            type: Sequelize.INTEGER(10),
            primaryKey: true,
            autoIncrement: true
        },
        nome:{
            type:Sequelize.STRING(500),
            allowNull: false
        },
        sobrenome:{
            type:Sequelize.STRING(500),
            allowNull: false
        },
        email:{
            type:Sequelize.STRING(500),
            allowNull: false
        },
        celular:{
            type:Sequelize.STRING(500),
            allowNull: false
        }
    }
);

// Usuario.sync({force:true});

module.exports = Usuario;