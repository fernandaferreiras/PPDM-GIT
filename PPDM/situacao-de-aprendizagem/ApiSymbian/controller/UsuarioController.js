const express = require("express");

const usuario = require("../model/Usuario");

const router = express.Router();

router.post("/usuario/cadastrarUsuario", (req, res) => {
  const { nome, sobrenome, email, celular } = req.body;

  usuario
    .create({
      nome,
      sobrenome,
      email,
      celular,
    })
    .then(() => {
      res.status(200).json({ MSG: "USUÁRIO INSERIDO COM SUCESSO!" });
    });
});

module.exports = router;
