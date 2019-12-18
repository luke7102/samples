package com.luke.samples;

import org.junit.jupiter.api.*;

@DisplayName("Basic Annotation Test")
class BasicAnnotationsTest {

    @BeforeAll
    static void beforeAllTest() { // 반드시 static으로 선언
        System.out.println("@BeforeAll : 모든 테스트가 수행 전 한번만 실행");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach : 각 테스트 수행되기 전 실행");
    }

    @DisplayName("심플 성공 테스트1") // 테스트 이름
    @Test // 실제 테스트할 코드 부분
    void simpleSuccessTest1() {
        System.out.println("심플 성공 테스트1 테스트 완료");
    }

    @DisplayName("심플 성공 테스트2")
    @Test
    void simpleSuccessTest2() {
        System.out.println("심플 성공 테스트2 테스트 완료");
    }

    @Test
    @Disabled("아직 구현되지 않았음") // 테스트 제외
    void notImplementsTest() {

    }

    @AfterEach
    void afterEachTest() {
        System.out.println("@AfterEach : 각 테스트 수행 후 실행");
    }

    @AfterAll
    static void afterAllTest() { // 반드시 static으로 선언
        System.out.println("@AfterAll : 모든 테스트가 수행 후 한번만 실행");
    }
}
