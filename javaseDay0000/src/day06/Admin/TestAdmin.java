package day06.Admin;

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

import com.alibaba.fastjson.JSON;

import day06.Bean.Movie;
import day06.Utils.SortUtils;

public class TestAdmin {
	public static void main(String[] args) {
		
		Map<String,Integer> map=new HashMap<>();
		//拿到以movie做为key的map数组  movieKey
		Map<String, List<Movie>> movieKey = MovieToMovieKey();
		Set<Entry<String, List<Movie>>> entrySet = movieKey.entrySet();
		for(Entry<String, List<Movie>> entry:entrySet){
			String key = entry.getKey();
			//List<Movie> values = entry.getValue();
			/*Movie movie = new Movie();
			String uid = movie.getUid();*/
			List<Movie> list = movieKey.getOrDefault(key, new ArrayList<>());
			map.put(key, list.size());	
		}
		Set<Entry<String, Integer>> entrySet2 = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(entrySet2);
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for(Entry<String, Integer> s:list){
			System.out.println(s);
		}
		
		
	
	}
	public static void TestMain3() {
		Map<String, Double> map3 = TestMain2();
		//SortUtils.UidSortMapTest(map3);
		Set<Entry<String, Double>> entrySet = map3.entrySet();
		
		ArrayList<Entry<String, Double>> list = new ArrayList<>(entrySet);
		Collections.sort(list, new Comparator<Entry<String, Double>>(){

			@Override
			public int compare(Entry<String, Double> o1,
					Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for(Entry<String, Double> s:list){
		System.out.println(s);
	}
	}
	public static Map<String,Double> TestMain2() {
		Map<String,Double> map2=new HashMap<>();
		Map<String, List<Movie>> uidKey = MovieToUidKey();
		Set<Entry<String, List<Movie>>> entrySet = uidKey.entrySet();
		for(Entry<String, List<Movie>> entry:entrySet){
			String key = entry.getKey();
			int sum=0;
			List<Movie> values = entry.getValue();
				List<String> list = new ArrayList<>();
				for(int i=0;i<values.size()-1;i++){
					Movie movie = values.get(i);
					String rate = movie.getRate();
					list.add(rate);
				}
				for(String s:list){
					sum+=Integer.parseInt(s);
				}
				
				map2.put(key, (double)sum/list.size());	
				
		}
		/*Set<Entry<String, Double>> entrySet2 = map2.entrySet();
		for(Entry<String, Double> s:entrySet2){
			System.out.println(s);
		}*/
		return map2;
	}
	public static void TestMain1() {
		Map<String,List<String>> map1=new HashMap<>();
		Map<String, List<Movie>> uidKey = MovieToUidKey();
		Set<Entry<String, List<Movie>>> entrySet = uidKey.entrySet();
		for(Entry<String, List<Movie>> entry:entrySet){
			String key = entry.getKey();
			List<Movie> values = entry.getValue();
			if(values.size()>2){
				List<String> list = new ArrayList<>();
				for(int i=0;i<3;i++){
					Movie movie = values.get(i);
					String rate = movie.getRate();
					list.add(rate);
				}
				SortUtils.UidSortByTest(list);
				map1.put(key, list);
			}	
		}
		Set<Entry<String, List<String>>> set = map1.entrySet();				
			for(Entry<String, List<String>> s:set){
				System.out.println(s);
			}
	}

	public static Map<String,List<Movie>> MovieToUidKey() {
		Map<String,List<Movie>> map=new HashMap<>();
		try(BufferedReader bfr = new BufferedReader(new FileReader("E:\\小牛每日内容\\每天内容\\java基础增强案例\\案例五\\movie.txt"));) {
			String line;
			while((line=bfr.readLine())!=null){
				Movie mm = JSON.parseObject(line, Movie.class);
				String uid = mm.getUid();
				List<Movie> list = map.getOrDefault(uid, new ArrayList<Movie>());
				list.add(mm);
				
				map.put(uid, list);	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	public static Map<String,List<Movie>> MovieToMovieKey() {
		Map<String,List<Movie>> map=new HashMap<>();
		try(BufferedReader bfr = new BufferedReader(new FileReader("E:\\小牛每日内容\\每天内容\\java基础增强案例\\案例五\\movie.txt"));) {
			String line;
			while((line=bfr.readLine())!=null){
				Movie mm = JSON.parseObject(line, Movie.class);
				String movie = mm.getMovie();
				List<Movie> list = map.getOrDefault(movie, new ArrayList<Movie>());
				list.add(mm);
				map.put(movie, list);	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
