package br.com.duckstore.duckbuy.api.item.response;

import java.util.ArrayList;
import java.util.List;

public class ItemsResponse extends DefaultResponse {

    private List<ItemResponse> items = new ArrayList<>();

    public List<ItemResponse> getItems() {
        return items;
    }

    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }

    public void addItem(ItemResponse item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "ItemsResponse{" +
                "items=" + items +
                '}';
    }
}
