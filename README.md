# Android-Cheat-sheet
Cheat Sheet for Android Interviews

## Topics
* [Common Coding Programs](#common-coding-programs)
* [Data Structure Coding Programs](#data-structure-coding-programs)
* [Android Interview Questions](#android-interview-questions)
* Java Interview Questions
</br>


### Common Coding Programs
* <b>Arrays</b></br>
  * [Find Maximum Sell Profit](FindMaximumSellProfit.java)
  * [Find Low & High Index of a key from a given array](LowHighIndex.java)
  * [Merge Overlapping Intervals](MergeOverlappingIntervals.java)
  * [Move all zeros in an array to the Left or Right](MoveZeroesToLeft.java)
  * [Rotate an array](RotateArray.java)
  * [Find the smallest common number in a given array](SmallestCommonNumber.java)
  * [Find the sum of two elements in a given array](SumOfTwoValues.java)
  </br>



* <b>Dynamic Programming</b></br>
   * [Fibonacci Series](FibonacciSeries.java)
   * [Given an array, find the contiguous subarray with the largest sum](LargestSumSubarray.java)
   * [Find the maximum sum of a subsequence such that no consecutive elements are part of the subsequence](MaxSumSubsequenceOfNonadjacentElements.java)
   </br>
   
   
   
* <b>Queues</b></br>
   * [Find the Maximum in a Sliding Window](Dequeue.java)
   * [Implement a queue using stack](QueuesUsingStack.java)
   </br>
   
   
   
* <b>Stacks</b></br>
   * [Evaluate an expression](EvaluationExpression.java)
   * [Implement a stack using queues](StacksUsingQueues.java)
   </br>



* <b>Strings</b></br>
   * [Palindrone String](PalindroneStrings.java)
   * [Regular Expression](RegularExpression.java)
   * [Remove Duplicates](RemoveDuplicates.java)
   * [Remove White Spaces](RemoveWhiteSpaces.java)
   * [Remove a String](ReverseString.java)
   * [String Segmentation](StringSegmentation.java)   
   </br>
   
  
  
### Data Structure Coding Programs
* <b>Sorting</b></br>
   * [QuickSort](QuickSort.java)
   </br>
   
   
* <b>Searching</b></br>
   * [Binary Search](BinarySearch.java)
   * [Rotated Binary Search](RotatedBinarySearch.java)
   </br>
   
   
   
### Android Interview Questions 
* <b>What is Application?</b></br>
  * The Application class in Android is the base class within an Android app that contains all other components such as activities and services. The Application class, or any subclass of the Application class, is instantiated before any other class when the process for your application/package is created.</br>

* <b>What is Context?</b></br>
  * A Context is a handle to the system; it provides services like resolving resources, obtaining access to databases and preferences, and so on. An Android app has activities. Context is like a handle to the environment your application is currently running in.</br>
<b>Application Context:</b> This context is tied to the lifecycle of an application. The application context can be used where you need a context whose lifecycle is separate from the current context or when you are passing a context beyond the scope of an activity.</br>
<b>Activity Context:</b> This context is available in an activity. This context is tied to the lifecycle of an activity. The activity context should be used when you are passing the context in the scope of an activity or you need the context whose lifecycle is attached to the current context.</br>


* <b>What is the Android Application Architecture?</b></br>
    * Android application architecture has the following components:</br>
    a. Services − It will perform background functionalities</br>
    b. Intent − It will perform the inter connection between activities and the data passing mechanism</br>
    c. Resource Externalization − strings and graphics</br>
    d. Notification − light,sound,icon,notification,dialog box,and toast</br>
    e. Content Providers − It will share the data between applications</br>
    
  
* <b>Describe activities</b></br>
  * Activities are basically containers or windows to the user interface.</br>
  
  
* <b>Lifecycle of an Activity</b></br>
  * ```OnCreate()```: This is when the view is first created. This is normally where we create views, get data from bundles etc.</br>
  * ```OnStart()```: Called when the activity is becoming visible to the user. Followed by onResume() if the activity comes to the foreground, or onStop() if it becomes hidden.</br>
  * ```OnResume()```: Called when the activity will start interacting with the user. At this point your activity is at the top of the activity stack, with user input going to it.</br>
  * ```OnPause()```: Called as part of the activity lifecycle when an activity is going into the background, but has not (yet) been killed.</br>
  * ```OnStop()```: Called when you are no longer visible to the user.</br>
  * ```OnDestroy()```: Called when the activity is finishing</br>
  * ```OnRestart()```: Called after your activity has been stopped, prior to it being started again</br>
  
  
* <b>What’s the difference between onCreate() and onStart()?</b></br>
  * The onCreate() method is called once during the Activity lifecycle, either when the application starts, or when the Activity has been destroyed and then recreated, for example during a configuration change.</br>
  * The onStart() method is called whenever the Activity becomes visible to the user, typically after onCreate() or onRestart().</br>
  
  
* <b>Describe content providers</b></br>
  * A ContentProvider provides data from one application to another, when requested. It manages access to a structured set of data.  It provides mechanisms for defining data security. ContentProvider is the standard interface that connects data in one process with code running in another process.</br>  
  * When you want to access data in a <b>ContentProvider</b>, you must instead use the ContentResolver object in your application’s Context to communicate with the provider as a client. The provider object receives data requests from clients, performs the requested action, and returns the results.</br>
  
  
* <b>Access data using Content Provider:</b></br>
  * Start by making sure your Android application has the necessary read access permissions. Then, get access to the ContentResolver object by calling getContentResolver() on the Context object, and retrieving the data by constructing a query using ContentResolver.query().</br>
  * The ContentResolver.query() method returns a Cursor, so you can retrieve data from each column using Cursor methods.</br> 
  
  
* <b>Describe services</b></br>
  * Service is a component that is used to perform operations on the background such as playing music, handle network transactions. Services can run in the background even in the application is destroyed.</br>
  
  
* <b>Difference between Service & Intent Service</b></br>
  * <b>Service</b> is the base class for Android services that can be extended to create any service. A class that directly extends Service runs on the main thread so it will block the UI (if there is one) and should therefore either be used only for short tasks or should make use of other threads for longer tasks.</br>  
  * <b>IntentService</b> is a subclass of Service that handles asynchronous requests (expressed as “Intents”) on demand. Clients send requests through startService(Intent) calls. The service is started as needed, handles each Intent in turn using a worker thread, and stops itself when it runs out of work.</br>  
  
  
* <b>Difference between Service, Intent Service, AsyncTask & Threads</b></br>
  * <b>Android service</b> is a component that is used to perform operations on the background such as playing music. It doesn’t has any UI (user interface). The service runs in the background indefinitely even if application is destroyed.</br>
  * <b>AsyncTask</b> allows you to perform asynchronous work on your user interface. It performs the blocking operations in a worker thread and then publishes the results on the UI thread, without requiring you to handle threads and/or handlers yourself.</br>
  * <b>IntentService</b> is a base class for Services that handle asynchronous requests (expressed as Intents) on demand. Clients send requests through startService(Intent) calls; the service is started as needed, handles each Intent in turn using a worker thread, and stops itself when it runs out of work.</br>
  * A <b>thread</b> is a single sequential flow of control within a program. Threads can be thought of as mini-processes running within a main process.</br>
  
  
* <b>Android Bound Service</b></br>
  * A bound service is a service that allows other android components (like activity) to bind to it and send and receive data.
A bound service is a service that can be used not only by components running in the same process as local service, but activities and services, running in different processes, can bind to it and send and receive data.</br>
  * When implementing a bound service we have to extend Service class but we have to override onBind method too. This method returns an object that implements IBinder, that can be used to interact with the service.</br>
  * Implementing Android bound service with Android Messenger</br>
  * Service based on Messenger can communicate with other components in different processes, known as Inter Process Communication (IPC), without using AIDL.</br>
  * <b>A service handler</b>: this component handles incoming requests from clients that interact with the service itself.</br>
  * <b>A Messenger</b>: this class is used to create an object implementing IBinder interface so that a client can interact with the service.</br>
  * Example Implementation: [Link](https://www.survivingwithandroid.com/2014/01/android-bound-service-ipc-with-messenger-2.html)
  

* <b>AIDL vs Messenger Queue</b></br>
  * AIDL is for purpose when you've to go application level communication for data and control sharing, a scenario depicting it can be : An app requires list of all contacts from Contacts app (content part lies here) plus it also wants to show the call's duration and you can also disconnect it from that app (control part lies here).
  * In Messenger queues you're more IN the application and working on threads and processes to manage the queue having messages so no Outside services interference here.</br>
  * Messenger is needed if you want to bind a remote service (e.g. running in another process).</br>



* <b>What is a ThreadPool? And is it more effective than using several separate Threads?</b></br>
  * Creating and destroying threads has a high CPU usage, so when we need to perform lots of small, simple tasks concurrently, the overhead of creating our own threads can take up a significant portion of the CPU cycles and severely affect the final response time.</br>
  * ThreadPool consists of a task queue and a group of worker threads, which allows it to run multiple parallel instances of a task.</br>



* <b>Difference between Activity & Service</b></br>
  * Activities are basically containers or windows to the user interface. Services is a component that is used to perform operations on the background. It does not have an UI.</br>
  
  
* <b>How would you update the UI of an activity from a background service</b></br>
  * We need to register a LocalBroadcastReceiver in the activity. And send a broadcast with the data using intents from the background service. As long as the activity is in the foreground, the UI will be updated from the background. Ensure to unregister the broadcast receiver in the onStop() method of the activity to avoid memory leaks. 
We can also register a Handler and pass data using Handlers.</br>


* <b>What is an intent?</b></br>
  * Intents are messages that can be used to pass information to the various components of android. For instance, launch an activity, open a webview etc.</br>
  * Two types of intents-</br> 
    * Implicit: Implicit intent is when you call system default intent like send email, send SMS, dial number.</br>
    * Explicit: Explicit intent is when you call an application activity from another activity of the same application.</br>
