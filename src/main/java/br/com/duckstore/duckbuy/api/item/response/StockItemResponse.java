package br.com.duckstore.duckbuy.api.item.response;

public class StockItemResponse {

    private Long itemId;
    private String itemDescription;
    private Integer quantity;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StockItemResponse{" +
                "itemId=" + itemId +
                ", itemDescription='" + itemDescription + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
