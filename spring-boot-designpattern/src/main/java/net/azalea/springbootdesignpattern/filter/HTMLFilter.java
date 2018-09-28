package net.azalea.springbootdesignpattern.filter;

import net.azalea.springbootdesignpattern.pattern.FilterChain;

/**
 * 处理html标记
 * @author user
 *
 */
public class HTMLFilter implements FilterChain {

	@Override
	public void doFilter(String request, String response, FilterChain filter) {
		//将字符串中出现的"<>"符号替换成"[]" ,后面添加的是便于我们观察代码执行步骤的字符串
		request = request.replace('<', '[').replace('>', ']');
		
		//打印请求信息
		System.out.println("HTMLFilter request:"+ request);
		//打印响应信息
		System.out.println("HTMLFilter response:"+response);
				
		filter.doFilter(request, response, filter);
		response += "---HTMLFilter()";
		
		
		
	}

}
