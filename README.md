# MaterialDrawerTest
There seems to be a bug in `5.0.0` where calling `updateBadge` when the `Drawer` was created `withFooter` causes it to crash:


```Process: materialdrawertest.jonathancaryl.org.materialdrawertest, PID: 27299
                                                                                                         java.lang.ArrayIndexOutOfBoundsException: length=12; index=-1
                                                                                                             at java.util.ArrayList.set(ArrayList.java:483)
                                                                                                             at com.mikepenz.fastadapter.adapters.ItemAdapter.set(ItemAdapter.java:271)
                                                                                                             at com.mikepenz.materialdrawer.Drawer.updateItemAtPosition(Drawer.java:633)
                                                                                                             at com.mikepenz.materialdrawer.Drawer.updateItem(Drawer.java:574)
                                                                                                             at com.mikepenz.materialdrawer.Drawer.updateBadge(Drawer.java:589)
                                                                                                             at materialdrawertest.jonathancaryl.org.materialdrawertest.MainActivity$1.onClick(MainActivity.java:41)
                                                                                                             at android.view.View.performClick(View.java:5198)
                                                                                                             at android.view.View$PerformClick.run(View.java:21147)
                                                                                                             at android.os.Handler.handleCallback(Handler.java:739)
                                                                                                             at android.os.Handler.dispatchMessage(Handler.java:95)
                                                                                                             at android.os.Looper.loop(Looper.java:148)
                                                                                                             at android.app.ActivityThread.main(ActivityThread.java:5417)
                                                                                                             at java.lang.reflect.Method.invoke(Native Method)
                                                                                                             at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
                                                                                                             at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
```

Without the `withFooter` it seems to be ok.