

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kent.domain.Store;

import com.google.gson.Gson;


@WebServlet("/api/list")
public class ApiListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApiListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// mime type : json
		// 1. arrayList에 store 담고 json 문자열로 만들고 확인
		// 2. mime type 붙이고 응답 메시지로 보내기, 브라우저에서 확인
		// 3. filter 설정, AJAX로 호출 가능
		// 4. WebStorm에서 버튼에서 누르면 보이도록 설정
		
		// 1단계 시작...
		List<Store> stores = new ArrayList<>();
		
		stores.add(Store.builder().name("로리스 더 프라임").lat(37.498150).lng(127.026200).build());
		stores.add(Store.builder().name("뚜레쥬르").lat(37.499612).lng(127.027181).build());
		stores.add(Store.builder().name("카페더스노우").lat(37.507013).lng(127.026528).build());
		stores.add(Store.builder().name("카페 마마스").lat(37.496390).lng(127.025560).build());
		stores.add(Store.builder().name("후와후와").lat(37.5276311308612).lng(126.9247329947).build());
		stores.add(Store.builder().name("도피오로스터리").lat(37.505326).lng(127.022188).build());
		stores.add(Store.builder().name("Chloris Tea Rooms").lat(37.504024).lng(127.025525).build());
		stores.add(Store.builder().name("Keopibin").lat(37.502466).lng(127.024828).build());
		stores.add(Store.builder().name("그레이스케일커피").lat(37.503462).lng(127.028282).build());
		stores.add(Store.builder().name("맘마미아").lat(37.525905385032885).lng(127.03464565651308).build());

		Gson gson = new Gson();
		String jsonString = gson.toJson(stores);
		
		System.out.println(jsonString);
		
		// 브라우저에서 보여주는 단계
		// 1. mime type, UTF-8
		response.setContentType("application/json; charset=UTF-8");
		// 2. respose로 밀어주기
		response.getWriter().println(jsonString);
		
	}



}
