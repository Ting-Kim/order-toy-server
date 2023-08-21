package com.example.ordertoy.web.event;

import com.example.ordertoy.domain.event.DomainEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
public class ConfigBasedEventWrapperFactoryTest {

  @Autowired
  ConfigBasedEventWrapperFactory configBasedEventWrapperFactory;

  @Test
  @DisplayName("팩토리 내부 Map이 정상적으로 초기화되어야 한다")
  void postConstructTest() {
    // when
    Map<Class<? extends DomainEvent<?>>, Function<BaseDomainWrappedEvent, DomainWrappedEvent<?>>> wrapperMappings =
        (HashMap<Class<? extends DomainEvent<?>>, Function<BaseDomainWrappedEvent, DomainWrappedEvent<?>>>) ReflectionTestUtils.getField(configBasedEventWrapperFactory, "wrapperMappings");

    // then
    Assertions.assertThat(wrapperMappings)
              .isNotEmpty();

  }
}
