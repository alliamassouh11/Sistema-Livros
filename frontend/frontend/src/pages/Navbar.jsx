export default function Navbar() {
  return (
    <header className="main-header">
      {/* Barra superior fina (Acessibilidade/Ouvidoria) */}
      <div className="top-bar">
        <div className="container-nav">
          <span>Acessibilidade</span>
          <span>Ouvidoria</span>
        </div>
      </div>

      {/* Menu Principal */}
      <nav className="navbar">
        <div className="container-nav">
          <div className="logo">
            <div className="logo-icon"></div>
            <div className="logo-text">
              <strong>TSE</strong>
              <span>Biblioteca</span>
            </div>
          </div>

          <ul className="nav-links">
            <li>Acervo</li>
            <li>Empréstimos</li>
            <li>Minha Conta</li>
            <li className="search-icon">🔍</li>
          </ul>
        </div>
      </nav>

      {/* Breadcrumb (Caminho da página) */}
      <div className="breadcrumb">
        <div className="container-nav">
          🏠 / Institucional / <strong>Biblioteca</strong>
        </div>
      </div>
    </header>
  );
}