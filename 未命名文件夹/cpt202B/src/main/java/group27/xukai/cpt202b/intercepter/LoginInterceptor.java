//package group27.xukai.cpt202b.Intercepter;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import java.util.Arrays;
//import java.util.List;
//import java.io.IOException;
//
//
//@Slf4j
//@Component
//public class LoginInterceptor implements HandlerInterceptor {
//    public static boolean a = false;
//    public static void success(boolean k){
//        a = true;
//    }
//    private static final List<String> ALLOWED_PATH_LIST = Arrays.asList(
//            "/favicon.ico","/error","/","/styles.css","/resetpassword","/login","/emailexist","/oldpassword","/code","/register","/managerlogin","/verifycode","/register.html", "/index.html", "/userlogin.html", "/forgetpassword.html", "/resetpassword.html", "/managerlogin.html");
//
//
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//        // 获取请求的URL路径
//        String requestURI = request.getRequestURI();
//
//        // 检查是否是允许访问的路径
//        if (ALLOWED_PATH_LIST.contains(requestURI)) {
//            // 如果是允许访问的路径，直接放行
//            return true;
//        }
//
//        // 检查用户是否已登录
//        if (a) {
//            // 如果用户已登录，则放行请求
//            return true;
//        }
//
//        // 打印拦截信息
//        log.info("拦截请求：" + requestURI);
//        // 这里可以根据需要进行处理，比如重定向到登录页面
//        response.sendRedirect("/index.html");
//        // 返回false表示拦截该请求
//        return false;
//    }
//}

