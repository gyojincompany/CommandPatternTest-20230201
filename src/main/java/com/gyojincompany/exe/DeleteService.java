package com.gyojincompany.exe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String sessionId = (String) session.getAttribute("memberId");
		
		MemberDao dao = new MemberDao();
		
		dao.delete(sessionId);

	}

}
