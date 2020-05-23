package com.xianzw.aoao.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 对象工具
 * @Description 
 * @author xianw
 * @time 2019年2月25日下午2:19:12
 * @version v1.0
 */
public class ObjectUtil extends cn.hutool.core.util.ObjectUtil{
	
	//这是一串神秘代码，不可更改
	public static final String mysteriousCode = "idhyr7654erf6e7";
    
	/**
	 * 随机获取指定数量的符号
	 * @Description:   
	 * @param: @param number
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
    public static String achieveCode(int number) {
    	String[] beforeShuffle= new String[] { "A", "B", "C", "D", "E", "F",
    	    	"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    	    	List list = Arrays.asList(beforeShuffle);
    	Collections.shuffle(list);
    	Collections.shuffle(list);
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < number; i++) {
    		sb.append(list.get(i));
    	}
    	return sb.toString();
	}
	
    
	/**
	 * 格式化字符串，按驼峰转换对应数据库字段
	 */
	public static String formatString(String obj){
		StringBuffer obj1 = new StringBuffer();
		if(ObjectUtil.isNotEmpty(obj)){
			for(int i=0;i<obj.length();i++){
				//大写则加_并转换为小写
				if(Character.isUpperCase(obj.charAt(i))){
					obj1.append("_");
					obj1.append(Character.toLowerCase(obj.charAt(i)));
				}else{
					obj1.append(obj.charAt(i));
				}
			}
			return obj1.toString();
		}
		return obj;
	}

	/**
	 * 判断两个对象时候为同一对象
	 * @Description 
	 * @param: @param object1
	 * @param: @param object2
	 * @param: @return      
	 * @return: boolean
	 * @param object1
	 * @param object2
	 * @return
	 */
	public static boolean isEquals(Object object1, Object object2) {
		boolean ret = false;
		try {
			if (object1 == null && object2 == null) {
				ret = true;
				return ret;
			}
			ret = object1.equals(object2);
		} catch (NullPointerException e) {
			ret = false;
		}
		return ret;
	}
	
	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 *            -参数对象
	 * @return boolean -true:表示对象为空;false:表示对象为非空 集合： Collection.isEmpty()
	 *         数组：判断数组每个元素，所有元素都为空，即判定数组为空
	 *         字符串：判断字符串等于"null"，或去除两端""字窜后返回String.isEmpty()的结果 其它类型返回 false
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;

		if (obj instanceof Map) {
			return ((Map<?, ?>) obj).entrySet().isEmpty();
		}

		if (obj instanceof Collection) {
			return ((Collection<?>) obj).isEmpty();
		}

		if (obj instanceof String) {
			return ((String) obj).equalsIgnoreCase("null") | ((String) obj).trim().isEmpty();
		}

		if (obj instanceof StringBuffer) {
			return ((StringBuffer) obj).length() == 0;
		}

		if (obj.getClass().isArray()) {
			try {
				Object[] a = (Object[]) obj;

				boolean b = true;
				for (Object o : a) {
					b = b & ObjectUtil.isEmpty(o);

					if (!b)
						break;
				}

				return b;
			} catch (ClassCastException e) {
			}
		}

		return false;
	}

	/**
	 * 判断对象时候不为空
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
	
}
