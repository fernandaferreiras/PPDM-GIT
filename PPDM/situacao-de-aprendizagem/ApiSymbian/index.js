const express = require('express');

const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const usuarioController = require('./controller/UsuarioController');
app.use('/', usuarioController);

app.listen(3000, ()=>{ 
    console.log('SERVIDOR RODANDO NA URL: http://localhost:3000'); 
});