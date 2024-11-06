# Usa uma imagem do Node para construção
FROM node:14 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o package.json e instala as dependências
COPY package*.json ./
RUN npm install

# Copia o restante do código
COPY . .

# Constrói o projeto
RUN npm run build

# Usa uma imagem de Nginx para servir os arquivos estáticos
FROM nginx:alpine
COPY --from=build /app/build /usr/share/nginx/html

# Expõe a porta 80 para o Nginx
EXPOSE 80

# Inicia o Nginx
CMD ["nginx", "-g", "daemon off;"]
