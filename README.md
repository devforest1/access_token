### 프로젝트 소개

환자등록, 방문등록 등 API 기능을 구현한 프로젝트입니다.

### 개발 구성

- JDK : 17
- Language : Java
- IDE : IntelliJ
- H2 database

### 사용 플러그인

```groovy
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.h2database:h2'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'

	// swagger
	implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0'
	// validation
	implementation 'org.springframework.boot:spring-boot-starter-validation'

	// JWT
	implementation 'io.jsonwebtoken:jjwt-api:0.11.5'
	runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.11.5'
	runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.11.5'

	// JSON
	implementation 'org.json:json:20231013'
	implementation 'com.fasterxml.jackson.core:jackson-databind:2.16.1'
	implementation 'com.fasterxml.jackson.core:jackson-core:2.16.1'

	// AOP
	implementation 'org.springframework.boot:spring-boot-starter-aop'
```

### 기능

[[메인기능]]
- 회원가입
- 로그인

[[그외기능]]
- Swagger로 API 인터페이스 정의서 작성
- LogConfig를 이용해 Logging 처리를 AOP 적용
- 스프링 시큐리티 적용
- 로그인 시 액세스 토큰 발행
  
