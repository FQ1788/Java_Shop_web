package tw.com.demo.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncoddingFilter
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "Encoddoing", value = "UTF-8")
		})
public class EncoddingFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	private FilterConfig fConfig;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//取得私有化參數內的值(value)		
		String utf=fConfig.getInitParameter("Encoddoing");
		//將傳送進來的請求轉換編碼成UTF-8
		request.setCharacterEncoding(utf);
		//將回應的內容編碼轉換成text/html; charset=UTF-8的形式
		//response.setContentType("text/html; charset="+utf);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//取得初始化參數並設定到私有參數內
		this.fConfig = fConfig;
	}

}
