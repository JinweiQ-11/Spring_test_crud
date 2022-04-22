//package com.itheima.interceptor;
//
//import org.springframework.lang.Nullable;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author ：qinjinwei
// * @date ：Created in 2022/4/16 23:00
// * @description：
// * @modified By：实现拦截器
// * @version: $
// */
//
//public class MyInterceptor1 implements HandlerInterceptor {
//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         System.out.println("preHandle running2...");
//         //true 放行
//         return false;
//    }
//    @Override // 方法执行 视图返回之前
//    // 返回之前可以修改视图
//     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle running2...");
//    }
//    @Override
//    // 流程执行之后
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        System.out.println("afterCompletion running2...");
//    }
//
//}
