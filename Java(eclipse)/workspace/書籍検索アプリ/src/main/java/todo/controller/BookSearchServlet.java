package todo.controller;

import java.io.IOException;
import java.util.ArrayList;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FILE_PATH = this.getServletContext().getRealPath("/Resources/") + FILE_NAME;
        bookDataListCsvExtractor = new BookDataListCsvExtractor(FILE_PATH);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String view = "/WEB-INF/view/BookSearchScreen.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String bookName = request.getParameter("bookName");
		ArrayList<BookDataBean> searchResultList = bookDataListCsvExtractor.keyWordSearch(bookName);
		
		//検索された本のタイトルをjspへ戻す
		request.setAttribute("bookName",bookName);
		//検索結果をjspへ戻す
		request.setAttribute("searchResultList",searchResultList);				
		doGet(request,response);
	}
}
