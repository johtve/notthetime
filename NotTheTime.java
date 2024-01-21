import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

class NotTheTime {

    private Calendar rightNow = Calendar.getInstance();
    private int currentMin = rightNow.get(Calendar.MINUTE);
    private ArrayList<String> notTimes = new ArrayList<>();

    public NotTheTime() {
        getCurrentMinute();
        fillNotTimes();
    }

    public NotTheTime(Boolean shuffle) {

        this();

        if (shuffle) {
            Collections.shuffle(notTimes);
        }
    }

    private void getCurrentMinute() {
        currentMin = rightNow.get(Calendar.MINUTE);

    }

    private void fillNotTimes() {

        for (int h = 1; h < 24; h++) {

            // Skip iteration if minute = current
            for (int m = 1; m < 60; m++) {
                if (m == currentMin) {
                    continue;
                }
                notTimes.add(h + ":" + m);
            }
        }
    }

    public void print() {
        for (int i = 0; i < notTimes.size(); i++) {

            String notTime = notTimes.get(i);
            String[] timeParts = notTime.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);

            String formattedHours = String.format("%02d", hours);
            String formattedMinutes = String.format("%02d", minutes);

            System.out.println("The time is not " + formattedHours + ":" + formattedMinutes);
        }
    }

    public static void main(String[] args) {

        NotTheTime notTheTime = new NotTheTime();
        notTheTime.print();

    }

}