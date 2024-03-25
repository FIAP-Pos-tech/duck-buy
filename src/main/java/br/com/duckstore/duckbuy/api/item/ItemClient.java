package br.com.duckstore.duckbuy.api.item;

import br.com.duckstore.duckbuy.api.item.response.ItemsResponse;
import br.com.duckstore.duckbuy.api.item.response.StockResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class ItemClient implements ItemApi {

    private final String url;

    public ItemClient(String url) {
        this.url = url;
    }

    private ItemApi getClient() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(ItemApi.class, url);
    }


    @Override
    public ItemsResponse getItems(int page, int size) {
        return getClient().getItems(page, size);
    }

    @Override
    public ItemsResponse getItem(Long id) {
        return getClient().getItem(id);
    }

    @Override
    public StockResponse getStockByItem(Long itemId) {
        return getClient().getStockByItem(itemId);
    }
}
