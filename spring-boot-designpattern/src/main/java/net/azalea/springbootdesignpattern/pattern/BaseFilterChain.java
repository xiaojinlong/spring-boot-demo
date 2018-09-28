package net.azalea.springbootdesignpattern.pattern;

import java.util.ArrayList;
import java.util.List;

public class BaseFilterChain implements FilterChain {

	//用List集合来存储过滤规则
	private List<FilterChain> filters = new ArrayList<FilterChain>();
	
	//用于标记规则的引用顺序
	private int index = 0;
	
	//往规则链条中添加规则
	public BaseFilterChain addFilterChain(FilterChain filterChain){
		filters.add(filterChain);
		//代码的设计技巧:Chain链添加过滤规则结束后返回添加后的Chain，方便我们下面doFilter函数的操作
		return this;
	}
	
	@Override
	public void doFilter(String request, String response, FilterChain filter) {
		// TODO Auto-generated method stub
		if (index == filters.size()){
			return ;
		}
		
		FilterChain f = filters.get(index);
		
		index++;
		 //根据索引值获取对应的规律规则对字符串进行处理
		f.doFilter(request, response, filter);
	}

}
