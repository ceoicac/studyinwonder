package spring.chapter04.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * javaConfig中启用AspectJ注解的自动代理
 * @author Administrator
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {
	@Bean
	public Audience audience(){
		return new Audience();
	}
}
