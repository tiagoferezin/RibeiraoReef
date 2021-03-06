/**
 * 
 */
package br.com.ribeiraoreefshop.config;

import java.util.Locale;

import javax.servlet.MultipartConfigElement;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import br.com.ribeiraoreefshop.interceptor.AutorizadorInterceptor;

/**
 * @author Tiago Ferezin Data: 13/08/2018
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "br.com.ribeiraoreefshop")
public class ConfiguracaoWeb extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		registry.viewResolver(viewResolver);

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
		localeInterceptor.setParamName("lang");

		AutorizadorInterceptor autorizador = new AutorizadorInterceptor();
		registry.addInterceptor(localeInterceptor);
		// registry.addInterceptor(autorizador);
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en_US"));
		return resolver;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/I18n/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations(
				"/static/");
	}

//	@Bean
//	public CommonsMultipartResolver multipartResolver() {
//		return new CommonsMultipartResolver();
//	}

	// @Bean
	// public MultipartConfigElement multipartConfigElement() {
	// MultipartConfigElement factory = new MultipartConfigElement
	//
	// factory.setMaxFileSize("500MB");
	// factory.setMaxRequestSize("500MB");
	// return factory.createMultipartConfig();
	// }
	
//	@Bean
//	public MultipartConfigElement multipartConfigElement(){
//	    MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
//	    multipartConfigFactory.setMaxFileSize("10MB");
//	    multipartConfigFactory.setMaxRequestSize("50MB");
//	    return multipartConfigFactory.createMultipartConfig();
//	}
	
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver commonsMultipartResolver(){
	    CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	    commonsMultipartResolver.setDefaultEncoding("utf-8");
	    commonsMultipartResolver.setMaxUploadSize(50000000);
	    return commonsMultipartResolver;
	}

}
