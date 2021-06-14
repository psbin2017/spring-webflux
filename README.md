# spring webflux

## 001-Building a Reactive RESTful Web Service

- [reference](https://spring.io/guides/gs/reactive-rest-service/)

1. Webflux 핸들러 생성
2. 라우터 생성
3. WebClient 생성

## 002-Annotated Controllers

- [document - Annotated Controllers](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-controller)

`@PathVariable` 를 통한 경로 값.

1. `{onlyPath}`: 가장 심플한 형태
2. `{regexPath:[a-z]+}`: 정규 표현식을 사용한 형태
3. `{*endPath}`: 항상 마지막 경로를 포함하는 형태 (중간 모든 경로를 포함)

```http request
GET http://localhost:8080/hello/world/well/come/to/my/application
```

요청/응답에 대한 미디어 타입을 지정

- consumes: 요청 Content-Type
- produces: 응답 Content-Type

```http request
POST http://localhost:8080/mediaType
Content-Type: application/json
```

요청에 대한 필수 헤더와 필수 파라미터

- params: 쿼리 스트링
- headers: 헤더

```http request
DELETE http://localhost:8080/required?myParam=myValue
myHeader: myValue
```
