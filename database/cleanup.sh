#!/bin/bash

echo "🚀 Iniciando a limpeza total do Docker..."

# --- 1. Remover todos os Contêineres (Parados e em Execução) ---
echo "🛑 Parando e removendo todos os contêineres..."
# Primeiro tenta parar todos os contêineres em execução
docker stop $(docker ps -aq) 2>/dev/null
# Depois remove todos os contêineres (parados e os que acabaram de ser parados)
docker rm -f $(docker ps -aq) 2>/dev/null

if [ $? -eq 0 ]; then
    echo "✅ Contêineres removidos com sucesso."
else
    echo "⚠️ Nenhum contêiner para remover ou erro ocorreu."
fi

echo "---"

# --- 2. Remover todas as Imagens (Untagged e em Uso/Não Usadas) ---
# O comando 'docker rmi' falhará se tentar remover uma imagem usada por um contêiner
# que não foi removido. No entanto, já removemos todos os contêineres acima.
echo "🗑️ Removendo todas as imagens (incluindo as não marcadas/dangling)..."
docker rmi -f $(docker images -aq) 2>/dev/null

if [ $? -eq 0 ]; then
    echo "✅ Imagens removidas com sucesso."
else
    echo "⚠️ Nenhuma imagem para remover ou erro ocorreu."
fi

echo "---"

# --- 3. Limpeza Geral com 'docker system prune' (Volumes, Redes, Cache) ---
# Esta é a ferramenta mais agressiva e abrangente.
# -a: remove todos os contêineres e imagens não usados, não apenas os "dangling".
# -f: força a execução sem prompt de confirmação.
# --volumes: inclui volumes (o que não é padrão no prune normal).
echo "🧹 Executando 'docker system prune' para remover volumes, redes e caches não utilizados..."
docker volume rm -f $(docker volume ls -q) 2>/dev/null
echo "✅ Volumes gerenciados pelo Docker removidos."
echo "---"

docker system prune -a -f --volumes

if [ $? -eq 0 ]; then
    echo "✅ Limpeza geral (volumes, redes, cache) concluída."
else
    echo "⚠️ Erro durante a execução de 'docker system prune'."
fi

echo "---"

echo "✨ Limpeza do Docker concluída! Seu ambiente está fresquinho."
