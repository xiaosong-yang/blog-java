package yyf256.top.blog.util;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;

//import entity.BPlayerSearch;
//import entity.PageEntity;


public class PageRefect {

	private static Logger logger=Logger.getLogger(PageRefect.class);
	/*
	 * obj:包含方法的实体对象
	 * methodnames:内部有两个，第一个是获取数据库中的行数方法，第二个获取数据列表的方法
	 * argscls:为方法所需的参数所属类，共三个参数，第一个是参数集合类，第二个是当前页，第三个是每页显示多少个
	 * arg：是上面说的三个参数的具体值
	 * returnclsname：查询列表，查出来的返回类型
	 * flag:查询方法中是否有size与cur两个参数
	 * map：存入键值得数据包
	 * 如果需要对获取的list进行在处理，给以获取List<E>
	 */
	@SuppressWarnings("unchecked")
//	public List<E> setPageMap(Object obj,String[] methodnames,Class[] argcls,Object[] args,boolean flag,Map<String,Object> map)
	public static<E> PageResult setPageMap(Object obj,String[] methodnames,Class<?>[] argcls,PageSearch arg,boolean flag)
	{
//		int cur=Integer.parseInt(args[1].toString());
		int size=arg.getSize();
		int cur=arg.getCur();
		try {
			Class<? extends Object> cls=obj.getClass();
			Method getcount,getlist;
			getcount = cls.getDeclaredMethod(methodnames[0],argcls[0]);
			if(flag)   //cur与size集成到第一个参数对象中后采用第一种策略
				getlist = cls.getDeclaredMethod(methodnames[1], argcls);
			else
				getlist = cls.getDeclaredMethod(methodnames[1], argcls[0]);
//			int count=(int) getcount.invoke(obj, args[0]);
			int count=(int) getcount.invoke(obj, arg);
//			int pagecount=(count%((int)args[2])==0)?(count/((int)args[2])):(count/((int)args[2])+1);
			int pagecount=(count%((int)arg.getSize())==0)?(count/((int)arg.getSize())):(count/((int)arg.getSize())+1);
			if(pagecount==0)
				pagecount=1;
			if(cur>pagecount){
				cur=1;
				arg.setCur(1);
				arg.setBegin((cur-1)*size);
			}
			System.out.println("总页数="+pagecount+"当前页="+arg.getCur());
			List<E> returnobj;
			if(flag){
//				 returnobj=(List<E>) getlist.invoke(obj, args);
				returnobj=(List<E>) getlist.invoke(obj, arg);
				 logger.info("执行三个参数");
			 }else{
//				 returnobj=(List<E>) getlist.invoke(obj, args[0]);
				 returnobj=(List<E>) getlist.invoke(obj, arg);
//				 logger.info("执行单个参数");
			}
//			if(returnobj.size()<=0){
//				returnobj=(List<E>) getlist.invoke(obj, args[0]);
//			}
			return new PageResult(pagecount, size, cur, returnobj, arg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * obj:包含方法的实体对象
	 * methodnames:内部有两个，第一个是获取数据库中的行数方法，第二个获取数据列表的方法
	 * argscls:为方法所需的参数所属类，共三个参数，第一个是参数集合类，第二个是当前页，第三个是每页显示多少个
	 * arg：是上面说的三个参数的具体值
	 * returnclsname：查询列表，查出来的返回类型
	 * flag:查询方法中是否有size与cur两个参数
	 * map：存入键值得数据包
	 * 如果需要对获取的list进行在处理，给以获取List<E>
	 */
	@SuppressWarnings("unchecked")
//	public List<E> setPageMap(Object obj,String[] methodnames,Class[] argcls,Object[] args,boolean flag,Map<String,Object> map)
	public static<E> PageResult setPageMap(Object obj,String methodname,Class<?>[] argcls,PageSearch arg,boolean flag)
	{
//		int size=Integer.parseInt(args[2].toString());
//		int cur=Integer.parseInt(args[1].toString());
		int size=arg.getSize();
		int cur=arg.getCur();
		try {
			Class<? extends Object> cls=obj.getClass();
			Method getcount,getlist;
			getcount = cls.getDeclaredMethod(methodname,argcls[0]);
			if(flag)   //cur与size集成到第一个参数对象中后采用第一种策略
				getlist = cls.getDeclaredMethod(methodname, argcls);
			else
				getlist = cls.getDeclaredMethod(methodname, argcls[0]);
//			int count=(int) getcount.invoke(obj, args[0]);
			int count=((List<E>) getcount.invoke(obj, arg)).size();			
			arg.setIsOneStr(true);
//			int pagecount=(count%((int)args[2])==0)?(count/((int)args[2])):(count/((int)args[2])+1);
			int pagecount=(count%((int)arg.getSize())==0)?(count/((int)arg.getSize())):(count/((int)arg.getSize())+1);
			if(pagecount==0)
				pagecount=1;
			if(cur>pagecount){
				cur=1;
				arg.setCur(1);
				arg.setBegin((cur-1)*size);
			}
			System.out.println("总页数="+pagecount+"当前页="+arg.getCur());
			List<E> returnobj;
			if(flag){
//				 returnobj=(List<E>) getlist.invoke(obj, args);
				returnobj=(List<E>) getlist.invoke(obj, arg);
				 logger.info("执行三个参数");
			 }else{
//				 returnobj=(List<E>) getlist.invoke(obj, args[0]);
				 returnobj=(List<E>) getlist.invoke(obj, arg);
//				 logger.info("执行单个参数");
			}
//			if(returnobj.size()<=0){
//				returnobj=(List<E>) getlist.invoke(obj, args[0]);
//			}
			return new PageResult(pagecount, size, cur, returnobj, arg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @param obj 查询的对象
	 * @param args 方法名，有两个参数，第一个是查询总数的方法名，第二个是查询列表的方法名
	 * @param search 查询条件的集合，需要继承自PageEntity
	 * @param map 存放数据的map
	 * @return
	 */
	@SuppressWarnings("unused")
	public static<E> PageResult search(Object obj,String[] args,PageSearch search){
		@SuppressWarnings("rawtypes")
		Class c=search.getClass();
		if (search == null)
			try {
				search = (PageSearch) c.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//	search.setSize(search.getPagesize());
		search.setBegin((search.getCur() - 1) * search.getSize());
//		return setPageMap(obj, args,
//				new Class[]{search.getClass(),search.getCur().getClass(),search.getSize().getClass()},
//				new Object[]{search,search.getCur(),search.getSize()}, false, map);
		return setPageMap(obj, args,
				new Class[]{search.getClass(),search.getCur().getClass(),search.getSize().getClass()},
				search, false);
	}
	
	/**
	 * 
	 * @param obj 查询的对象
	 * @param args 方法名，查询列表的方法名
	 * @param search 查询条件的集合，需要继承自PageEntity
	 * @param map 存放数据的map
	 * @return
	 */
	@SuppressWarnings("unused")
	public static<E> PageResult search(Object obj,String args,PageSearch search){
		@SuppressWarnings("rawtypes")
		Class c=search.getClass();
		if (search == null)
			try {
				search = (PageSearch) c.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//	search.setSize(search.getPagesize());
		search.setBegin((search.getCur() - 1) * search.getSize());
//		return setPageMap(obj, args,
//				new Class[]{search.getClass(),search.getCur().getClass(),search.getSize().getClass()},
//				new Object[]{search,search.getCur(),search.getSize()}, false, map);
		return setPageMap(obj, args,
				new Class[]{search.getClass(),search.getCur().getClass(),search.getSize().getClass()},
				search, false);
	}
}
