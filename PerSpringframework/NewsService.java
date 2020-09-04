package poly.service.impl;


import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.NewsDTO;
import poly.persistance.mapper.INewsMapper;
import poly.service.INewsService;

@Service("NewsService")
public class NewsService implements INewsService {

	@Resource(name = "NewsMapper")
	private INewsMapper newsMapper;

	private Logger log = Logger.getLogger(this.getClass());

	public NewsDTO insertNewsInfo(NewsDTO nDTO) throws Exception {
		// TODO Auto-generated method stub
		log.info(this.getClass().getName() + ".getNewsInfoFromWEB start!!");

		int res = 0; // 크롤링 결과 (0보다 크면 크롤링 성공)

		// 코리아헤럴드 사이트 (https:// 는 보안때문에 불가)
		String url = "http://www.koreaherald.com";

		// JSOUP 라이브러리를 통해 사이트에 접속되면, 그 사이트 전체의 HTML 소스를 저장할 변수
		Document doc = null;
		// 사이트 접속
		doc = Jsoup.connect(url).get();
		// 사이트에 접속하여 전체 기사 중 메인 기사를 찾아 들어가야 함.
		// 웹 페이지 전체 소스 중 일부 태그를 선택하기 위해 사용

		Elements element_urlGet = doc.select("a.main_c_art_main");
		log.info(element_urlGet.toString());
		// element_urlGet 소스에 href를 가져옴
		String newsUrl = (element_urlGet.attr("href")).toString();
		
		// 크롤링하는 값 앞에 기본 주소가 있어야 함.
		url = "http://www.koreaherald.com" + newsUrl;
		
		// 메인 기사 주소로 재접속
		doc = Jsoup.connect(url).get();
		
		// 본문 전체를 가져옴 
		Elements element = doc.select("div.view_bg"); 
		
		// 뉴스의 제목
		Iterator<Element> it_title = element.select("div.view_tit").iterator();
		
		// 로그를 찍기 위함
		String news_title = element.select("h1").text();

		log.info(news_title);
		
		// 뉴스의 기자
		Iterator<Element> it_author = element.select("div.view_tit_byline_l").iterator();
		
		String newsGetAuthor = element.select("a").text();
	
		String news_author = newsGetAuthor.substring(2, 15);
		
		log.info(news_author);
		
		// 뉴스의 날짜
		Elements element_date = doc.select("div.view_tit_byline_r");
		Iterator<Element> it_date = element.select("div.view_tit_byline_r").iterator();
		
		String newsGetDate = element_date.select("div.view_tit_byline_r").text();
		String news_dt = newsGetDate.substring(11, 24);
		log.info(news_dt);
		
		// 뉴스의 내용
		Elements element_contents = doc.select("div.view_con_t");
		String news_contents = element_contents.text();
		String test_news_contents = news_contents.substring(0, 100);
		log.info(news_contents);
		
		nDTO = null;

		// 수집된 데이터 DB에 저장
		
		nDTO = new NewsDTO();
		
		nDTO.setNews_dt(news_dt);
		nDTO.setNews_contents(test_news_contents);
		nDTO.setNews_author(news_author);
		nDTO.setNews_title(news_title);
		
		if(news_title != null) {
			res++;
		}
		if(res > 0) {
			log.info("데이터에 값이 잘 들어옴");
		} else {
			log.info("데이터에 값이 없다");
		}

		log.info(this.getClass().getName() + ".getNewsInfoFromWEB end!");
		
		return newsMapper.insertNewsInfo(nDTO);
		// newsMapper의 insertNewsInfo라는 id에 해당하는 쿼리를 실행.
	}

	@Override
	public NewsDTO getNewsInfo(NewsDTO nDTO) throws Exception {
		
		nDTO = new NewsDTO();
		
		nDTO.getNews_title();
		nDTO.getNews_contents();
		nDTO.getNews_author();
		nDTO.getNews_dt();
		
		return newsMapper.getNewsInfo(nDTO);
	}
	
}
