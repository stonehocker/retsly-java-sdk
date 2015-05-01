package io.rets.sdk.async;

public interface Async {
	//TODO AsyncInvoke, Callback as callback should run in AsyncsOnPost
	public void excute(AsyncInvoke invoke, RetslyCallback cb);
	public void excuteList(AsyncListInvoke invoke, RetslyListCallback cb);

}
