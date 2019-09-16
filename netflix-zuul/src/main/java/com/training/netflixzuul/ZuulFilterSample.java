/**
 * 
 */
package com.training.netflixzuul;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author dipesh
 *
 */
public class ZuulFilterSample extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		System.out.println(RequestContext.getCurrentContext().getRequest().getRequestURI());
		System.out.println("zull Gateway ");
		HttpServletRequest request = ctx.getRequest();
		String userName = request.getHeader("user");
		String authorizationKey = request.getHeader("authorization");
		// String[] userTokens = authorizationKey.split(" ", 2);
		// authorizationKey=userTokens[1];
		return null;
	}

	@Override
	public String filterType() {

		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
