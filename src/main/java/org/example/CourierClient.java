package org.example;

import io.qameta.allure.Description; // импорт Description
import io.qameta.allure.Step; // импорт Step
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierClient {

    public CourierClient() {

        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    @Step("Метод для шага Создание курьера")
    @Description("POST на ручку /api/v1/courier")
    public Response createCourier(Courier courier) {
        return
                // метод given() помогает сформировать запрос
                given()
                        .header("Content-type", "application/json") // Строка указывает, что данные в теле запроса передаются в формате JSON
                        .and()
                        .body(courier)
                        .when()
                        // отправляем POST-запрос с помощью метода post, недостающую часть URL (ручку) передаём в него в качестве параметра
                        .post("/api/v1/courier");


    }

    @Step("Авторизация курьера в системе")
    @Description("POST на ручку /api/v1/courier/login")
    public Response loginCourier(Courier courier) {
        return
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(courier)
                        .when()
                        .post("/api/v1/courier/login");
    }

    @Step("Удалить курьера из системы")
    @Description("DELETE на ручку /api/v1/courier/:id")

    public void deleteCourier(Courier courier) {
        try {
            int id = loginCourier(courier).then().extract().path("id");


            given()
                    .header("Content-type", "application/json")
                    .and()
                    .body(courier)
                    .when()
                    .delete("/api/v1/courier/" + id);

        } catch (NullPointerException e) {
            System.out.println("Нечего удалять после теста");
        }
    }

}
