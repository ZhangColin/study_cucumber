package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nickbank.TransactionProcessor;

/**
 * Created by Administrator on 2016/3/26.
 */
public class BackgroundProcessHooks {
    private Thread transactionProcessorThread;

    @Before
    public void startBackgroundThread(){
        transactionProcessorThread = new Thread(){
            public void run(){
                TransactionProcessor processor = new TransactionProcessor();

                processor.process();
            }
        };

        transactionProcessorThread.start();
    }

    @After
    public void stopBackgroundThread(){
        transactionProcessorThread.interrupt();
    }
}
