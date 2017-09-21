# android_practice5_Handler
*********实验总结**********
功能实现：
使用Handler在新线程中发送消息，然后在主线程中处理消息。设定一个耗时运算。
心得体会：
实现Java的Runnable接口，并重写run()方法，在run()方法中实现耗时运算。
然后创建Thread对象，将Runnable对象传递给Thread对象。
最后调用Thread.start()方法启动线程，当run()返回时，该线程即结束。
这是线程的基本流程。
在实验中我另加了一行text进行一个在耗时运算结束后的呈现效果，遇到一些小问题，后经网络搜查改为以object为类型进行传递。


