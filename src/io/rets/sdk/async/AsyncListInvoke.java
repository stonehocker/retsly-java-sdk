package io.rets.sdk.async;

import java.util.List;

public interface AsyncListInvoke<T> {
	public List<T> runList() throws Exception;
}
