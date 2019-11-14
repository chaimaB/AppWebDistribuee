package filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class PostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run(){
		System.out.println("inside post filter");
		return null;
	}

	@Override
	public String filterType() {
		return "post filter";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
