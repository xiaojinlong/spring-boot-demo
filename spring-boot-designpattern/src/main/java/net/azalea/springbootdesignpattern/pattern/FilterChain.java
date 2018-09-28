package net.azalea.springbootdesignpattern.pattern;

public interface FilterChain {
	void doFilter(String request, String response , FilterChain filter);
}
