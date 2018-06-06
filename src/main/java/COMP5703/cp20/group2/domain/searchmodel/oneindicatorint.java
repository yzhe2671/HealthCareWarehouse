package COMP5703.cp20.group2.domain.searchmodel;

public class oneindicatorint {
	private String indicator;
	private int value;
	
	public oneindicatorint(String indicator, int value) {
		this.indicator=indicator;
		this.value=value;
    }

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public float getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
