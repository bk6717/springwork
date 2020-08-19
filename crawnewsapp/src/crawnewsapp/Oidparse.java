package crawnewsapp;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//1.. Jsoup (Maven) 가져오기
//2.. Jsoup 이용해서 URL 요청하기
//3.. oid의 번호가 어디까지 있는지
// oid마다 신문사명 매칭

public class Oidparse {
	

	
	public static void main(String[] args) {
		Map<String, String> oidMap = new HashMap<>();
		
		String oid = "0";
		
		
		for (int i = 0; i < 500; i++) {
			if ((i+"").length() == 1) {
			
				oid = "00" + i ;
			
			}else if ((i+"").length() == 2) {
				
				oid = "0" + i;
		
			}else if ((i+"").length() == 3) {
				
				oid = "" + i ; 
			}
			
			//크롤링할 url 지정
			String url = "https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=100&oid="+oid+"&aid=0000000001";
			//Document에는 페이지의 전체 소스가 저장된다.
			Document doc = null;
			
			String element = "";
			
			
			try {
				
				doc = Jsoup.connect(url).get();
				element = doc.select(".press_logo").select("img").attr("title");
			
				
//				element가 없으면 출력 안함
				if (element != "") {
					oidMap.put(oid, element);
					System.out.println(oid+ " : "+element);	
				}else if (element == "") {
					System.out.println(oid +" : 1번글 없음");
					
				}
					
				
			} catch (Exception e) {
				System.out.println("================");
			}
			
		
			
			
		}// end for
		
		System.out.println(oidMap);
	}
}
