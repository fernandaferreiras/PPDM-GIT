/** IMPORTA O PACOTE SEQUELIZE PARA A APLICAÇÃO **/
const sequelize = require('sequelize');

/** IMPORTA O ARQUIVO DE CONEXÃO COM O BANCO DE DADOS **/
const connection = require('../database/database');

/** REPRESENTA O MODELO DA TABELA DE DADOS DE USUÁRIO 
 define - CRIA A REPRESENTAÇAO DA TABELA.
 PARAMETROS:
 1 - NOME DA TABELA;
 2 -  OBJETO JSON QUE VAI CONTER OS CAMPOS DA TABELA, SEUS
      TIPOS E REGRAS.
  
 **/
const Usuario = connection.define(
    'tbl_usuario', {
        cod_usuario: {
            type: sequelize.INTEGER(10),
            primaryKey: true,
            autoIncrement: true
        },
        nome: {
            type: sequelize.STRING(500),
            allowNull: false
        },
        sobrenome: {
            type: sequelize.STRING(500),
            allowNull: false
        },
        email: {
            type: sequelize.STRING(500),
            allowNull: false
        },
        foto: {
            type: sequelize.STRING(500),
            allowNull: false
        },
        login: {
            type: sequelize.STRING(50),
            allowNull: false
        },
        senha: {
            type: sequelize.STRING(50),
            allowNull: false
        }
    }
);

// Usuario.sync({
//     force: true
// });  

module.exports = Usuario;