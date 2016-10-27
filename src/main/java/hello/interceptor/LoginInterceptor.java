package hello.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by W28L30 on 2016/10/18.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (request.getSession().getAttribute("root") != null) {
//            return true;
//        }
//        response.sendRedirect("/login?next=".concat(request.getRequestURI())); //next at here is to remember the path of the request before login in, then after login if will jump to the page it request before
//        return  false;
//    }
}
