package bookmall.vo;

public class OrderBookVo {
	private Long book_no;
	private Long order_no;
	private Long count;
	private String book_title;
	
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String toString() {
		return "OrderBook [book_no=" + book_no + ", book_title=" + book_title + ", count=" + count + "]";
	}
}
