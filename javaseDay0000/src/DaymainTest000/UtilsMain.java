package DaymainTest000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilsMain {

	public static void main(String[] args) {
		Map<String, TelBean> map = MapUtil();
		List<TelBean> list = ListUtil();
		System.out.println(list.size());

	}

	public static Map<String,TelBean> MapUtil() {
		Map<String,TelBean> map=new HashMap<>();
		try(BufferedReader bfr = new BufferedReader(new FileReader("E:\\小牛每日内容\\每天内容\\java基础增强案例\\day02\\data\\手机号段规则.txt"));) {
			String line;
			bfr.readLine();
			while((line=bfr.readLine())!=null){
				//System.out.println(line);
				String[] split = line.split("\\s");
				 String prefix=split[0];
				 String phone=split[1];
				 String province=split[2];
				 String city=split[3];
				 String isp=split[4];
				 String postCode=split[5];
				 String cityCode=split[6];
				 String areaCode=split[7];
				 TelBean telBean = new TelBean(prefix,phone,province,city,isp,postCode,cityCode,areaCode);
				 map.put(phone,telBean);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	public static List<TelBean> ListUtil() {
		List<TelBean>list=new ArrayList<>();
		try(BufferedReader bfr = new BufferedReader(new FileReader("E:\\小牛每日内容\\每天内容\\java基础增强案例\\day02\\data\\手机号段规则.txt"));) {
			String line;
			bfr.readLine();
			while((line=bfr.readLine())!=null){
				//System.out.println(line);
				String[] split = line.split("\\s");
				 String prefix=split[0];
				 String phone=split[1];
				 String province=split[2];
				 String city=split[3];
				 String isp=split[4];
				 String postCode=split[5];
				 String cityCode=split[6];
				 String areaCode=split[7];
				 TelBean telBean = new TelBean(prefix,phone,province,city,isp,postCode,cityCode,areaCode);
				 list.add(telBean);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
