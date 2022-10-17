package com.djtu.fywz.util;

/**
 * 分页工具类
 */
public class Page {
    private int start; //开始页数
    private int count; //每页显示个数
    private int total; //总个数
    private static final int defaultCount = 8; //默认每页显示5条

    public Page() {
        count = defaultCount;
    }

//<editor-fold defaultstate="collapsed" desc="delombok">
//</editor-fold>
    public Page(int start, int count) {
        this();
        this.start = start;
        this.count = count;
    }

    public int getStart() {
        return start;
    }

//<editor-fold defaultstate="collapsed" desc="delombok">
//</editor-fold>
    public void setStart(int start) {
        this.start = start;
    }

//<editor-fold defaultstate="collapsed" desc="delombok">
//</editor-fold>
    public int getCount() {
        return count;
    }

//<editor-fold defaultstate="collapsed" desc="delombok">
//</editor-fold>
    public void setCount(int count) {
        this.count = count;
    }

    public boolean isHasPreviouse() {
        if (start == 0) return false;
        return true;
    }

    public boolean isHasNext() {
        if (start == getLast()) return false;
        return true;
    }

    public int getTotalPage() {
        int totalPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == total % count) totalPage = total / count;
         else 
        // 假设总数是51，不能够被5整除的，那么就有11页
        totalPage = total / count + 1;
        if (0 == totalPage) totalPage = 1;
        return totalPage;
    }

    public int getLast() {
        int last;
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % count) last = total - count;
         else 
        // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        last = total - total % count;
        last = last < 0 ? 0 : last;
        return last;
    }

    public int getTotal() {
        return total;
    }

//<editor-fold defaultstate="collapsed" desc="delombok">
//</editor-fold>
    public void setTotal(int total) {
        this.total = total;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Page(start=" + this.getStart() + ", count=" + this.getCount() + ", total=" + this.getTotal() + ")";
    }
    //</editor-fold>
}
