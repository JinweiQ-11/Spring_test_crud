package com.itheima.interceptor;

import com.itheima.domain.User;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/4/16 23:31
 * @description：
 * @modified By：
 * @version: $
 */
public class PrivilegeInterceptor implements HandlerInterceptor {
         @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
             HttpSession session = request.getSession();
             User user  = (User) session.getAttribute("user");
             if (user == null){
                 response.sendRedirect(request.getContextPath() + "/login.jsp");
                 return  false;
             }
             return true;
    }
    // 返回之前可以修改视图
    // 方法执行 视图返回之前
    @Override
     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle running...");
    }
    @Override
    // 流程执行之后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion running...");
    }
}
