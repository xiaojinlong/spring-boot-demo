package net.azalea.springbootdesignpattern.filter;

import net.azalea.springbootdesignpattern.pattern.FilterChain;

/**
 * 过滤敏感字符
 * @author user
 *
 */
public class SensitiveFilter implements FilterChain {

	@Override
	public void doFilter(String request, String response, FilterChain filter) {
		//处理字符串中的敏感信息，将被就业和谐成就业
		request = request.replace("被就业", "就业").replace("敏感", "");
		filter.doFilter(request, response, filter);
		response += "---sensitiveFilter()";
		
		//打印请求信息
		System.out.println("SensitiveFilter request:"+request);
		//打印响应信息
		System.out.println("SensitiveFilter response:"+response);
}

}
