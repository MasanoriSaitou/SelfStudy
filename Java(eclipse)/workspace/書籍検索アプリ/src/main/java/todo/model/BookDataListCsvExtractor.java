package todo.model;

import java.util.ArrayList;

import todo.model.beans.BookDataBean;
import 自作ライブラリ.TextFileLib;

public class BookDataListCsvExtractor {
	
	private interface FunctionPointer {
		
		// Method signatures of pointed method
		String methodSignature(BookDataBean bookData);
	}
	
	private BookDataBean[] bookDataBeans;
	private final FunctionPointer[] SEARCH_TARGET_ARRAY = {
		//検索は上のものから順に探す
		//本のタイトルで検索
		this::getBookName,
		//著者で検索
		this::getAuthor,
		//架空ISBNコードで検索
		this::getFictitiousISBN,
	};
	
	//----------
	//コンストラクタ
	public BookDataListCsvExtractor() {
		
		bookDataBeans = new BookDataBean[0];
	}
	
	//------------
	//CSVを読み込み
	public void csvExtractor(String filePath) {
		
		String[][] resultArray  = TextFileLib.readerCsvData(filePath,"Shift-JIS",true);
		bookDataBeans = new BookDataBean[resultArray.length];
		int i = 0;
		for(String[] results : resultArray) {
			bookDataBeans[i] = new BookDataBean(results);
			i++;
		}
	}
	
	private String getBookName(BookDataBean bookData) {
		
		//本のタイトルで検索
		return bookData.getBookName();
	}
	
	private String getAuthor(BookDataBean bookData) {
			
		//著者で検索
		return bookData.getAuthor();
	}
	
	private String getFictitiousISBN(BookDataBean bookData) {
		
		//架空ISBNコードで検索
		return bookData.getFictitiousISBN();
	}
	
	public BookDataBean[] allBookDataClone() {
		
		return bookDataBeans.clone();
	}
	
	public ArrayList<BookDataBean> keyWordSearch(String keyWord) {
		
		var searchResultList = new ArrayList<BookDataBean>();
		for(FunctionPointer search:SEARCH_TARGET_ARRAY) {
			
			for(BookDataBean bookData : bookDataBeans) {
				
				if(stringRegexCheck(search.methodSignature(bookData),keyWord)) {
					
					searchResultList.add(bookData);
				}
			}	
		}
		return searchResultList;
	}
	
	public ArrayList<BookDataBean> bookTitleNameSearch(String bookTitleName) {
		
		var searchResultList = new ArrayList<BookDataBean>();
		for(BookDataBean bookData : bookDataBeans) {
			
			//SEARCH_TARGET_ARRAY[0]：本のタイトルでの検索のみ実施
			if(stringRegexCheck(SEARCH_TARGET_ARRAY[0].methodSignature(bookData),bookTitleName)) {
				
				searchResultList.add(bookData);
			}
		}	
		return searchResultList;
	}
	
	public boolean stringRegexCheck(String target,String keyWord) {
		
		if(target.matches(".*" + keyWord + ".*")) {
			
			return true;
		}else {
			
			return false;
		}
	}
}