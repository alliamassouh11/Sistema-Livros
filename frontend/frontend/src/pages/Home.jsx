export default function Home() {
  return (
    <main className="container">
      <section className="card">
        <h1>Tribunal Superior Eleitoral </h1>
        <h2>Sistema de empréstimos de Livros </h2>
        
        <p>
          Organize e controle empréstimos de livros de forma segura e eficiente.
        </p>

        <div className="buttons">
          <button className="btn-primary" title="Acessar o sistema">
            Entrar no Sistema
          </button>
          <button className="btn-secondary" title="Ver livros disponíveis">
            Explorar Catálogo
          </button>
        </div>
      </section>
    </main>
  );
}