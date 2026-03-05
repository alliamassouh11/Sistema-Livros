import { useState } from "react"
import axios from "axios"

export default function App() {

  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")

  const handleLogin = async () => {

    try {

      const response = await axios.get(
        "http://localhost:8080/livros",
        {
          auth: {
            username: email,
            password: password
          }
        }
      )

      alert("Login realizado com sucesso!")

    } catch (error) {
      alert("Email ou senha inválidos")
    }

  }

  return (
    <div>

      <h2>Login</h2>

      <input
        type="text"
        placeholder="Email"
        onChange={(e)=>setEmail(e.target.value)}
      />

      <input
        type="password"
        placeholder="Senha"
        onChange={(e)=>setPassword(e.target.value)}
      />

      <button onClick={handleLogin}>
        Entrar
      </button>

    </div>
  )
}