package br.com.gunthercloud.distributor.controller.pageable;

import java.util.List;

public class PageModel<T> {

    private List<T> content;
    private PageableModel pageable;
    private int totalPages;
    private int totalElements;
    private boolean last;
    private boolean first;
    private int size;
    private int number;
    private SortModel sort;
    private int numberOfElements;
    private boolean empty;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public PageableModel getPageable() {
        return pageable;
    }

    public void setPageable(PageableModel pageable) {
        this.pageable = pageable;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SortModel getSort() {
        return sort;
    }

    public void setSort(SortModel sort) {
        this.sort = sort;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
