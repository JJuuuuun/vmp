package com.toyproject.vending_machine.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "id"/*제외*/ /*of = "name" of만*/, callSuper = true/*parent's toString()*/)
@EqualsAndHashCode
public class TestVO {

    @NonNull
    private String id;
    private String name;

//    @Cleanup : try - finally 에서 close() 호출
//    @Synchronized :
//      > 자바의 synchronized를 사용할 때 deadlock이 발생하는 경우가 종종 발생하는걸 방지하기 위해
//          Lombok이 메소드가 실행되기 전에 잠글 $ lock이라는 개인 잠금 필드를 생성한다.
//      > lock 오브젝트를 자동으로 생성, synchronized를 손쉽게 사용할수 있게 해준다.

//    @Data : @Getter, @Setter, @NonNull, @EqualsAndHashCode, @ToString 에 대한 걸 모두 해주는 Annotation
//      > @NonNull 또는 final 필드를 매개변수로 사용하는 public 생성자가 생성된다.
//      > @Data는 staticConstructor 하나의 파라미터 옵션만 제공하는데, 파라미터를 이름으로 하는 static factory 메서드를 생성하여 준다.
//      > ex) @Data(staticConstructor="of")

//    @Value : Value는 Immutable Class을 생성해준다.
//      > @Data와 비슷하지만 모든 필드를 기본적으로 Private 및 Final로 로 하고, Setter 함수를 생성하지 않고, Class또한 Final로 지정하는 것만 빼고 동일하다.
//
//    @Slf4j, @Log 등
//      > 해당 어노테이션을 클래스에 선언하면, log관련 static 메소드를 클래스 별로 선언할 필요가 없다.
//
//    @Builder
//      > 어노테이션을 클래스에 선언하면 생성자 대신에 빌더를 사용할 수 있다.
//      > @Singular : collection 타입에 선언하게 되면 파라미터를 하나씩 추가할 수 있다.

        /*
            TestVo test = TestVo.builder().id("jun")
                                        .name("juun")
                                        .listTest("list")
                                        .listTest("List Test")
                                        .maps("age", "20")
                                        .maps("gender", "male")
                                        .build();
        */

}
