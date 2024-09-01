#!/bin/bash

# Diretório onde os scripts de migração serão armazenados
MIGRATION_DIR="src/main/resources/db/migration"

# Verifica se o diretório de migração existe, se não, cria
if [ ! -d "$MIGRATION_DIR" ]; then
  echo "O diretório de migração não existe. Criando..."
  mkdir -p "$MIGRATION_DIR"
fi

# Solicita o nome do arquivo ao usuário
read -p "Digite o nome do arquivo (sem extensão): " MIGRATION_NAME

# Substitui espaços em branco por sublinhados
MIGRATION_NAME=$(echo "$MIGRATION_NAME" | tr ' ' '_')

# Obtém a data e hora atuais no formato YYYYMMDD_HHMMSS
TIMESTAMP=$(date +"%Y%m%d_%H%M%S")

# Define o nome do arquivo com o timestamp e o nome fornecido
FILE_NAME="V1_${TIMESTAMP}__${MIGRATION_NAME}.sql"

# Cria o arquivo SQL vazio no diretório de migração
FILE_PATH="${MIGRATION_DIR}/${FILE_NAME}"
touch "$FILE_PATH"

# Adiciona um comentário ao início do arquivo SQL
echo "-- insert your migration" > "$FILE_PATH"

# Confirma a criação do arquivo
echo "Arquivo de migração criado: $FILE_PATH"
