package org.koreait;

import org.koreait.member.MemberDao;
import org.koreait.member.MemberRegisterService;

public class Main2 {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		MemberRegisterService service = new MemberRegisterService(memberDao);

	}

}
