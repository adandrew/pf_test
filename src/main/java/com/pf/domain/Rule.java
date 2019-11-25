package com.pf.domain;

public class Rule {
	
	private int ruleId;
	private int paidQuantity;
	private int freeQuantity;
	private String ruleDescription;
	
	public Rule(int ruleId,int paidQuantity, int freeQuantity, String ruleDescription) {
		this.ruleId = ruleId;
		this.paidQuantity = paidQuantity;
		this.freeQuantity = freeQuantity;
		this.ruleDescription = ruleDescription;
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

	public String getRuleDescription() {
		return ruleDescription;
	}

	public void setRuleDescription(String ruleDescription) {
		this.ruleDescription = ruleDescription;
	}
}
