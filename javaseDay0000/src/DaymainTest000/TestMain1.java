package DaymainTest000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMain1 {

	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<>();
		try (BufferedReader bfr = new BufferedReader(new FileReader("E:\\小牛每日内容\\每天内容\\java基础增强案例\\day02\\data\\http.log"));){
			String line;
			while((line=bfr.readLine())!=null){
				String[] split = line.split("\\s");
				 String phone=split[0];
				 String tel=phone.substring(0, 7);
				 String[] urlstr=split[1].split("\\.");
				 String upDatestr=split[2];
				 Integer upDate = Integer.valueOf(upDatestr);
				 String lowDatestr=split[3];
				 Integer lowDate = Integer.valueOf(lowDatestr);
				 if(urlstr.length>=3){
					 String url=urlstr[1];
					// System.out.println(url);
					 HttpBean httpBean = new HttpBean(tel,url,upDatestr,lowDatestr);
					 Integer totol = map.getOrDefault(tel, 0);
					 totol+=upDate+lowDate;
					 map.put(url, totol);
				 }			
			}
			Set<Entry<String, Integer>> entrySet = map.entrySet();
			List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(entrySet);
			Collections.sort(list, new Comparator<Entry<String, Integer>>(){

				public int compare(Entry<String, Integer> o1,
						Entry<String, Integer> o2) {
					// TODO Auto-generated method stub
					return o2.getValue()-o1.getValue();
				}
				
			});
			for(Entry<String, Integer> s:list){
				System.out.println(s);
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
