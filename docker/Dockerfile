# Build stage
FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM amazoncorretto:17
ARG PROFILE=dev
ARG APP_VERSION=1.0.1

WORKDIR /app
COPY --from=build /build/target/shoppingmart-productservice-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8088

ENV DB_URL=jdbc:mysql://mysql-sql-shoppingmart-products-db:3306/products
ENV DB_PSWD=productdb
ENV DB_USERNAME=admin
ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}

CMD java -Dspring.profiles.active=${ACTIVE_PROFILE} \
         -Dspring.datasource.url=${DB_URL} \
         -Dspring.datasource.username=${DB_USERNAME} \
         -Dspring.datasource.password=${DB_PSWD} \
         -jar shoppingmart-productservice-0.0.1-SNAPSHOT.jar
