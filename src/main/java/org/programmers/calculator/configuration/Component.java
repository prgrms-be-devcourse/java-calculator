package org.programmers.calculator.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 현재 기능은 오브젝트 컨테이너 관리할 대상임을 표시하는 용도입니다.
 * 구현 클래스가 아닌 인터페이스에만 적용됩니다.
 */
@Target(value = ElementType.TYPE)
public @interface Component {
}
