package esd.scos.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginValidator extends HttpServlet {
	
	static String userName;
	static String password;
	public static void main(String [] arg){
		System.out.println("�û�����"+userName);
		System.out.println("���룺"+password);
	}

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		//���SCOS�ͻ��˵�¼��������û�����������֤����֤�ɹ�����1�����򷵻�0
		userName = req.getParameter("userName");
		password = req.getParameter("password");
		
		
		if(check(userName) && check(password)){
			resp.setStatus(1);
		}else{
			resp.setStatus(0);
		}
	}

	public static boolean check(String str){
        String regex = "^[a-zA-Z0-9]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }
	
	

}
