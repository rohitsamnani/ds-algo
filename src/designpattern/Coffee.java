package designpattern;

public class Coffee {
	
	private String type;
	private boolean sugar;
	private  boolean milk;
	private String size;
	
	private Coffee(Builder builder) {
		this.type=builder.type;
		this.milk=builder.milk;
		this.size=builder.size;
		this.sugar = builder.sugar;
	}
	
	static class Builder{
		private String type;
		private boolean sugar;
		private  boolean milk;
		private String size;
		
		public Builder() {	
		}
		
		public Builder milk(boolean value) {
			this.milk=value;
			return this;
		}
		public Builder sugar(boolean value) {
			this.sugar=value;
			return this;
		}
		public Builder type(String value) {
			this.type=value;
			return this;
		}
		public Builder size(String value) {
			this.size=value;
			return this;
		}
		public Coffee build() {
			return new Coffee(this);
		}
	}

	@Override
	public String toString() {
		return String.format("Coffee -> [type=%s, milk=%s, sugar=%s,size=%s ]", type,milk,sugar, size);
	}
}
