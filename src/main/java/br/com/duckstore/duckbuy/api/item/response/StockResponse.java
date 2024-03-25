package br.com.duckstore.duckbuy.api.item.response;

import java.util.List;

public class StockResponse extends DefaultResponse {

    private List<StockItemResponse> stockList;

    public List<StockItemResponse> getStockList() {
        return stockList;
    }

    public void setStockList(List<StockItemResponse> stockList) {
        this.stockList = stockList;
    }

    public void addStockItem(StockItemResponse stockItemResponse) {
        this.stockList.add(stockItemResponse);
    }

    @Override
    public String toString() {
        return "StockResponse{" +
                "stockList=" + stockList +
                '}';
    }
}
