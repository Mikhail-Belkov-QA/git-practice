package API;

import API.colors.ColorsData;

import API.registration.Register;
import API.registration.SuccesReg;
import API.registration.UnSuccesReg;
import API.specifications.Specifications;
import API.users.UserData;
import API.users.UserTime;
import API.users.UserTimeResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.Assert;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    @DisplayName("Метод GET - убеждаемся , что пользователи содержат аватары")
    public void checkAvatarAndIdTest (){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<UserData> users = given()
                .when()
              //  .contentType(ContentType.JSON)
              //  .get(URL + "api/users?page=2")
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
//int i = 0;
       users.forEach(x-> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));

      Assertions.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));

       List<String> avatars = users.stream().map(UserData :: getAvatar).collect(Collectors.toList());

       List<String> ids = users.stream().map(x-> x.getId().toString()).collect(Collectors.toList());
       for (int i = 0; i<avatars.size(); i++){
    Assertions.assertTrue(avatars.get(i).contains(ids.get(i)));

        }

    }
    @Test
    @DisplayName("Метод POST - успешное создание аккаунта ")
    public void successReqTestPost(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccesReg succesReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccesReg.class);

        Assertions.assertNotNull(succesReg.getId()); //убеждаемся сначала что нам приходит не пустой результат
        Assertions.assertNotNull(succesReg.getToken());
        Assertions.assertEquals(id, succesReg.getId());
        Assertions.assertEquals(token, succesReg.getToken());

    }

    @Test
    @DisplayName("Метод POST - создание аккаунта без пароля ошибка 400")
    public void unSuccessRegTestPost(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError400());

        Register user = new Register("sydney@fife", "");
        UnSuccesReg unSuccesReg = given()
                .body(user)
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccesReg.class);
        Assertions.assertEquals("Missing password", unSuccesReg.getError());

    }
    @Test
    @DisplayName("Метод GET - сортировка по годам")
    public void sortedYearsTestGet(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<ColorsData> colors = given()
                .when()
                .get("api/unknow")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);

        List<Integer> years = colors.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        Assertions.assertEquals(sortedYears, years);
        //просто убеждаемся визуально
        System.out.println(years);
        System.out.println(sortedYears);

    }
    @Test
    @DisplayName("Метод DELETE - удаление второго пользователям")
    public void deleteUserTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();



    }
    @Test
    @DisplayName("Метод PUT - проверка совпадения времени")
    public void timeTestPut(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());

        UserTime user = new UserTime("morpheus", "zion resident");
        UserTimeResponse response = given()
                .body(user)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);
        String regex = "(.{5})$"; //регулярно выражение, заменяем крайние (последние) 5 цифр
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex, "");
        System.out.println(currentTime);

        Assertions.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex, ""));
        System.out.println(response.getUpdatedAt().replaceAll(regex, ""));


    }



}
