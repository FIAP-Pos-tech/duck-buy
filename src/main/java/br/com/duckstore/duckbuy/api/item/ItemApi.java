package br.com.duckstore.duckbuy.api.item;

import br.com.duckstore.duckbuy.api.item.response.ItemResponse;
import br.com.duckstore.duckbuy.api.item.response.ItemsResponse;
import br.com.duckstore.duckbuy.api.item.response.StockResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Content-Type: application/json")
public interface ItemApi {

    @RequestLine("GET api/items?page={page}&size={size}")
    ItemsResponse getItems(@Param("page") int page, @Param("size") int size);

    @RequestLine("GET api/items/{id}")
    ItemsResponse getItem(@Param("id") Long id);

    @RequestLine("GET api/stock/{itemId}")
    StockResponse getStockByItem(@Param("itemId") Long itemId);


}
