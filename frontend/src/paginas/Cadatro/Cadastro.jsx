import axios from "axios";
import { useState } from "react";

function Cadastro() {

  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [nome, setNome] = useState("");

  const cadastrar = async () => {
    try {
      await axios.post("http://localhost:8080/auth/register", {
        name: nome,
        email: email,
        passwordHash: senha
      });

      alert("Usuário cadastrado com sucesso!");
    } catch (error) {
      alert("Erro ao cadastrar.");
    }
  };

  return (
    <div>
      <input placeholder="Nome" onChange={e => setNome(e.target.value)} />
      <input placeholder="Email" onChange={e => setEmail(e.target.value)} />
      <input type="password" placeholder="Senha" onChange={e => setSenha(e.target.value)} />
      <button onClick={cadastrar}>Cadastrar</button>
    </div>
  );
}

export default Cadastro;