package io.rets.sdk.async;

import java.util.List;

public interface RetslyListCallback<T> {
    public void getDataList(List<T> data);
}
