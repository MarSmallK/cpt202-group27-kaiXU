//package group27.xukai.cpt202b.Configuration;
//
//import group27.xukai.cpt202b.Intercepter.LoginInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Configuration
//public class WebMVCConfiguation implements WebMvcConfigurer {
//    // 定义排除的路径列表
//    private static List<String> excludePathList = Arrays.asList("/login");
//
//    // 注入LoginInterceptor拦截器
//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 将LoginInterceptor添加到拦截器注册表中
//        registry.addInterceptor(loginInterceptor)
//                // 对所有路径进行拦截
//                .addPathPatterns("/**")
//                // 排除excludePathList中的路径
//                .excludePathPatterns(excludePathList);
//    }
//}
