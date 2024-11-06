# Usa uma imagem do Maven com JDK 17 para construção
FROM maven:3.8.1-openjdk-17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o código para dentro do contêiner
COPY . .

# Compila o projeto
RUN mvn clean package -DskipTests

# Usa uma imagem do OpenJDK 17 para rodar o JAR
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/cartoes-ms-0.0.1-SNAPSHOT.jar /cartoes-ms.jar

# Expõe a porta 8081
EXPOSE 8081

# Comando para iniciar o serviço
ENTRYPOINT ["java", "-jar", "/cartoes-ms.jar"]
