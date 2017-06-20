package com.mkyong.stock;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity

@FilterDef(name="stockRecordFilter",
parameters=@ParamDef( name="stockRecordFilterParam", type="date" ) )

@Table(name = "stock", catalog = "MKYONG", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer stockId;
	private String stockCode;
	private String stockName;
	private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>(0);
	
	public Stock() {
		super();
	}

	public Stock(Integer stockId, String stockCode, String stockName, Set<StockDailyRecord> stockDailyRecords) {
		super();
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDailyRecords = stockDailyRecords;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockCode=" + stockCode + ", stockName=" + stockName
				+ ", stockDailyRecords=" + stockDailyRecords + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
	@Filter(
			name = "stockRecordFilter",
			condition="date >= :stockRecordFilterParam"
		)
	public Set<StockDailyRecord> getStockDailyRecords() {
		return stockDailyRecords;
	}

	public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}

}
