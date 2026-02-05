# Sistema-de-Controle-de-Emprestimos-de-Livros


# Descrição

Este projeto consiste no desenvolvimento de um Sistema de Controle de Empréstimos de Livros para uma biblioteca escolar, com o objetivo de organizar, registrar e acompanhar o ciclo de empréstimos e devoluções de obras, garantindo integridade dos dados, controle de acesso e rastreabilidade das operações.

A aplicação foi projetada para oferecer uma experiência simples para usuários finais, ao mesmo tempo em que fornece ferramentas operacionais seguras para os perfis responsáveis pela gestão dos empréstimos.

O sistema implementa regras de negócio claras, controle de permissões baseado em perfis e persistência em banco de dados relacional, seguindo boas práticas de desenvolvimento de software.

# Objetivos do Sistema

Controlar o empréstimo e a devolução de livros

Garantir que um livro não seja emprestado mais de uma vez simultaneamente

Manter o status das obras sempre atualizado

Controlar o acesso às funcionalidades conforme o perfil do usuário

Registrar operações críticas para fins de auditoria

# Perfis de Acesso

O sistema possui três perfis de usuários, cada um com permissões específicas:

# Usuário

Visualizar o catálogo de livros

Consultar o status das obras (disponível, emprestado ou indisponível)

Visualizar detalhes dos livros

# Apoio

Visualizar o catálogo

Liberar empréstimos

Registrar devoluções e encerrar empréstimos

Não possui permissão para cadastro ou edição de livros

# Administrador

Cadastrar novos livros

Editar informações de livros

Excluir ou inativar livros

Liberar empréstimos

Registrar devoluções

Gerenciar o ciclo completo do sistema

# Funcionalidades Principais

Cadastro, edição e exclusão de livros

Consulta ao catálogo de obras

Registro de empréstimos vinculados a usuários

Registro de devoluções

Controle automático da disponibilidade dos livros

Aplicação de regras de negócio

Controle de acesso baseado em perfil

Registro de logs de operações críticas


Apenas usuários com perfil Administrador ou Apoio podem liberar empréstimos

Apenas o perfil Administrador pode cadastrar, editar ou excluir livros

Toda operação de empréstimo e devolução gera um registro com data, hora e usuário responsável
