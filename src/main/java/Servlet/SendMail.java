package Servlet;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import Model.User;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/sendmail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
	List<User> list = dao.fillAll();
	public SendMail() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/user/forgot.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String email = "huyhoike@gmail.com";
		final String password = "hoangquochuyh123";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		int i=0;
		for (User u : list) {
			if (u.getEmail().equals(request.getParameter("email"))) {
				i++;
				String emailTo = request.getParameter("email");
				System.out.println(request.getParameter("email"));
				String title = "From Trailer Movie";
				String text = "Your password is: " + u.getPassword();
				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(email));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
					message.setSubject(title);
					message.setText(text);
					Transport.send(message);
					System.out.println("done!");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				request.setAttribute("alert", "Mật khẩu đã gửi đến email");
				response.sendRedirect(request.getContextPath() + "/user/login");
			}
		}
		if(i==0) {
			request.setAttribute("mss", "Sai email");
			response.sendRedirect(request.getContextPath()+"/sendmail");
		}
	}

}
