package com.pf.domain;

public class Rule {
	
	private int ruleId;
	private int paidQuantity;
	private int freeQuantity;
	
	public Rule(int ruleId,int paidQuantity, int freeQuantity) {
		this.ruleId = ruleId;
		this.paidQuantity = paidQuantity;
		this.freeQuantity = freeQuantity;
	}
	
	public int getRuleId() {
		return ruleId;
	}
	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
	public int getPaidQuantity() {
		return paidQuantity;
	}
	public void setPaidQuantity(int paidQuantity) {
		this.paidQuantity = paidQuantity;
	}
	public int getFreeQuantity() {
		return freeQuantity;
	}
	public void setFreeQuantity(int freeQuantity) {
		this.freeQuantity = freeQuantity;
	}
}
