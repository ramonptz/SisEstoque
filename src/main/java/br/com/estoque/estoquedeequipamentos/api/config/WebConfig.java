package br.com.estoque.estoquedeequipamentos.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

/*o HiddenHttpMethodFilter
 * é usado para interpretar as tags forms para metodos como delete,put e patch
 * para que quando chamado a tag <form th:method="DELETE"> 
 * 
 * ele automaticamente insere esta linha
 * <input th:action="@{...}" type="hidden" name="_method" value="DELETE">
 * por isso se faz necessario o bean hiddenHttpMethodFilter
 */

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}