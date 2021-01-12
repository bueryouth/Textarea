package exam.Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*	*	*	*	*	*	*
 * 不二青年i	文本处理测试	*
 *	*	*	*	*	*	*/
@WebServlet("/test01")
public class test01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public test01() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // 输出
		String key = null; // 答案
		String str = request.getParameter("comment"); // 接收文本
		str = new String(str.getBytes("iso8859-1"), "utf-8"); // 解决中文乱码
		str = str.replace("\r\n", "<br/>").replace("（", "(").replace("）", ")"); // 替换换行符，显示换行
		if (str.indexOf("(") != -1 && str.indexOf(")") != -1) {
			for (int i = 0; i < str.length(); i++) {
				if (str.substring(i, i + 1).equals("(")) {
					for (int j = 0; j < 10; j++) {
						if (str.substring(i + j, i + j + 1).equals(")")) {
							String x = str.substring(i + 1, i + j).trim();
							if (x.equals("A") || x.equals("B") || x.equals("C") || x.equals("D")) {

								if (key == null) {
									key = str.substring(i + 1, i + j).trim(); // 提取答案
								} else {
									key = key + str.substring(i + 1, i + j).trim(); // 提取答案
								}
								str = str.substring(0, i + 1).concat(str.substring(i + j)); // 删除答案
								/* replaceAll(" +"," ")把多个空格替换成一个//replace(" ", "<br/>")替换空格换行 */
							}
							break;
						}
					}
				}
			}
//			key=str.substring(str.indexOf("(")+1, str.indexOf(")")).trim();	//提取答案
//			out.println(key+"<br/>");	//显示答案
//			str=str.substring(0,str.indexOf("(")+1).concat(str.substring(str.indexOf(")")));	//删除答案
//			/*replaceAll(" +"," ")把多个空格替换成一个//replace(" ", "<br/>")替换空格换行*/
//			str=str.replaceAll(" +"," ").replace(" ", "<br/>");
		}
		if(key != null) {
			out.println(key + "<br/>"); // 显示答案
		}
		str = str.replaceAll(" +", " ").replace(" ", "<br/>"); // 显示题目
		out.println(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
