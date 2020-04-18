package homework3;

public  class BrowserUtils {


    public static void pause(int second)  {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
