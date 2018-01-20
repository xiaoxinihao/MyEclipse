package cn.xiaoxi.select;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xiaoxi.util.SmsVerification;

@SuppressWarnings("serial")
@WebServlet(value="/VerifyMobilePhoneSelect")
public class VerifyMobilePhoneServlet extends HttpServlet {

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
		String phoneNumber= req.getParameter("phone");
		System.out.println(phoneNumber);
		if(phoneNumber.equals("")&&phoneNumber!=null){
		SmsVerification smsVerification = new SmsVerification();
 		   int num = smsVerification.getVerificationNum(phoneNumber);
		   //返回获取的验证码
		   resp.getWriter().print(num +"");
		}
	}
}
