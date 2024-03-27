package br.com.duckstore.duckbuy.api.item;

import br.com.duckstore.duckbuy.api.auth.interceptor.BearerInterceptor;
import br.com.duckstore.duckbuy.api.item.response.ItemsResponse;
import br.com.duckstore.duckbuy.api.item.response.StockResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class ItemClient {

    private final String url;

    public ItemClient(String url) {
        this.url = url;
    }

    private ItemApi getClient(String token) {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .requestInterceptor(new BearerInterceptor(token))
                .target(ItemApi.class, url);
    }

    public ItemsResponse getItems(String token, int page, int size) {
        return getClient(token).getItems(page, size);
    }

    public ItemsResponse getItem(String token, Long id) {
        return getClient(token).getItem(id);
    }

    public StockResponse getStockByItem(String token, Long itemId) {
        return getClient(token).getStockByItem(itemId);
    }
}
