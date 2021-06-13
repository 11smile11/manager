package com.util;

import java.util.List;

public class PageUtils<T> {
    //页码
    private int pageNo;
    //页面大小
    private int pageSize;
    //总记录条数
    private long totalRecord;
    //总页数
    private int totalPage;
    //每页的开始
    private int start;
    //当前页面记录集
    private List<T> results;

    public void doPage(List<T> lists){
        int count = lists.size();
        setTotalRecord(count);
        setTotalPage(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
        setStart(getPageNo() * getPageSize());
        setResults(lists.subList(getStart(),
                (count - getStart()) > getPageSize() ? getStart() + getPageSize() : count));
    }
    public PageUtils(){
        super();
    }
    public PageUtils(int pageNo, int pageSize){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}