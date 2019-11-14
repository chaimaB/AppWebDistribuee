package filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class RouteFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("Inside route filter");
		return null;
	}

	@Override
	public String filterType() {
		return "route filter";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
