package cn.edu.tju.cs.lab.oaweb.rest.services;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
/**
 * 
 * @author rcl
 * 应用程序类
 * 使用register(XXXXResource.class)来注册rest Resource
 */
public class ServiceApplication extends ResourceConfig {
	public ServiceApplication()
	{
		register(RequestContextFilter.class);
		register(GreetingResource.class);
		register(JacksonFeature.class);

	}
}
