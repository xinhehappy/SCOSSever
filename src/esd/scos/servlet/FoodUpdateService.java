package esd.scos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

public class FoodUpdateService extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		//实现菜品更新信息发送
		PrintWriter writer = resp.getWriter();
		List<FoodOnService> foodList = new ArrayList<FoodOnService>();
		for(int i = 0 ; i<10 ;i++){
			FoodOnService item = new FoodOnService();
			item.name = i+"";
			item.price = i;
			item.type = "热菜";
			item.number = 10;
			foodList.add(item);
		}
		Map<String ,List<FoodOnService>> map = new HashMap<String ,List<FoodOnService>>();
		map.put("foodOnService", foodList);
		JSONObject jsonString = JSONObject.fromObject(map);
		jsonString.accumulate("foods", map);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		this.doGet(req, resp);
	}
	class FoodOnService{
		int number ;//菜品数量
		String name;
		int price;
		String type;
	}

}
