package todo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.model.BookDataListCsvExtractor;
import todo.model.beans.BookDataBean;

/**
 * Servlet implementation class BookSearchScreen
 */
@WebServlet("/BookSearchServlet")
public class BookSearchServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private BookDataListCsvExtractor bookDataListCsvExtractor;
	private static final String FILE_NAME = "bookDataList.csv";
	private String FILE_PATH;
	
	//---------
	//検索情報
	private ArrayList<BookDataBean> searchResultList; //検索結果
	private Integer selectNo; //どの番号が選択されたのか
	private String keyWord;  //入力されたキーワード
	private String pushedButton;   //押下されたボタン
	private String pushedRadio;  //選択されたラジオボタン
	private Boolean isButtonPush;  //検索ボタンが押下されたか
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        bookDataListCsvExtractor = new BookDataListCsvExtractor();
        searchResultList = new ArrayList<BookDataBean>();
        selectNo = null;
        keyWord = "";
        pushedButton = "全件検索";
        pushedRadio = "keyWordSearch";
        isButtonPush = false;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String selNo = request.getParameter("selectNo");
		selectNo = (selNo != null)? Integer.parseInt(selNo) : null;
		if(selectNo != null) {
			
			//何らかの番号が選択されている
			BookDataBean resultRecord = searchResultList.get(selectNo);
			request.setAttribute("resultRecord",resultRecord);
			request.setAttribute("selectNo",selectNo = null);
			transForward("./SearchResultServlet",request,response);
			return;
		}
		FILE_PATH = this.getServletContext().getRealPath("/Resources/") + FILE_NAME;
        bookDataListCsvExtractor.csvExtractor(FILE_PATH);
        //パラメータ初期化
        parameterSet(request);
        //全件表示（初期表示）
        allBookDataDisplay(request,response);
	}
	
	private void parameterSet(HttpServletRequest request) {
		
		request.setAttribute("selectNo",selectNo);
        request.setAttribute("keyWord",keyWord);
        request.setAttribute("pushedButton",pushedButton);
        request.setAttribute("pushedRadio",pushedRadio);
        pushSearchButton(isButtonPush,request);
	}
	
	private Object parameterAdjustment(String target,Object nowParam,HttpServletRequest request) {
		
		Object requestGetParam = request.getParameter(target);
		return (requestGetParam != null)? requestGetParam : nowParam;
	}
	
	private void pushSearchButton(Boolean isPush,HttpServletRequest request) {
		
		isButtonPush = isPush;
		request.setAttribute("isButtonPush",isPush);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		keyWord = (String)parameterAdjustment("keyWord",keyWord,request);
		pushedButton = (String)parameterAdjustment("pushedButton",pushedButton,request);
		pushedRadio = (String)parameterAdjustment("pushedRadio",pushedRadio,request);
		isButtonPush = (Boolean)parameterAdjustment("isButtonPush",isButtonPush,request);
		pushSearchButton(isButtonPush,request);
		if(pushedButton != null) {
			
			switch(pushedButton) {
			
				//-----------------
				//検索
				case "検索":
					searchBookData(keyWord,request,response);
				break;
				//-----------------
				//全件表示
				case "全件検索":
					allBookDataDisplay(request,response);
				break;
			}
		}
	}
	
	//-----------
	//検索
	private void searchBookData(String keyWord,HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
		
		if(!"".equals(keyWord)) {
			
			switch(pushedRadio) {
			
				case "keyWordSearch":
					//キーワードで検索
					searchResultList = keyWordSearch(keyWord);
				break;
					
				case "titleSearch":
					//本のタイトルで検索
					searchResultList = bookTitleNameSearch(keyWord);
				break;
			}
			pushSearchButton(true,request);
		}else {
			
			pushSearchButton(false,request);
		}
		//検索された本のタイトルをjspへ戻す
		//request.setAttribute("keyWord",keyWord);
		//選択されたラジオボタンをjspへ渡す
		//request.setAttribute("pushedRadio",pushedRadio);
		//パラメータをjspへ渡す
		parameterSet(request);
		//検索結果をjspへ戻す
		request.setAttribute("searchResultList",searchResultList);
		transForward("/WEB-INF/view/BookSearchScreen.jsp",request,response);
	}
	
	//------------
	//キーワードで検索
	private ArrayList<BookDataBean> keyWordSearch(String keyWord) {
		
		
		return bookDataListCsvExtractor.keyWordSearch(keyWord);
	}
	
	//------------
	//本のタイトルで検索
	private ArrayList<BookDataBean> bookTitleNameSearch(String titleName) {
		
		return bookDataListCsvExtractor.bookTitleNameSearch(titleName);
	}
	
	//----------
	//全件表示
	private void allBookDataDisplay(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException, IOException {
		
		BookDataBean[] allBookData = bookDataListCsvExtractor.allBookDataClone();
		searchResultList = new ArrayList<BookDataBean>(Arrays.asList(allBookData));
		pushSearchButton(true,request);
		//パラメータをjspへ渡す
		parameterSet(request);
		//検索結果をjspへ戻す
		request.setAttribute("searchResultList",searchResultList);
		transForward("/WEB-INF/view/BookSearchScreen.jsp",request,response);
	}
	
	private void transForward(String transPath,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(transPath);
			dispatcher.forward(request, response);
		}catch(ServletException e) {
			
			transException(request);
		}catch(IOException e) {
			
			transException(request);
		}catch(IllegalStateException e) {
			
			transException(request);
		}		
	}
	
	private void transException(HttpServletRequest request) {
		
		request.setAttribute("outbreakException",true);
	}
}
