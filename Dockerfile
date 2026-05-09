# Estágio 1: Build (utilizando o Maven)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o pom.xml e baixa as dependências (melhora o uso de cache do Docker)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte e compila o projeto
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Execução (imagem mais leve, apenas com o JRE)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia o JAR gerado no estágio anterior
COPY --from=build /app/target/jogo-das-senhas-1.0-SNAPSHOT.jar app.jar

# Expõe a porta do Registry RMI (padrão 1099) e a porta do objeto remoto (ex: 1100)
EXPOSE 1099 1100

# Executa a aplicação
# NOTA: A propriedade java.rmi.server.hostname é vital para o RMI funcionar no Docker.
ENTRYPOINT ["java", "-Djava.rmi.server.hostname=127.0.0.1", "-jar", "app.jar"]