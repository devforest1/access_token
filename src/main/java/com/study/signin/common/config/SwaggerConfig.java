package com.study.signin.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    // SecurityScheme 명
    private final String SECURITY_SCHEME_NAME = "authorization";

    // 스웨거 설정
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .addSecurityItem(securityRequirement())
                .components(components());
    }

    // 스웨거 문서 제목, 설명, 버전 정보
    private Info apiInfo() {
        return new Info()
                .title("AccessToken API")
                .description("Swagger API 인터페이스 정의서")
                .version("1.0.0");
    }

    // 스웨거 토큰 적용
    private SecurityRequirement securityRequirement() {
        return new SecurityRequirement().addList(SECURITY_SCHEME_NAME);
    }

    // 스웨거 Components 설정
    private Components components() {
        return new Components()
                .addSecuritySchemes(SECURITY_SCHEME_NAME, new SecurityScheme()
                        .name(SECURITY_SCHEME_NAME)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT"));
    }
}
