package itfbstudy.bookservice.metrics;

import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {

    @Bean
    CountedAspect countedAspect(MeterRegistry registry){
        return new CountedAspect(registry);
    }
    @Bean
    MeterRegistry registry(){
        return new SimpleMeterRegistry();
    }
}