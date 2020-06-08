package com.demo.component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * @Author kyrie
 * @Date 2020/5/15
 */
@Component
public class MyFilter extends ZuulFilter {
    /**
     * 返回过滤器的类型,过滤器类型如下:
     * pre: 请求路由之前调用过滤
     * routing: 请求routing时调用过滤
     * post: 请求路由之后调用过滤
     * error: 发送错误时调用过滤
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否要过滤, true表示永远过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑可以在改方法中处理有没有权限访问等
     */
    @Override
    public Object run() {
        //获取请求对象
        RequestContext ctx = RequestContext.getCurrentContext();
        Object pass = ctx.getRequest().getParameter("pass");
        if (pass == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("pass is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
