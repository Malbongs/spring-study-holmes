package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.GroupMember;
import model.StudyMember;
import model.StudyMenu;
import service.GroupMemberDao;
import service.NoticeDao;
import service.StudyMemberDao;
import service.StudyMenuDao;

@Controller
@RequestMapping("/studymenu/")
public class StudyMenuController {

	HttpServletRequest request;
	Model m;
	HttpSession session;

	@Autowired
	StudyMenuDao sd;
	@Autowired
	GroupMemberDao gm;
	@Autowired
	NoticeDao nd;
	@Autowired
	StudyMemberDao md;
	@Autowired
	StudyMenuDao sm;
	@Autowired
	StudyMenuDao smd;
	
	
	
	@ModelAttribute
	void init(HttpServletRequest request, Model m) {
		this.request = request;
		this.m = m;
		this.session = request.getSession();
	}

	@RequestMapping("onStudyMenuList")
	public String onStudyMenuList() {

		String menuid = "";
		int pageInt = 1;
		int limit = 9;

		if (request.getParameter("menuid") != null) {
			session.setAttribute("menuid", request.getParameter("menuid"));
			session.setAttribute("pageNum", "1");
		}
		menuid = (String) session.getAttribute("menuid");

		if (menuid == null) {
			menuid = "8";
		}
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		pageInt = Integer.parseInt(pageNum);

		int menucount = sd.menuCount(menuid);
		List<StudyMenu> list = sd.menuList(pageInt, limit, menucount, menuid);

		int menuAllCount = sd.onAllCount(pageNum);
		List<StudyMenu> allList = sd.onallList(pageInt, limit, menuAllCount, menuid);

		int menunum = menucount - (pageInt - 1) * limit;

		int bottomLine = 3;
		int startPage = (pageInt - 1) / bottomLine * bottomLine + 1;
		int endPage = startPage + bottomLine - 1;
		int maxPage = (menucount / limit) + (menucount % limit == 0 ? 0 : 1);
		if (endPage > maxPage)
			endPage = maxPage;

		/* 전체스터디페이징 */
		int a_menunum = menuAllCount - (pageInt - 1) * limit;
		int a_bottomLine = 3;
		int a_startPage = (pageInt - 1) / a_bottomLine * a_bottomLine + 1;
		int a_endPage = a_startPage + a_bottomLine - 1;
		int a_maxPage = (menuAllCount / limit) + (menuAllCount % limit == 0 ? 0 : 1);
		if (a_endPage > a_maxPage)
			a_endPage = a_maxPage;

		String menuName = "";
		switch (menuid) {
		case "8":
			menuName = "전체 스터디";
			/* 전체스터디목록 */
			list = allList;
			break;
		case "9":
			menuName = "개발/프로그래밍";
			break;
		case "10":
			menuName = "보안/네트워크";
			break;
		case "11":
			menuName = "크리에이티브";
			break;
		case "12":
			menuName = "직무/마케팅";
			break;
		case "13":
			menuName = "학문/외국어";
			break;
		case "14":
			menuName = "교양";
			break;
		}

		m.addAttribute("menuName", menuName);
		m.addAttribute("menuid", menuid);
		m.addAttribute("pageInt", pageInt);
		m.addAttribute("menucount", menucount);
		m.addAttribute("list", list);
		m.addAttribute("menunum", menunum);
		m.addAttribute("startPage", startPage);
		m.addAttribute("bottomLine", bottomLine);
		m.addAttribute("endPage", endPage);
		m.addAttribute("maxPage", maxPage);

		m.addAttribute("a_menunum", a_menunum);
		m.addAttribute("a_bottomLine", a_bottomLine);
		m.addAttribute("a_startPage", a_startPage);
		m.addAttribute("a_endPage", a_endPage);
		m.addAttribute("a_maxPage", a_maxPage);

		return "/view/study/onStudyMenuList";
	}

	@RequestMapping("offStudyMenuList")
	public String offstudyMenuList() {

		String menuid = "";
		int pageInt = 1;
		int limit = 9;

		if (request.getParameter("menuid") != null) {
			session.setAttribute("menuid", request.getParameter("menuid"));
			session.setAttribute("pageNum", "1");
		}
		menuid = (String) session.getAttribute("menuid");

		if (menuid == null) {
			menuid = "1";
		}
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		pageInt = Integer.parseInt(pageNum);

		int menucount = sd.menuCount(menuid);
		List<StudyMenu> list = sd.menuList2(pageInt, limit, menucount, menuid);

		int menuAllCount = sd.offAllCount(pageNum);
		List<StudyMenu> allList = sd.offallList2(pageInt, limit, menuAllCount, menuid);

		int menunum = menucount - (pageInt - 1) * limit;

		int bottomLine = 3;
		int startPage = (pageInt - 1) / bottomLine * bottomLine + 1;
		int endPage = startPage + bottomLine - 1;
		int maxPage = (menucount / limit) + (menucount % limit == 0 ? 0 : 1);
		if (endPage > maxPage)
			endPage = maxPage;

		/* 전체스터디페이징 */
		int a_menunum = menuAllCount - (pageInt - 1) * limit;
		int a_bottomLine = 3;
		int a_startPage = (pageInt - 1) / a_bottomLine * a_bottomLine + 1;
		int a_endPage = a_startPage + a_bottomLine - 1;
		int a_maxPage = (menuAllCount / limit) + (menuAllCount % limit == 0 ? 0 : 1);
		if (a_endPage > a_maxPage)
			a_endPage = a_maxPage;

		String menuName = "";
		switch (menuid) {
		case "1":
			menuName = "전체 스터디";
			/* 전체스터디목록 */
			list = allList;
			break;
		case "2":
			menuName = "개발/프로그래밍";
			break;
		case "3":
			menuName = "보안/네트워크";
			break;
		case "4":
			menuName = "크리에이티브";
			break;
		case "5":
			menuName = "직무/마케팅";
			break;
		case "6":
			menuName = "학문/외국어";
			break;
		case "7":
			menuName = "교양";
			break;
		}

		m.addAttribute("menuName", menuName);
		m.addAttribute("menuid", menuid);
		m.addAttribute("pageInt", pageInt);
		m.addAttribute("menucount", menucount);
		m.addAttribute("list", list);
		m.addAttribute("menunum", menunum);
		m.addAttribute("startPage", startPage);
		m.addAttribute("bottomLine", bottomLine);
		m.addAttribute("endPage", endPage);
		m.addAttribute("maxPage", maxPage);

		m.addAttribute("a_menunum", a_menunum);
		m.addAttribute("a_bottomLine", a_bottomLine);
		m.addAttribute("a_startPage", a_startPage);
		m.addAttribute("a_endPage", a_endPage);
		m.addAttribute("a_maxPage", a_maxPage);

		return "/view/study/offStudyMenuList";
	}

	@RequestMapping("onoffStudyMenuList")
	public String onoffStudyMenuList() {

		String menuid = "";
		int pageInt = 1;
		int limit = 9;

		if (request.getParameter("menuid") != null) {
			session.setAttribute("menuid", request.getParameter("menuid"));
			session.setAttribute("pageNum", "1");
		}
		menuid = (String) session.getAttribute("menuid");

		if (menuid == null) {
			menuid = "15";
		}
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		pageInt = Integer.parseInt(pageNum);

		int menucount = sd.menuCount(menuid);
		List<StudyMenu> list = sd.menuList(pageInt, limit, menucount, menuid);

		int menuAllCount = sd.onoffAllCount(pageNum);
		List<StudyMenu> allList = sd.onoffallList(pageInt, limit, menuAllCount, menuid);

		int menunum = menucount - (pageInt - 1) * limit;

		int bottomLine = 3;
		int startPage = (pageInt - 1) / bottomLine * bottomLine + 1;
		int endPage = startPage + bottomLine - 1;
		int maxPage = (menucount / limit) + (menucount % limit == 0 ? 0 : 1);
		if (endPage > maxPage)
			endPage = maxPage;

		/* 전체스터디페이징 */
		int a_menunum = menuAllCount - (pageInt - 1) * limit;
		int a_bottomLine = 3;
		int a_startPage = (pageInt - 1) / a_bottomLine * a_bottomLine + 1;
		int a_endPage = a_startPage + a_bottomLine - 1;
		int a_maxPage = (menuAllCount / limit) + (menuAllCount % limit == 0 ? 0 : 1);
		if (a_endPage > a_maxPage)
			a_endPage = a_maxPage;

		String menuName = "";
		switch (menuid) {
		case "15":
			menuName = "전체 스터디";
			/* 전체스터디목록 */
			list = allList;
			break;
		case "16":
			menuName = "개발/프로그래밍";
			break;
		case "17":
			menuName = "보안/네트워크";
			break;
		case "18":
			menuName = "크리에이티브";
			break;
		case "19":
			menuName = "직무/마케팅";
			break;
		case "20":
			menuName = "학문/외국어";
			break;
		case "21":
			menuName = "교양";
			break;
		}

		m.addAttribute("menuName", menuName);
		m.addAttribute("menuid", menuid);
		m.addAttribute("pageInt", pageInt);
		m.addAttribute("menucount", menucount);
		m.addAttribute("list", list);
		m.addAttribute("menunum", menunum);
		m.addAttribute("startPage", startPage);
		m.addAttribute("bottomLine", bottomLine);
		m.addAttribute("endPage", endPage);
		m.addAttribute("maxPage", maxPage);

		m.addAttribute("a_menunum", a_menunum);
		m.addAttribute("a_bottomLine", a_bottomLine);
		m.addAttribute("a_startPage", a_startPage);
		m.addAttribute("a_endPage", a_endPage);
		m.addAttribute("a_maxPage", a_maxPage);

		return "/view/study/onoffStudyMenuList";
	}

	/*---------------------------------------------------------------------------*/
	/* 오프라인글쓰기 */
	@RequestMapping("offStudyWriteForm")
	public String offStudyWriteForm() {

		String msg = "로그인이 필요합니다";
		String url = request.getContextPath() + "/studymember/loginForm";

		if (session.getAttribute("memberNickname") != null) {
			return "/view/study/offStudyWriteForm";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}

	@RequestMapping("offWritePro")
	public String offWritePro(StudyMenu studymenu) {

		studymenu.setNickname((String) session.getAttribute("memberNickname"));
		String menuid = (String) session.getAttribute("menuid");
		if (menuid == null)
			menuid = "1";
		studymenu.setMenuid(menuid);

		studymenu.setBoard_num(sm.menuNextNum());

		int num = sm.insertMenu(studymenu);

		// group insert

		System.out.println(studymenu);
		GroupMember gmem = new GroupMember();
		gmem.setBoardnum(studymenu.getBoard_num());
		gmem.setNickname(studymenu.getNickname());
		gm.groupInsert(gmem, 1);

		String msg = "게시물 등록 실패";
		String url = request.getContextPath() + "/studymenu/offStudyWriteForm";

		if (num == 1) {
			msg = "게시물 등록 성공";
			url = request.getContextPath() + "/studymenu/offStudyMenuList?pageNum=1";

		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}

	/* 온라인글쓰기 */
	@RequestMapping("onStudyWriteForm")
	public String onStudyWriteForm() {

		String msg = "로그인이 필요합니다";
		String url = request.getContextPath() + "/studymember/loginForm";

		if (session.getAttribute("memberNickname") != null) {
			return "/view/study/onStudyWriteForm";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}

	@RequestMapping("onWritePro")
	public String onWritePro(StudyMenu studymenu) {
		
		studymenu.setNickname((String) session.getAttribute("memberNickname"));
		String menuid = (String) session.getAttribute("menuid");
		if (menuid == null)
			menuid = "1";
		studymenu.setMenuid(menuid);

		studymenu.setBoard_num(sm.menuNextNum());

		int num = sm.insertMenu(studymenu);

		// group insert

		GroupMember gmem = new GroupMember();
		gmem.setBoardnum(studymenu.getBoard_num());
		gmem.setNickname(studymenu.getNickname());
		gm.groupInsert(gmem, 1);

		String msg = "게시물 등록 실패";
		String url = request.getContextPath() + "/studymenu/onStudyWriteForm";

		if (num == 1) {
			msg = "게시물 등록 성공";
			url = request.getContextPath() + "/studymenu/onStudyMenuList?pageNum=1";

		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}

	/* 온라인글쓰기 */
	@RequestMapping("onoffStudyWriteForm")
	public String onoffStudyWriteForm() {

		String msg = "로그인이 필요합니다";
		String url = request.getContextPath() + "/studymember/loginForm";

		if (session.getAttribute("memberNickname") != null) {
			return "/view/study/onoffStudyWriteForm";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}

	/* 온오프라인글쓰기 */
	@RequestMapping("onoffWritePro")
	public String onoffWritePro(StudyMenu studymenu) {

		studymenu.setNickname((String) session.getAttribute("memberNickname"));
		String menuid = (String) session.getAttribute("menuid");
		if (menuid == null)
			menuid = "1";
		studymenu.setMenuid(menuid);

		studymenu.setBoard_num(sm.menuNextNum());

		int num = sm.insertMenu(studymenu);

		// group insert
		GroupMember gmem = new GroupMember();
		gmem.setBoardnum(studymenu.getBoard_num());
		gmem.setNickname(studymenu.getNickname());
		gm.groupInsert(gmem, 1);

		String msg = "게시물 등록 실패";
		String url = request.getContextPath() + "/studymenu/onoffStudyWriteForm";

		if (num == 1) {
			msg = "게시물 등록 성공";
			url = request.getContextPath() + "/studymenu/onoffStudyMenuList?pageNum=1";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}

	/*---------------------------------------------------------------------------*/
	@RequestMapping("onSearch")
	public String onSearch(String part, String searchData, String menuid) {

		int pageInt = 1;
		int limit = 9;

		if (request.getParameter("menuid") != null) {
			session.setAttribute("menuid", request.getParameter("menuid"));
			session.setAttribute("pageNum", "1");
		}

		menuid = (String) session.getAttribute("menuid");
		if (menuid == null) {
			menuid = "1";
		}
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		pageInt = Integer.parseInt(pageNum);
		m.addAttribute("part", part);
		m.addAttribute("searchData", searchData);

		int menucount = smd.studySearchCount(menuid, part, searchData);
		List<StudyMenu> searchList = smd.studySearchList(pageInt, limit, menucount, menuid, part, searchData);

		int menunum = menucount - limit * (pageInt - 1);
		int bottomLine = 3;
		int startPage = (pageInt - 1) / bottomLine * bottomLine + 1;
		int endPage = startPage + bottomLine - 1;
		int maxPage = (menucount / limit) + (menucount % limit == 0 ? 0 : 1);
		if (endPage > maxPage)
			endPage = maxPage;

		String menuName = "";
		switch (menuid) {
		case "8":
			menuName = "전체 스터디";
			break;
		case "9":
			menuName = "개발/프로그래밍";
			break;
		case "10":
			menuName = "보안/네트워크";
			break;
		case "11":
			menuName = "크리에이티브";
			break;
		case "12":
			menuName = "직무/마케팅";
			break;
		case "13":
			menuName = "학문/외국어";
			break;
		case "14":
			menuName = "교양";
			break;
		}

		m.addAttribute("menuName", menuName);
		m.addAttribute("menuid", menuid);
		m.addAttribute("pageInt", pageInt);
		m.addAttribute("menucount", menucount);
		m.addAttribute("searchList", searchList);
		m.addAttribute("menunum", menunum);
		m.addAttribute("startPage", startPage);
		m.addAttribute("bottomLine", bottomLine);
		m.addAttribute("endPage", endPage);
		m.addAttribute("maxPage", maxPage);

		return "/view/study/onSearchList";
	}

	/*---------------------------------------------------------------------------*/
	@RequestMapping("offSearch")
	public String offSearch(String part, String searchData, String menuid) {

		int pageInt = 1;
		int limit = 9;

		if (request.getParameter("menuid") != null) {
			session.setAttribute("menuid", request.getParameter("menuid"));
			session.setAttribute("pageNum", "1");
		}
		menuid = (String) session.getAttribute("menuid");
		if (menuid == null) {
			menuid = "1";
		}
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		pageInt = Integer.parseInt(pageNum);
		m.addAttribute("part", part);
		m.addAttribute("searchData", searchData);

		int menucount = smd.studySearchCount(menuid, part, searchData);
		List<StudyMenu> searchList = smd.studySearchList(pageInt, limit, menucount, menuid, part, searchData);

		int menunum = menucount - limit * (pageInt - 1);
		int bottomLine = 3;
		int startPage = (pageInt - 1) / bottomLine * bottomLine + 1;
		int endPage = startPage + bottomLine - 1;
		int maxPage = (menucount / limit) + (menucount % limit == 0 ? 0 : 1);
		if (endPage > maxPage)
			endPage = maxPage;

		String menuName = "";
		switch (menuid) {
		case "1":
			menuName = "전체 스터디";
			break;
		case "2":
			menuName = "개발/프로그래밍";
			break;
		case "3":
			menuName = "보안/네트워크";
			break;
		case "4":
			menuName = "크리에이티브";
			break;
		case "5":
			menuName = "직무/마케팅";
			break;
		case "6":
			menuName = "학문/외국어";
			break;
		case "7":
			menuName = "교양";
			break;
		}

		m.addAttribute("menuName", menuName);
		m.addAttribute("menuid", menuid);
		m.addAttribute("pageInt", pageInt);
		m.addAttribute("menucount", menucount);
		m.addAttribute("searchList", searchList);
		m.addAttribute("menunum", menunum);
		m.addAttribute("startPage", startPage);
		m.addAttribute("bottomLine", bottomLine);
		m.addAttribute("endPage", endPage);
		m.addAttribute("maxPage", maxPage);

		return "/view/study/offSearchList";
	}

	/*---------------------------------------------------------------------------*/
	@RequestMapping("onoffSearch")
	public String onoffSearch(String part, String searchData, String menuid) {

		int pageInt = 1;
		int limit = 9;

		if (request.getParameter("menuid") != null) {
			session.setAttribute("menuid", request.getParameter("menuid"));
			session.setAttribute("pageNum", "1");
		}
		menuid = (String) session.getAttribute("menuid");
		if (menuid == null) {
			menuid = "1";
		}
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		pageInt = Integer.parseInt(pageNum);
		m.addAttribute("part", part);
		m.addAttribute("searchData", searchData);

		int menucount = smd.studySearchCount(menuid, part, searchData);
		List<StudyMenu> searchList = smd.studySearchList(pageInt, limit, menucount, menuid, part, searchData);

		int menunum = menucount - limit * (pageInt - 1);
		int bottomLine = 3;
		int startPage = (pageInt - 1) / bottomLine * bottomLine + 1;
		int endPage = startPage + bottomLine - 1;
		int maxPage = (menucount / limit) + (menucount % limit == 0 ? 0 : 1);
		if (endPage > maxPage)
			endPage = maxPage;

		String menuName = "";
		switch (menuid) {
		case "15":
			menuName = "전체 스터디";
			break;
		case "16":
			menuName = "개발/프로그래밍";
			break;
		case "17":
			menuName = "보안/네트워크";
			break;
		case "18":
			menuName = "크리에이티브";
			break;
		case "19":
			menuName = "직무/마케팅";
			break;
		case "20":
			menuName = "학문/외국어";
			break;
		case "21":
			menuName = "교양";
			break;
		}

		m.addAttribute("menuName", menuName);
		m.addAttribute("menuid", menuid);
		m.addAttribute("pageInt", pageInt);
		m.addAttribute("menucount", menucount);
		m.addAttribute("searchList", searchList);
		m.addAttribute("menunum", menunum);
		m.addAttribute("startPage", startPage);
		m.addAttribute("bottomLine", bottomLine);
		m.addAttribute("endPage", endPage);
		m.addAttribute("maxPage", maxPage);

		return "/view/study/onoffSearchList";
	}

	/*---------------------------------------------------------------------------*/
	@RequestMapping("onAllSearch")
	public String onAllSearch(String part, String searchData, String menuid) {

		int pageInt = 1;
		int limit = 9;

		if (request.getParameter("menuid") != null) {
			session.setAttribute("menuid", request.getParameter("menuid"));
			session.setAttribute("pageNum", "1");
		}
		menuid = (String) session.getAttribute("menuid");
		if (menuid == null) {
			menuid = "1";
		}
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		pageInt = Integer.parseInt(pageNum);
		m.addAttribute("part", part);
		m.addAttribute("searchData", searchData);

		int menucount = smd.onAllSearchCount(menuid, part, searchData);
		List<StudyMenu> searchList = smd.onAllSearchList(pageInt, limit, menucount, menuid, part, searchData);

		int menunum = menucount - limit * (pageInt - 1);
		int bottomLine = 3;
		int startPage = (pageInt - 1) / bottomLine * bottomLine + 1;
		int endPage = startPage + bottomLine - 1;
		int maxPage = (menucount / limit) + (menucount % limit == 0 ? 0 : 1);
		if (endPage > maxPage)
			endPage = maxPage;

		String menuName = "";
		switch (menuid) {
		case "8":
			menuName = "전체 스터디";
			break;
		case "9":
			menuName = "개발/프로그래밍";
			break;
		case "10":
			menuName = "보안/네트워크";
			break;
		case "11":
			menuName = "크리에이티브";
			break;
		case "12":
			menuName = "직무/마케팅";
			break;
		case "13":
			menuName = "학문/외국어";
			break;
		case "14":
			menuName = "교양";
			break;
		}
		m.addAttribute("menuName", menuName);
		m.addAttribute("menuid", menuid);
		m.addAttribute("pageInt", pageInt);
		m.addAttribute("menucount", menucount);
		m.addAttribute("searchList", searchList);
		m.addAttribute("menunum", menunum);
		m.addAttribute("startPage", startPage);
		m.addAttribute("bottomLine", bottomLine);
		m.addAttribute("endPage", endPage);
		m.addAttribute("maxPage", maxPage);

		return "/view/study/onSearchList";
	}

	/*---------------------------------------------------------------------------*/
	@RequestMapping("offAllSearch")
	public String offAllSearch(String part, String searchData, String menuid) {

		int pageInt = 1;
		int limit = 9;

		if (request.getParameter("menuid") != null) {
			session.setAttribute("menuid", request.getParameter("menuid"));
			session.setAttribute("pageNum", "1");
		}
		menuid = (String) session.getAttribute("menuid");
		if (menuid == null) {
			menuid = "1";
		}
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		pageInt = Integer.parseInt(pageNum);
		m.addAttribute("part", part);
		m.addAttribute("searchData", searchData);

		int menucount = smd.offAllSearchCount(menuid, part, searchData);
		List<StudyMenu> searchList = smd.offAllSearchList(pageInt, limit, menucount, menuid, part, searchData);

		int menunum = menucount - limit * (pageInt - 1);
		int bottomLine = 3;
		int startPage = (pageInt - 1) / bottomLine * bottomLine + 1;
		int endPage = startPage + bottomLine - 1;
		int maxPage = (menucount / limit) + (menucount % limit == 0 ? 0 : 1);
		if (endPage > maxPage)
			endPage = maxPage;

		String menuName = "";
		switch (menuid) {
		case "8":
			menuName = "전체 스터디";
			break;
		case "9":
			menuName = "개발/프로그래밍";
			break;
		case "10":
			menuName = "보안/네트워크";
			break;
		case "11":
			menuName = "크리에이티브";
			break;
		case "12":
			menuName = "직무/마케팅";
			break;
		case "13":
			menuName = "학문/외국어";
			break;
		case "14":
			menuName = "교양";
			break;
		}

		m.addAttribute("menuName", menuName);
		m.addAttribute("menuid", menuid);
		m.addAttribute("pageInt", pageInt);
		m.addAttribute("menucount", menucount);
		m.addAttribute("searchList", searchList);
		m.addAttribute("menunum", menunum);
		m.addAttribute("startPage", startPage);
		m.addAttribute("bottomLine", bottomLine);
		m.addAttribute("endPage", endPage);
		m.addAttribute("maxPage", maxPage);

		return "/view/study/offSearchList";
	}

	/*---------------------------------------------------------------------------*/
	@RequestMapping("onoffAllSearch")
	public String onoffAllSearch(String part, String searchData, String menuid) {

		int pageInt = 1;
		int limit = 9;

		if (request.getParameter("menuid") != null) {
			session.setAttribute("menuid", request.getParameter("menuid"));
			session.setAttribute("pageNum", "1");
		}
		menuid = (String) session.getAttribute("menuid");
		if (menuid == null) {
			menuid = "1";
		}
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		pageInt = Integer.parseInt(pageNum);
		m.addAttribute("part", part);
		m.addAttribute("searchData", searchData);

		int menucount = smd.onoffAllSearchCount(menuid, part, searchData);
		List<StudyMenu> searchList = smd.onoffAllSearchList(pageInt, limit, menucount, menuid, part, searchData);

		int menunum = menucount - limit * (pageInt - 1);
		int bottomLine = 3;
		int startPage = (pageInt - 1) / bottomLine * bottomLine + 1;
		int endPage = startPage + bottomLine - 1;
		int maxPage = (menucount / limit) + (menucount % limit == 0 ? 0 : 1);
		if (endPage > maxPage)
			endPage = maxPage;

		String menuName = "";
		switch (menuid) {
		case "8":
			menuName = "전체 스터디";
			break;
		case "9":
			menuName = "개발/프로그래밍";
			break;
		case "10":
			menuName = "보안/네트워크";
			break;
		case "11":
			menuName = "크리에이티브";
			break;
		case "12":
			menuName = "직무/마케팅";
			break;
		case "13":
			menuName = "학문/외국어";
			break;
		case "14":
			menuName = "교양";
			break;
		}
		m.addAttribute("menuName", menuName);
		m.addAttribute("menuid", menuid);
		m.addAttribute("pageInt", pageInt);
		m.addAttribute("menucount", menucount);
		m.addAttribute("searchList", searchList);
		m.addAttribute("menunum", menunum);
		m.addAttribute("startPage", startPage);
		m.addAttribute("bottomLine", bottomLine);
		m.addAttribute("endPage", endPage);
		m.addAttribute("maxPage", maxPage);

		return "/view/study/onoffSearchList";
	}

	/*---------------------------------------------------------------------------*/
	@RequestMapping("onStudyMenuInfo")
	public String onStudyMenuInfo(StudyMenu studymenu, int board_num) {

		StudyMenu s = smd.menuBoardOne(board_num);
		m.addAttribute("s", s);

		// session의 닉네임 가져오기

		String loginNick = (String) session.getAttribute("memberNickname");
		m.addAttribute("loginNick", loginNick);

		// 닉네임으로 평판 가져오기

		StudyMember repVal = md.getPoint(s.getNickname());
		m.addAttribute("repVal", repVal);

		return "/view/study/onStudyMenuInfo";
	}

	@RequestMapping("offStudyMenuInfo")
	public String offStudyMenuInfo(StudyMenu studymenu, int board_num) {

		StudyMenu s = smd.menuBoardOne(board_num);
		m.addAttribute("s", s);

		// session의 닉네임 가져오기

		String loginNick = (String) session.getAttribute("memberNickname");
		m.addAttribute("loginNick", loginNick);

		// 닉네임으로 평판 가져오기

		StudyMember repVal = md.getPoint(s.getNickname());
		m.addAttribute("repVal", repVal);

		return "/view/study/offStudyMenuInfo";
	}

	@RequestMapping("onoffStudyMenuInfo")
	public String onoffStudyMenuInfo(StudyMenu studymenu, int board_num) {

		StudyMenu s = smd.menuBoardOne(board_num);
		m.addAttribute("s", s);

		// session의 닉네임 가져오기

		String loginNick = (String) session.getAttribute("memberNickname");
		m.addAttribute("loginNick", loginNick);

		// 닉네임으로 평판 가져오기

		StudyMember repVal = md.getPoint(s.getNickname());
		m.addAttribute("repVal", repVal);

		return "/view/study/onoffStudyMenuInfo";
	}

	/*---------------------------------------------------------------------------*/
	@RequestMapping("onStudyUpdateForm")
	public String onStudyUpdateForm(StudyMenu studymenu, int board_num) {

		StudyMenu sm = smd.studyMenuOne(board_num);
		m.addAttribute("sm", sm);

		return "/view/study/onStudyUpdateForm";
	}

	@RequestMapping("onStudyUpdatePro")
	public String onStudyUpdatePro(StudyMenu sm, int board_num) {

		String msg = "";
		String url = "";
		if (smd.studyUpdate(sm) > 0) {
			msg = "수정되었습니다";
			url = request.getContextPath() + "/studymenu/onStudyMenuInfo?board_num=" + sm.getBoard_num();

		} else {
			msg = "수정이 실패하였습니다";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}

	/*---------------------------------------------------------------------------*/
	@RequestMapping("offStudyUpdateForm")
	public String offStudyUpdateForm(StudyMenu studymenu, int board_num) {

		StudyMenu sm = smd.studyMenuOne(board_num);
		m.addAttribute("sm", sm);

		return "/view/study/offStudyUpdateForm";
	}

	@RequestMapping("offStudyUpdatePro")
	public String offStudyUpdatePro(StudyMenu sm, int board_num) {

		String msg = "";
		String url = "";
		if (smd.studyUpdate(sm) > 0) {
			msg = "수정되었습니다";
			url = request.getContextPath() + "/studymenu/offStudyMenuInfo?board_num=" + sm.getBoard_num();
		} else {
			msg = "수정이 실패하였습니다";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}

	/*---------------------------------------------------------------------------*/
	@RequestMapping("onoffStudyUpdateForm")
	public String onoffStudyUpdateForm(StudyMenu studymenu, int board_num) {

		StudyMenu sm = smd.studyMenuOne(board_num);
		m.addAttribute("sm", sm);

		return "/view/study/onoffStudyUpdateForm";
	}

	@RequestMapping("onoffStudyUpdatePro")
	public String onoffStudyUpdatePro(StudyMenu sm, int board_num) {

		String msg = "";
		String url = "";
		if (smd.studyUpdate(sm) > 0) {
			msg = "수정되었습니다";
			url = request.getContextPath() + "/studymenu/onoffStudyMenuInfo?board_num=" + sm.getBoard_num();

		} else {
			msg = "수정이 실패하였습니다";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";

	}

	/*---------------------------------------------------------------------------*/
	@RequestMapping("onStudyDelete")
	public String onStudyDelete(StudyMenu studymenu, int board_num) {

		StudyMenu sm = smd.studyMenuOne(board_num);
		m.addAttribute("sm", sm);

		String msg = "";
		String url = "";

		if (smd.studyDelete(board_num) > 0) {

			msg = "게시글이 삭제되었습니다.";
			url = request.getContextPath() + "/studymenu/onStudyMenuList";
		} else {
			msg = "삭제가 불가능합니다";
			url = request.getContextPath() + "/studymenu/onStudyMenuInfo";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}

	@RequestMapping("offStudyDelete")
	public String offStudyDelete(StudyMenu studymenu, int board_num) {

		StudyMenu sm = smd.studyMenuOne(board_num);
		m.addAttribute("sm", sm);

		String msg = "";
		String url = "";

		if (smd.studyDelete(board_num) > 0) {

			msg = "게시글이 삭제되었습니다.";
			url = request.getContextPath() + "/studymenu/offStudyMenuList";
		} else {
			msg = "삭제가 불가능합니다";
			url = request.getContextPath() + "/studymenu/offStudyMenuInfo";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}

	@RequestMapping("onoffStudyDelete")
	public String onoffStudyDelete(StudyMenu studymenu, int board_num) {

		StudyMenu sm = smd.studyMenuOne(board_num);
		m.addAttribute("sm", sm);

		String msg = "";
		String url = "";

		if (smd.studyDelete(board_num) > 0) {

			msg = "게시글이 삭제되었습니다.";
			url = request.getContextPath() + "/studymenu/onoffStudyMenuList";
		} else {
			msg = "삭제가 불가능합니다";
			url = request.getContextPath() + "/studymenu/onoffStudyMenuInfo";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}

	// 내가쓴 커뮤니티 게시글//

	@RequestMapping("mylist2")
	public String mylist2() {

		String nickname = (String) session.getAttribute("memberNickname");
		String menuid = "";
		int pageInt = 1;
		int limit = 4;

		if (request.getParameter("menuid") != null) {
			session.setAttribute("menuid", request.getParameter("menuid"));
			session.setAttribute("pageNum", "1");
		}
		menuid = (String) session.getAttribute("menuid");
		if (menuid == null) {
			menuid = "1";
		}
		if (request.getParameter("pageNum") != null) {
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		String pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		pageInt = Integer.parseInt(pageNum);

		int menucount = sd.myStudyCount(nickname);
		List<StudyMenu> list = sd.mylist2(pageInt, limit, menucount, nickname);

		int menunum = menucount - (pageInt - 1) * limit;

		int bottomLine = 3;
		int startPage = (pageInt - 1) / bottomLine * bottomLine + 1;
		int endPage = startPage + bottomLine - 1;
		int maxPage = (menucount / limit) + (menucount % limit == 0 ? 0 : 1);
		if (endPage > maxPage)
			endPage = maxPage;

		String menuName = "스터디 게시물";

		m.addAttribute("menuName", menuName);
		m.addAttribute("menuid", menuid);
		m.addAttribute("pageInt", pageInt);
		m.addAttribute("menucount", menucount);
		m.addAttribute("list", list);
		m.addAttribute("menunum", menunum);
		m.addAttribute("startPage", startPage);
		m.addAttribute("bottomLine", bottomLine);
		m.addAttribute("endPage", endPage);
		m.addAttribute("maxPage", maxPage);

		return "/view/study/myList2";
	}

	/*---------------------------------------------------------------------------*/
	// 스터디 참가신청 버튼을 누를 때
	@RequestMapping("studyIn")
	public String studyIn() {
		
		String board_name = (String) request.getParameter("board_name");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String nickname_from = (String) request.getParameter("f_nickname");
		String nickname_to = (String) request.getParameter("t_nickname");

		nd.noticeWrite(board_num, nickname_from, nickname_to);

		String msg = "참가 요청이 전송되었습니다";
		String url = request.getContextPath() + "/studymenu/" + board_name;

		m.addAttribute("msg", msg);
		m.addAttribute("url", url);

		return "/view/alert";
	}
}
