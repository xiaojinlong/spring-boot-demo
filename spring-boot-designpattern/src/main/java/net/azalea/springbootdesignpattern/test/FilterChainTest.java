package net.azalea.springbootdesignpattern.test;

import net.azalea.springbootdesignpattern.filter.HTMLFilter;
import net.azalea.springbootdesignpattern.filter.SensitiveFilter;
import net.azalea.springbootdesignpattern.pattern.BaseFilterChain;

public class FilterChainTest {

	public static void main(String[] args) {
		 //设定过滤规则，对msg字符串进行过滤处理
		String request = ":):,<script>,敏感,被就业,网络授课";
		String response = "response:";
		
		BaseFilterChain bfc = new BaseFilterChain();
		bfc.addFilterChain(new HTMLFilter())
		   .addFilterChain(new SensitiveFilter());
		
		bfc.doFilter(request, response, bfc);
		
	}

}
