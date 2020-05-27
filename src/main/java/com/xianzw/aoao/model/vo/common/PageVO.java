package com.xianzw.aoao.model.vo.common;

import java.util.ArrayList;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xianzw.aoao.utils.ObjectUtil;

import lombok.Data;

/**
 * 分页排序
 * @description: 
 * @author: xianzw
 * @time: 2019年3月20日下午3:11:41
 */
@Data
public class PageVO<T> {
	
	public static final String ASC = "asc";
	public static final String DESC = "desc";
	
	/**
     * 总数
     */
    private long total = 0;
    
    /**
     * 每页显示条数，默认 10
     */
    private long size = 10;

    /**
     * 当前页
     */
    private long current = 1;
	
	/**
	 * 排序字段
	 */
	private String sort;
	
	/**
	 * 排序类型
	 */
	private String sortType = ASC;
	
	/**
	 * 默认排序字段
	 */
	private String defSort;
	
	/**
	 * 默认排序类型
	 */
	private String defSortType = ASC;
	
    /**
     * 自动优化 COUNT SQL
     */
    private boolean optimizeCountSql = true;
    /**
     * 是否进行 count 查询
     */
    private boolean isSearchCount = true;
    /**
     * 是否命中count缓存
     */
    private boolean hitCount = false;
	
	
	/**
	 * 构造mybatis-plus分页page对象
	 * @Description:   
	 * @param: @return      
	 * @return: Page<T>      
	 * @throws
	 */
	public Page<T> page(){
		Page<T> page = new Page<T>(current,size);
		if(ObjectUtil.isNotEmpty(sort)){
			ArrayList<OrderItem> orders = new ArrayList<OrderItem>();
			//指定表名表名
			if(sort.contains(".")){
				String[] sortArray = sort.split(".");
				String formatString = ObjectUtil.formatString(sortArray[1]);
				sort = sortArray[0].concat(".").concat(formatString);
			}else{
				sort = ObjectUtil.formatString(sort);
			}
			
			OrderItem orderItem = new OrderItem();
			orderItem.setColumn(sort);
			if(DESC.equals(sortType)){
				orderItem.setAsc(false);
			}
			orders.add(orderItem);
			page.addOrder(orders);
		}
		return page;
	}
	
	/**
	 * 构造mybatis-plus分页page对象并无排序则按默认排序
	 * @Description:   
	 * @param: @return      
	 * @return: Page<T>      
	 * @throws
	 */
	public Page<T> page(String defSort,String defSortType){
		Page<T> page = new Page<T>(current,size);
		
		defSort = ObjectUtil.formatString(defSort);
		ArrayList<OrderItem> orders = new ArrayList<OrderItem>();
		
		//不为空则按前台传递排序
		if(ObjectUtil.isNotEmpty(sort)){
			//指定表名表名
			if(sort.contains(".")){
				String[] sortArray = sort.split(".");
				String formatString = ObjectUtil.formatString(sortArray[1]);
				sort = sortArray[0].concat(".").concat(formatString);
			}else{
				sort = ObjectUtil.formatString(sort);
			}
			
			//前端排序
			OrderItem orderItem = new OrderItem();
			orderItem.setColumn(sort);
			if(DESC.equals(sortType)){
				orderItem.setAsc(false);
			}
			orders.add(orderItem);
			
			if(!sort.equals(defSort)) {
				//默认排序
				OrderItem defOrderItem = new OrderItem();
				defOrderItem.setColumn(defSort);
				if(DESC.equals(defSortType)) {
					defOrderItem.setAsc(false);
				}
				orders.add(defOrderItem);
			}
			
		}else {
			//默认排序
			OrderItem defOrderItem = new OrderItem();
			defOrderItem.setColumn(defSort);
			if(DESC.equals(defSortType)) {
				defOrderItem.setAsc(false);
			}
			orders.add(defOrderItem);
		}
		
		page.setOrders(orders);
		return page;
	}
	
	/**
	 * 默认顺序排序
	 * @param defSort
	 * @return
	 */
	public Page<T> pageOnAsc(String defSort){
		return page(defSort,ASC);
	}
	/**
	 * 默认顺序倒序
	 * @param defSort
	 * @return
	 */
	public Page<T> pageOnDesc(String defSort){
		return page(defSort,DESC);
	}
	
}
