import { useState } from "react";
import axios from "axios";

export default function Home() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/livros",
        {
          auth: {
            username,
            password
          }
        }
      );

      if (response.status === 200) {
        alert("Login realizado com sucesso!");
      }
    } catch (error) {
      alert("Usuário ou senha inválidos.");
    }
  };

  return (
    <main className="container">
      <section className="card">
        <h1>Controle de Empréstimos</h1>

        <input
          type="text"
          placeholder="Usuário"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />

        <input
          type="password"
          placeholder="Senha"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <button onClick={handleLogin}>
          Entrar
        </button>
      </section>
    </main>
  );
}
