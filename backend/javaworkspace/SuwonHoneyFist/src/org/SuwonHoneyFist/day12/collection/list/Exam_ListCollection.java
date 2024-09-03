package org.SuwonHoneyFist.day12.collection.list;

import java.util.ArrayList;
import java.util.List;

public class Exam_ListCollection {
    
    public static void main(String[] args) {
        // List 인터페이스 존재
    	// List 인터페이스를 구현하여 만든 클래스가 존재
    	// ArrayList 클래스라고 하면 이것을 사용한다.
    	Exam_ListCollection listRun = new Exam_ListCollection();
        
        
        // List 인터페이스를 사용하는 예제
        List<String> list = new ArrayList<String>();
        list.add("김만규");
        list.add("김지혁");
        list.add("양희준");
        list.add("오정민");
        list.add("김태우");
        list.add("이용재");
        list.add("조홍빈");
        list.add("오준석");
        list.add(2, "조승효");
         System.out.println(list.get(0));
         System.out.println(list.get(5));
         System.out.println("크기 : " + list.size());
         int listSize = list.size() -1;
         System.out.println("마지막 값 : " + list.get(listSize));
         for(int i = 0; i < list.size(); i++) {
        	 System.out.println(i + " :" + list.get(i));
         }
         list.remove(listSize);
         for(String name : list) {
        	 System.out.println(name);
         }
         System.out.println("isEmpty() : " + list.isEmpty() + ", size() : " + list.size());
         
        
        // objListSample 메서드 호출
        listRun.objListSample();

        // IntList 사용 예제
        IntList nums = new IntList();
        nums.add(5);
        nums.add(7);
        nums.add(1023);

        System.out.println(nums.get(0)); // 5 출력
        System.out.println(nums.get(1)); // 7 출력
        System.out.println(nums.get(2)); // 1023 출력
        System.out.println("크기 : " + nums.size()); // 크기 : 3 출력
        nums.clear();
        System.out.println("크기 : " + nums.size()); // 크기 : 0 출력
    }
    
    public void objListSample() {
        GenericList<String> strList = new GenericList<>();

        strList.add("김정욱");
        strList.add("이현주");
        strList.add("강신욱");

        String a1 = strList.get(0);
        String a2 = strList.get(1);
        String a3 = strList.get(2);  // 인덱스 수정: 3 -> 2
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        ObjectList obj = new ObjectList();
        obj.add("개강");
        obj.add("프로젝트");
        obj.add("종강");

        String start = (String)obj.get(0);
        String project = (String)obj.get(1);
        String end = (String)obj.get(2);
        System.out.println(start);
        System.out.println(project);
        System.out.println(end);

        // 제네릭 없이 사용하면 형 변환 해야됨
        ObjectList objList = new ObjectList();
        objList.add(5.7);
        objList.add(1023);
        objList.add("종강");

        double startValue = (double)objList.get(0);
        int endValue = (int)objList.get(1);
        // msg로 종강 메시지가 출력되도록 적어보세요
        String msg = (String)objList.get(2);
        System.out.println(startValue);
        System.out.println(endValue);
        System.out.println(msg);
    }
}
