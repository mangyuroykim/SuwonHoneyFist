package com.benq.ajax.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.benq.ajax.basic.domain.UserVO;

@Controller
@RequestMapping("/ajax")
public class BenqAjaxController {

		@RequestMapping("/example")
		public String showExamplePage() {
			return "ajax/example";
		}
		
		@RequestMapping("/javascript")
		public void javascriptAjax(String msg) {
			System.out.println("전송받은 메시지 : " +msg);
		}
		
		@ResponseBody
		@RequestMapping("/sendMsg")
		public String sendToClient() {
			return "Hello!!";
		}
		
		@ResponseBody
		@RequestMapping("/sendAndRecv")
		public String sendValProcessing(Integer num1, Integer num2) {
			Integer result = num1 + num2;
			return String.valueOf(result);
//			int result = num1 + num2;
//			return result+"";
			
		}
		@ResponseBody
		@RequestMapping(value="/sendAndJson"
						, produces="application/json;charset=utf-8")
		public String jsonProcessing(String userId) {
			List<UserVO> userList = new ArrayList<UserVO>();
			userList.add(new UserVO("khuser01", "pass01"));
			userList.add(new UserVO("khuser02", "pass02"));
			userList.add(new UserVO("khuser03", "pass03"));
			userList.add(new UserVO("khuser04", "pass04"));
			userList.add(new UserVO("khuser05", "pass05"));
			UserVO findOne = null;
			for(UserVO uOne : userList) {
				if(uOne.getUserId().equals(userId)) {
					findOne = uOne;
					break;
				}
			}
			// import org.json.simple.JSONObject;
			// userToJson
			JSONObject json = new JSONObject();
			json.put("userId", findOne.getUserId());
			json.put("userPw", findOne.getUserPw());
			return json.toString();
		}
		
		@ResponseBody
		@RequestMapping(value="/sendAndJsonMap")
		public Map<String, Object> jsonMapProcessing(String userId) {
		    List<UserVO> userList = new ArrayList<UserVO>();
		    userList.add(new UserVO("khuser01", "pass01"));
		    userList.add(new UserVO("khuser02", "pass02"));
		    userList.add(new UserVO("khuser03", "pass03"));
		    userList.add(new UserVO("khuser04", "pass04"));
		    userList.add(new UserVO("khuser05", "pass05"));
		    UserVO findOne = null;
		    for(UserVO uOne : userList) {
		        if(uOne.getUserId().equals(userId)) {
		            findOne = uOne;
		            break;
		        }
		    }
		    // userToMap
		    Map<String, Object> userMap = new HashMap<String, Object>();
		    userMap.put("userId", findOne.getUserId());
		    userMap.put("userPw", findOne.getUserPw());
		    return userMap;
		}
		
		@ResponseBody
		@RequestMapping(value="/sendAndJsonJackson")
		public UserVO jsonJacksonProcessing(String userId) {
		    List<UserVO> userList = new ArrayList<UserVO>();
		    userList.add(new UserVO("khuser01", "pass01"));
		    userList.add(new UserVO("khuser02", "pass02"));
		    userList.add(new UserVO("khuser03", "pass03"));
		    userList.add(new UserVO("khuser04", "pass04"));
		    userList.add(new UserVO("khuser05", "pass05"));
		    UserVO findOne = null;
		    for(UserVO uOne : userList) {
		        if(uOne.getUserId().equals(userId)) {
		            findOne = uOne;
		            break;
		        }
		    }
		    // userToJson(Jackson)
		    return findOne;
		}
		
		@ResponseBody
		@RequestMapping(value="/sendAndJsonList")
		public String jsonList(String userId) {
		    List<UserVO> userList = new ArrayList<UserVO>();
		    userList.add(new UserVO("khuser01", "pass01"));
		    userList.add(new UserVO("khuser02", "pass02"));
		    userList.add(new UserVO("khuser03", "pass03"));
		    userList.add(new UserVO("khuser04", "pass04"));
		    userList.add(new UserVO("khuser05", "pass05"));
		    UserVO findOne = null;
		    for(UserVO uOne : userList) {
		        if(uOne.getUserId().equals(userId)) {
		            findOne = uOne;
		            break;
		        }
		    }
		JSONArray jsonArr = new JSONArray();
		if(findOne != null) {
			JSONObject json = new JSONObject();
			json.put("userId", findOne.getUserId());
			json.put("userPw", findOne.getUserPw());
			jsonArr.add(json);
			
		}else {
			for(UserVO user : userList) {
				JSONObject json	= new JSONObject();
				json.put("userId", user.getUserId());
				json.put("userPw", findOne.getUserPw());
				jsonArr.add(json);
				
			}
		}
		return jsonArr.toString();
	}
		
}
